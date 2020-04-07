package exemples;

import arbre.*;
import tds.Main;
import tds.Symbole;
import tds.Tds;

public class exemple8 {

	public static Noeud getNoeud() throws Exception {
		Tds tds = new Tds();
        Symbole s = tds.ajouter("main",Symbole.CAT_FONCTION,Symbole.CAT_GLOBAL,Symbole.TYPE_VOID);
        Symbole s2 = tds.ajouter("a",Symbole.CAT_GLOBAL,Symbole.CAT_GLOBAL,Symbole.TYPE_ENTIER);
        Symbole s3 = tds.ajouter("f",Symbole.CAT_FONCTION, Symbole.SCOPE_GLOBAL,Symbole.TYPE_ENTIER);
        s3.set_nbparam(2);
        s3.set_nbloc(1);
        Symbole s4 = tds.ajouter("x",Symbole.CAT_LOCAL,"f",Symbole.TYPE_ENTIER);
        s4.set_rang(0);
        Symbole s5 = tds.ajouter("i",Symbole.CAT_PARAMETRE,"f",Symbole.TYPE_ENTIER);
        s5.set_rang(0);
        Symbole s6 = tds.ajouter("j",Symbole.CAT_PARAMETRE,"f",Symbole.TYPE_ENTIER);
        s6.set_rang(1);
		
		Prog prog = new Prog();
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

		prog.ajouterUnFils(f);
		prog.ajouterUnFils(main);
		return prog;

	}

	public static Tds getTds() {
		return Main.exemple8();
	}
}
