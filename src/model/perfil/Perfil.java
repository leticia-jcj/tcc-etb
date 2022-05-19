package model.perfil;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Perfil {
    
    private int idPerfil;
    private String nome;
    private Date dataCadastro;
    private int status;
    
    //criar metodo para validar campos da model
    
}
