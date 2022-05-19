package model.menu_perfil;

import java.awt.Menu;
import java.sql.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.perfil.Perfil;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class MenuPerfil {
	
    private int idMenuPerfil;
    private Perfil perfil;
    private Menu menu;
    private Date dataCadastro;
}
