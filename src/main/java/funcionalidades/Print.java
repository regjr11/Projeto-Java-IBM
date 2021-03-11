package funcionalidades;

import lombok.NoArgsConstructor;

import java.text.DecimalFormat;

@NoArgsConstructor
public class Print {
    public void imprimirMenu(){
        System.out.println("          Menu\n" +
                "1 - Cliente\n" +
                "2 - Conta\n" +
                "3 - Sair");
                System.out.print("Opção escolhida: ");
    }
    public void imprimirMenuCliente() {
        System.out.println("Escolha uma das opções:\n" +
                "1 - Cadastrar cliente\n" +
                "2 - Excluir cliente\n" +
                "3 - Voltar");
        System.out.print("Opção escolhida: ");
    }
    public void imprimirMenuConta() {
        System.out.println("Escolha uma das opções:\n" +
                "1 - Abrir conta para um cliente\n" +
                "2 - Saque\n" +
                "3 - Depósito\n" +
                "4 - Consultar Saldo\n" +
                "5 - Voltar");
        System.out.print("Opção escolhida: ");
    }
    public void imprimirMenuTipoConta() {
        System.out.println("Escolha o tipo de conta desejado:\n" +
                "1 - Conta corrente\n" +
                "2 - Conta poupança");
        System.out.print("Opção escolhida: ");
    }
    public void imprimir(String texto) {
        System.out.println(texto);
    }
    public void imprimirSemQuebraDeLinhas(String texto) {
        System.out.print(texto);
    }
    public void imprimirDinheiro(Double valor){
        DecimalFormat fmt = new DecimalFormat("0.00");
        String valorFormatado = fmt.format(valor);
        System.out.println(valorFormatado);
    }

}
