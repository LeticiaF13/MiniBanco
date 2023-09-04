package Banco;

import java.util.Scanner;

//      * * * * * * * * * * * * * * * * * * *
//      *             ACADÊMICO:            *
//      *                                   *
//      *      Leticia Faeda RA: 1116       *
//      *                                   *
//      * * * * * * * * * * * * * * * * * * *

public class ConsoleApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

        while (true) {
            System.out.println(" ");
            System.out.println("        * * * Menu * * * ");
            System.out.println("  ");
            System.out.println("1. Cadastrar Cliente Pessoa Física");
            System.out.println("2. Cadastrar Conta ");
            System.out.println("3. Efetuar Depósito");
            System.out.println("4. Efetuar Saque");
            System.out.println("6. Efetuar Transferência");
            System.out.println("7. Verificar Saldo");
            System.out.println("0. Sair");

            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpfCliente = scanner.nextLine();
                    Cliente cliente = new Cliente(nomeCliente, cpfCliente);
                    banco.cadastrarCliente(cliente);
                    break;
                case 2:
                    System.out.println("Qual tipo da conta que você deseja cadastrar?");
                    System.out.println("1 - Corrente");
                    System.out.println("2 - Poupança");
                    int opcaoConta = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha

                    if (opcaoConta == 1) {
                        System.out.println("* *  CADASTRO CONTA CORRENTE * * * ");
                        System.out.print("CPF do cliente: ");
                        String cpfContaCorrente = scanner.nextLine();
                        Cliente clienteContaCorrente = banco.buscarCliente(cpfContaCorrente);

                        if (clienteContaCorrente != null) {
                            System.out.print("Agência da Conta Corrente: ");
                            String agenciaContaCorrente = scanner.nextLine();
                            System.out.print("Senha da Conta Corrente: ");
                            String senhaContaCorrente = scanner.nextLine();
                            ContaCorrente contaCorrente = new ContaCorrente(clienteContaCorrente, agenciaContaCorrente, senhaContaCorrente);
                            banco.cadastrarConta(contaCorrente);
                            System.out.println("Conta Corrente cadastrada com sucesso!");
                            System.out.println("Número da Conta: " + contaCorrente.getNumeroConta());
                        } else {
                            System.out.println("Cliente não encontrado.");
                        }
                    } else if (opcaoConta == 2) {
                        System.out.println("* *  CADASTRO CONTA POUPANÇA * * * ");
                        System.out.print("CPF do cliente: ");
                        String cpfContaPoupanca = scanner.nextLine();
                        Cliente clienteContaPoupanca = banco.buscarCliente(cpfContaPoupanca);

                        if (clienteContaPoupanca != null) {
                            System.out.print("Agência da Conta Poupança: ");
                            String agenciaContaPoupanca = scanner.nextLine();
                            System.out.print("Senha da Conta Poupança: ");
                            String senhaContaPoupanca = scanner.nextLine();
                            ContaPoupanca contaPoupanca = new ContaPoupanca(clienteContaPoupanca, agenciaContaPoupanca, senhaContaPoupanca);
                            banco.cadastrarConta(contaPoupanca);
                            System.out.println("Conta Poupança cadastrada com sucesso!");
                            System.out.println("Número da Conta: " + contaPoupanca.getNumeroConta());
                        } else {
                            System.out.println("Cliente não encontrado.");
                        }
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 3:
                    System.out.println("* *  DEPÓSITO * * * ");
                    System.out.print("CPF do cliente: ");
                    String cpfDeposito = scanner.nextLine();
                    Cliente clienteDeposito = banco.buscarCliente(cpfDeposito);

                    if (clienteDeposito != null) {
                        System.out.print("Número da Conta (Conta-Corrente ou Poupança): ");
                        String numeroContaDeposito = scanner.nextLine();
                        Conta contaDeposito = banco.buscarConta(numeroContaDeposito);

                        if (contaDeposito != null && contaDeposito.getCliente() == clienteDeposito) {
                            System.out.print("Valor para depósito: ");
                            double valorDeposito = scanner.nextDouble();
                            if (valorDeposito > 0) {
                                scanner.nextLine(); // Consumir a quebra de linha

                                System.out.print("Senha da Conta: ");
                                String senhaDeposito = scanner.nextLine();

                                if (contaDeposito.getSenha().equals(senhaDeposito)) {
                                    System.out.println("Confirma o depósito? (S/N): ");
                                    String confirmacao = scanner.nextLine();
                                    if (confirmacao.equalsIgnoreCase("S")) {
                                        contaDeposito.depositar(valorDeposito);
                                      //  System.out.println("Depósito efetuado com sucesso.");
                                       // System.out.println("Novo saldo: " + contaDeposito.verificarSaldo());
                                    } else {
                                        System.out.println("Depósito cancelado.");
                                    }
                                } else {
                                    System.out.println("Senha incorreta.");
                                }
                            } else {
                                System.out.println("Valor inválido para depósito.");
                            }
                        } else {
                            System.out.println("Conta não encontrada ou não pertence ao cliente.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("* *  SAQUE * * * ");
                    System.out.print("CPF do cliente: ");
                    String cpfSaque = scanner.nextLine();
                    Cliente clienteSaque = banco.buscarCliente(cpfSaque);

                    if (clienteSaque != null) {
                        System.out.print("Número da Conta (Conta-Corrente ou Poupança): ");
                        String numeroContaSaque = scanner.nextLine();
                        Conta contaSaque = banco.buscarConta(numeroContaSaque);

                        if (contaSaque != null && contaSaque.getCliente() == clienteSaque) {
                            System.out.print("Valor para saque: ");
                            double valorSaque = scanner.nextDouble();
                            contaSaque.sacar(valorSaque);
                        } else {
                            System.out.println("Conta não encontrada ou não pertence ao cliente.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                case 6:
                    System.out.println("* *  TRANSFERÊNCIA * * * ");
                    System.out.print("CPF do cliente (conta origem): ");
                    String cpfOrigem = scanner.nextLine();
                    Cliente clienteOrigem = banco.buscarCliente(cpfOrigem);

                    if (clienteOrigem != null) {
                        System.out.print("Número da Conta (Conta-Corrente ou Poupança) origem: ");
                        String numeroContaOrigem = scanner.nextLine();
                        Conta contaOrigem = banco.buscarConta(numeroContaOrigem);

                        if (contaOrigem != null && contaOrigem.getCliente() == clienteOrigem) {
                            System.out.print("CPF do cliente (conta destino): ");
                            String cpfDestino = scanner.nextLine();
                            Cliente clienteDestino = banco.buscarCliente(cpfDestino);

                            if (clienteDestino != null) {
                                System.out.print("Número da Conta (Conta-Corrente ou Poupança) destino: ");
                                String numeroContaDestino = scanner.nextLine();
                                Conta contaDestino = banco.buscarConta(numeroContaDestino);

                                if (contaDestino != null && contaDestino.getCliente() == clienteDestino) {
                                    System.out.print("Valor para transferência: ");
                                    double valorTransferencia = scanner.nextDouble();
                                    scanner.nextLine(); // Consumir a quebra de linha

                                    System.out.print("Senha da Conta origem: ");
                                    String senhaTransferencia = scanner.nextLine();

                                    contaOrigem.transferir(contaDestino, valorTransferencia, senhaTransferencia);
                                } else {
                                    System.out.println("Conta destino não encontrada ou não pertence ao cliente.");
                                }
                            } else {
                                System.out.println("Cliente destino não encontrado.");
                            }
                        } else {
                            System.out.println("Conta origem não encontrada ou não pertence ao cliente.");
                        }
                    } else {
                        System.out.println("Cliente origem não encontrado.");
                    }
                    break;

                case 7:
                    System.out.println("* *  SALDO * * * ");
                    System.out.print("CPF do cliente: ");
                    String cpfVerificarSaldo = scanner.nextLine();
                    Cliente clienteVerificarSaldo = banco.buscarCliente(cpfVerificarSaldo);

                    if (clienteVerificarSaldo != null) {
                        System.out.print("Número da Conta (Conta-Corrente ou Poupança): ");
                        String numeroContaVerificarSaldo = scanner.nextLine();
                        Conta contaVerificarSaldo = banco.buscarConta(numeroContaVerificarSaldo);

                        if (contaVerificarSaldo != null && contaVerificarSaldo.getCliente() == clienteVerificarSaldo) {
                            System.out.println("Saldo da Conta: " + contaVerificarSaldo.verificarSaldo());
                        } else {
                            System.out.println("Conta não encontrada ou não pertence ao cliente.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;


            }
        }
    }
}
