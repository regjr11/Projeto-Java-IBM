package entidades;
import funcionalidades.Print;
import interfaces.BancoInterface;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Banco implements BancoInterface {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Conta> contas = new ArrayList<>();
    Print print = new Print();

    @Override
    public void cadastrarCliente(Cliente cliente) {
        Integer tamanhoCpf = cliente.getCpf().length();
        Integer tamanhoNome = cliente.getNome().length();
        if(tamanhoCpf < 11)
            print.imprimir("CPF inválido!");
        else if(tamanhoNome == 0)
            print.imprimir("Nome do cliente não foi digitado!");
            else
                clientes.add(cliente);
    }

    @Override
    public Boolean excluirCliente(String cpfCliente) {
        Boolean clienteExiste = Boolean.FALSE;
        for(Cliente cliente : clientes) {
            if(cliente.getCpf().equals(cpfCliente)) {
                clientes.remove(cliente);
                clienteExiste = Boolean.TRUE;
                break;
            }
        }
        return clienteExiste;
    }

    @Override
    public Boolean abrirContaCliente(String cpfCliente,String tipoConta) {
        Boolean clienteExiste = Boolean.FALSE;
        Integer numeroUltimaConta = 0;
        Conta conta;
        for(Cliente cliente : clientes) {
            if(cliente.getCpf().equals(cpfCliente)) {
                clienteExiste = Boolean.TRUE;
                if(!clienteTemConta(cliente)) {
                    try {
                        numeroUltimaConta = Integer.parseInt(contas.get(contas.size() - 1).getNumero());
                    } catch (IndexOutOfBoundsException e) {
                        print.imprimir("Primeira conta registrada no banco!");
                    } finally {
                        numeroUltimaConta++;
                        cliente.setNumeroConta("" + numeroUltimaConta);
                        conta = new Conta("" + numeroUltimaConta, tipoConta, 0.0);
                        contas.add(conta);
                        print.imprimir("Número da conta criada: " + numeroUltimaConta);
                    }
                }
                break;
            }
        }
        return clienteExiste;
    }
    public Boolean clienteTemConta(Cliente cliente) {
        Boolean possuiConta = Boolean.FALSE;
        if(cliente.getNumeroConta() != null) {
            possuiConta = Boolean.TRUE;
            print.imprimir("Cliente já possui uma conta!");
        }
        return possuiConta;
    }
    @Override
    public Boolean saqueConta(String numeroContaCliente, Double valorSaque) {
        Boolean contaExiste = Boolean.FALSE;
        for(Conta conta : contas) {
            if(conta.getNumero().equals(numeroContaCliente)) {
                contaExiste = Boolean.TRUE;
                Double saldo = conta.getSaldo();
                if(saldo == 0) {
                    print.imprimir("Conta está sem saldo!");
                }
                else if(saldo >= valorSaque) {
                    conta.setSaldo(saldo-valorSaque);
                    print.imprimirSemQuebraDeLinhas("Novo saldo: R$ ");
                    print.imprimirDinheiro(conta.getSaldo());
                }
                else {
                    print.imprimir("Saldo insuficiente!");
                }
                break;
            }
        }
        return contaExiste;
    }

    @Override
    public Boolean depositoConta(String numeroContaCliente, Double valorSaque) {
        Boolean contaExiste = Boolean.FALSE;
        for(Conta conta : contas) {
            if (conta.getNumero().equals(numeroContaCliente)) {
                contaExiste = Boolean.TRUE;
                Double saldo = conta.getSaldo();
                conta.setSaldo(saldo + valorSaque);
                break;
            }
        }
        return contaExiste;
    }

    @Override
    public Boolean consultarSaldo(String numeroContaCliente) {
        Boolean contaExiste = Boolean.FALSE;
        for(Conta conta : contas) {
            if (conta.getNumero().equals(numeroContaCliente)) {
                print.imprimirSemQuebraDeLinhas("Saldo da conta : R$ ");
                print.imprimirDinheiro(conta.getSaldo());
                contaExiste = Boolean.TRUE;
                break;
            }
        }
        return contaExiste;
    }
}
