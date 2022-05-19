package model.cliente;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Cliente {
	
    private int idCliente;
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private int status; 
    
    public boolean estaInvalido() {
		return estaVazio(nome) || estaVazio(nome) || estaVazio(cpf) || estaVazio(endereco)
							   || estaVazio(email) || estaVazio(telefone);

	}

	private boolean estaVazio(String campo) {
		return (campo.isEmpty() || campo.equals(""));
	}
    
}
