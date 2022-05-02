package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Cliente {
    
    public int idCliente;
    public String nome;
    public String cpf;
    public String endereco;
    public String email;
    public String telefone;
    public int status;        
    
}
