package arbre;

import java.util.ArrayList;

public class Ecrire extends Noeud0 {
	
	public Ecrire() {
		setCat(Categories.ECRIRE);
		setFils(new ArrayList<Noeud>());
	}
	
	public Noeud getLeFils() {
		return getFils().get(0);
	}
	
	public void setLeFils(Noeud n) {
		getFils().add(0, n);
	}
}
