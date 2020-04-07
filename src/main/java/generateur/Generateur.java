package generateur;

import java.util.ArrayList;
import java.util.List;

import arbre.*;
import tds.Symbole;
import tds.Tds;

public class Generateur {

	public String generer(Noeud node, Tds tds) {
		String assembleur = "";
		// generation des instructions de démarrages
		assembleur += ".include beta.uasm \n" + ".include intio.uasm \n" + ".options tty \n\n" + "CMOVE(pile,sp) \n"
				+ "BR(debut) \n";
		// generation du code pour les symboles du tds
		assembleur += "|Declaration des données";
		assembleur += genererVariables(tds);
		
		for (int i = 0; i < node.getFils().size(); i++) {
			// generation du code pour chaque noeud
			assembleur += genererAssembleur(node.getFils().get(i), tds);
		}
		
		// appel de la fonction main
		assembleur += "debut :\n" + "\tCALL(main)\n" + "\tHALT()\n";
		

		assembleur += "pile : \n";

		return assembleur;
	}

	private String genererAssembleur(Noeud noeud, Tds tds) {
		String assembleur = "";
		switch (noeud.getCat()) {
		case AFF:
			assembleur = genererAffectation(noeud, tds);
			break;
		case APPEL:
			assembleur = genererAppel(noeud, tds);
			break;
		case BLOC:
			assembleur = genererBloc(noeud, tds);
			break;
		case CONST:
			assembleur = genererConstante(noeud);
			break;
		case DIFF:
			assembleur = genererDifferent(noeud, tds);
			break;
		case DIV:
			assembleur = genererDivision(noeud, tds);
			break;
		case ECRIRE:
			assembleur = genererEcrire(noeud, tds);
			break;
		case EGAL:
			assembleur = genererEgal(noeud, tds);
			break;
		case FONCTION:
			assembleur = genererFonction(noeud, tds);
			break;
		case IDF:
			assembleur = genererIdf(noeud, tds);
			break;
		case INF:
			assembleur = genererInferieur(noeud, tds);
			break;
		case INFEQ:
			assembleur = genererInferieurEgal(noeud, tds);
			break;
		case LIRE:
			assembleur = genererLire(noeud);
			break;
		case MOINS:
			assembleur = genererMoins(noeud, tds);
			break;
		case MUL:
			assembleur = genererMultiplication(noeud, tds);
			break;
		case PLUS:
			assembleur = genererPlus(noeud, tds);
			break;
		case RET:
			assembleur = genererRetour(noeud, tds);
			break;
		case SI:
			assembleur = genererSi(noeud, tds);
			break;
		case SUP:
			assembleur = genererSuperieur(noeud, tds);
			break;
		case SUPEQ:
			assembleur = genererSuperieurEgal(noeud, tds);
			break;
		case TQ:
			assembleur = genererTantque(noeud, tds);
			break;

		default:
			break;
		}
		return assembleur;
	}
	
	private String genererFonction(Noeud noeud,Tds tds) {
	    String resultat = "\n\t|fonction\n";
        Fonction f = new Fonction("");
        if (noeud instanceof Fonction) {
            f = (Fonction) noeud;
        }
        resultat += f.getValeur()+" :\n";
        for (int i = 0; i < noeud.getFils().size(); i++) {
            resultat += genererAssembleur(noeud.getFils().get(i),tds);
        }
        resultat +=  "\tRTN() \n\t |Fin Fonction\n";
        return resultat;
	}


	private String genererBloc(Noeud noeud,Tds tds) {
    	String resultat = "\n\t|bloc\n";
    	for (int i = 0; i < noeud.getFils().size(); i++) {
            resultat += genererAssembleur(noeud.getFils().get(i),tds);
        }
        return resultat+="\t|Fin Bloc\n";
    }

	private String genererAffectation(Noeud noeud,Tds tds) {
	    String resultat = "\n\t|Affectation\n";
		Idf i = new Idf(0);
		if(noeud.getFils().get(0) instanceof Idf) {
			i = (Idf) noeud.getFils().get(0);
		}
		resultat += genererAssembleur(noeud.getFils().get(1),tds)
				+ "\tPOP(R0)\n"
				+ "\tST(R0, "+i.getFonction()+i.getValeur()+")  \n\t |Fin Affectation\n\n"; 
		return resultat;
	}

	private String genererSi(Noeud noeud,Tds tds) {
	    String resultat = "\n\t| Si\n";
	    Si s = new Si(0);
        if(noeud instanceof Si) {
            s = (Si) noeud;
        }
		resultat += genererAssembleur(s.getCondition(),tds)
				+ "\tPOP(R0)\n"
				+ "\tBF(R0, sinon"+s.getValeur()+")\n"
				+ genererBloc(s.getBlocAlors(),tds)
				+ "\tBR(fsi"+s.getValeur()+")\n"
				+ "sinon"+s.getValeur()+" :\n"
				+ genererBloc(s.getBlocSinon(),tds)
				+ "fsi"+s.getValeur()+" : \n\t|Fin Si\n\n";
		return resultat;
	}

