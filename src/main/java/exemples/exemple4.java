package exemples;

import arbre.*;
import tds.Main;
import tds.Tds;

public class exemple4 {
	
	public static Noeud getNoeud() {
		Prog prog = new Prog();
		Fonction main = new Fonction("main");
		
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
