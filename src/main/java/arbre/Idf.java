package arbre;

//défini une variable
public class Idf extends NoeudObj{
	
	public Idf(Object valeur) {
		setCat(Categories.IDF);
		setValeur(valeur);
		setFils(null);
	}
}
