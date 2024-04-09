package personnages;

public class Humain {
	private String nom;
	private String boissonPref;
	private int argent;
	protected int nbConnaissance=0;
	protected Humain[] memoire = new Humain[30];

	public Humain(String nom, String boissonPref, int argent) {
		this.nom = nom;
		this.boissonPref = boissonPref;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}

	protected void parler(String texte) {
		System.out.println(nom + " : « " + texte + " »");
	}

	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boissonPref);
	}

	public void boire() {
		parler("Mmmm, un bon verre de " + boissonPref + " ! GLOUPS !");
	}

	public void acheter(String bien, int prix) {
		if (prix <= argent) {
			parler("J'ai " + argent + " sous. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous.");
			perdreArgent(prix);
		} else {
			parler("Je n'ai plus que " + argent + " sous en poche. "
					+ "Je ne peux même pas m'offrir " + bien + " à " + prix + " sous.");
		}
	}

	protected void gagnerArgent(int gain) {
		argent += gain;
	}

	protected void perdreArgent(int perte) {
		argent -= perte;
	}
	
	public void faireConnaissanceAvec(Humain humain) {
		direBonjour();
		memoriser(humain);
		humain.repondre(this);
	}

	private void memoriser(Humain humain) {
		if (nbConnaissance < memoire.length) {
			memoire[nbConnaissance] = humain;
			nbConnaissance++;
		} else {		
			for (int i = 1; i < nbConnaissance; i++) {
	            memoire[i - 1] = memoire[i];
			}
			memoire[nbConnaissance-1] = humain;
		}
	}
	
	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}
	
	public void listerConnaissance() {
		System.out.print(nom + " : « Je connais beaucoup de monde dont : ");
		
	for (int i = 0; i < nbConnaissance-1; i++) {
		System.out.print(memoire[i].getNom()+", ");
	}
	
	System.out.println(memoire[nbConnaissance-1].getNom()+"!");
	}
}

