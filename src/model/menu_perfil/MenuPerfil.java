package model.menu_perfil;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import model.menu.Menu;
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
    private int Status;
}
