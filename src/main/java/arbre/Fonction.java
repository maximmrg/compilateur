package arbre;

import java.util.ArrayList;

public class Fonction extends NoeudObj{
	
	public Fonction(Object valeur) {
		setCat(Categories.FONCTION);
		setValeur(valeur);
		setFils(new ArrayList<Noeud>());
	}
}
