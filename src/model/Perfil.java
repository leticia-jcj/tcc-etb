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
public class Perfil {
    
    public int idPerfil;
    public String nome;
    public Date dataCadastro;
    public int status;
    
}