	private String genererTantque(Noeud noeud,Tds tds) {
	    String resultat = "\n\t|Tant Que\n";
		TantQue tq = new TantQue(0);
        if (noeud instanceof TantQue) {
            tq = (TantQue) noeud;
        }
		resultat += "boucle"+tq.getValeur()+" : \n"
		        + genererAssembleur(tq.getCondition(),tds)
		        + "\tPOP(r0)\n"
		        + "\tBF(r0, finboucle"+tq.getValeur()+")\n"
		        + genererBloc(tq.getBloc(),tds)
		        + "\tBR(boucle"+tq.getValeur()+")\n"
		        + "finboucle"+tq.getValeur()+" : |Fin Tant Que\n\n";
		return resultat;
	}

   private String genererEcrire(Noeud noeud,Tds tds) {
       String resultat = "\n\t|Ecrire\n";
        resultat += genererAssembleur(noeud.getFils().get(0),tds)
                + "\tPOP(r0)\n"
        		+ "\tWRINT() |Fin Ecrire\n";
        return resultat;
    }

    private String genererRetour(Noeud noeud,Tds tds) {
        String resultat = "\n\t|Retourne\n";
        Retour r = new Retour("");
        if (noeud instanceof Retour) {
            r = (Retour) noeud;
        }
        resultat += genererAssembleur(r.getLeFils(),tds)
                + "\t|Fin Retourne\n";
        return resultat;
    }

    private String genererPlus(Noeud noeud,Tds tds) {
        String resultat = "\n\t|Plus\n";
        resultat += genererAssembleur(noeud.getFils().get(0),tds)
                + genererAssembleur(noeud.getFils().get(1),tds)
                + "\tPOP(R1)\n"
                + "\tPOP(R0)\n"
                + "\tADD(R0, R1, R2)\n"
                + "\tPUSH(R2) |Fin Plus\n\n";
        return resultat;
    }

    private String genererMoins(Noeud noeud,Tds tds) {
        String resultat = "\n\t|Moins\n";
        resultat += genererAssembleur(noeud.getFils().get(0),tds)
                + genererAssembleur(noeud.getFils().get(1),tds)
                + "\tPOP(r1)\n"
                + "\tPOP(r0)\n"
                + "\tSUB(r0,r1,r2)\n"
                + "\tPUSH(r2) |Fin Moins\n";
        return resultat;
    }

    private String genererDivision(Noeud noeud,Tds tds) {
        String resultat = "\n\t|Division\n";
        resultat += genererAssembleur(noeud.getFils().get(0),tds)
                + genererAssembleur(noeud.getFils().get(1),tds)
                + "\tPOP(R1)\n"
                + "\tPOP(r0)\n"
                + "\tDIV(r0,r1,r2)\n"
                + "\tPUSH(r2) |Fin Division\n";
        return resultat;
    }

    private String genererMultiplication(Noeud noeud,Tds tds) {
        String resultat = "\n\t|Multiplication\n";
        resultat += genererAssembleur(noeud.getFils().get(0),tds)
                + genererAssembleur(noeud.getFils().get(1),tds)
                + "\tPOP(R1)\n"
                + "\tPOP(r0)\n"
                + "\tMUL(r0,r1,r2)\n"
                + "\tPUSH(r2) |Fin Multiplication\n";
        return resultat;
    }

    private String genererSuperieur(Noeud noeud,Tds tds) {
        String resultat = "\n\t|Superieur\n";
        resultat += genererAssembleur(noeud.getFils().get(0),tds)
                + genererAssembleur(noeud.getFils().get(1),tds)
                + "\tPOP(R1)\n"
                + "\tPOP(r0)\n"
                + "\tCMPLT(r1,r0,r2)\n"
                + "\tPUSH(r2) |Fin Sup\n";
        return resultat;
    }

    private String genererInferieur(Noeud noeud,Tds tds) {
        String resultat = "\n\t|Inferieur\n";
        resultat += genererAssembleur(noeud.getFils().get(0),tds)
                + genererAssembleur(noeud.getFils().get(1),tds)
                + "\tPOP(R1)\n"
                + "\tPOP(r0)\n"
                + "\tCMPLT(r0,r1,r2)\n"
                + "\tPUSH(r2) |Fin Inf\n";
        return resultat;
    }

    private String genererSuperieurEgal(Noeud noeud,Tds tds) {
        String resultat = "\n\t|Superieur ou egal\n";
        resultat += genererAssembleur(noeud.getFils().get(0),tds)
                + genererAssembleur(noeud.getFils().get(1),tds)
                + "\tPOP(R1)\n"
                + "\tPOP(r0)\n"
                + "\tCMPLE(r1,r0,r2)\n"
                + "\tPUSH(r2) |Fin Supegal\n";
        return resultat;
    }

