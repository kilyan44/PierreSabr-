package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, String boissonFavorite, int argent, String clan) {
		super(nom, boissonFavorite, argent);
		this.clan = clan;
	}

	public void extorquer(Commercant victime) {
		reputation++;
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime + "Si tu tiens à la vie, donne-moi ta bourse !");
		int argentVole = victime.seFaireExtorquer();
		gagnerArgent(argentVole);
		parler("J’ai piqué les " + argentVole + " sous " + victime + ", ce qui me fait " + getArgent()
				+ " sous dans ma poche. Hi! Hi!");
	}

	public void perdre() {
		perdreArgent(getArgent());
		parler("J'ai perdu mon duel et tout mon argent... J'ai déshonoré le clan de " + clan);
	}
	
	public void gagner(Ronin ronin) {
	    gagnerArgent(ronin.getArgent());
	    parler("Ce ronin pensait vraiment battre " + getNom() + " du clan " + clan + "\n "
	    		+ "Je l'ai dépouiller de ses " + ronin.getArgent() + " sous.");
	}

	public int getReputation() {
		return reputation;
	}
}
