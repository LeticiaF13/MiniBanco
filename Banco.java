package Banco;

import java.util.HashMap;
import java.util.Map;

class Banco {
    private Map<String, Cliente> clientes;
    private Map<String, Conta> contas;

    public Banco() {
        clientes = new HashMap<>();
        contas = new HashMap<>();
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.put(cliente.getCpf(), cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public Cliente buscarCliente(String cpf) {
        return clientes.get(cpf);
    }

    public void cadastrarConta(Conta conta) {
        contas.put(conta.getNumeroConta(), conta);
        System.out.println("Conta cadastrada com sucesso!");
    }

    public Conta buscarConta(String numeroConta) {
        return contas.get(numeroConta);
    }
}
