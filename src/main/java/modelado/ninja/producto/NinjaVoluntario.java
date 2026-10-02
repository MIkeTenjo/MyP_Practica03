package modelado.ninja.producto;

import modelado.ninja.enumeraciones.Clan;
import modelado.ninja.enumeraciones.RangoNinja;

/**
 * Clase que representa un Ninja Voluntario a participar en las actividades
 * de la Academia.
 * NinjaVoluntario tiene atributos como nombre, edad, clan de procedencia, nivel actual
 * y además una propiedad exclusiva que es su Rango ya que este Ninja tiene experiencia.
 * 
 * La clase extiende de la clase abstracta {@link Ninja}.
 */
public class NinjaVoluntario extends Ninja{

    private final RangoNinja rango;

    /**
     * Método abstracto que utiliza el constructor de la clase
     * padre {@link Ninja} para inicializar un objeto de tipo NinjaVoluntario.
     * Además le da el atributo de Tipo de Ninja como Voluntario.
     * @param nombre El nombre del ninja.
     * @param edad La edad del Ninja.
     * @param clan El clan de procedencia del Ninja.
     * @param rango El rango del Ninja.
     * @param nivel EL nivel actual del Ninja.
     */
    public NinjaVoluntario(String nombre,
                           int edad, 
                           Clan  clan, 
                           RangoNinja rango, 
                           int nivel){

        super(nombre, edad, clan, nivel);
        this.rango = rango;
    }

    /**
     * Retorna el Rango del Ninja.
     * @return El rango del Ninja.
     */
    public RangoNinja getRangoNinja(){
        return rango;
    }

    @Override public String getDetalles(){
        String s = String.format("""
                                 Voluntario: %s 
                                 Edad     : %d 
                                 Clan     : %s
                                 Rango    : %s 
                                 NIvel    : %d 
                                 """,
                                  getNombre(),
                                  getEdad(),
                                  getClanDeProcedencia(),
                                  getRangoNinja(),
                                  getNivelHabilidad());
        return s;
    }
}
