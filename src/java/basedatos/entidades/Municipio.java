package basedatos.entidades;

/**
 * 
 */
public class Municipio extends Registro {

    /**
     * Default constructor
     */
    public Municipio() {
    }

    public Municipio(String id) {
        super(id);
    }
    /**
     * 
     */
    private String nombre;
    private String estado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}