package generateur;

import exemples.*;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("Exemple rendu");
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
	
	private static String exemple1() throws Exception {
		Generateur g = new Generateur();
		String res = g.generer(exemple1.getNoeud(), exemple1.getTds());
		return res;
	}
	private static String exemple2() throws Exception {
		Generateur g = new Generateur();
		String res = g.generer(exemple2.getNoeud(), exemple2.getTds());
		return res;
	}
	private static String exemple3() throws Exception {
		Generateur g = new Generateur();
		String res = g.generer(exemple3.getNoeud(), exemple3.getTds());
		return res;
	}
	private static String exemple4() throws Exception{
		Generateur g = new Generateur();
		String res = g.generer(exemple4.getNoeud(), exemple4.getTds());
		return res;
	}
	private static String exemple5() throws Exception{
		Generateur g = new Generateur();
		String res = g.generer(exemple5.getNoeud(), exemple5.getTds());
		return res;
	}
	private static String exemple6() throws Exception{
		Generateur g = new Generateur();
		String res = g.generer(exemple6.getNoeud(), exemple6.getTds());
		return res;
	}
	private static String exemple7() throws Exception{
		Generateur g = new Generateur();
		String res = g.generer(exemple7.getNoeud(), exemple7.getTds());
		return res;
	}
	private static String exemple8() throws Exception{
		Generateur g = new Generateur();
		String res = g.generer(exemple8.getNoeud(), exemple8.getTds());
		return res;
	}
	private static String exempleRendu() throws Exception {
		Generateur g = new Generateur();
		String res = g.generer(exempleRendu.getNoeud(), exempleRendu.getTds());
		return res;
	}

}
