import java.util.*;

public class Deck {
    public static  HashMap<String,String> palos = new HashMap<String,String>();

    private ArrayList<Card> juego = new ArrayList<Card>();

    Deck(){
        palos.put("Diamante","Rojo");
        palos.put("Corazón","Rojo");
        palos.put("Trébol","Negro");
        palos.put("Pica","Negro");

        init();
    }

    public ArrayList<Card> getJuego() {
        return juego;
    }

    public void init(){
        if (juego.size() > 1) juego.clear();

        for (Map.Entry<String,String> palo : palos.entrySet()){
            var paloCard = palo.getKey();
            var color = palo.getValue();
            Card card;
            for (int i=1;i <= 13;i++){
                card = new Card(paloCard, color, i);
                juego.add(card);
            }
        }
    }

    public void shuffle(){ Collections.shuffle(juego); }

    public Card head()throws Exception{
        if(juego.isEmpty() || juego.size() < 1)
            throw new Exception("Ya no quedan cartas");

        return juego.remove(juego.size()-1);
    }

    public Card pick()throws Exception{
        if(juego.isEmpty())
            throw new Exception("Ya no quedan cartas");

        return juego.remove(randomCard());
    }

    public ArrayList<Card> hand() throws Exception{
        var cards = new ArrayList<Card>();

        if(juego.isEmpty()){
            throw new Exception("Ya no quedan cartas");
        }
        else if(juego.size() < 5){
            throw new Exception("No hay suficientes cartas");
        }
        else {
            for (int i=1;i<=5;i++){
                cards.add(pick());
            }
        }
        return cards;
    }

    private int randomCard(){
        var max = juego.size() -1;
        var rnd = (int)Math.floor(Math.random()*(0-max+1)+max);
        return rnd;
    }
}