package exemples;

import java.util.ArrayList;
import java.util.Arrays;

import arbre.*;
import tds.Main;
import tds.Symbole;
import tds.Tds;

public class exemple7 {
	
	public static Noeud getNoeud() throws Exception {
		Tds tds = new Tds();
		Symbole s = tds.ajouter("main",Symbole.CAT_FONCTION,Symbole.CAT_GLOBAL,Symbole.TYPE_VOID);
		Symbole s2 = tds.ajouter("a",Symbole.CAT_GLOBAL,Symbole.SCOPE_GLOBAL,Symbole.TYPE_ENTIER);
		s2.set_valeur(10);
		Symbole s3 = tds.ajouter("f",Symbole.CAT_FONCTION, Symbole.SCOPE_GLOBAL,Symbole.TYPE_ENTIER);
		s3.set_nbparam(1);
		s3.set_nbloc(2);
		Symbole s4 = tds.ajouter("i",Symbole.CAT_PARAMETRE,"f",Symbole.TYPE_ENTIER);
		s4.set_rang(0);
		Symbole s5 = tds.ajouter("x",Symbole.CAT_LOCAL,"f",Symbole.TYPE_ENTIER);
		s5.set_rang(0);
		Symbole s6 = tds.ajouter("y",Symbole.CAT_LOCAL,"f",Symbole.TYPE_ENTIER);
		s6.set_rang(1);
		
		Prog prog = new Prog();
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
		
		prog.ajouterUnFils(f);
		prog.ajouterUnFils(main);
		return prog;
	}
	
	public static Tds getTds() {
		return Main.exemple7();
	}
}
