package arbre;

import java.util.ArrayList;

public class Affectation extends Noeud0{
	
	public Affectation() {
		setCat(Categories.AFF);
		setFils(new ArrayList<Noeud>(2));
	}
	
	public Noeud getFilsGauche() {
		return getFils().get(0);
	}
	
	public Noeud getFilsDroit() {
		return getFils().get(1);
	}
	
	public void setFilsGauche(Noeud n) {
		getFils().add(0, n);
	}
	
	public void setFilsDroit(Noeud n) {
		getFils().add(1, n);
	}
}
