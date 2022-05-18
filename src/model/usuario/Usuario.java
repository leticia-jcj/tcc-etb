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
    
    public int idUsuario;
    public Perfil perfil;
    public String nome;
    public String login;
    public String senha;
    public int status;
    
    public boolean estaInvalido() {
		return estaVazio(nome) || estaVazio(login) || estaVazio(senha);

	}

	private boolean estaVazio(String campo) {
		return (campo.isEmpty() || campo.equals(""));
	}
  
}
