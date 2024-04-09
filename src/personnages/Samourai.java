package personnages;

public class Samourai extends Ronin{
	private String nomSeigneur;
	
	public Samourai(String seigneur, String nom, String boissonFavorite, int argent) {
		super(nom, boissonFavorite,argent);
		this.nomSeigneur = seigneur;
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Je suis fier de servir le seigneur " + nomSeigneur);
	}
	
	public void boire(String boisson) {
		parler("Qu'est-ce que je vais choisir comme boisson ? Tiens je vais prendre du " + boisson );
	}
	
}
