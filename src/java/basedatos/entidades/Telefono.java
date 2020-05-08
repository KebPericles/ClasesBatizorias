package basedatos.entidades;
/**
 * 
 */
public class Telefono extends Registro {

    /**
     * Default constructor
     */
    public Telefono() {
    }

    public Telefono(String id) {
        super(id);
    }

    /**
     * 
     */
    private String idUsuario;
    private String telefono;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}