package exemples;

import arbre.*;
import tds.Main;
import tds.Tds;

public class exemple2 {
	Noeud programme;
	

	public static Noeud getNoeud() {
		 Prog prog = new Prog();
	        Fonction main = new Fonction("main");
	        
	        Idf i3 = new Idf("i");
	        Idf j3 = new Idf("j");
	        Idf k3 = new Idf("k");
	        Idf l3 = new Idf("l");

	        prog.ajouterUnFils(main);
	        return prog;
	}
	public static Tds getTds() {
		return Main.exemple2();
	}
	
}
