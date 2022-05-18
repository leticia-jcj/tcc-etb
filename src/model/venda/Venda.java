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
    
   public int idVenda;
   public Cliente cliente;
   public Orcamento orcamento;
   public Usuario usuario;
   public double totalVenda;
   public int status;
   
}
