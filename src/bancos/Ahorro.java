package bancos;

import java.util.Scanner;

public class Ahorro extends Cuentas {

    public static Scanner leer = new Scanner(System.in);
    //private int fechavencio = 0;
    private float porcentajeIm = 0;
    private int dd = 0, mm = 0, yy = 0;
    //

    public Ahorro() {
    }

    public Ahorro(int NumCuenta, float Saldo, String NombreCliente,
            int fechavenci, int fechavencio, int porcentajeIm, int dd, int mm, int yy) {
        super(NumCuenta, Saldo, NombreCliente);
        //this.fechavencio = fechavencio;
        this.porcentajeIm = porcentajeIm;
        this.dd = dd;
        this.mm = mm;
        this.yy = yy;
    }

    @Override
    public void PedirDatos() {
        super.PedirDatos();
        do {
            System.out.print("Ingresa el interes mensual de la cuenta en un rango de 1% - 99% :");
            this.porcentajeIm = Ahorro.leer.nextInt();
            if (porcentajeIm < 1 && porcentajeIm >= 100) {
                System.out.println("Interes no valido");
            }
        } while (porcentajeIm >= 1 != porcentajeIm < 100);
        System.out.println("Ingresa la fecha de vencimiento del ahorro");
        System.out.print("Ingresa el  dia vencimiento: ");
        this.dd = Ahorro.leer.nextInt();
        System.out.print("Ingresa el mes de vencimiento: ");
        this.mm = Ahorro.leer.nextInt();
        System.out.print("Ingresa el año de vencimiento: ");
        this.yy = Ahorro.leer.nextInt();

    }

    @Override
    public void RetirarSaldo() {
        String buscar, Cliente, NumeroDeCuenta;
        System.out.print("Ingresa el nombre del cliente o numero de cuenta bancaria a retirar: ");
        buscar = leer.next();
        Cliente = NombreCliente;
        float Cretirar = 0;
        NumeroDeCuenta = String.valueOf(NumCuenta);
        if (Cliente.equals(buscar) || NumeroDeCuenta.equals(buscar)) {
            int NumDia = 0, NumMes = 0, NumAno = 0;
            System.out.println("Ingrese la fecha actual");
            System.out.print("Ingrese el dia actual:");
            NumDia = leer.nextInt();
            System.out.print("Ingrese el mes actual:");
            NumMes = leer.nextInt();
            System.out.print("ingrese el año actual:");
            NumAno = leer.nextInt();
            if (dd == NumDia && mm == NumMes && yy == NumAno) {
                System.out.println("Ingresa una cantidad a retirar");
                Cretirar = Ahorro.leer.nextFloat();
                if (Cretirar > Saldo) {
                    System.out.println("saldo insuficiente ");
                } else {
                    Saldo = Saldo - Cretirar;
                    System.out.println("Retiro con exito!, su saldo actual es:" + "$" + Saldo);
                    System.out.println("Ingresa una nueva fecha de vencimiento para tu cuenta de ahorro");
                    System.out.print("Ingresa el dia de la fecha de vencimiento: ");
                    this.dd = Ahorro.leer.nextInt();
                    System.out.print("Ingresa el mes de la fecha de vencimiento: ");
                    this.mm = Ahorro.leer.nextInt();
                    System.out.print("Ingresa el año de la fecha de vencimiento: ");
                    this.yy = Ahorro.leer.nextInt();
                }
            } else {
                System.out.println("Error, solo puede retirar en la fecha de vencimiento acordada");
            }
        } else {
            System.out.println("Error, usuario no encontrado");
        }
    }

    @Override
    public void DepositarSaldo() {
        super.DepositarSaldo();
        int NumDia = 0, NumMes = 0, NumAno = 0;
        float Interes = 0;
        System.out.println("Pago del interes mensual");
        System.out.print("Ingrese el dia actual:");
        NumDia = leer.nextInt();
        System.out.print("Ingrese el mes actual:");
        NumMes = leer.nextInt();
        System.out.print("ingrese el año actual:");
        NumAno = leer.nextInt();
        Interes = ((porcentajeIm * Deposito) / 100);

        if (NumDia == 1) {
            Saldo = Saldo + Deposito + Interes;
            
            System.out.println("Pago con exito!, su saldo actual es:" + "$" + Saldo);
        } else {
            System.out.println("Aun no es tiempo de pagar el interes mensual");
        }
    }

    @Override
    public void ConsultarDatos() {
        super.ConsultarDatos();
        System.out.println("Fecha de vencimiento: " + dd + "/" + mm + "/" + yy);
        System.out.println("porcentaje de interes mensual: " + porcentajeIm);

    }
}
