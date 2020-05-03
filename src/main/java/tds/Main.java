/*  License and Copyright:
 *  This file is part of tds project.
 *
 *   It is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   any later version.
 *
 *   It is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
 * 
 *  Copyright 2020 by LORIA, Université de Lorraine
 *  All right reserved 
 */
package tds;

import java.util.logging.Logger;

/**
 * Classe de test de l'api tds licence MIASHS/MIAGE
 * 
 * @author azim roussanaly
 */

public class Main {
	private static final Logger LOG = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		System.out.println("Exemple Rendu");
		System.out.println(exempleRendu());
		System.out.println("Exemple 1");
		System.out.println(exemple1());
		System.out.println("Exemple 2");
		System.out.println(exemple2());
		System.out.println("Exemple 3");
		System.out.println(exemple3());
		System.out.println("Exemple 4");
		System.out.println(exemple4());
		System.out.println("Exemple 5");
		System.out.println(exemple5());
		System.out.println("Exemple 6");
		System.out.println(exemple6());
		System.out.println("Exemple 7");
		System.out.println(exemple7());
		System.out.println("Exemple 8");
		System.out.println(exemple8());
	}
	public static Tds exempleRendu() {
		Tds tds = new Tds();
		// remplissage
		try {
			Symbole s = tds.ajouter("main", Symbole.CAT_FONCTION, Symbole.SCOPE_GLOBAL, "void");
			s.set_nbparam(0);
			s.set_nbloc(0);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("n", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, "int");
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("res", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, "int");
			s.set_valeur(0);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		return tds;
	}

	public static Tds exemple1() {
		Tds tds = new Tds();
		// remplissage
		try {
			Symbole s = tds.ajouter("main", Symbole.CAT_FONCTION, Symbole.SCOPE_GLOBAL, "void");
			s.set_nbparam(0);
			s.set_nbloc(0);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		return tds;
	}

	public static Tds exemple2() {
		Tds tds = new Tds();
		// remplissage
		try {
			Symbole s = tds.ajouter("main", Symbole.CAT_FONCTION, Symbole.SCOPE_GLOBAL, "void");
			s.set_nbparam(0);
			s.set_nbloc(4);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("i", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, "int");
			s.set_valeur(10);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("j", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, "int");
			s.set_valeur(20);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("k", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, "int");
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("l", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, "int");
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		return tds;

	}

	public static Tds exemple3() {
		Tds tds = new Tds();
		// remplissage
		try {
			Symbole s = tds.ajouter("main", Symbole.TYPE_VOID, Symbole.CAT_FONCTION, "void");
			s.set_nbparam(0);
			s.set_nbloc(0);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("i", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, "int");
			s.set_valeur(10);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("j", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, "int");
			s.set_valeur(20);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("k", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, "int");
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}

		try {
			Symbole s = tds.ajouter("l", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, "int");
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		return tds;
	}

	public static Tds exemple4() {
		Tds tds = new Tds();
		// remplissage
		try {
			Symbole s = tds.ajouter("main", Symbole.CAT_FONCTION, Symbole.SCOPE_GLOBAL, "void");
			s.set_nbparam(0);
			s.set_nbloc(0);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("i", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, "int");
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("j", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, "int");
			s.set_valeur(20);
			System.out.println(tds);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		return tds;
	}

	public static Tds exemple5() {
		Tds tds = new Tds();
		// remplissage
		try {
			Symbole s = tds.ajouter("main", Symbole.CAT_FONCTION, Symbole.SCOPE_GLOBAL, "void");
			s.set_nbparam(0);
			s.set_nbloc(0);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("i", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, "int");
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		return tds;
	}

	public static Tds exemple6() {
		Tds tds = new Tds();
		// remplissage
		try {
			Symbole s = tds.ajouter("main", Symbole.CAT_FONCTION, Symbole.SCOPE_GLOBAL, "void");
			s.set_nbparam(0);
			s.set_nbloc(0);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("i", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, "int");
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("n", Symbole.CAT_GLOBAL, Symbole.SCOPE_GLOBAL, "int");
			s.set_valeur(5);
			System.out.println(tds);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}

		return tds;
	}

	public static Tds exemple7() {
		Tds tds = new Tds();
		// remplissage
		try {
			Symbole s = tds.ajouter("main", Symbole.CAT_FONCTION, Symbole.CAT_GLOBAL, "void");
			s.set_nbparam(0);
			s.set_nbloc(0);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("a", Symbole.CAT_GLOBAL, Symbole.CAT_GLOBAL, "int");
			s.set_valeur(10);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("f", Symbole.CAT_FONCTION, Symbole.SCOPE_GLOBAL, "int");
			s.set_nbparam(1);
			s.set_nbloc(2);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("i", Symbole.CAT_PARAMETRE, "f", "int");
			s.set_rang(0);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("x", Symbole.CAT_LOCAL, "f", "int");
			s.set_rang(0);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("y", Symbole.CAT_LOCAL, "f", "int");
			s.set_rang(1);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		return tds;
	}

	public static Tds exemple8() {
		Tds tds = new Tds();
		// remplissage
		try {
			Symbole s = tds.ajouter("main", Symbole.CAT_FONCTION, Symbole.CAT_GLOBAL, "void");
			s.set_nbparam(0);
			s.set_nbloc(0);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("a", Symbole.CAT_GLOBAL, Symbole.CAT_GLOBAL, "int");
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("f", Symbole.CAT_FONCTION, Symbole.SCOPE_GLOBAL, "int");
			s.set_nbparam(2);
			s.set_nbloc(1);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("x", Symbole.CAT_LOCAL, "f", "int");
			s.set_rang(0);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("i", Symbole.CAT_PARAMETRE, "f", "int");
			s.set_rang(0);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		try {
			Symbole s = tds.ajouter("j", Symbole.CAT_PARAMETRE, "f", "int");
			s.set_rang(1);
		} catch (Exception e) {
			LOG.warning(e.getMessage());
		}
		return tds;
	}
}
