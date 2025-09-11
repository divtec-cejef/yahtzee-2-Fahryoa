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

/*
* 1 manche :
* 1) tu lance tout les dés (5)
* 2) tu relance les dés choisi
* 3) tu relance une nouvelle fois
* 4) tu choisi la combinaison
*/
