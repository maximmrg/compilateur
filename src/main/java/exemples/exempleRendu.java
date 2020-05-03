package exemples;

import java.util.logging.Logger;

import arbre.*;
import tds.Main;
import tds.Symbole;
import tds.Tds;

public class exempleRendu {
	private static final Logger LOG = Logger.getLogger(Main.class.getName());
	public static Noeud getNoeud() throws Exception {
		Tds tds = new Tds();
        Symbole s = tds.ajouter("main",Symbole.CAT_FONCTION, Symbole.SCOPE_GLOBAL, Symbole.TYPE_VOID);
        Symbole s2 = tds.ajouter("n", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, Symbole.TYPE_ENTIER);
        Symbole s3 = tds.ajouter("nb", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, Symbole.TYPE_ENTIER);
		
		Prog prog = new Prog();
        Fonction main = new Fonction("main", prog);
        
        Idf n = new Idf ("n");
        Idf res = new Idf("res");
        Constante c0 = new Constante(0);
        Constante c1 = new Constante(1);
        
        Lire lire1 = new Lire();
		Affectation affect1 = new Affectation();
		affect1.setFilsGauche(n);
		affect1.setFilsDroit(lire1);
		Affectation affect2 = new Affectation();
		affect2.setFilsGauche(res);
		affect2.setFilsDroit(n);
		
		Fonction f = new Fonction("f", main);
		
		
		Bloc bloc1 = new Bloc();
		Moins moins1 = new Moins();
		moins1.setFilsGauche(n);
		moins1.setFilsDroit(c1);
		Affectation affect3 = new Affectation();
		affect3.setFilsGauche(n);
		affect3.setFilsDroit(moins1);
		Appel appelRec = new Appel(f);
		appelRec.ajouterUnFils(n);
		appelRec.ajouterUnFils(res);
		Affectation affect4 = new Affectation();
		affect4.setFilsGauche(res);
		affect4.setFilsDroit(appelRec);
		bloc1.ajouterUnFils(affect3);
		bloc1.ajouterUnFils(affect4);
		
		Multiplication mult1 = new Multiplication();
		mult1.setFilsGauche(res);
		mult1.setFilsDroit(n);
		Retour ret1 = new Retour("ret1");
		ret1.ajouterUnFils(mult1);
		
		Si si1 = new Si(0);
		Superieur sup1 = new Superieur();
		sup1.setFilsGauche(n);
		sup1.setFilsDroit(res);
		si1.setCondition(sup1);
		si1.setBlocAlors(bloc1);
		
		f.ajouterUnFils(si1);
		f.ajouterUnFils(ret1);
		
		Appel appelF = new Appel(f);
		appelF.ajouterUnFils(n);
		appelF.ajouterUnFils(res);
		
		Ecrire ecrireRes = new Ecrire();
		ecrireRes.setLeFils(res);
		
		main.ajouterUnFils(affect1);
		main.ajouterUnFils(affect2);
		main.ajouterUnFils(f);
		main.ajouterUnFils(appelF);
		main.ajouterUnFils(ecrireRes);
		
		
        prog.ajouterUnFils(main);
        return prog;

	}

	public static Tds getTds() {
		return Main.exempleRendu();
	}
}
