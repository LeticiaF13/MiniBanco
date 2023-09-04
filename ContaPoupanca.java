package Banco;

import java.util.Random;

class ContaPoupanca extends Conta {
    private static final int NUMERO_CONTA_LENGTH = 6;

    public ContaPoupanca(Cliente cliente, String agencia, String senha) {
        super(cliente, agencia, senha);
        this.numeroConta = gerarNumeroConta();
    }

    private String gerarNumeroConta() {
        Random random = new Random();
        StringBuilder numeroConta = new StringBuilder();

        for (int i = 0; i < NUMERO_CONTA_LENGTH; i++) {
            int digit = random.nextInt(10);
            numeroConta.append(digit);
        }

        return numeroConta.toString();
    }


    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Depósito efetuado com sucesso. Novo saldo: " + getSaldo());
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }
    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque efetuado com sucesso. Novo saldo: " + saldo);
        } else {
            System.out.println("Valor inválido para saque ou saldo insuficiente.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Conta Poupança | Número da Conta: " + numeroConta;
    }
    @Override
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
    @Override
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


