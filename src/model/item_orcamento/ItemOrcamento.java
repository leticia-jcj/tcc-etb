package model.item_orcamento;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class ItemOrcamento {
  
    private int idOrcamento;
    private int idProduto;
    private int quantidade;
    
}