    private String genererInferieurEgal(Noeud noeud,Tds tds) {
        String resultat = "\n\t|Inferieur ou egal\n";
        resultat += genererAssembleur(noeud.getFils().get(0),tds)
                + genererAssembleur(noeud.getFils().get(1),tds)
                + "\tPOP(R1)\n"
                + "\tPOP(r0)\n"
                + "\tCMPLE(r0,r1,r2)\n"
                + "\tPUSH(r2) |Fin Infegal\n";
        return resultat;
    }

    private String genererEgal(Noeud noeud,Tds tds) {
        String resultat = "\n\t|Egal\n";
        resultat += genererAssembleur(noeud.getFils().get(0),tds)
                + genererAssembleur(noeud.getFils().get(1),tds)
                + "\tPOP(R1)\n"
                + "\tPOP(r0)\n"
                + "\tCMPEQ(r0,r1,r2)\n"
                + "\tPUSH(r2) |Fin Egal\n";
        return resultat;
    }

    private String genererDifferent(Noeud noeud,Tds tds) {
        String resultat = "\n\t| Diferrencef\n";
        resultat += genererAssembleur(noeud.getFils().get(0),tds)
                + genererAssembleur(noeud.getFils().get(1),tds)
                + "\tPOP(R1)\n"
                + "\tPOP(r0)\n"
                + "\tCMPEQ(r0,r1,r2)\n"
                + "\tCMPEQC(R2,0,R3)\n"
                + "\tPUSH(r) |Fin Difference\n";
        return resultat;
    }

    private String genererIdf(Noeud noeud, Tds tds) {
        String resultat = "\n\t|Debut Idf\n";
        Idf i = new Idf(0);
        if (noeud instanceof Idf) {
            i = (Idf) noeud;
        }
        resultat += "\tLD("+i.getFonction()+i.getValeur()+", R0)\n"
                + "\tPUSH(R0) |Fin Idf\n";
        return resultat;
    }

    private String genererConstante(Noeud noeud) {
        String resultat = "\n\t|Constante\n";
        Constante c = new Constante(0);
        if (noeud instanceof Constante) {
            c = (Constante) noeud;
        }
        resultat += "\tCMOVE("+c.getValeur()+", r0) \n"
                + "\tPUSH(r0) |Fin Constante\n";
        return resultat;
    }

    private String genererLire(Noeud noeud) {
        String resultat = "\n\t|Lire\n";
        resultat = "\tRDINT()\n"
                + "\tPUSH(R0) |Fin Lire\n";
        return resultat;
    }

    private String genererAppel(Noeud noeud, Tds tds) {
        String resultat = "\n\t|Appel\n";
        Appel a = new Appel("");
        if (noeud instanceof Appel) {
            a = (Appel) noeud;
        }
        Fonction f = new Fonction("");
        if (a.getValeur() instanceof Fonction) {
            f = (Fonction) a.getValeur();
        }
        if(noeud.getFils() != null && !noeud.getFils().isEmpty()) {
            for(Noeud n : noeud.getFils()) {
                resultat+= genererAssembleur(n,tds);
            }
            
            List<String> noms = new ArrayList<String>();
            for( String k : tds.getTable().keySet()) {
                List<Symbole> i = tds.getTable().get(k);
                for(Symbole s : i) {
                    if(s.get_type() == "int" && s.getScope()==f.getValeur() && s.getCat()==Symbole.CAT_PARAMETRE) {
                        noms.add(f.getValeur()+s.getNom());
                    }
                  }
            }
            for(int j = noms.size()-1; j >=0;j--) {
                resultat += "\tPOP(r0)\n"
                        + "\tST(r0,"+noms.get(j)+")\n";
            }
        }
        resultat += "\tCALL(" + f.getValeur() + ") |Fin Appel\n";
        return resultat;
    }
	
	private String genererVariables(Tds tds) {
		String globales = "\n";

		for (String k : tds.getTable().keySet()) {
			List<Symbole> i = tds.getTable().get(k);
			for (Symbole s : i) {
				if (s.get_type() == "int" && s.getScope() == Symbole.SCOPE_GLOBAL && s.getCat() == Symbole.CAT_GLOBAL) {
					globales += s.getNom() + ": LONG(" + s.get_valeur() + ")\n";
				}
			}
		}

		String locales = "";

		for (String k : tds.getTable().keySet()) {
			List<Symbole> i = tds.getTable().get(k);
			for (Symbole s : i) {
				if (s.get_type() == "int" && s.getCat() == Symbole.CAT_PARAMETRE) {
					locales += s.getScope() + s.getNom() + ": LONG(" + s.get_valeur() + ")\n";
				}
			}
		}
		for (String k : tds.getTable().keySet()) {
			List<Symbole> i = tds.getTable().get(k);
			for (Symbole s : i) {
				if (s.get_type() == "int" && s.getCat() == Symbole.CAT_LOCAL) {
					locales += s.getScope() + s.getNom() + ": LONG(" + s.get_valeur() + ")\n";
				}
			}
		}
		return globales + locales + "\n";
	}
	
}
