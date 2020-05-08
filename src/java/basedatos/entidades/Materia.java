package basedatos.entidades;

/**
 * 
 */
public class Materia extends Registro {

    /**
     * Default constructor
     */
    public Materia() {
    }

    public Materia(String id) {
        super(id);
    }

    /**
     * 
     */
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}