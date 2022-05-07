package bancos;

import java.util.Scanner;

public abstract class Cuentas {

    public static Scanner leer = new Scanner(System.in);
    protected float Saldo;
    protected String NombreCliente;
    protected int NumCuenta;
    float Deposito = 0;
    public Cuentas() {
    }

    public Cuentas(int NumCuenta, float Saldo, String NombreCliente) {
        this.Saldo = Saldo;
        this.NombreCliente = NombreCliente;
        this.NumCuenta = NumCuenta;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(float Saldo) {
        this.Saldo = Saldo;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public int getNumCuenta() {
        return NumCuenta;
    }

    public void setNumCuenta(int NumCuenta) {
        this.NumCuenta = NumCuenta;
    }

    public void PedirDatos() {
        System.out.println("Registrar cuenta bancaria");
        System.out.print("Ingrese su nombre: ");
        this.NombreCliente = Cuentas.leer.next();
        System.out.print("Ingrese su numero de cuenta bancaria: ");
        this.NumCuenta = Cuentas.leer.nextInt();
        System.out.print("Ingrese su saldo inicial: ");
        this.Saldo = Cuentas.leer.nextFloat();

    }

    abstract public void RetirarSaldo();

    public void DepositarSaldo() {

        String buscar, Cliente, NumeroDeCuenta;
        System.out.print("Ingresa el nombre del cliente o numero de cuenta bancaria a depositar: ");
        buscar = leer.next();
        Cliente = NombreCliente;
        NumeroDeCuenta = String.valueOf(NumCuenta);
        if (Cliente.equals(buscar) || NumeroDeCuenta.equals(buscar)) {
            System.out.print("Ingresa la cantidad a depositar: ");
            Deposito = leer.nextFloat();
            
            if (Deposito <= 0) {
                System.out.println("Ingrese una cantidad valida a depositar: ");
            } else {
               Saldo = Saldo + Deposito;
                System.out.println("Depósito realizado con exito, su saldo actual es: " + " $" + Saldo);
            }
        } else {
            System.out.println("Usuario no encontrado");
        }
    }

    public void ConsultarDatos() {
        System.out.println("\nCUENTA BANCARIA");
        System.out.println("Nombre del cliente: " + NombreCliente);
        System.out.println("Numero de cuenta bancaria: " + NumCuenta);
        System.out.println("saldo actual: " + "$" + Saldo);
    }
}
