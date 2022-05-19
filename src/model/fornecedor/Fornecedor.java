package model.fornecedor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Fornecedor {

	private int idFornecedor;
	private String razaoSocial;
	private String nomeContato;
	private String email;
	private String telefone;
	private String cnpj;
	private int status;

	public boolean estaInvalido() {
		return estaVazio(razaoSocial) || estaVazio(nomeContato) || estaVazio(telefone)
				|| estaVazio(cnpj);

	}

	private boolean estaVazio(String campo) {
		return (campo.isEmpty() || campo.equals(""));
	}

}
