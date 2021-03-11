package interfaces;
import entidades.Cliente;

public interface BancoInterface {
    void cadastrarCliente(Cliente cliente);
    Boolean excluirCliente(String cpfCliente);
    Boolean abrirContaCliente(String cpfCliente,String tipoConta);
    Boolean clienteTemConta(Cliente cliente);
    Boolean saqueConta(String numeroContaCliente,Double valor);
    Boolean depositoConta(String numeroContaCliente,Double valor);
    Boolean consultarSaldo(String numeroContaCliente);
}
