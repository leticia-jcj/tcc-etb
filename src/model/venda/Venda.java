package model.venda;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.cliente.Cliente;
import model.orcamento.Orcamento;
import model.usuario.Usuario;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Venda {
    
   private int idVenda;
   private Cliente cliente;
   private Orcamento orcamento;
   private Usuario usuario;
   private int status;
   private double totalVenda;
   
}
