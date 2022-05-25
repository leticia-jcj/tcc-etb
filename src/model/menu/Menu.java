package model.menu;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Menu {
 
    private int idMenu;
    private String nome;
    private String link;
    private String icone;
    private int status;
    
    public boolean estaInvalido() {
		return estaVazio(nome) || estaVazio(link) ;

	}

	private boolean estaVazio(String campo) {
		return (campo.isEmpty() || campo.equals(""));
	}
}
