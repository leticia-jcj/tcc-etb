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
   
    private int idOrcamento;
    private Cliente cliente;
    private Date dataOrcamento;
    private double totalOrcamento;
    private double totalVenda;
    private int status;
      
}
