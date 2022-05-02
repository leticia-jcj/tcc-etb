package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class Menu {
 
    public int idMenu;
    public String nome;
    public String link;
    public String icone;
    public int status;
    
}
