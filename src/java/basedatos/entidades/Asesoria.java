package basedatos.entidades;

/**
 * 
 */
public class Asesoria extends Registro {

    /**
     * Default constructor
     */
    public Asesoria() {}

    public Asesoria(String id) {
        super(id);
    }

    private String idUsuario;
    private byte idMateria;
    private String costo;

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public byte getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(byte idMateria) {
        this.idMateria = idMateria;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

}