package exemples;

import java.util.logging.Logger;

import arbre.*;
import tds.Main;
import tds.Symbole;
import tds.Tds;

public class exemple1 {
	private static final Logger LOG = Logger.getLogger(Main.class.getName());
	public static Noeud getNoeud() throws Exception {
		Tds tds = new Tds();
        Symbole s = tds.ajouter("main",Symbole.CAT_FONCTION, Symbole.SCOPE_GLOBAL, Symbole.TYPE_VOID);
		
		Prog prog = new Prog();
        Fonction main = new Fonction("main");
        prog.ajouterUnFils(main);
        return prog;

	}

	public static Tds getTds() {
		return Main.exemple1();
	}
}
