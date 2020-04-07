package exemples;

import arbre.*;
import tds.Main;
import tds.Symbole;
import tds.Tds;

public class exemple2 {	

	public static Noeud getNoeud() throws Exception {
		
		Tds tds = new Tds();
		Symbole s = tds.ajouter("main", Symbole.CAT_FONCTION, Symbole.SCOPE_GLOBAL, Symbole.TYPE_VOID);
		Symbole s2 = tds.ajouter("i", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, Symbole.TYPE_ENTIER);
		s2.set_valeur(10);
		Symbole s3 = tds.ajouter("j", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, Symbole.TYPE_ENTIER);
		s3.set_valeur(20);
		Symbole s4 = tds.ajouter("k", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, Symbole.TYPE_ENTIER);
		Symbole s5 = tds.ajouter("l", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, Symbole.TYPE_ENTIER);
		
		System.out.println(tds.toString());
		
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
