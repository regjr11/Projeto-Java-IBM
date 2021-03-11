package funcionalidades;

import entidades.*;
import lombok.NoArgsConstructor;

import java.util.InputMismatchException;
import java.util.Scanner;

@NoArgsConstructor
public class Menu {
    public void IniciarMenu() {
        Print print = new Print();
        Scanner entrada;
        Cliente cliente;
        Banco banco = new Banco();
        Boolean sair = Boolean.TRUE;
        Integer opcao;
        while (sair) {
            print.imprimirMenu();
            try {
                entrada = new Scanner(System.in);
                opcao = entrada.nextInt();
                switch (opcao) {
                    case 1:
                        print.imprimirMenuCliente();
                        entrada = new Scanner(System.in);
                        opcao = entrada.nextInt();
                        switch (opcao) {
                            case 1:
                                cliente = new Cliente();
                                print.imprimir("Digite o CPF do cliente(Somente os números): ");
                                entrada = new Scanner(System.in);
                                String cpf = "" + entrada.nextLong();
                                cliente.setCpf(cpf);
                                print.imprimir("Digite o nome do cliente: ");
                                entrada = new Scanner(System.in);
                                cliente.setNome(entrada.nextLine());
                                banco.cadastrarCliente(cliente);
                                break;
                            case 2:
                                print.imprimir("Digite o CPF do cliente que deseja excluir: ");
                                entrada = new Scanner(System.in);
                                Boolean clienteExiste = banco.excluirCliente(entrada.nextLine());
                                if(!clienteExiste)
                                    print.imprimir("Cliente não cadastrado!");
                                break;
                            case 3:
                                break;
                            default:
                                print.imprimir("Opção inválida!\n");
                        }
                        break;
                    case 2:
                        print.imprimirMenuConta();
                        entrada = new Scanner(System.in);
                        opcao = entrada.nextInt();
                        String numeroConta;
                        String tipoConta = "";
                        String cpf;
                        Boolean contaExiste;
                        Boolean opcaoValida = Boolean.FALSE;
                        switch(opcao) {
                            case 1:
                                print.imprimir("Digite o CPF do cliente que deseja abrir conta: ");
                                entrada = new Scanner(System.in);
                                cpf = entrada.nextLine();
                                print.imprimirMenuTipoConta();
                                while(!opcaoValida) {
                                    entrada = new Scanner(System.in);
                                    opcao = entrada.nextInt();
                                    switch (opcao) {
                                        case 1:
                                            tipoConta = "Conta corrente";
                                            opcaoValida = Boolean.TRUE;
                                            break;
                                        case 2:
                                            tipoConta = "Conta poupança";
                                            opcaoValida = Boolean.TRUE;
                                            break;
                                        default:
                                            print.imprimir("Opção inválida!");
                                            print.imprimir("Digite novamente:");
                                    }
                                }
                                Boolean clienteExiste = banco.abrirContaCliente(cpf,tipoConta);
                                if(!clienteExiste)
                                    print.imprimir("Cliente não cadastrado!");
                                break;
                            case 2:
                                print.imprimir("Digite o número da conta que deseja realizar o saque: ");
                                entrada = new Scanner(System.in);
                                numeroConta = entrada.nextLine();
                                print.imprimir("Digite o valor do saque: ");
                                entrada = new Scanner(System.in);
                                contaExiste = banco.saqueConta(numeroConta,entrada.nextDouble());
                                if(!contaExiste)
                                    print.imprimir("Conta não cadastrada");
                                break;
                            case 3:
                                print.imprimir("Digite o número da conta que deseja realizar o depósito: ");
                                entrada = new Scanner(System.in);
                                numeroConta = entrada.nextLine();
                                print.imprimir("Digite o valor do depósito: ");
                                entrada = new Scanner(System.in);
                                contaExiste = banco.depositoConta(numeroConta,entrada.nextDouble());
                                if(!contaExiste)
                                    print.imprimir("Conta não cadastrada!");
                                break;
                            case 4:
                                print.imprimir("Digite o número da conta que deseja consultar o saldo: ");
                                entrada = new Scanner(System.in);
                                numeroConta = entrada.nextLine();
                                contaExiste = banco.consultarSaldo(numeroConta);
                                if(!contaExiste)
                                    print.imprimir("Conta não cadastrada!");
                                break;
                            case 5:
                                break;
                            default:
                                print.imprimir("Opção inválida!");
                        }
                        break;
                    case 3:
                        sair = Boolean.FALSE;
                        break;
                    default:
                        print.imprimir("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                print.imprimir("Valor Inválido!");
                print.imprimir("Digite um valor válido ao que está pedindo");
            }
        }
    }
}
