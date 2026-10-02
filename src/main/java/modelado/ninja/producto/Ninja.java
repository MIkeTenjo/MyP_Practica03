package modelado.ninja.producto;

import modelado.ninja.enumeraciones.Clan;
import modelado.ninja.enumeraciones.TipoNinja;

/**
 * Clase abstracta que simula un objeto Ninja que representará a los Ninjas
 * de la Academia y de los nuevos que quieren inscribirse. 
 * Ninja tiene nombre, edad, un clan de procedencia y nivel de habilidad, además
 * cada Ninja sabe que tipo de Ninja son, si son voluntarios o aspirantes.
 */
public abstract class Ninja {

    /*Contador global de la Clase Ninja que nos dirá cuantos Ninjas ya han sido creados. */
    private static int contadorGlobalId = 0;

    /*Un identificador que tendrá cada Ninja */
    private final int id;

    private final String nombre;

    private final int edad;

    private final Clan  clanDeProcedencia;

    private final int nivelHabilidad;

    /*Aspirante o Voluntario */
    protected TipoNinja tipo;

    /**
     * Constructor que Genera un Ninja. Se usará para sobrecargar
     * el constructor en sus clases hijas.
     * @param nombre El nombre del Ninja.
     * @param edad La edad del Ninja.
     * @param clan El Clan de procedencia del Ninja.
     * @param nivel El nivel actual del Ninja.
     */
    public Ninja(String nombre, int edad, Clan clan, int nivel){
        this.id = contadorGlobalId++;
        this.nombre = nombre;
        this.edad = edad;
        this.clanDeProcedencia = clan;
        this.nivelHabilidad = nivel;
    }

    /**
     * Retorna el valor del identificador que tiene el Ninja.
     * @return El identificador del NInja.
     */
    public int getId(){
        return id;
    }

    /**
     * Retorna el nombre del Ninja.
     * @return EL nombre del Ninja.
     */
    public String getNombre(){
        return nombre;
    }
    
    /**
     * Retorna la edad del Ninja.
     * @return La edad del Ninja.
     */
    public int getEdad(){
        return edad;
    }

    /**
     * Retorna el Clan de procedencia del Ninja.
     * @return El clan de procedencia del Ninja.
     */
    public Clan getClanDeProcedencia(){
        return clanDeProcedencia;
    }

    /**
     * Retorna el nivel actual del Ninja.
     * @return EL nivel del Ninja.
     */
    public int getNivelHabilidad(){
        return nivelHabilidad;
    }

    /**
     * Retorna el tipo de Ninja que es en las actividades
     * de la Academia.
     * @return El tipo del Ninja.
     */
    public TipoNinja getTipoNinja(){
        return tipo;
    }

    /**
     * Método abstracto que retorna los detalles de cada
     * Ninja según su Tipo.
     * @return Los detalles del Ninja representadas en una cadena.
     */
    public abstract String getDetalles();

}
