package Objet;

/**
 * Un dé a jouer
 */
public class Die {

    // La face exposé du dés
    private int FaceExpose;
    // le nbr de faces du dés
    private int nbrFaces;

    /**
     * Constructeur de dés
     * @param FaceExpose La face exposé du dés
     * @param nbrFaces le nbr de faces du dés
     */
    public Die(int FaceExpose, int nbrFaces) {
        setFaceExpose(FaceExpose);
        setNbrFaces(nbrFaces);
    }

    /**
     * Constructeur de dés
     * @param nbrFaces le nbr de faces du dés
     */
    public Die(int nbrFaces) {
        setFaceExpose(1);
        setNbrFaces(nbrFaces);
    }

    /**
     * Constructeur de dés
     */
    public Die() {
        setFaceExpose(1);
        setNbrFaces(6);
    }

    /**
     * Lance le dés (change la face exposé entre 1 - et le nbr de face)
     */
    public void lancer() {
        FaceExpose = (int) (Math.random() * nbrFaces + 1);
    }

    public int getFaceExpose() {
        return FaceExpose;
    }

    public int getnbrFaces() {
        return nbrFaces;
    }

    public void setFaceExpose(int FaceExpose) {
        if (FaceExpose > 0 && FaceExpose < nbrFaces) {
            this.FaceExpose = FaceExpose;
        }
    }

    public void setNbrFaces(int nbrFaces) {
        if (nbrFaces > 0) {
            this.nbrFaces = nbrFaces;
        }
    }

}
