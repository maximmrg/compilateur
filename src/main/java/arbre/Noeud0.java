package arbre;

//classe des noeud qui n'ont pas d'attributs supplémentaires
//Ex : PROG, BLOC, AFF, RET, PLUS, MOINS, DIV, MUL, SUP, INF, SUPEQ, ...
public class Noeud0 extends Noeud{
	public Noeud0(){		
	}
	
	@Override
	public String getLabel() {
		String label = getCat().toString();
		return label;
	}
}
