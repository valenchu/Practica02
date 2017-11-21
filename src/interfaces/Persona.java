package interfaces;

import static com.sun.media.jfxmediaimpl.MediaUtils.error;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.format.*;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class Persona implements InterfazNombre {

    private String nombre;
    private String apellido;
    private Date fecha_nacimiento;
    private String fe;
    private String rol;
    private Pelicula pelicula1;
//Constructor

    public Persona(String nombre, String apellido, String fe, String rol, Pelicula pelicula1) {
        //utilizo date format para formatiar el formato a date
        SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
        this.nombre = nombre;
        this.pelicula1 = pelicula1;
        this.apellido = apellido;
        try {
            //aplico fecha.parse(fe); para pasar la fecha del estilo
            //String al estilo Date pedido 
            this.fecha_nacimiento = fecha.parse(fe);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "La fecha se ingreso mal verifique", "Eror", JOptionPane.ERROR);
        }
        this.rol = rol;
    }
//geters y setters

    public Pelicula getPelicula1() {
        return pelicula1;
    }

    public void setPelicula1(Pelicula pelicula1) {
        this.pelicula1 = pelicula1;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha_nacimiento() {

        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String completo() {

        return nombre + " " + apellido;
    }

    public String obtenerEdad() {
        int años;
        //Paso el formato en que quiero la fecha
        SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yyyy");
        //uso el formato fecha y format para transformar date en String
        String nacimiento = fecha.format(fecha_nacimiento);
        //Paso el string a array y le paso la division de numeros con split
        //para dividir la fecha en 3 secciones
        String[] nacAray = nacimiento.split("-");
        //paso dia a int
        int dia = Integer.valueOf(nacAray[0]);
        //paso mes a int y le resto uno ya que calendar toma meses desde
        //0 y no desde 1 tonces así diciembre es 12 y no 11
        int mes = Integer.valueOf(nacAray[1]) - 1;
        //paso año
        int anno = Integer.valueOf(nacAray[2]);
        //genero variable actual que me dara los días mes y años actuales
        Calendar actual = Calendar.getInstance();
        //resto dia de cumple al dia actual
        dia = (dia) - (actual.get(Calendar.DATE));
        //resto mes de cumple a mes actual
        mes = (mes) - (actual.get(Calendar.MONTH));
        //resto año de cumple a año actual
        anno = (anno) - (actual.get(Calendar.YEAR));

        //creo una mini verificacion por si se pasa día o mes no sume año
        if (dia < 0 || mes < 0) {
            años = anno--;
        } else {
            años = anno;
        }
        //declaro los años finales de la persona uso math.abs para sacar
        //valor absoluto de años ya que me da negativa la edad 
        String edad = Integer.toString(Math.abs(años));
        return edad;
    }
}
