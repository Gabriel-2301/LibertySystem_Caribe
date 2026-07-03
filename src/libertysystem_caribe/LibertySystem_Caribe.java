package libertysystem_caribe;

import Formularios.FrmInicio;
import conexion.Conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class LibertySystem_Caribe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        if (Conexion.probarConexion()) {

            System.out.println("Conexion exitosa.");

            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new FrmInicio().setVisible(true);
                }
            });
            
        } else {

            JOptionPane.showMessageDialog(
                null, 
                "No se pudo establecer conexión con la base de datos.\n\n"
                + "Por favor, verifique que:\n"
                + "1. El servidor MySQL esté activo.\n"
                + "2. La base de datos 'liberty_caribe' exista.\n"
                + "3. Las credenciales de acceso sean correctas.", 
                "Error Crítico de Conexión", 
                JOptionPane.ERROR_MESSAGE
            );

            System.exit(0); 
        }
    }
}