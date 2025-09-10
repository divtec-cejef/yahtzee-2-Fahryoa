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

    public Die[] getLesDes() {
        return lesDes;
    }

    public void setLesDes(Die[] lesDes) {
        if (lesDes.length <= this.lesDes.length) {
            this.lesDes = lesDes;
        }
    }
}
