package model.item_orcamento;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.orcamento.Orcamento;
import model.produto.Produto;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class ItemOrcamento {
  
	private int idItemOrcamento;
    private Orcamento orcamento;
    private Produto produto;
    private int quantidade;
    private int status;
    
}
