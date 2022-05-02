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
    public int quantidade;
    public double precoUnitario;
    public int status;
    
}
