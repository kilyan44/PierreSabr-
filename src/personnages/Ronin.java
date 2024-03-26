package personnages;

public class Ronin extends Humain {
    private int honneur = 1;

    public Ronin(String nom, String boissonFavorite, int argent) {
        super(nom, boissonFavorite, argent);
    }

    public void donner(Commercant beneficiaire) {
        int argentDonne = getArgent() / 10;
        perdreArgent(argentDonne);
        parler(beneficiaire.getNom() + " prend ces " + argentDonne + " sous.");
        beneficiaire.recevoir(argentDonne);
    }
    
    public void provoquer(Yakuza adversaire) {
    parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
    int force = honneur * 2;
    int reputationAdversaire = adversaire.getReputation();
    if (force >= reputationAdversaire) {
    	parler("Je t'ai eu petit yakuza!");
        honneur++;
        gagnerArgent(adversaire.getArgent());
        adversaire.perdre();
    } else {
        honneur--;
        parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont été pris d'un coup");
        adversaire.gagner(this);
        perdreArgent(getArgent());
    }
}
    
}
