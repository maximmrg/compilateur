package arbre;

import java.util.ArrayList;

public class Retour extends NoeudObj{
	
	public Retour(Object valeur) {
		setCat(Categories.RET);
		setValeur(valeur);
		setFils(new ArrayList<Noeud>());
	}
	
	
	public Noeud getRetFils() {
		return getFils().get(0);
	}
	
	public void setRetFils(Noeud n) {
		getFils().add(0, n);
	}

}
