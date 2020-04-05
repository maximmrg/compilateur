package arbre;

import java.util.List;
import java.util.logging.Logger;

//Représente un noeud et un arbre
public abstract class Noeud {
	private static final Logger LOG = Logger.getLogger(Noeud.class.getName());

	
	//les catégories possibles pour un noeud
	static enum Categories {
		PROG, 
		FONCTION, 
		BLOC,
		AFF, 
		SI,  
		TQ, 
		ECRIRE, 
		RET,
		PLUS,
		MOINS, 
		DIV, 
		MUL,
		SUP, 
		INF, 
		SUPEQ, 
		INFEQ, 
		EGAL, 
		DIFF,
		IDF, 
		CONST, 
		LIRE, 
		APPEL
	}
	//attributs
	private Categories cat;
	private List<Noeud> fils;

	//abstract
	abstract public String  getLabel();

	//methodes
	
	public boolean ajouterUnFils(Noeud f) {
		return getFils().add(f);
	}
	
	public int ajouterDesFils(List<Noeud> l) {
		int res = 0;
		for (Noeud f : l) {
			if (ajouterUnFils(f)) {
				res++;
			}
		}
		return res;
	}
	
	public boolean estFeuille() {
		if ((fils == null) || (fils.size() == 0)){
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return getLabel();
	}


	//setters & getters
	public Categories getCat() {
		return cat;
	}
	public void setCat(Categories cat) {
		this.cat = cat;
	}
	public List<Noeud> getFils() {
		return fils;
	}
	public void setFils(List<Noeud> fils) {
		this.fils = fils;
	}

}
