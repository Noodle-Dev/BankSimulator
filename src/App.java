
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        //Bank simulator
        StartSpanish();
        Scanner sc = new Scanner(System.in);
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
                case 5:
                    salir();
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
            option = sc.nextInt();
        }
        
    }
    public static void StartSpanish(){
        System.out.println("--------------------Bank Simulator--------------------");
        System.out.println("1.- Consultar saldo");
        System.out.println("2.- Retirar dinero");
        System.out.println("3.- depositar dinero");
        System.out.println("4.- Cambiar idioma");
        System.out.println("5.- Salir");
        System.out.println("------------------------------------------------------");
    }
    public static void StartEnglish(){
        System.out.println("--------------------Bank Simulator--------------------");
        System.out.println("1.- Check balance");
        System.out.println("2.- Withdraw money");
        System.out.println("3.- Deposit money");
        System.out.println("4.- Change language");
        System.out.println("5.- Exit");
        System.out.println("------------------------------------------------------");
    }


    //Metodos de la clase
    public static void consultarSaldo(){
        System.out.println("Saldo actual: $1000");
    }
    public static void retirarDinero(){
        System.out.println("Retirar dinero");
    }
    public static void depositarDinero(){
        System.out.println("Depositar dinero");
    }
    public static void cambiarIdioma(){
        System.out.println("Cambiar idioma");
    }
    public static void salir(){
        System.out.println("Salir");
    }
}
