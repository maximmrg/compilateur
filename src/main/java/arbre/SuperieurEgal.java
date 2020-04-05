package arbre;

import java.util.ArrayList;

public class SuperieurEgal extends Noeud0 {
	
	public SuperieurEgal() {
		setCat(Categories.SUPEQ);
		setFils(new ArrayList<Noeud>());
	}
	
	public Noeud getFilsGauche() {
		return getFils().get(0);
	}

	public Noeud getFilsDroit() {
		return getFils().get(1);
	}
	
	public void setFilsGauche(Noeud fils_gauche) {
		getFils().add(0, fils_gauche);
	}
	
	public void setFilsDroit(Noeud fils_droit) {
		getFils().add(1, fils_droit);
	}	
}
