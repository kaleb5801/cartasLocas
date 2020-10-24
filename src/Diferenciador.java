public class Diferenciador {
    private Deck deck;

    Diferenciador(){
        deck = new Deck();
    }

    public void shuffle(){
        deck.shuffle();
        System.out.println("Se mezcló el Deck");
    }

    public void head() throws Exception {
        showSelectedCard(deck.head());
        showSizeDeck();
    }

    public void pick() throws Exception {
        showSelectedCard(deck.pick());
        showSizeDeck();
    }

    public void hand() throws Exception {
        deck.hand().forEach(c -> showSelectedCard(c));
        showSizeDeck();
    }

    public void reset(){
        deck.init();
        deck.shuffle();
        System.out.println("Se reinicio el juego \ny se mezclo el Deck");
    }

    private void showSizeDeck(){
        var messageCard = (deck.getJuego().size() > 1)?"cartas":"carta";
        System.out.println(String.format("Quedan %s %s",deck.getJuego().size(),messageCard));
    }

    private void showSelectedCard(Card card){
        var showCard = card.toString();
        System.out.println(String.format("La carta es %s",showCard));
    }
}
