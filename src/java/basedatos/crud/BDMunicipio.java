package basedatos.crud;

import basedatos.conexion.Conexion;
import basedatos.entidades.Municipio;
import basedatos.entidades.Registro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 */
public class BDMunicipio implements BD {

    /**
     * Default constructor
     */
    public BDMunicipio() {
    }

    /**
     * @param r 
     * @return
     */
    @Override
    public boolean registrar(Registro r) {
        // TODO implement here
        //Creacion del objeto a registrar usando polimorfismo
        Municipio m = (Municipio)r;
        
        //Evaluar si el objeto tiene algo dentro
        if(m==null){
            return false;
        }
        
        try{
            //Conectar a la bd
            Connection conBD = Conexion.conectarBD();
            String q = "INSERT INTO municipios (nombre,estado) VALUES (?,?)";
            PreparedStatement ps = conBD.prepareStatement(q);
            
            try{
                //preparacion de las variables de 
                ps.setString(1, m.getNombre());
                ps.setString(2, m.getEstado());
                
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
        Municipio m = null;
        
        try{
            //Conectar a la bd
            Connection conBD = Conexion.conectarBD();
            String q = "SELECT * FROM municipios WHERE id = ?";
            PreparedStatement ps = conBD.prepareStatement(q);
            
            try{
                //preparacion de las variables de 
                ps.setString(1, id);
                
                rs = ps.executeQuery();
                
                if(rs.next()){
                    m = new Municipio(rs.getString(1));
                    m.setNombre(rs.getString(2));
                    m.setEstado(rs.getString(3));
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
        return m;
    }

    /**
     * @param registroModificado 
     * @return
     */
    @Override
    public boolean modificar(Registro registroModificado) {
        // TODO implement here
        Municipio m = (Municipio)registroModificado;
        
        if(m == null){
            return false;
        }
        
        String id = m.getId();
        try{
            //Conectar a la bd
            Connection conBD = Conexion.conectarBD();
            String q = "UPDATE municipios SET nombre = ?,estado = ? WHERE id = ?";
            PreparedStatement ps = conBD.prepareStatement(q);
            
            try{
                //preparacion de las variables
                ps.setString(1, m.getNombre());
                ps.setString(2, m.getEstado());
                ps.setString(3, id);
                
                ps.executeUpdate();
                
                ps.close();
                conBD.close();
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
    public boolean borrar(String id) {
        // TODO implement here
        try{
            //Conectar a la bd
            Connection conBD = Conexion.conectarBD();
            String q = "DELETE FROM municipios WHERE id = ?";
            PreparedStatement ps = conBD.prepareStatement(q);
            
            try{
                //preparacion de las variables de 
                ps.setString(1, id);
                
                ps.executeUpdate();
                q = "SELECT * FROM municipios WHERE id = ?";
                ps = conBD.prepareStatement(q);
                ps.setString(1, id);
                boolean tr = ps.executeQuery().next();
                
                ps.close();
                conBD.close(); 
                //retornamos operacion con exito
                return tr;
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
}