package dinobase;

import controlador.TaxonomiaCtrl;
import controlador.UsuarioCtrl;
import framesTaxonomia.TaxonomiaFrame;
import framesUsuario.UsuarioFrame;
import modelo.ConsultasTaxonomia;
import modelo.ConsultasUsuario;
import modelo.Taxonomia;
import modelo.Usuario;

public class DinoBase {

    public static void main(String[] args) {
//        TaxonomiaFrame frame = new TaxonomiaFrame();
//        
//        TaxonomiaCtrl ctrl = 
//                new TaxonomiaCtrl(new Taxonomia(),new ConsultasTaxonomia(),frame);
//        
//        ctrl.iniciar();
//        frame.setVisible(true);

        UsuarioFrame frame = new UsuarioFrame();
        UsuarioCtrl ctrl = 
                new UsuarioCtrl(new Usuario(),new ConsultasUsuario(),frame);
        
        ctrl.iniciar();
        frame.setVisible(true);
    }
    
}
