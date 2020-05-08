package basedatos.crud;

import basedatos.conexion.Conexion;
import basedatos.entidades.Horario;
import basedatos.entidades.Registro;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public static Horario buscarIdAsesoria(String idAsesoria) {
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