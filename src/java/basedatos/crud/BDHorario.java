package basedatos.crud;

import basedatos.conexion.Conexion;
import basedatos.entidades.Horario;
import basedatos.entidades.Registro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 */
public class BDHorario implements BD {

    /**
     * Default constructor
     */
    public BDHorario() {
    }

    /**
     * @param idAsesoria 
     * @return
     */
    public static Horario[] buscarIdAsesoria(String idAsesoria) {
        // TODO implement here
        ResultSet rs;
        Horario[] h = null;
        
        try{
            //Conectar a la bd
            Connection conBD = Conexion.conectarBD();
            String q = "SELECT * FROM horarios WHERE idAsesoria = ?";
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
                h = new Horario[i];
                
                for(int n = 0; n < i; n++){
                    if(rs.previous()){
                        h[n] = new Horario(rs.getString(1));
                        h[n].setIdAsesoria(rs.getString(2));
                        h[n].setHoraInicio(rs.getTime(3).getHours());
                        h[n].setMinutoInicio(rs.getTime(3).getMinutes());
                        h[n].setDias(rs.getString(4));
                        h[n].setDuracion(rs.getShort(5));
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
        return h;
    }

    /**
     * @param r 
     * @return
     */
    @Override
    public boolean registrar(Registro r) {
        // TODO implement here
        Horario h = (Horario)r;
        if(h==null){
            return false;
        }
        
        try{
            //Conectar a la bd
            Connection conBD = Conexion.conectarBD();
            String q = "INSERT INTO horarios (idAsesoria,horaInicio,dias,duracion) "
                    + "VALUES (?,?,?,?)";
            PreparedStatement ps = conBD.prepareStatement(q);
            
            try{
                //preparacion de las variables de 
                ps.setInt(1, Integer.getInteger(h.getIdAsesoria()));
                ps.setTime(2, new java.sql.Time(h.getHoraInicio(),h.getMinutoInicio(),0));
                ps.setString(3, h.getDias());
                ps.setByte(4, Byte.valueOf(String.valueOf(h.getDuracion())));
                
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
        Horario h = null;
        
        try{
            //Conectar a la bd
            Connection conBD = Conexion.conectarBD();
            String q = "SELECT * FROM horarios WHERE id = ?";
            PreparedStatement ps = conBD.prepareStatement(q);
            
            try{
                //preparacion de las variables de 
                ps.setString(1, id);
                
                rs = ps.executeQuery();
                
                if(rs.next()){
                    h = new Horario(rs.getString(1));
                    h.setIdAsesoria(rs.getString(2));
                    h.setHoraInicio(rs.getTime(3).getHours());
                    h.setMinutoInicio(rs.getTime(3).getMinutes());
                    h.setDias(rs.getString(4));
                    h.setDuracion(rs.getShort(5));
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
        return h;
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