package interfaces;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pelicula implements InterfazNombre {

    private String nombre;
    private int duracion;
    private Date fecha_estreno;
    private String genero;
    private Persona persona;
    private String estreno;

    public Pelicula(String nombre, int duracion, String estreno, String genero, Persona persona) {
        try {
            SimpleDateFormat est = new SimpleDateFormat("dd-MM-yyyy");
            this.nombre = nombre;
            this.duracion = duracion;
            this.fecha_estreno = est.parse(estreno);
            this.genero = genero;
            this.persona = persona;
        } catch (ParseException ex) {
            Logger.getLogger(Pelicula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Date getFecha_estreno() {
        return fecha_estreno;
    }

    public void setFecha_estreno(Date fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Pelicula pelicula1) {
        this.persona = persona;
    }

    @Override
    public String completo() {
        return nombre;
    }

}
