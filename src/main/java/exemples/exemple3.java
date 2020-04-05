package exemples;

import arbre.*;

public class exemple3 {
	
	Noeud programme;
	
	public void programme() {
		Idf i = new Idf (10);
		Idf j = new Idf (20);
		Idf k = new Idf("k");
		Idf l = new Idf("l");
		Fonction main = new Fonction("main");
		
		Affectation affect1 = new Affectation();
		affect1.setFilsGauche(k);
		Constante a = new Constante(2);
		affect1.setFilsDroit(a);
		
		Affectation affect2 = new Affectation();
		affect2.setFilsGauche(l);
		
		Multiplication multiplication1 = new Multiplication();
		Constante b = new Constante(3);
		multiplication1.setFilsGauche(b);
		multiplication1.setFilsDroit(j);
		
		Plus plus1 = new Plus();
		plus1.setFilsGauche(i);
		plus1.setFilsDroit(multiplication1);
		
		affect2.setFilsGauche(l);
		affect2.setFilsDroit(plus1);
		
		main.ajouterUnFils(affect1);
		main.ajouterUnFils(affect2);
		
		this.programme.ajouterUnFils(main);
	}
	
}
