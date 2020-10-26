import java.util.Scanner;

public class MenuInte {
    private Diferenciador diferenciador;
    private boolean jugar;
    private int vecesJugadas;

    MenuInte(){
        diferenciador = new Diferenciador();
    }
    public void play(){
        jugar = true;
        vecesJugadas = 1;
        do{
            showMenu();
            try {
                var opcion = limites();

                if(opcion != 0)
                    showDivision();

                opciones(opcion);

                if(opcion != 0)
                    showDivision();

            }catch (Exception exception){
                System.out.println(exception.getMessage());
                showDivision();
            }
        }while (jugar);
    }

    public void showMenu(){
        if(vecesJugadas == 1)
            System.out.println("Bienvenido a Poker!\n" +
                    "Selecciona una opción:\n" +
                    "1 Mezclar deck\n" +
                    "2 Sacar una carta\n" +
                    "3 Carta al azar\n" +
                    "4 Generar una mano de 5 cartas\n" +
                    "0 Salir");
            System.out.print("Introduce una opcion:");
    }

    private int limites() throws Exception{
        Scanner scn = new Scanner(System.in);
        var opcion = scn.nextInt();
        if(opcion < 0  || opcion > 5)
            throw new Exception("Introduce una opción Valida");

        return opcion;
    }

    private static void showDivision(){
        System.out.println("-------------------------------" );
    }

    private void opciones(int opcion) throws Exception {
        switch (opcion){
            // Mezclar deck//
            case 1:
                diferenciador.shuffle();
                vecesJugadas++;
                break;
            //Sacar una carta//
            case 2:
                diferenciador.head();
                vecesJugadas++;
                break;
            //Carta al azar//
            case 3:
                diferenciador.pick();
                vecesJugadas++;
                break;
            //Generar una mano de 5 cartas//
            case 4:
                diferenciador.hand();
                vecesJugadas++;
                break;
            case 5:
                diferenciador.reset();
                vecesJugadas = 1;
                break;
            case 0:
                System.out.println("¡Hasta la próxima!");
                System.exit(0);
                break;
        }
    }

}