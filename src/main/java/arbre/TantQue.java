package arbre;

import java.util.ArrayList;

public class TantQue extends NoeudInt{
	
	public TantQue(int valeur) {
		setValeur(valeur);
		setCat(Categories.TQ);
		setFils(new ArrayList<Noeud>(2));
		this.getFils().add(1, new Bloc());
	}
	
	public Noeud getCondition() {
		return getFils().get(0);
	}
	
	public Bloc getBloc() {
		return (Bloc) getFils().get(1);
	}
	
	public void setCondition(Noeud n) {
		getFils().add(0, n);
	}
	
	public void setBlocAlors(Bloc b) {
		getFils().add(1, b);
	}
}
