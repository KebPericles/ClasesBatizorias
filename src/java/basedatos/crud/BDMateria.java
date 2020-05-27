package basedatos.crud;

import basedatos.conexion.Conexion;
import basedatos.entidades.Asesoria;
import basedatos.entidades.Materia;
import basedatos.entidades.Municipio;
import basedatos.entidades.Registro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 */
public class BDMateria implements BD {

    /**
     * Default constructor
     */
    public BDMateria() {
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
        ResultSet rs;
        Materia m = null;
        
        try{
            //Conectar a la bd
            Connection conBD = Conexion.conectarBD();
            String q = "SELECT * FROM batizorias.materias WHERE id = ?";
            PreparedStatement ps = conBD.prepareStatement(q);
            
            try{
                //preparacion de las variables de 
                ps.setString(1, id);
                
                rs = ps.executeQuery();
                
                if(rs.next()){
                    m = new Materia(rs.getString(1));
                    m.setNombre(rs.getString(2));
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
    
    public static String nombreMateriaId(String idMateria){
        String nombre = null;
        ResultSet rs = null;
        
        try{
            //Conectar a la bd
            Connection conBD = Conexion.conectarBD();
            String q = "SELECT * FROM batizorias.materias WHERE id = ?";
            PreparedStatement ps = conBD.prepareStatement(q);
            
            try{
                //preparacion de las variables de 
                ps.setString(1, idMateria);
                
                rs = ps.executeQuery();
                
                if(rs.next()){
                    nombre = rs.getString(2);
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
        
        return nombre;
    }

    public static Materia[] todasMaterias(){
        Materia[] m = null;
        ResultSet rs;
        
        try{
            //Conectar a la bd
            Connection conBD = Conexion.conectarBD();
            String q = "SELECT * FROM batizorias.materias";
            PreparedStatement ps = conBD.prepareStatement(q);
            
            try{
                
                rs = ps.executeQuery();
                
                //Aqui cambia porque puede haber varias asesorias de un mismo usuario
                int i = 0;
                //Descubrimos la longitud de la consulta
                while(rs.next()){
                    i++;
                }
                //Instanciamos el aarray con la longitud que hay
                m = new Materia[i];
                //Instanciamos cada objeto
                for(int n = 0; n < i; n++){
                    if(rs.previous()){
                        m[n] = new Materia(rs.getString(1));
                        m[n].setNombre(rs.getString(2));
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
        return m;
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