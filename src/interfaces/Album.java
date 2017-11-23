
package interfaces;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


class Album implements InterfazNombre{
    private Banda bandaAlbum;
    private Persona personaAlbum;
    private Cancion cancionAlbum;
    private String nombre; 
    private Date fecha_lanzamiento;
    private String genero;
    private String lanzamiento;
    SimpleDateFormat lan = new SimpleDateFormat("dd-MM-yyyy");
    public Album (Banda bandaAlbum, Persona personaAlbum, Cancion cancionAlbum,
            String nombre, String lanzamiento, String genero){
        
        try {
            this.bandaAlbum = bandaAlbum;
            this.cancionAlbum = cancionAlbum;
            this.personaAlbum = personaAlbum;
            this.nombre = nombre;
            this.fecha_lanzamiento = lan.parse(lanzamiento);
            this.genero = genero;
        } catch (ParseException ex) {
            Logger.getLogger(Album.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public Banda getBandaAlbum() {
        return bandaAlbum;
    }

    public void setBandaAlbum(Banda bandaAlbum) {
        this.bandaAlbum = bandaAlbum;
    }

    public Persona getPersonaAlbum() {
        return personaAlbum;
    }

    public void setPersonaAlbum(Persona personaAlbum) {
        this.personaAlbum = personaAlbum;
    }

    public Cancion getCancionAlbum() {
        return cancionAlbum;
    }

    public void setCancionAlbum(Cancion cancionAlbum) {
        this.cancionAlbum = cancionAlbum;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_lanzamiento() {
        return fecha_lanzamiento;
    }

    public void setFecha_lanzamiento(Date fecha_lanzamiento) {
        this.fecha_lanzamiento = fecha_lanzamiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public SimpleDateFormat getLan() {
        return lan;
    }

    public void setLan(SimpleDateFormat lan) {
        this.lan = lan;
    }
    

    @Override
    public String completo() {
        return nombre;
    }
    
}
