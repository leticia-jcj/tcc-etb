package model;

import java.util.Date;

//importar as anotações | baixar o lombok
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
