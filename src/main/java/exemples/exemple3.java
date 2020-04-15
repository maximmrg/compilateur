package exemples;

import arbre.*;
import tds.Main;
import tds.Symbole;
import tds.Tds;

public class exemple3 {
	
	public static Noeud getNoeud() throws Exception {
		Tds tds = new Tds();
		Symbole s = tds.ajouter("main",Symbole.CAT_FONCTION, Symbole.SCOPE_GLOBAL, Symbole.TYPE_VOID);
		Symbole s2 = tds.ajouter("i",Symbole.CAT_GLOBAL,Symbole.SCOPE_GLOBAL, Symbole.TYPE_ENTIER);
		s2.set_valeur(10);
		Symbole s3 = tds.ajouter("j",Symbole.CAT_GLOBAL,Symbole.SCOPE_GLOBAL,Symbole.TYPE_ENTIER);
		s3.set_valeur(20);
		Symbole s4 = tds.ajouter("k",Symbole.CAT_GLOBAL,Symbole.SCOPE_GLOBAL,Symbole.TYPE_ENTIER);
		Symbole s5 = tds.ajouter("l",Symbole.CAT_GLOBAL,Symbole.SCOPE_GLOBAL,Symbole.TYPE_ENTIER);
		System.out.println(tds);

		Prog prog = new Prog();
		Idf i = new Idf (10);
		Idf j = new Idf (20);
		Idf k = new Idf("k");
		Idf l = new Idf("l");
		Fonction main = new Fonction("main", prog);
		
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
		
		prog.ajouterUnFils(main);
		return prog;
	}
	
	public static Tds getTds() {
		return Main.exemple3();
	}
}
