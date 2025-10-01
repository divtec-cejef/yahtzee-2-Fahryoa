package objet;

/**
 * Les différentes combinaisons
 */
public enum Category {
    PAIRE("1) Paire") {
        public int score(DiceHand hand) {
            return hand.estPaire() ? 5 : 0;
        }
    },
    DOUBLE_PAIRE("2) Double Paire") {
        public int score(DiceHand hand) {
            return hand.estDoublePaire() ? 10 : 0;
        }
    },
    BRELAN("3) Brelan") {
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
    CARRE("4) Carre") {
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
    FULL_HOUSE("5) Full House") {
        public int score(DiceHand hand) {
            return hand.estFullHouse() ? 25 : 0;
        }
    },
    PETITE_SUITE("6) Petite Suite") {
        public int score(DiceHand hand) {
            return hand.estPetiteSuite() ? 30 : 0;
        }
    },
    GRANDE_SUITE("7) Grande Suite") {
        public int score(DiceHand hand) {
            return hand.estGrandeSuite() ? 40 : 0;
        }
    },
    YAHTZEE("8) Yahtzee") {
        public int score(DiceHand hand) {
            return hand.estYahtzee() ? 50 : 0;
        }
    };

    private final String nomCategorie;

    Category(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public abstract int score(DiceHand hand);

    public Category TransformeIntEnCategory(int nomCategorie) {
        switch (nomCategorie) {
            case 1:
                return Category.PAIRE;
            case 2:
                return Category.DOUBLE_PAIRE;
            case 3:
                return Category.BRELAN;
            case 4:
                return Category.CARRE;
            case 5:
                return Category.FULL_HOUSE;
            case 6:
                return Category.PETITE_SUITE;
            case 7:
                return Category.GRANDE_SUITE;
            case 8:
                return Category.YAHTZEE;
        }
        return null;
    }

        public String getNomCategorie () {
            return nomCategorie;
        }

    }
