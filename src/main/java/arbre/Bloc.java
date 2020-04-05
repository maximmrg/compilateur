package arbre;

import java.util.ArrayList;

public class Bloc extends Noeud0{
	
	public Bloc() {
		setCat(Categories.BLOC);
		setFils(new ArrayList<Noeud>());
	}
}
