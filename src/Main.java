import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    // Opciones posibles
    String[] opciones = {"piedra", "papel", "tijera"};

    // Crear un objeto Scanner para leer la entrada del usuario
    Scanner scanner = new Scanner(System.in);    boolean continuar = true;

    while (continuar){

        String eleccionUsuario = elegirElementoUsuario(scanner);
        String eleccionComputadora = elegirElementoComputadora(opciones);

        // Mostrar las elecciones de ambos jugadores
        System.out.println("Tu elección: "+eleccionUsuario);
        System.out.println("Elección de la computadora: "+eleccionComputadora);

        // Determinar el resultado del juego
        String resultado;
        if(eleccionUsuario.equals(eleccionComputadora)){
            resultado = "¡Es un empate!";
        } else if((eleccionUsuario.equals("piedra")&&eleccionComputadora.equals("tijera"))||
                (eleccionUsuario.equals("papel")&&eleccionComputadora.equals("piedra"))||
                (eleccionUsuario.equals("tijera")&&eleccionComputadora.equals("papel")))
        {
            resultado = "¡Ganaste!";
        } else {
            resultado = "¡Perdiste!";
        }

        // Mostrar el resultado
            System.out.println(resultado);

        continuar = preguntarSiQueremosContinuar();
    }// end while

    System.out.println("¡Hasta pronto!");
    scanner.close();
}

    private static String elegirElementoUsuario(Scanner scanner){
        // Solicitar al usuario que ingrese su elección
        System.out.println("Elige una opción: piedra, papel o tijera");
        String eleccion = scanner.nextLine().toLowerCase();
        return  eleccion;
    }

    private static String elegirElementoComputadora(String[] opciones) {
        // Crear un objeto Random para generar la elección de la computadora
        Random random = new Random();
        // Generar la elección de la computadora
        int indice = random.nextInt(3);
        return opciones[indice];
    }

    private static boolean preguntarSiQueremosContinuar(){
        System.out.println("¿Desea continuar? s/n");
        Scanner scanner = new Scanner(System.in);
        String respuesta = scanner.nextLine();
        return respuesta.toLowerCase().charAt(0) == 's';
    }
}


