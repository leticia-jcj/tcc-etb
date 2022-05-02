package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Venda {
    
   public int idVenda;
   public int idCliente;
   public int idOrcamento;
   public int idUsuario;
   public int status;
   
}
