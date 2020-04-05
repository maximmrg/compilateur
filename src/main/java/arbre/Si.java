package arbre;

import java.util.ArrayList;

public class Si extends NoeudInt{
	
	public Si(int valeur) {
		setValeur(valeur);
		setCat(Categories.SI);
		setFils(new ArrayList<Noeud>(3));
		this.getFils().set(0, null);
		this.getFils().set(1, new Bloc());
		this.getFils().set(2, new Bloc());
	}
	
	public Noeud getCondition() {
		return getFils().get(0);
	}
	
	public Bloc getBlocAlors() {
		return (Bloc) getFils().get(1);
	}
	
	public Bloc getBlocSinon() {
		return (Bloc) getFils().get(1);
	}
	
	public void setCondition(Noeud n) {
		getFils().set(0, n);
	}
	
	public void setBlocAlors(Bloc b) {
		getFils().set(1, b);
	}
	
	public void setBlocSinon(Bloc b) {
		getFils().set(2, b);
	}
}
