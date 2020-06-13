package basedatos.crud;

import basedatos.conexion.Conexion;
import basedatos.entidades.Asesoria;
import basedatos.entidades.Registro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * 
 */
public class BDAsesoria implements BD {

    /**
     * Default constructor
     */
    public BDAsesoria() {
    }

    /**
     * @param idUsuario 
     * @return
     */
    public static Asesoria[] buscarIdUsuario(String idUsuario) {
        // TODO implement here
        ResultSet rs;
        Asesoria[] a = null;
        
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
                a = new Asesoria[i];
                //Instanciamos cada objeto
                for(int n = 0; n < i; n++){
                    if(rs.previous()){
                        a[n] = new Asesoria(rs.getString(1));
                        a[n].setIdUsuario(rs.getString(2));
                        a[n].setIdMateria(rs.getByte(3));
                        a[n].setCosto(rs.getString(4));
                    }
                }
                rs.close();
            }catch(SQLException es){
                System.out.println(es.getMessage());
                System.out.println(Arrays.toString(es.getStackTrace()));
            }finally{
                ps.close();
                conBD.close();
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return a;
    }

    /**
     * @param idMateria 
     * @return
     */
    public static Asesoria[] buscarIdMateria(String idMateria) {
        // TODO implement here
        ResultSet rs;
        Asesoria[] a = null;
        
        try{
            //Conectar a la bd
            Connection conBD = Conexion.conectarBD();
            String q = "SELECT * FROM asesorias WHERE idMateria = ?";
            PreparedStatement ps = conBD.prepareStatement(q);
            
            try{
                //preparacion de las variables de 
                ps.setString(1, idMateria);
                
                rs = ps.executeQuery();
                
                int i = 0;
                while(rs.next()){i++;}
                
                a = new Asesoria[i];
                
                for(int n = 0; n < i; n++){
                    if(rs.previous()){
                        a[n] = new Asesoria(rs.getString(1));
                        a[n].setIdUsuario(rs.getString(2));
                        a[n].setIdMateria(rs.getByte(3));
                        a[n].setCosto(rs.getString(4));
                    }
                }
                rs.close();
            }catch(SQLException es){
                System.out.println(es.getMessage());
                System.out.println(Arrays.toString(es.getStackTrace()));
            }finally{
                ps.close();
                conBD.close();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return a;
    }

    /**
     * @param r 
     * @return
     */
    @Override
    public boolean registrar(Registro r) {
        // TODO implement here
        Asesoria a = (Asesoria)r;
        
        if(a==null){
            return false;
        }
        
        try{
            //Conectar a la bd
            Connection conBD = Conexion.conectarBD();
            String q = "INSERT INTO asesorias (idUsuario,idMateria,costo) VALUES (?,?,?)";
            PreparedStatement ps = conBD.prepareStatement(q);
            
            try{
                //preparacion de las variables de la BD
                ps.setString(1, a.getIdUsuario());
                ps.setByte(2, a.getIdMateria());
                ps.setString(3, a.getCosto());
                
                ps.executeUpdate();
                
                ps.close();
                conBD.close();
                
                //retornamos operacion con exito
                return true;
            }catch(SQLException es){
                System.out.println(es.getMessage());
                System.out.println(Arrays.toString(es.getStackTrace()));
            }finally{
                ps.close();
                conBD.close();
            }
            
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
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
        Asesoria a = null;
        
        try{
            //Conectar a la bd
            Connection conBD = Conexion.conectarBD();
            String q = "SELECT * FROM asesorias WHERE id = ?";
            PreparedStatement ps = conBD.prepareStatement(q);
            
            try{
                //preparacion de las variables de 
                ps.setString(1, id);
                
                rs = ps.executeQuery();
                
                if(rs.next()){
                    a = new Asesoria(rs.getString(1));
                    a.setIdUsuario(rs.getString(2));
                    a.setIdMateria(rs.getByte(3));
                    a.setCosto(rs.getString(4));
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
        return a;
    }

    /**
     * @param registroModificado 
     * @return
     */
    @Override
    public boolean modificar(Registro registroModificado) {
        // TODO implement here
        Asesoria a = (Asesoria) registroModificado;
        
        if(a == null){
            return false;
        }
        
        String id = a.getId();
        try{
            //Conectar a la bd
            Connection conBD = Conexion.conectarBD();
            String q = "UPDATE asesorias SET idUsuario = ?, idMateria = ?, costo = ? WHERE id = ?";
            PreparedStatement ps = conBD.prepareStatement(q);
            
            try{
                //preparacion de las variables
                ps.setString(1, a.getIdUsuario());
                ps.setByte(2, a.getIdMateria());
                ps.setString(3, a.getCosto());
                ps.setString(4, id);
                
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
        return false;
    }

}