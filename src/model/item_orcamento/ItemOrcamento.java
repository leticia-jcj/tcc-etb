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
  
    public int idOrcamento;
    public int idProduto;
    public int quantidade;
    
}
