package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Usuario {
    
    public int idUauario;
    public int idPerfil;
    public String nome;
    public String login;
    public String senha;
    public int status;
  
}
