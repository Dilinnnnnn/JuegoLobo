import java.util.Scanner;

public class App {
    private static final int CAPERUCITA = 0;
    private static final int LOBO = 1;
    private static final int UVAS = 2;
    private static final int SOLO = 3;

    public static void main(String[] args) throws Exception {
        int go = CAPERUCITA;
        Scanner scan = new Scanner(System.in);

        for (int a = 1; a <= 7; a++) {
            System.out.println(
                    "\n\n\t 0 - CAPERUCITA \n\n\t 1 - LOBO \n\n\t 2 - UVAS \n\n\t 3 - SOLO \n\n");
            int numero;
            if (a % 2 != 0)
                System.out.print(
                        "\n \\_Obs_,_?_ / ------------------------- _____ Con que personaje vas a cruzar al otro lado del rio:....?");
            else
                System.out.print(
                        "\n \\_Obs_,_?_ / ------------------------- _____ Con que personaje regresaras al otro lado del rio:....?");
            numero = scan.nextInt();
            String personaje = nombrePersonaje(numero);
            animacion(personaje);
            if (numero == go) {
                if (a == 7) {
                    System.out.print("\n\n - LO LOGRASTE, HAZ GANADO-FELICIDADES!!!!");
                }
            } else {
                System.out.print("\n\n - SE COMIERON A ALGUIEN-PERDISTE :C");
                break;
            }
            go = getSiguiente(numero, a);
        }
        scan.close();
    }

    public static String nombrePersonaje(int numero) {
        switch (numero) {
            case CAPERUCITA:
                return "CAPERUCITA";
            case LOBO:
                return "---LOBO---";
            case UVAS:
                return "---UVAS---";
            case SOLO:
                return "----------";
            default:
                return "";
        }
    }

    public static void animacion(String personaje) {
        for (int n = 0; n < 50; n++) {
            clearConsole();
            StringBuilder animar = new StringBuilder();
            for (int i = 0; i < n; i++)
                animar.append("  ");
            animar.append("\\_Obs_,_" + personaje + "_ /");
            System.out.print("\r" + animar.toString());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static int getSiguiente(int numero, int rondas) {
        if (numero == SOLO && rondas == 6)
            return CAPERUCITA;
        if (numero == CAPERUCITA && rondas == 4)
            return UVAS;
        if (numero == CAPERUCITA)
            return SOLO;
        if (numero == SOLO)
            return LOBO;
        if (numero == LOBO)
            return CAPERUCITA;
        if (numero == UVAS)
            return SOLO;
        else {
            return 0;
        }
    }
}
