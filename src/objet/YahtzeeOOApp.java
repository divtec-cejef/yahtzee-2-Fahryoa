package objet;

public class YahtzeeOOApp {

    public static void main(String[] args) {

        Die de1 = new Die(6);

        System.out.println(de1.getFaceExpose());
        de1.lancer();
        System.out.println(de1.getFaceExpose());

        DiceHand main1 =  new DiceHand(5);
        Die[] lesDes = main1.getLesDes();
        for (Die de : lesDes) {
            System.out.println(de.getFaceExpose());
        }
        int[] desARelancer = {4, 5};
        main1.relanceLesDes(desARelancer);
        for (Die de : lesDes) {
            System.out.println(de.getFaceExpose());
        }

    }
}
