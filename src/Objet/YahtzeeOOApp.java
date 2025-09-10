package Objet;

public class YahtzeeOOApp {

    public static void main(String[] args) {

        Die de1 = new Die(6);

        System.out.println(de1.getFaceExpose());
        de1.lancer();
        System.out.println(de1.getFaceExpose());

    }
}
