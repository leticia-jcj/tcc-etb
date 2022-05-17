package model;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Orcamento {
   
    public int idOrcamento;
    public int idCliente;
    public Date dataOrcamento;
    public double totalOrcamento;
    public int status;
      
}
