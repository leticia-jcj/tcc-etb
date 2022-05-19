package model.usuario;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.perfil.Perfil;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Usuario {
    
    private int idUsuario;
    private Perfil perfil;
    private String nome;
    private String login;
    private String senha;
    private int status;
    
    public boolean estaInvalido() {
		return estaVazio(nome) || estaVazio(login) || estaVazio(senha);

	}

	private boolean estaVazio(String campo) {
		return (campo.isEmpty() || campo.equals(""));
	}
  
}
