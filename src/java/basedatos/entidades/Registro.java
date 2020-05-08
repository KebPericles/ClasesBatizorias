package basedatos.entidades;

/**
 * 
 */
public abstract class Registro {

    /**
     * Default constructor
     */
    public Registro() {
    }

    public Registro(String id) {
        this.id = id;
    }

    /**
     * 
     */
    private String id;

    /**
     * @return
     */
    public String getId() {
        // TODO implement here
        return id;
    }

}