package basedatos.crud;

import basedatos.conexion.Conexion;
import basedatos.entidades.Registro;
import basedatos.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 */
public class BDUsuario implements BD {

    /**
     * Default constructor
     */
    public BDUsuario() {
    }

    /**
     * @param nick 
     * @return
     */
    public static Usuario buscarNick(String nick) {
        // TODO implement here
        return null;
    }

    /**
     * @param semestre 
     * @return
     */
    public static Usuario buscarSemestre(byte semestre) {
        // TODO implement here
        return null;
    }

    /**
     * @param idMunicipio 
     * @return
     */
    public static Usuario buscarIdMunicipio(String idMunicipio) {
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
        //
        Usuario u = (Usuario) r;
        
        try{
            Connection conBD = Conexion.conectarBD();
            String q = "INSERT INTO usuarios (nick, clave,tipoUsuario,correo,nombre,apPat,"
                    + "apMat,fNac,idMunicipio,genero,semestre,telefono, correoVisible) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?, ?, ?, ?)";
            //                 1 2 3 4 5 6 7 8 9 10 11 12 13
            PreparedStatement ps = conBD.prepareStatement(q);
            
            try{
                ps.setString(1, u.getNick());
                ps.setString(2, u.getClave());
                ps.setByte(3, u.getTipoUsuario());
                ps.setString(4, u.getCorreo());
                ps.setString(5, u.getNombre());
                ps.setString(6, u.getApPat());
                ps.setString(7, u.getApMat());
                ps.setDate(8, new java.sql.Date(u.getfNac().getTime()));
                ps.setShort(9, Short.valueOf(u.getIdMunicipio()));
                ps.setString(10, String.valueOf(u.getGenero()));
                ps.setByte(11,u.getSemestre());
                ps.setBoolean(12, u.isTelefono());
                ps.setBoolean(13, u.isCorreoVisible());
                
                ps.executeUpdate();
                
                ps.close();
                conBD.close();
                return true;
            }catch(NumberFormatException | SQLException es){
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
        Usuario u = null;
        
        try{
            //Conectar a la bd
            Connection conBD = Conexion.conectarBD();
            String q = "SELECT * FROM usuarios WHERE id = ?";
            PreparedStatement ps = conBD.prepareStatement(q);
            
            try{
                //preparacion de las variables de 
                ps.setString(1, id);
                
                rs = ps.executeQuery();
                
                if(rs.next()){
                    u = new Usuario(rs.getString(1));
                    u.setNick(rs.getString(2));
                    u.setClave(rs.getString(3));
                    u.setTipoUsuario(rs.getByte(4));
                    u.setCorreo(rs.getString(5));
                    u.setNombre(rs.getString(6));
                    u.setApPat(rs.getString(7));
                    u.setApMat(rs.getString(8));
                    u.setfNac(rs.getDate(9));
                    u.setIdMunicipio(rs.getString(10));
                    u.setGenero(rs.getString(11).charAt(0));
                    u.setSemestre(rs.getByte(12));
                    u.setTelefono(rs.getBoolean(13));
                    u.setCorreoVisible(rs.getBoolean(14));
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
        return u;
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