package exemples;

import arbre.*;
import tds.Main;
import tds.Symbole;
import tds.Tds;

public class exemple4 {
	
	public static Noeud getNoeud() throws Exception {
		
		Tds tds = new Tds();
        Symbole s = tds.ajouter("main",Symbole.CAT_FONCTION,Symbole.SCOPE_GLOBAL,Symbole.TYPE_VOID);
        Symbole s2 = tds.ajouter("i",Symbole.CAT_GLOBAL,Symbole.SCOPE_GLOBAL,Symbole.TYPE_ENTIER);
        Symbole s3 = tds.ajouter("j",Symbole.CAT_GLOBAL,Symbole.SCOPE_GLOBAL,Symbole.TYPE_ENTIER);
        s3.set_valeur(20);
        
		Prog prog = new Prog();
		Fonction main = new Fonction("main", prog);
		
		Idf i = new Idf("i");
		Idf j = new Idf("j");
		
		Lire lire1 = new Lire();
		Affectation affect1 = new Affectation();
		affect1.setFilsGauche(i);
		affect1.setFilsDroit(lire1);
		
		Plus plus1 = new Plus();
		plus1.setFilsGauche(i);
		plus1.setFilsDroit(j);
		
		Ecrire ecrire1 = new Ecrire();
		ecrire1.ajouterUnFils(plus1);
		
		main.ajouterUnFils(affect1);
		main.ajouterUnFils(ecrire1);
		
		prog.ajouterUnFils(main);		
		return prog;
	}
	public static Tds getTds() {
		return Main.exemple4();
	}
}
