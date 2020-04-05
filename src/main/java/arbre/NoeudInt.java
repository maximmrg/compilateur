package arbre;

//classe des noeuds n'ayant pas d'attributs supplémentaires
public class NoeudInt extends Noeud{

	int valeur;
		
	public NoeudInt() {
		setValeur(0);
	}
	
	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		StringBuffer buf = new StringBuffer();
		buf.append(getCat());
		buf.append("/");
		buf.append(valeur);
		return buf.toString();
	}
	
	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}


}
