package model.produto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Produto {
    
    public int idProduto;
    public int idFornecedor;
    public String nome;
    public String descricao;
    public int estoque;
    public double precoUnitario;
    public String nomeFoto;
    public String caminho;
    public int status;
    
    public boolean estaInvalido() {
		return estaVazio(nome);

	}

	private boolean estaVazio(String campo) {
		return (campo.isEmpty() || campo.equals(""));
	}
    
}
