package interfaces;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Interfaces {

    public static void main(String[] args) {
        Persona p = new Persona("Valentin", "Cassino", "29-08-1992", "Cantante", null);
        System.out.println(p.obtenerEdad());

        Pelicula peli = new Pelicula("Anabelle", 2, "08-09-2019", "Terror", p);
        System.out.println(peli.completo());

        Banda ban = new Banda(p, "Electrica", "29-05-1932", "25-04-2002", null);
        System.out.println("La banda "+ban.completo()+" tiene "+
                ban.aniosActiva()+" años de funcionamiento");
            
    }

}
