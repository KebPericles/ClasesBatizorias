package basedatos.crud;

import basedatos.conexion.Conexion;
import basedatos.entidades.Asesoria;
import basedatos.entidades.PermisoMateria;
import basedatos.entidades.Registro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 */
public class BDPermisoMateria implements BD {

    /**
     * Default constructor
     */
    public BDPermisoMateria() {
    }

    /**
     * @param idUsuario 
     * @return
     */
    public static PermisoMateria[] buscarIdUsuario(String idUsuario) {
        // TODO implement here
        ResultSet rs;
        PermisoMateria[] pm = null;
        
        try{
            //Conectar a la bd
            Connection conBD = Conexion.conectarBD();
            String q = "SELECT * FROM asesorias WHERE idUsuario = ?";
            PreparedStatement ps = conBD.prepareStatement(q);
            
            try{
                //preparacion de las variables de 
                ps.setString(1, idUsuario);
                
                rs = ps.executeQuery();
                
                //Aqui cambia porque puede haber varias asesorias de un mismo usuario
                int i = 0;
                //Descubrimos la longitud de la consulta
                while(rs.next()){
                    i++;
                }
                //Instanciamos el aarray con la longitud que hay
                pm = new PermisoMateria[i];
                //Instanciamos cada objeto
                for(int n = 0; n < i; n++){
                    if(rs.previous()){
                        pm[n] = new PermisoMateria(rs.getString(1));
                        pm[n].setIdMateria(rs.getString(2));
                        pm[n].setIdUsuario(rs.getString(3));
                    }
                }
                rs.close();
            }catch(SQLException es){
                System.out.println(es.getMessage());
                System.out.println(es.getStackTrace());
            }finally{
                ps.close();
                conBD.close();
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        return pm;
    }

    /**
     * @param r 
     * @return
     */
    @Override
    public boolean registrar(Registro r) {
        // TODO implement here
        return false;
    }

    /**
     * @param id 
     * @return
     */
    @Override
    public Registro buscarId(String id) {
        // TODO implement here
        return null;
    }

    /**
     * @param registroModificado 
     * @return
     */
    @Override
    public boolean modificar(Registro registroModificado) {
        // TODO implement here
        return false;
    }

    /**
     * @param id 
     * @return
     */
    @Override
    public boolean borrar(String id) {
        // TODO implement here
        return false;
    }

}