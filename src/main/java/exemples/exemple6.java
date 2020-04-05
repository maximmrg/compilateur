package exemples;

import java.util.ArrayList;
import java.util.Arrays;

import arbre.*;

public class exemple6 {
	Noeud programme;
	
	public void programme() {
		Fonction main = new Fonction("main");
		Idf i = new Idf("i");
		Constante c0 = new Constante(0);
		Affectation affect1 = new Affectation();
		affect1.setFilsGauche(i);
		affect1.setFilsDroit(c0);
		
		Idf n = new Idf("n");
		Inferieur inf1 = new Inferieur();
		inf1.setFilsGauche(i);
		inf1.setFilsDroit(n);
		
		Constante c1 = new Constante(1);
		Plus plus1 = new Plus();
		plus1.setFilsGauche(i);
		plus1.setFilsDroit(c1);
		Affectation affect2 = new Affectation();
		affect2.setFilsGauche(i);
		affect2.setFilsDroit(plus1);
		
		Ecrire ecrire1 = new Ecrire();
		ecrire1.setLeFils(i);
		Bloc bloc1 = new Bloc();
		bloc1.ajouterUnFils(inf1);
		bloc1.ajouterUnFils(ecrire1);
		bloc1.ajouterUnFils(affect2);
		//bloc1.ajouterDesFils(Arrays.asList(ecrire1, affect2)));
		
		TantQue tq1 = new TantQue(1);
		tq1.setCondition(inf1);
		tq1.setBlocAlors(bloc1);		
		
		main.ajouterDesFils(Arrays.asList(affect1, tq1));
		this.programme.ajouterUnFils(main);
	}
}
