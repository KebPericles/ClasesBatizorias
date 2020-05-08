package basedatos.entidades;

/**
 * 
 */
public class PermisoMateria extends Registro {

    /**
     * Default constructor
     */
    public PermisoMateria() {
    }

    public PermisoMateria(String id) {
        super(id);
    }

    /**
     * 
     */
    private String idMateria;
    private String idUsuario;

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}