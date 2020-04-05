package exemples;

import arbre.*;

public class exemple8 {

	Noeud programme;
	
	public void programme() {
		Fonction main = new Fonction("main");
		Idf a = new Idf("a");
		Fonction f = new Fonction("f");
		Idf x = new Idf("x");
		Idf i = new Idf("i");
		Idf j = new Idf("j");
		
		
		Plus plus1 = new Plus();
		plus1.setFilsGauche(i);
		plus1.setFilsDroit(j);
		
		Affectation affect1 = new Affectation();
		affect1.setFilsGauche(x);
		affect1.setFilsDroit(plus1);
		
		Constante c10 = new Constante(10);
		Plus plus2 = new Plus();
		plus2.setFilsGauche(x);
		plus2.setFilsDroit(c10);
		
		Retour retour_f = new Retour("retour_f");
		retour_f.ajouterUnFils(plus2);
		f.ajouterUnFils(affect1);
		f.ajouterUnFils(retour_f);
		
		Constante c1 = new Constante(1);
		Constante c2 = new Constante(2);
		Appel appel_f = new Appel("appel_f");
		appel_f.ajouterUnFils(c1);
		appel_f.ajouterUnFils(c2);
		
		Affectation affect2 = new Affectation();
		affect2.setFilsGauche(a);
		affect2.setFilsDroit(appel_f);
		
		Ecrire ecrire1 = new Ecrire();
		ecrire1.ajouterUnFils(a);
		
		main.ajouterUnFils(affect2);
		main.ajouterUnFils(ecrire1);
		
		programme.ajouterUnFils(f);
		programme.ajouterUnFils(main);
				
		//test
		
	}
}
