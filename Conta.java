package Banco;

import java.util.UUID;

abstract class Conta {
    protected String numeroConta;
    protected Cliente cliente;
    protected String agencia;
    protected String senha;
    protected double saldo;


    public Conta(Cliente cliente, String agencia, String senha) {
        this.cliente = cliente;
        this.agencia = agencia;
        this.senha = senha;
        this.saldo = 0.0;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public double verificarSaldo() {
        return saldo;
    }


    public abstract void depositar(double valor);

    public abstract void sacar(double valor);
    public String getSenha() {
        return senha;
    }
    public void transferir(Conta destino, double valor, String senha) {
        if (valor <= 0) {
            System.out.println("Valor inválido para transferência.");
            return;
        }

        if (!senha.equals(this.senha)) {
            System.out.println("Senha incorreta.");
            return;
        }

        if (saldo < valor) {
            System.out.println("Saldo insuficiente para realizar a transferência.");
            return;
        }

        saldo -= valor;
        destino.depositar(valor);
        System.out.println("Transferência efetuada com sucesso.");
    }
    public void sacar(double valor, String senha) {
        if (valor <= 0) {
            System.out.println("Valor inválido para saque.");
            return;
        }

        if (!senha.equals(this.senha)) {
            System.out.println("Senha incorreta.");
            return;
        }

        if (saldo < valor) {
            System.out.println("Saldo insuficiente para realizar o saque.");
            return;
        }

        saldo -= valor;
        System.out.println("Saque efetuado com sucesso. Novo saldo: " + saldo);
    }

}
