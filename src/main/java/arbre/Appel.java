package arbre;

import java.util.ArrayList;

public class Appel extends NoeudObj{
	
	public Appel(Object valeur) {
		setCat(Categories.APPEL);
		setValeur(valeur);
		setFils(new ArrayList<Noeud>());
	}
	
	public Noeud getLeFils() {
		return getFils().get(0);
	}
	
	public void setLeFils(Noeud n) {
		getFils().add(0, n);
	}
}
