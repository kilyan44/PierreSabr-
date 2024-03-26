package personnages;

public class Commercant extends Humain {
	    public Commercant(String nom, int argent) {
	        super(nom, "thé", argent); 
	    }

	    public int seFaireExtorquer() {
	        int sommeExtorquee = getArgent();
	        perdreArgent(sommeExtorquee);
	        parler("J'ai tout perdu! Le monde est trop injuste...");
	        return sommeExtorquee;
	    }

	    public void recevoir(int argentRecu) {
	        gagnerArgent(argentRecu);
	        parler(argentRecu + " sous ! Je te remercie généreux donateur!");
	    }
	}
