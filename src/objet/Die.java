package objet;

/**
 * Un dé a jouer
 */
public class Die {


    public final int nbrFace = 6;
    // La face exposé du dés
    private int FaceExpose = 1;

    /**
     * Constructeur de dés
     * @param FaceExpose La face exposé du dés
     */
    public Die(int FaceExpose) {
        setFaceExpose(FaceExpose);
    }

    /**
     * Constructeur de dés
     */
    public Die() {
        lancer();
    }

    /**
     * Lance le dés (change la face exposé entre 1 - et le nbr de face)
     */
    public void lancer() {
        FaceExpose = (int) (Math.random() * nbrFace + 1);
    }

    public int getFaceExpose() {
        return FaceExpose;
    }

    public void setFaceExpose(int FaceExpose) {
        if (FaceExpose > 0 && FaceExpose < nbrFace) {
            this.FaceExpose = FaceExpose;
        }
    }
}
