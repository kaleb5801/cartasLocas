import java.util.HashMap;
import java.util.Map;

public class Card {

    private final String palo;
    private final String color;
    private final String valor;

    Card(String palo,String color, Integer valor){
        this.palo = palo;
        this.color = color;
        this.valor = setValor(valor);
    }

    public String getPalo() {
        return palo;
    }

    public String getColor() {
        return color;
    }

    public String getValor() {
        return valor;
    }

    private String setValor(Integer valor) {
        if(valor <= 10){
            if(valor == 1) return "A";
            return valor.toString();
        }else {
            if(valor == 11) return  "J";
            else if(valor == 12) return "Q";
            else return "K";
        }
    }

    @Override
    public String toString() { return String.format("%s, %s, %s",palo,color,valor); }
}
