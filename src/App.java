import java.util.Scanner;
/*
 * Programa: Simulador de Cajero Automático  
 * Autor: Alejandro Alonso Membrila, Patrick Rubi Garica Sandoval, 
 *        Rigoberto Ordaz Cavadas, Hassan Karim Leyva Ezquiveda
 * Fecha: 26 Marzo 2025
 * Descripción: Programa que simula las operaciones básicas de un cajero automático
 *              con soporte para dos idiomas (español/inglés).
 */
public class App {
    // Variables globales
    private static double saldo = 0;          // Almacena el balance del usuario
    private static boolean spanish = true;    // Controla el idioma (true=español)
    private static Scanner sc = new Scanner(System.in);  // Scanner para entrada de usuario

    /**
     * Método principal que inicia la aplicación
     */
    public static void main(String[] args) throws Exception {
        mostrarMenu();              // Mostrar el menú principal
        int option = sc.nextInt();  // Leer la opción del usuario
        
        // Bucle principal del programa
        while(option != 5){         // 5 = Opción de salida
            switch(option){
                case 1:            // Consultar saldo
                    consultarSaldo();
                    break;
                case 2:            // Retirar dinero
                    retirarDinero();
                    break;
                case 3:            // Depositar dinero
                    depositarDinero();
                    break;
                case 4:            // Cambiar idioma
                    cambiarIdioma();
                    break;
                default:           // Opción inválida
                    System.out.println(spanish ? "Opción no válida" : "Invalid option");
                    break;
            }
            mostrarMenu();        // Mostrar menú nuevamente
            option = sc.nextInt(); // Leer nueva opción
        }
        
        salir();      // Ejecutar secuencia de salida
        sc.close();   // Cerrar scanner
    }

    /**
     * Muestra el menú en el idioma actual
     */
    public static void mostrarMenu() {
        if(spanish) {
            StartSpanish();  // Menú en español
        } else {
            StartEnglish();  // Menú en inglés
        }
    }

    /**
     * Muestra el menú en español
     */
    public static void StartSpanish(){
        System.out.println("\n--------------------Bank Simulator--------------------");
        System.out.println("1.- Consultar saldo");
        System.out.println("2.- Retirar dinero");
        System.out.println("3.- Depositar dinero");
        System.out.println("4.- Cambiar idioma");
        System.out.println("5.- Salir");
        System.out.println("------------------------------------------------------");
        System.out.print("Seleccione una opción: ");
    }

    /**
     * Muestra el menú en inglés
     */
    public static void StartEnglish(){
        System.out.println("\n--------------------Bank Simulator--------------------");
        System.out.println("1.- Check balance");
        System.out.println("2.- Withdraw money");
        System.out.println("3.- Deposit money");
        System.out.println("4.- Change language");
        System.out.println("5.- Exit");
        System.out.println("------------------------------------------------------");
        System.out.print("Select an option: ");
    }

    // ========== OPERACIONES DEL CAJERO ========== //
    
    /**
     * Muestra el saldo actual en el idioma seleccionado
     */
    public static void consultarSaldo(){
        System.out.println(spanish ? 
            "Saldo actual: " + saldo + "$" : 
            "Current balance: " + saldo + "$");
    }

    /**
     * Permite retirar dinero con validaciones
     */
    public static void retirarDinero(){
        // Solicitar cantidad
        System.out.println(spanish ? 
            "¿Qué cantidad desea retirar?" : 
            "How much do you want to withdraw?");
        double cantidad = sc.nextDouble();
        
        // Validar fondos suficientes
        if(cantidad > saldo) {
            System.out.println(spanish ? 
                "No tiene suficiente saldo" : 
                "You don't have enough balance");
        } 
        // Validar cantidad positiva
        else if(cantidad <= 0) {
            System.out.println(spanish ? 
                "Cantidad no válida" : 
                "Invalid amount");
        } 
        // Procesar retiro
        else {
            saldo -= cantidad;  // Actualizar saldo
            System.out.println(spanish ? 
                "Retiro exitoso. Nuevo saldo: " + saldo + "$" : 
                "Withdrawal successful. New balance: " + saldo + "$");
        }
    }

    /**
     * Permite depositar dinero con validaciones
     */
    public static void depositarDinero(){
        // Solicitar cantidad
        System.out.println(spanish ? 
            "¿Qué cantidad desea depositar?" : 
            "How much do you want to deposit?");
        double cantidad = sc.nextDouble();
        
        // Validar cantidad positiva
        if(cantidad <= 0) {
            System.out.println(spanish ? 
                "Cantidad no válida" : 
                "Invalid amount");
        } 
        // Procesar depósito
        else {
            saldo += cantidad;  // Actualizar saldo
            System.out.println(spanish ? 
                "Depósito exitoso. Nuevo saldo: " + saldo + "$" : 
                "Deposit successful. New balance: " + saldo + "$");
        }
    }

    /**
     * Cambia el idioma entre español e inglés
     */
    public static void cambiarIdioma(){
        spanish = !spanish;  // Alternar bandera de idioma
        System.out.println(spanish ? 
            "Idioma cambiado a español" : 
            "Language changed to English");
        System.out.flush();   // Limpiar buffer de salida
    }

    /**
     * Muestra mensaje de despedida y termina el programa
     */
    public static void salir(){
        System.out.println(spanish ? 
            "Gracias por usar nuestro servicio. ¡Hasta luego!" : 
            "Thank you for using our service. Goodbye!");

        System.exit(0);  // Terminar aplicación
    }
}