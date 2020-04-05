package arbre;

public class Constante extends NoeudInt {
	
	public Constante(int valeur) {
		setValeur(valeur);
		setCat(Categories.CONST);
		setFils(null);
	}
}
