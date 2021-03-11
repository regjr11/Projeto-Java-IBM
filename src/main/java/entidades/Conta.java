package entidades;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Conta {
    private String numero;
    private String tipoConta;
    private Double saldo;
}
