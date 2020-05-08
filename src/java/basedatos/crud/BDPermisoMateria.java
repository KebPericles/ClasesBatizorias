package basedatos.crud;

import basedatos.entidades.PermisoMateria;
import basedatos.entidades.Registro;

/**
 * 
 */
public class BDPermisoMateria implements BD {

    /**
     * Default constructor
     */
    public BDPermisoMateria() {
    }

    /**
     * @param idUsuario 
     * @return
     */
    public static PermisoMateria buscarIdUsuario(String idUsuario) {
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