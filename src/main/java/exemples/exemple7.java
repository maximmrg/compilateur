package exemples;

import java.util.ArrayList;
import java.util.Arrays;

import arbre.*;

public class exemple7 {
	Noeud programme;
	
	public void programme() {
		Fonction main = new Fonction("main");
		Idf a = new Idf("a");
		Idf i = new Idf("i");
		Idf x = new Idf("x");
		Idf y = new Idf("y");
		
		Fonction f = new Fonction("f");
		
		Constante c1 = new Constante(1);
		Affectation affect1 = new Affectation();
		affect1.setFilsGauche(x);
		affect1.setFilsDroit(c1);
		
		Affectation affect2 = new Affectation();
		affect2.setFilsGauche(y);
		affect2.setFilsDroit(c1);
		
		Plus plus1 = new Plus();
		plus1.setFilsGauche(x);
		plus1.setFilsDroit(y);
		
		Plus plus2 = new Plus();
		plus2.setFilsGauche(i);
		plus2.setFilsDroit(plus1);
		
		Affectation affect3 = new Affectation();
		affect3.setFilsGauche(a);
		affect3.setFilsDroit(plus2);
		
		f.ajouterUnFils(affect1);
		f.ajouterUnFils(affect2);
		f.ajouterUnFils(affect3);
		
		Constante c3 = new Constante(3);
		Appel appel_f =  new Appel("appel_f");
		appel_f.ajouterUnFils(c3);
		
		Ecrire ecrire1 = new Ecrire();
		ecrire1.ajouterUnFils(a);
		
		main.ajouterUnFils(appel_f);
		main.ajouterUnFils(ecrire1);
		
		programme.ajouterUnFils(f);
		programme.ajouterUnFils(main);
	}
}
