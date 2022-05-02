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

	public int idFornecedor;
	public String razaoSocial;
	public String nomeContato;
	public String email;
	public String telefone;
	public String cnpj;
	public int status;

	public boolean estaInvalido() {
		return estaVazio(razaoSocial) || estaVazio(nomeContato) || estaVazio(telefone)
				|| estaVazio(cnpj);

	}

	private boolean estaVazio(String campo) {
		return (campo.isEmpty() || campo.equals(""));
	}

}
