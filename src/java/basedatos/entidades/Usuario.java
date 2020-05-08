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
    private String nick;
    private String clave;
    private byte tipoUsuario;
    private String correo;
    private String nombre;
    private String apPat;
    private String apMat;
    private Date fNac;
    private String idMunicipio;
    private char genero;
    private byte semestre;
    private boolean telefono;
    private boolean correoVisible;

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