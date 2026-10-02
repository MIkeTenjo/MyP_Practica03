package modelado.ninja.producto;

import modelado.ninja.enumeraciones.Clan;
import modelado.ninja.enumeraciones.TipoNinja;

/**
 * Clase que representa un tipo de Ninja Aspirante.
 * NinjaAspirante tiene atributos como nombre, edad, clan de 
 * procedencia y nivel actual, además que sabe que es un 
 * aspirante en las actividades de la Academia y que no cuenta
 * con un Rango de Ninja.
 * 
 * La clase extiende de la clase abstracta {@link Ninja}.
 */
public class NinjaAspirante extends Ninja{

    /**
     * Constructor que sobrecarga el constructor de la clase
     * {@link Ninja}, además que agrega el Tipo de NInja que 
     * es (Ninja Aspirante).
     * @param nombre El nombre del Ninja.
     * @param edad La edad del Ninja.
     * @param clan El clan de procedencia del Ninja.
     * @param nivel El nivel actual del Ninja.
     */
    public NinjaAspirante(String nombre, int edad, Clan clan, int nivel){
        super(nombre, edad, clan, nivel);
        this.tipo = TipoNinja.ASPIRANTE;
    }

    @Override public String getDetalles(){
        String s = String.format("""
                                 Aspirante: %s 
                                 Edad     : %d 
                                 Clan     : %s 
                                 NIvel    : %d 
                                 """,
                                  getNombre(),
                                  getEdad(),
                                  getClanDeProcedencia(),
                                  getNivelHabilidad());
        return s;
    }

}
