package interfaces;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Banda implements InterfazNombre {

    private Persona personaBanda;
    private String nombre;
    private Date fecha_formacion;
    private Date fecha_separacion;
    private Album albumBanda;
    private String formacion;
    private String separacion;

    public Banda(Persona personaBanda, String nombre, String formacion,
            String separacion, Album albumBanda) {
        try {
            SimpleDateFormat forma = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat separa = new SimpleDateFormat("dd-MM-yyyy");
            this.personaBanda = personaBanda;
            this.nombre = nombre;
            this.fecha_formacion = forma.parse(formacion);
            this.fecha_separacion = separa.parse(separacion);
            this.albumBanda = albumBanda;
        } catch (ParseException ex) {
            Logger.getLogger(Banda.class.getName()).log(Level.SEVERE, "Mal ingreso fecha", ex);
        }
    }

    public Persona getPersonaBanda() {
        return personaBanda;
    }

    public void setPersonaBanda(Persona personaBanda) {
        this.personaBanda = personaBanda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_formacion() {
        return fecha_formacion;
    }

    public void setFecha_formacion(Date fecha_formacion) {
        this.fecha_formacion = fecha_formacion;
    }

    public Date getFecha_separacion() {
        return fecha_separacion;
    }

    public void setFecha_separacion(Date fecha_separacion) {
        this.fecha_separacion = fecha_separacion;
    }

    public Album getAlbumBanda() {
        return albumBanda;
    }

    public void setAlbumBanda(Album albumBanda) {
        this.albumBanda = albumBanda;
    }

    //modificacion de metodos 
    public String aniosActiva() {
       /* int totalAnos;
        SimpleDateFormat forma = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat separa = new SimpleDateFormat("dd-MM-yyyy");
        String union = forma.format(fecha_formacion);
        String sepa = separa.format(fecha_separacion);
        String[] u = union.split("-");
        String[] s = sepa.split("-");
        int diaU = Integer.valueOf(u[0]);
        int diaS = Integer.valueOf(s[0]);

        int mesU = Integer.valueOf(u[1]) - 1;
        int mesS = Integer.valueOf(s[1]) - 1;

        int anoU = Integer.valueOf(u[2]);
        int anoS = Integer.valueOf(s[2]);
        //Verifico annos
        totalAnos = (anoS - anoU);
        if ((diaS - diaU < 0) || (mesS - mesU < 0) || (diaS - diaU < 0 && 
                mesS - mesU < 0)) {
            totalAnos--;

        }
               
        String anosTotalesBanda = Integer.toString(totalAnos);
               */
        //Calculo diferencia entre dos fechas de forma sencilla ! 
        long diferencia = fecha_separacion.getTime() - fecha_formacion.getTime();
        long dias = diferencia / (1000*60*60*24); 
        int d = (int) (dias /365);
        String anosTotalesBanda = Integer.toString(d);
        return anosTotalesBanda;
    }

    @Override
    public String completo() {
        return nombre;
    }

}
