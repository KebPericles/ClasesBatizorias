package basedatos.entidades;

import java.util.Date;

/**
 * 
 */
public class Usuario extends Registro {

    /**
     * Default constructor
     */
    public Usuario() {
    }

    public Usuario(String id) {
        super(id);
    }

    /**
     * 
     */
    private String nick = null;
    private String clave = null;
    private byte tipoUsuario = 0;
    private String correo = null;
    private String nombre = null;
    private String apPat = null;
    private String apMat= null;
    private Date fNac= null;
    private String idMunicipio= null;
    private char genero = ' ';
    private byte semestre= 0;
    private boolean telefono = false;
    private boolean correoVisible = false;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public byte getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(byte tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPat() {
        return apPat;
    }

    public void setApPat(String apPat) {
        this.apPat = apPat;
    }

    public String getApMat() {
        return apMat;
    }

    public void setApMat(String apMat) {
        this.apMat = apMat;
    }

    public Date getfNac() {
        return fNac;
    }

    public void setfNac(Date fNac) {
        this.fNac = fNac;
    }

    public String getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(String idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public byte getSemestre() {
        return semestre;
    }

    public void setSemestre(byte semestre) {
        this.semestre = semestre;
    }

    public boolean isTelefono() {
        return telefono;
    }

    public void setTelefono(boolean telefono) {
        this.telefono = telefono;
    }

    public boolean isCorreoVisible() {
        return correoVisible;
    }

    public void setCorreoVisible(boolean correoVisible) {
        this.correoVisible = correoVisible;
    }

}