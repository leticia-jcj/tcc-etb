package model.produto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.fornecedor.Fornecedor;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Produto {
    
    private int idProduto;
    private Fornecedor fornecedor;
    private String nome;
    private String descricao;
    private int estoque;
    private double precoUnitario;
    private String nomeFoto;
    private String caminho;
    private int status;
    
    public boolean estaInvalido() {
		return estaVazio(nome);

	}

	private boolean estaVazio(String campo) {
		return (campo.isEmpty() || campo.equals(""));
	}
    
}
