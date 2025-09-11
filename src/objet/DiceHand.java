package objet;

public class DiceHand {

    // La liste des dés
    private Die[] lesDes;

    /**
     * Constructeur de mains
     * @param NombreDes Combien de dés il doit y avoir dans la main
     */
    public DiceHand(int NombreDes) {
        Die[] des = new Die[NombreDes];

        for (int i = 0; i < NombreDes; i++) {
            des[i] = new Die();
        }

        this.lesDes = des;

    }

    /**
     * Relance les dés choisi de la main
     * @param lesIndex Les indexs des dés a relancer
     */
    public void relanceLesDes(int[] lesIndex) {
        if (lesIndex.length <= lesDes.length) {
            for (int i = 0; i < lesIndex.length; i++) {
                if (lesIndex[i] < lesDes.length) {
                    lesDes[lesIndex[i]].lancer();
                }
            }
        } else {
            relancerTousLesDes();
        }
    }

    /**
     * Relance tous les dés de la main
     */
    public void relancerTousLesDes() {
        for (int i = 0; i < lesDes.length; i++) {
            lesDes[i].lancer();
        }
    }

    public int[] compterOccurence() {
        int[] occurence = new int[lesDes[0].nbrFace];
        for (int i = 0; i < lesDes[0].nbrFace; i++) {
            occurence[i]++;
        }

        return occurence;
    }

    public boolean estPaire() {
        boolean estPaire = false;
        int[] occurence = compterOccurence();

        for (int i = 0; i < occurence.length; i++) {
            if (occurence[i] >= 2) {
                estPaire = true;
            }
        }

        return estPaire;
    }

    public boolean estDoublePaire() {
        int nbrPaire = 0;
        int[] occurences = compterOccurence();

        for (int i = 0; i < lesDes[0].nbrFace; i++){
            if (occurences[i] >= 2) {
                nbrPaire++;
            }
        }

        return nbrPaire >= 2;
    }

    public boolean estBrelan() {
        boolean estBrelan = false;
        int[] occurence = compterOccurence();

        for (int i = 0; i < occurence.length; i++) {
            if (occurence[i] >= 3) {
                estBrelan = true;
            }
        }

        return estBrelan;
    }

    public boolean estCarre() {
        boolean estCarre = false;
        int[] occurence = compterOccurence();

        for (int i = 0; i < occurence.length; i++) {
            if (occurence[i] >= 4) {
                estCarre = true;
            }
        }

        return estCarre;
    }

    public boolean estFullHouse() {
        boolean estPaire = false;
        boolean estBrelan = false;
        int[] occurence = compterOccurence();

        for (int i = 0; i < lesDes[0].nbrFace; i++) {
            if (occurence[i] == 2) {
                estPaire = true;
            }

            if (occurence[i] == 3) {
                estBrelan = true;
            }
        }

        return estPaire && estBrelan;
    }



    public Die[] getLesDes() {
        return lesDes;
    }
    public boolean estPetiteSuite() {
            boolean estPetiteSuite = false;
            int[] occurence = compterOccurence();

        if (occurence[0] >= 1 && occurence[1] >= 1 && occurence[2] >= 1 && occurence[3] >= 1) {
            estPetiteSuite = true;
        }

        if (occurence[1] >= 1 && occurence[2] >= 1 && occurence[3] >= 1 && occurence[4] >= 1) {
            estPetiteSuite = true;
        }

        if (occurence[2] >= 1 && occurence[3] >= 1 && occurence[4] >= 1 && occurence[5] >= 1) {
            estPetiteSuite = true;
        }

        return estPetiteSuite;
    }

    public boolean estGrandeSuite() {
        boolean estGrandeSuite = false;
        int[] occurence = compterOccurence();

        if (occurence[0] >= 1 && occurence[1] >= 1 && occurence[2] >= 1 && occurence[3] >= 1 && occurence[4] >= 1) {
            estGrandeSuite = true;
        }

        if (occurence[1] >= 1 && occurence[2] >= 1 && occurence[3] >= 1 && occurence[4] >= 1 && occurence[5] >= 1) {
            estGrandeSuite = true;
        }

        return estGrandeSuite;
    }

    public boolean estYahtzee() {
        boolean estYahtzee = false;
        int[] occurence = compterOccurence();

        for (int i = 0; i < occurence.length; i++) {
            if (occurence[i] >= 2) {
                estYahtzee = true;
            }
        }

        return estYahtzee;
    }

    public void setLesDes(Die[] lesDes) {
        if (lesDes.length <= this.lesDes.length) {
            this.lesDes = lesDes;
        }
    }
}
