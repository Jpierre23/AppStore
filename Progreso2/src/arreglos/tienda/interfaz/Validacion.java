package arreglos.tienda.interfaz;

import java.util.Scanner;

public class Validacion {
    private static Scanner sc = new Scanner(System.in);

    public static String leerString (String mensaje){
        String nombre;
        do {
            System.out.print(mensaje + " : ");
            nombre = sc.nextLine();
        }while(nombre==null || nombre.trim().isEmpty());
        return nombre;
    }

    public static int leerEnteroPositivo(String mensaje) {
        int numero;

        do {
            System.out.print(mensaje + ": ");
            numero = Integer.parseInt(sc.nextLine());

            if (numero <= 0) {
                System.out.println("Error: Ingrese un entero positivo.");
            }

        } while (numero <= 0);

        return numero;
    }

    public static int leerEnteroNegativo(String mensaje) {
        int numero;

        do {
            System.out.print(mensaje + ": ");
            numero = Integer.parseInt(sc.nextLine());

            if (numero >= 0) {
                System.out.println("Error: Ingrese un entero negativo.");
            }

        } while (numero >= 0);

        return numero;
    }

    public static int leerEntero(String mensaje) {
        int numero;

        System.out.print(mensaje + ": ");
        numero = Integer.parseInt(sc.nextLine());

        return numero;
    }

    public static double leerDoublePositivo(String mensaje) {
        double numero;

        do {
            System.out.print(mensaje + ": ");
            numero = Double.parseDouble(sc.nextLine());

            if (numero <= 0) {
                System.out.println("Error: Ingrese un double positivo.");
            }

        } while (numero <= 0);

        return numero;
    }

    public static double leerDoubleNegativo(String mensaje) {
        double numero;

        do {
            System.out.print(mensaje + ": ");
            numero = Double.parseDouble(sc.nextLine());

            if (numero >= 0) {
                System.out.println("Error: Ingrese un double negativo.");
            }

        } while (numero >= 0);

        return numero;
    }

    public static double leerDouble(String mensaje) {
        double numero;

        System.out.print(mensaje + ": ");
        numero = Double.parseDouble(sc.nextLine());

        return numero;
    }
}

