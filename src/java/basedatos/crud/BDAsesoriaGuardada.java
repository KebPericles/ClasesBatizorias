package basedatos.crud;

import basedatos.conexion.Conexion;
import basedatos.entidades.AsesoriaGuardada;
import basedatos.entidades.Registro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

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
    public static AsesoriaGuardada[] buscarIdUsuario(String idUsuario) {
        // TODO implement here
        ResultSet rs;
        AsesoriaGuardada[] ag = null;
        
        try{
            //Conectar a la bd
            Connection conBD = Conexion.conectarBD();
            String q = "SELECT * FROM asesoriasGuardadas WHERE idUsuario = ?";
            PreparedStatement ps = conBD.prepareStatement(q);
            
            try{
                //preparacion de las variables de 
                ps.setString(1, idUsuario);
                
                rs = ps.executeQuery();
                int i = 0;
                while(rs.next()){
                    i++;
                }
                //Instanciamos el array con la longitud que hay
                ag = new AsesoriaGuardada[i];
                
                for(int n = 0; n < ag.length; n++){
                    if(rs.previous()){
                        ag[n] = new AsesoriaGuardada(rs.getString(1));
                        ag[n].setIdUsuario(rs.getString(2));
                        ag[n].setIdAsesoria(rs.getString(3));
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
        return ag;
    }

    /**
     * @param idAsesoria 
     * @return
     */
    public static AsesoriaGuardada[] buscarIdAsesoria(String idAsesoria) {
        // TODO implement here
        ResultSet rs;
        AsesoriaGuardada[] ag = null;
        
        try{
            //Conectar a la bd
            Connection conBD = Conexion.conectarBD();
            String q = "SELECT * FROM asesoriasGuardadas WHERE idAsesoria = ?";
            PreparedStatement ps = conBD.prepareStatement(q);
            
            try{
                //preparacion de las variables de 
                ps.setString(1, idAsesoria);
                
                rs = ps.executeQuery();
                int i = 0;
                while(rs.next()){
                    i++;
                }
                //Instanciamos el array con la longitud que hay
                ag = new AsesoriaGuardada[i];
                
                for(int n = 0; n < i; n++){
                    if(rs.previous()){
                        ag[n] = new AsesoriaGuardada(rs.getString(1));
                        ag[n].setIdUsuario(rs.getString(2));
                        ag[n].setIdAsesoria(rs.getString(3));
                    }
                }
                System.out.println(ag[i-1].getId());
                
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
        return ag;
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
        ResultSet rs;
        AsesoriaGuardada ag = null;
        
        try{
            //Conectar a la bd
            Connection conBD = Conexion.conectarBD();
            String q = "SELECT * FROM asesoriasGuardadas WHERE id = ?";
            PreparedStatement ps = conBD.prepareStatement(q);
            
            try{
                //preparacion de las variables de 
                ps.setString(1, id);
                
                rs = ps.executeQuery();
                
                if(rs.next()){
                    ag = new AsesoriaGuardada(rs.getString(1));
                    ag.setIdUsuario(rs.getString(2));
                    ag.setIdAsesoria(rs.getString(3));
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
        return ag;
    }

    /**
     * @param registroModificado 
     * @return
     */
    @Override
    public boolean modificar(Registro registroModificado) {
        // No hay implementacion porque no puedes modificar una asesoria guardada,
        // solo la puedes borrar
        return false;
    }

    /**
     * @param id 
     * @return
     */
    public boolean borrar(String id, String idUsuario) {
        // TODO implement here
        try{
            //Conectar a la bd
            Connection conBD = Conexion.conectarBD();
            String q = "DELETE FROM asesoriasGuardadas WHERE id = ? AND idUsuario = ?";
            PreparedStatement ps = conBD.prepareStatement(q);
            
            try{
                //preparacion de las variables de 
                ps.setString(1, id);
                ps.setString(2, idUsuario);
                
                ps.executeUpdate();
                q = "SELECT * FROM asesoriasGuardadas WHERE id = ? AND idUsuario = ?";
                ps = conBD.prepareStatement(q);
                ps.setString(1, id);
                ps.setString(2, idUsuario);
                boolean tr = !ps.executeQuery().next();
                
                ps.close();
                conBD.close(); 
                //retornamos operacion con exito
                return tr;
            }catch(SQLException es){
                System.out.println(es.getMessage());
                System.out.println(Arrays.toString(es.getStackTrace()));
            }finally{
                ps.close();
                conBD.close();
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return false;
    }

    @Override
    public boolean borrar(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}