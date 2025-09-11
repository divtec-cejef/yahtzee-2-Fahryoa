package objet;

public class Player {

    DiceHand laMain;

    public Player(DiceHand laMain) {
        this.laMain = laMain;
    }

    public DiceHand getDiceHand() {
        return laMain;
    }

    public void setDiceHand(DiceHand laMain) {
        this.laMain = laMain;
    }

}
