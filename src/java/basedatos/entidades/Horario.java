package basedatos.entidades;
/**
 * 
 */
public class Horario extends Registro {

    /**
     * Default constructor
     */
    public Horario() {
    }

    public Horario(String id) {
        super(id);
    }

    /**
     * 
     */
    private String idAsesoria;
    private int horaInicio;
    private int minutoInicio;
    private String dias;
    private short duracion;

    public String getIdAsesoria() {
        return idAsesoria;
    }

    public void setIdAsesoria(String idAsesoria) {
        this.idAsesoria = idAsesoria;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHorarioInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public short getDuracion() {
        return duracion;
    }

    public void setDuracion(short duracion) {
        this.duracion = duracion;
    }

    public int getMinutoInicio() {
        return minutoInicio;
    }

    public void setMinutoInicio(int minutoInicio) {
        this.minutoInicio = minutoInicio;
    }
}