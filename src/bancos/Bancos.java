package bancos;

import java.util.Scanner;

public class Bancos {

    public static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        int opc, opc2, NC = 0, temp = 0;
        Cuentas NCuentas[] = new Cuentas[40];
        do {
            System.out.println("B-A-N-C-O");
            System.out.println("Menu bancario");
            System.out.println("1:Registrar cuenta bancaria"
                    + "\n2:Consultar datos de la cuenta bancaria"
                    + "\n3:Depositar"
                    + "\n4:Retirar"
                    + "\n5:salir");
            System.out.print("Ingrese una opción del menú: ");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Menú sistema bancario de la cuenta");
                    System.out.println("\n1: Cuenta de ahorro"
                            + "\n2: Cuenta de cheques");
                    System.out.print("Selecciona una opción de cuenta bancaria: ");
                    opc2 = leer.nextInt();
                    switch (opc2) {
                        case 1:
                            System.out.println("Cuenta de tipo ahorro");
                            NCuentas[NC] = new Ahorro();
                            break;
                        case 2:
                            System.out.println("Cuenta de tipo chequera");
                            NCuentas[NC] = new Cheques();
                            break;
                    }
                    NCuentas[NC].PedirDatos();
                    NC++;
                    break;
                case 2:
                    for (int i = 0; i < NC; i++) {
                        NCuentas[i].ConsultarDatos();
                    }
                    break;
                case 3:
                    for (int i = 0; i < NC; i++) {
                        NCuentas[i].DepositarSaldo();
                    }
                    break;
                case 4:
                    for (int i = 0; i < NC; i++) {
                        NCuentas[i].RetirarSaldo();
                    }
                    break;
                case 5:
                    System.out.println("Gracias por usar el sistema, vuelva pronto");
                    break;
                default:
                    System.out.println("Opción incorrecta intentelo de nuevo\n");
                    break;
            }
        } while (opc != 5);
    }
}
