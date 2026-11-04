package Exercicio01;

import java.util.Random;

public class Conta {
    private int id = new Random().nextInt(100);
    private int numeroAgencia;
    private int numeroConta;
    private Double saldo;
    private Double chequeEspecial;

    public Conta() {

    }

    public Conta(int numeroAgencia, int numeroConta, Double saldo, Double chequeEspecial) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
    }

    public int getId() {
        return id;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(Double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    

    
}
