package bancos;

import java.util.Scanner;

public class Cheques extends Cuentas {

    public static Scanner leer = new Scanner(System.in);
    private float comisionpersaldos = 10f;
    private float comisionperuso = 8.5f;
    private float Sfinal;

    public Cheques() {
    }

    public Cheques(int NumCuenta, float Saldo, String NombreCliente,
            float comisionpersaldos, float comisionperuso) {
        super(NumCuenta, Saldo, NombreCliente);
        this.comisionpersaldos = comisionpersaldos;
        this.comisionperuso = comisionperuso;

    }
   
    @Override
    public void PedirDatos() {
        super.PedirDatos();
        System.out.println("La comisión por uso de chequera es de: " + comisionperuso);
        System.out.println("La cmisión por emisión de cheques con saldo insuficiente es: " + comisionpersaldos);
    }

    @Override
    public void RetirarSaldo() {
        String buscar, Cliente, NumeroDeCuenta;
        float Cantidad, ComisionChequera;
        NumeroDeCuenta = String.valueOf(NumCuenta);
        Cliente = NombreCliente;
        System.out.print("Ingresa el nombre del cliente o numero de cuenta bancaria a retirar: ");
        buscar = Cheques.leer.next();
        if (Cliente.equals(buscar) || NumeroDeCuenta.equals(buscar)) {
            System.out.println("Cobro de Cheque...!");
            System.out.println("Ingresa la cantidad del cheque a retirar. ");
            Cantidad = Cheques.leer.nextFloat();
            if (Saldo > Cantidad) {
                System.out.println("Se le cobrara la siguiente comisión: " + "$" + comisionperuso);
                ComisionChequera = (float) ((comisionperuso * Saldo) / 100);
               float Sfinal = Saldo = Saldo - ComisionChequera;
                
                Saldo = Saldo - Cantidad;
                System.out.println("Saldo actual es: " + "$" + Saldo);
            } else {
                System.out.println("Saldo insuficiente ");
                System.out.println("Se te descontara la comision " + comisionpersaldos + " Por saldo insuficiente en tu cuena bancaria ");
                ComisionChequera = ((comisionpersaldos * Saldo) / 100);
                float Sfinal1 = ( Saldo-comisionpersaldos);
                System.out.println("Su saldo actual es: " + "$" + Sfinal1);
            }
        }
    }
    
    @Override
    public void ConsultarDatos() {
        super.ConsultarDatos();
        System.out.println("comisionpersaldos "+ comisionpersaldos);
        System.out.println("comisionperuso "+ comisionperuso); 
        
    }
}
