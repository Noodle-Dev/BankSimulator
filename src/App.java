import java.util.Scanner;

public class App {
    // Variables globales
    private static double saldo = 0;
    private static boolean spanish = true;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        mostrarMenu();
        int option = sc.nextInt();
        
        while(option != 5){
            switch(option){
                case 1:
                    consultarSaldo();
                    break;
                case 2:
                    retirarDinero();
                    break;
                case 3:
                    depositarDinero();
                    break;
                case 4:
                    cambiarIdioma();
                    break;
                default:
                    System.out.println(spanish ? "Opción no válida" : "Invalid option");
                    break;
            }
            mostrarMenu();
            option = sc.nextInt();
        }
        
        salir();
        sc.close();
    }

    public static void mostrarMenu() {
        if(spanish) {
            StartSpanish();
        } else {
            StartEnglish();
        }
    }

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

    // Métodos de la clase
    public static void consultarSaldo(){
        System.out.println(spanish ? 
            "Saldo actual: " + saldo + "$" : 
            "Current balance: " + saldo + "$");
    }

    public static void retirarDinero(){
        System.out.println(spanish ? 
            "¿Qué cantidad desea retirar?" : 
            "How much do you want to withdraw?");
        double cantidad = sc.nextDouble();
        
        if(cantidad > saldo) {
            System.out.println(spanish ? 
                "No tiene suficiente saldo" : 
                "You don't have enough balance");
        } else if(cantidad <= 0) {
            System.out.println(spanish ? 
                "Cantidad no válida" : 
                "Invalid amount");
        } else {
            saldo -= cantidad;
            System.out.println(spanish ? 
                "Retiro exitoso. Nuevo saldo: " + saldo + "$" : 
                "Withdrawal successful. New balance: " + saldo + "$");
        }
    }

    public static void depositarDinero(){
        System.out.println(spanish ? 
            "¿Qué cantidad desea depositar?" : 
            "How much do you want to deposit?");
        double cantidad = sc.nextDouble();
        
        if(cantidad <= 0) {
            System.out.println(spanish ? 
                "Cantidad no válida" : 
                "Invalid amount");
        } else {
            saldo += cantidad;
            System.out.println(spanish ? 
                "Depósito exitoso. Nuevo saldo: " + saldo + "$" : 
                "Deposit successful. New balance: " + saldo + "$");
        }
    }

    public static void cambiarIdioma(){
        spanish = !spanish;
        System.out.println(spanish ? 
            "Idioma cambiado a español" : 
            "Language changed to English");
    }

    public static void salir(){
        System.out.println(spanish ? 
            "Gracias por usar nuestro servicio. ¡Hasta luego!" : 
            "Thank you for using our service. Goodbye!");
    }
}