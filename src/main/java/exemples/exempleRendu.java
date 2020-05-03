package exemples;

import java.util.logging.Logger;

import arbre.*;
import tds.Main;
import tds.Symbole;
import tds.Tds;

public class exempleRendu {
	private static final Logger LOG = Logger.getLogger(Main.class.getName());
	public static Noeud getNoeud() throws Exception {
		Tds tds = new Tds();
        Symbole s = tds.ajouter("main",Symbole.CAT_FONCTION, Symbole.SCOPE_GLOBAL, Symbole.TYPE_VOID);
        Symbole s2 = tds.ajouter("n", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, Symbole.TYPE_ENTIER);
        Symbole s3 = tds.ajouter("nb", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, Symbole.TYPE_ENTIER);
//        Symbole s4 = tds.ajouter("i", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, Symbole.TYPE_ENTIER);
//        s4.set_valeur(0);
//        Symbole s5 = tds.ajouter("res", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, Symbole.TYPE_ENTIER);
//        s5.set_valeur(0);
		
		Prog prog = new Prog();
        Fonction main = new Fonction("main", prog);
        
        Idf n = new Idf ("n");
        //Idf nb = new Idf("nb");
        //Idf i = new Idf (0);
        Idf res = new Idf("res");
        Constante c0 = new Constante(0);
        Constante c1 = new Constante(1);
        
        Lire lire1 = new Lire();
		Affectation affect1 = new Affectation();
		affect1.setFilsGauche(n);
		affect1.setFilsDroit(lire1);
		Affectation affect2 = new Affectation();
		affect2.setFilsGauche(res);
		affect2.setFilsDroit(n);
//		Affectation affect5 = new Affectation();
//		affect5.setFilsGauche(res);
//		affect5.setFilsDroit(c0);
		
		Bloc bloc1 = new Bloc();
		Moins moins1 = new Moins();
		moins1.setFilsGauche(n);
		moins1.setFilsDroit(c1);
		Affectation affect3 = new Affectation();
		affect3.setFilsGauche(n);
		affect3.setFilsDroit(moins1);
		
		Multiplication mult1 = new Multiplication();
		mult1.setFilsGauche(res);
		mult1.setFilsDroit(n);	
		Affectation affect4 = new Affectation();
		affect4.setFilsGauche(res);
		affect4.setFilsDroit(mult1);
		
		bloc1.ajouterUnFils(affect3);
		bloc1.ajouterUnFils(affect4);		
		
		Superieur sup1 = new Superieur();
		sup1.setFilsGauche(n);
		sup1.setFilsDroit(c1);
		
//		Plus plus1 = new Plus();
//		plus1.setFilsGauche(i);
//		plus1.setFilsDroit(c1);
//		Affectation affect2 = new Affectation();
//		affect2.setFilsGauche(i);
//		affect2.setFilsDroit(c1);
		
		TantQue tq1 = new TantQue(1);
        tq1.setCondition(sup1);
        tq1.setBlocAlors(bloc1);
        
        Ecrire ecrire1 = new Ecrire();
        ecrire1.ajouterUnFils(res);
        
        main.ajouterUnFils(affect1);
        main.ajouterUnFils(affect2);
        //main.ajouterUnFils(affect5);
        main.ajouterUnFils(tq1);
        main.ajouterUnFils(ecrire1);
		
        prog.ajouterUnFils(main);
        return prog;

	}

	public static Tds getTds() {
		return Main.exempleRendu();
	}
}
