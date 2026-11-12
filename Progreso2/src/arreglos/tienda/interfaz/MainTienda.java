package arreglos.tienda.interfaz;

import arreglos.tienda.modelo.AppStore;
import arreglos.tienda.modelo.Juego;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class MainTienda {
    private static Scanner sc = new Scanner(System.in);
    private static AppStore tienda = new AppStore();

    static void main() {
        int opc;
        tienda.inicializarDatos();
        do{
            menu();
            opc = Integer.parseInt(sc.nextLine());
            switch (opc){
                case 1:
                    ingresarJuego();
                break;
                case 2:
                    imprimirJuegos();
                break;
                case 3:
                    buscarJuego();
                break;
                case 4:
                    comprar();
                break;
                case 5:
                    vender();
                break;
                case 6:
                    mostrarJuegoMasVendido();
                break;
                case 7:
                    System.out.println("Saliendo");
                break;
                default:
                    System.out.println("Opción no válida");
            }
        }while(opc != 7);
    }
    public static void menu(){
        System.out.println("**********AppStore Udla**********");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego más vendido");
        System.out.println("7. Salir");
        System.out.print("Ingrese una opcion: ");
    }
    public static void ingresarJuego() {
        System.out.println("*******Ingreso de datos*******");
        String nombre = Validacion.leerString("Ingrese el nombre");
        String categoria = Validacion.leerString("Ingrese la categoria");
        int tamanio = Validacion.leerEnteroPositivo("Ingrese el tamanio");
        double precio = Validacion.leerDoublePositivo("Ingrese el precio");
        int licenciasDisponibles = Validacion.leerEnteroPositivo("Ingrese el stock inicial");

        if (tienda.agregarJuego(new Juego(nombre, categoria, tamanio, precio, licenciasDisponibles))) {
            JOptionPane.showMessageDialog(null, "Juego ingresado con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "No fue posible agregar el juego");
        }
    }

    public static void imprimirJuegos(){
        Juego juegos[] = tienda.getJuegos();
        for(Juego j : juegos){
            if(j != null){
                System.out.println(j);
            }else{
                System.out.println("No hay más juegos a mostrar");
                return;
            }
        }
    }

    public static void vender(){
        String nombre = Validacion.leerString("Ingrese el nombre, no puede ser nulo ni blanco");
        System.out.print("Ingrese la cantidad: ");
        int cantidad = Integer.parseInt(sc.nextLine());
        double totalVenta = tienda.vender(nombre,cantidad);
        if( totalVenta == 0){
            System.out.println("No fue posible realizar la venta");
        }else{
            System.out.println("Usted ha comprado " +cantidad+ " licenciad del juego " + nombre);
            System.out.println("Valor a pagar: "+totalVenta);
        }
    }

    public static void comprar(){
        System.out.println("********* COMPRAR JUEGO *********");
        String nombre = Validacion.leerString("Ingrese el Nombre (No vacío ni nulo): ");
        Juego j = tienda.buscarJuego(nombre);
        if (j == null) {
            JOptionPane.showMessageDialog(null, "No se encontró el juego: " + nombre);
            return;
        }
        int cantidad = Validacion.leerEnteroPositivo("Ingrese la cantidad a comprar: ");
        if(tienda.comprar(nombre, cantidad)){
            JOptionPane.showMessageDialog(null, "Usted ha comprado " + cantidad + " licencias del juego " + nombre);
        }else{
            JOptionPane.showMessageDialog(null, "No fue posible realizar la compra.");
        }

    }

    public static void mostrarJuegoMasVendido() {
        String juegoMasVendido = tienda.juegoMasVendido();
        if(!juegoMasVendido.equals("")){
            JOptionPane.showMessageDialog(null, "El juego mas vendido es: " + juegoMasVendido);
        }else{
            JOptionPane.showMessageDialog(null, "No hay elementos.");

        }

    }

    public static void buscarJuego(){
        String nombreBuscado = Validacion.leerString("Ingrese el Nombre (No vacío ni nulo): ");
        Juego j = tienda.buscarJuego(nombreBuscado);
        if(j != null){
            System.out.println(j);
        }else{
            System.out.println("No se encontró el juego");
        }
    }

}
