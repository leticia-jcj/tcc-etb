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
    
    public boolean estaInvalido() {
		return estaVazio(nome) || estaVazio(nome) || estaVazio(cpf) || estaVazio(endereco)
							   || estaVazio(email) || estaVazio(telefone);

	}

	private boolean estaVazio(String campo) {
		return (campo.isEmpty() || campo.equals(""));
	}
    
}
