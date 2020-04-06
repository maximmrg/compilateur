package exemples;

import java.util.Arrays;

import arbre.*;
import tds.Main;
import tds.Tds;

public class exemple5 {
		
	public static Noeud getNoeud() {
		Prog prog = new Prog();
		Fonction main = new Fonction("main");
		Idf i = new Idf("i");
		Lire lire1 = new Lire();
		Affectation affect1 = new Affectation();
		
		affect1.setFilsGauche(i);
		affect1.setFilsDroit(lire1);
		
		Constante c1 = new Constante(1);
		Ecrire ecrire1 = new Ecrire();
		ecrire1.setLeFils(c1);		
		Bloc bloc1 = new Bloc();
		bloc1.ajouterUnFils(ecrire1);
		
		
		Constante c2 = new Constante(2);
		Ecrire ecrire2 = new Ecrire();
		ecrire2.setLeFils(c2);		
		Bloc bloc2 = new Bloc();
		bloc2.ajouterUnFils(ecrire2);
		
		Constante c3 = new Constante(10);
		Superieur sup1 = new Superieur();
		sup1.setFilsGauche(i);
		sup1.setFilsDroit(c3);
		
		Si si1 = new Si(1);
		si1.setCondition(sup1);
		si1.setBlocAlors(bloc1);
		si1.setBlocSinon(bloc2);
		
		main.ajouterDesFils(Arrays.asList(affect1, si1));
		
		prog.ajouterUnFils(main);
		return prog;
		
	}
	
	public static Tds getTds() {
		return Main.exemple5();
	}
}
