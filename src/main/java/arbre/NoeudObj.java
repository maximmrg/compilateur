package arbre;

//classe des noeuds ayant un attribut valeur de type complexe
public class NoeudObj extends Noeud{
	 private Object valeur;
	 
	 public NoeudObj() {
		 setValeur(null);
	 }
	 
	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		StringBuffer buf = new StringBuffer();
		buf.append(getCat());
		buf.append("/");
		buf.append(valeur.toString());
		return buf.toString();
	}

	public Object getValeur() {
		return valeur;
	}

	public void setValeur(Object valeur) {
		this.valeur = valeur;
	}
}
