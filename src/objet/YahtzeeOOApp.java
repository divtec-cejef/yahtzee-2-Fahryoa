package objet;
import java.util.Random;

public class YahtzeeOOApp {

    public static void main(String[] args) {

       ConsoleIO console = new ConsoleIO();
       Game jeu = new Game();
       jeu.UnePartie(console);
    }
}
