package entidades;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Cliente {
    private String cpf;
    private String nome;
    private String numeroConta;
}
