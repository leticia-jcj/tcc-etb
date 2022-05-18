package model.orcamento;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.cliente.Cliente;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Orcamento {
   
    public int idOrcamento;
    public Cliente cliente;
    public Date dataOrcamento;
    public double totalOrcamento;
    public double totalVenda;
    public int status;
      
}
