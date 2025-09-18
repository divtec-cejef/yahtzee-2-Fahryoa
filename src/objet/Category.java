package objet;

/**
 * Les différentes combinaisons
 */
public enum Category {
    PAIRE("Paire") {
        public int score(DiceHand hand) {
            return hand.estPaire() ? 5 : 0;
        }
    },
    DOUBLE_PAIRE("Double Paire") {
        public int score(DiceHand hand) {
            return hand.estDoublePaire() ? 10 : 0;
        }
    },
    BRELAN("Brelan") {
        public int score(DiceHand hand) {
            int points = 0;

            for (int i = 0; i < 6; i++) {
                if (hand.compterOccurence()[i] >= 3) {
                    points = 3 * (i + 1);
                }
            }

            return points;
        }
    },
    CARRE("Carre") {
        public int score(DiceHand hand) {
            int points = 0;

            for (int i = 0; i < 6; i++) {
                if (hand.compterOccurence()[i] >= 4) {
                    points = 4 * (i + 1);
                }
            }

            return points;
        }
    },
    FULL_HOUSE("Full House") {
        public int score(DiceHand hand) {
            return hand.estFullHouse() ? 25 : 0;
        }
    },
    PETITE_SUITE("Petite Suite") {
        public int score(DiceHand hand) {
            return hand.estPetiteSuite() ? 30 : 0;
        }
    },
    GRANDE_SUITE("Grande Suite") {
        public int score(DiceHand hand) {
            return hand.estGrandeSuite() ? 40 : 0;
        }
    },
    YAHTZEE("Yahtzee") {
        public int score(DiceHand hand) {
            return hand.estYahtzee() ? 50 : 0;
        }
    };

    private final String nomCategorie;

    Category(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public abstract int score(DiceHand hand);

    public String getNomCategorie() {
        return nomCategorie;
    }

}
