import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Deck deck = new Deck();
        deck.initPalos();
        deck.init();

        deck.showMenu();
    }
}