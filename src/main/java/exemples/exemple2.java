package exemples;

import arbre.*;

public class exemple2 {
	Noeud programme;
	
	public void programme() {
		Idf i = new Idf(10);
		Idf j = new Idf(20);
		Idf k = new Idf("k");
		Idf l = new Idf("l");
		
		Fonction main = new Fonction("main");
		
		this.programme.ajouterUnFils(main);
	}
	
}
