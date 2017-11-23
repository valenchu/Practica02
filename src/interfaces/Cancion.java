
package interfaces;

import java.sql.Time;


class Cancion implements InterfazNombre{
    private Time duracion;
    private String nombre;
    
    public Cancion (Time duracion, String nombre){
        this.duracion = duracion;
        this.nombre = nombre;
        
    }

    public Time getDuracion() {
        return duracion;
    }

    public void setDuracion(Time duracion) {
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    @Override
    public String completo() {
        return nombre;
    }
    
}
