import java.util.*;

public class Deck {

    private HashMap<String,String> palos = new HashMap<String, String>();
    private ArrayList<Card> juego = new ArrayList<Card>();
    private String strFormat = "Quedan %s";

    Deck(){

    }

    public ArrayList<Card> getJuego() {
        return juego;
    }

    public void initPalos(){
        palos.put("Diamante","Rojo");
        palos.put("Trebol","Negro");
        palos.put("Pica","Negro");
        palos.put("Corazon","Rojo");
    }

    public void init(){
        for (Map.Entry<String,String> palo:palos.entrySet()){
            for (int i=1;i <= 13;i++){
                Card card = new Card(palo.getKey(), palo.getValue());
                card.setValor(i);
                juego.add(card);
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(juego);
        System.out.println("Se mezcló el Deck");
    }

    public void head(){

        var card = juego.get(juego.size()-1);
        juego.remove(card);
        System.out.println(card.toString());
        System.out.println(String.format(strFormat,juego.size()));

    }

    public void pick(){

        var card = randomCard();
        juego.remove(card);
        System.out.println(card.toString());
        System.out.println(String.format(strFormat,juego.size()));

    }

    public void hand(){
        if(juego.size() <= 5){
            for (var card:juego){
                printHand(juego);
            }
        }else {
            var cards = new ArrayList<Card>();
            Card card;
            for (int i=1;i<=5;i++){
                card = randomCard();
                juego.remove(card);
                cards.add(card);
            }
            printHand(cards);
            System.out.println(String.format(strFormat,juego.size()));
        }
    }

    private void printHand(ArrayList<Card> cards){
        for (var card: cards) System.out.println(card.toString());
    }

    private Card randomCard(){
        //inicio - final - constante - el tamaño
        var rnd = (int)Math.floor(Math.random()*(1-juego.size()+1)+juego.size());
        return juego.get(rnd);
    }

    public void showMenu(){
        Scanner leer = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("Bienvenido a Poker!\n" +
                    "Selecciona una opción:\n" +
                    "1 Mezclar deck\n" +
                    "2 Sacar una carta\n" +
                    "3 Carta al azar\n" +
                    "4 Generar una mano de 5 cartas\n" +
                    "0 Salir");
            System.out.print("Introduce una opcion:");
            opcion = leer.nextInt();

            switch (opcion) {
                // Mezclar deck//
                case 1:
                    shuffle();
                    break;
                //Sacar una carta//
                case 2:
                    head();
                    break;
                //Carta al azar//
                case 3:
                    pick();
                    break;
                //Generar una mano de 5 cartas//
                case 4:
                    hand();
                    break;
                //Salir//
                case 0:
                    System.out.println("Hasta la proxima");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida\n");
                    break;
            }

        } while (opcion != 0);
    }

}