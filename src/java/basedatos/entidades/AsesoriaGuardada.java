package basedatos.entidades;

/**
 * 
 */
public class AsesoriaGuardada extends Registro {

    /**
     * Default constructor
     */
    public AsesoriaGuardada() {
    }

    public AsesoriaGuardada(String id) {
        super(id);
    }

    private String idUsuario;
    private String idAsesoria;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdAsesoria() {
        return idAsesoria;
    }

    public void setIdAsesoria(String idAsesoria) {
        this.idAsesoria = idAsesoria;
    }
    
}