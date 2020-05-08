package basedatos.crud;
import basedatos.entidades.Registro;

/**
 * 
 */
public interface BD {

    /**
     * @param r 
     * @return
     */
    public boolean registrar(Registro r);

    /**
     * @param id 
     * @return
     */
    public Registro buscarId(String id);

    /**
     * @param registroModificado 
     * @return
     */
    public boolean modificar(Registro registroModificado);

    /**
     * @param id 
     * @return
     */
    public boolean borrar(String id);

}