package basedatos.crud;

import basedatos.conexion.Conexion;
import basedatos.entidades.AsesoriaGuardada;
import basedatos.entidades.Registro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 
 */
public class BDAsesoriaGuardada implements BD {

    /**
     * Default constructor
     */
    public BDAsesoriaGuardada() {
    }

    /**
     * @param idUsuario 
     * @return
     */
    public static AsesoriaGuardada buscarIdUsuario(String idUsuario) {
        // TODO implement here
        return null;
    }

    /**
     * @param idAsesoria 
     * @return
     */
    public static AsesoriaGuardada buscarIdAsesoria(String idAsesoria) {
        // TODO implement here
        return null;
    }

    /**
     * @param r 
     * @return
     */
    @Override
    public boolean registrar(Registro r) {
        // TODO implement here
        AsesoriaGuardada ag = (AsesoriaGuardada)r;
        
        if(ag==null){
            return false;
        }
        
        try{
            //Conectar a la bd
            Connection conBD = Conexion.conectarBD();
            String q = "INSERT INTO asesoriasGuardadas (idUsuario,idAsesoria) VALUES (?,?)";
            PreparedStatement ps = conBD.prepareStatement(q);
            
            try{
                //preparacion de las variables de la BD
                ps.setString(1, ag.getIdUsuario());
                ps.setString(2, ag.getIdAsesoria());                
                
                ps.executeUpdate();
                
                ps.close();
                conBD.close();
                
                //retornamos operacion con exito
                return true;
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