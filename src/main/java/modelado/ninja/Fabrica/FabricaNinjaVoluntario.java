package modelado.ninja.Fabrica;

import modelado.ninja.enumeraciones.Clan;
import modelado.ninja.enumeraciones.RangoNinja;
import modelado.ninja.producto.Ninja;
import modelado.ninja.producto.NinjaVoluntario;

/**
 * Clase que simula una fabrica que generá objetos de tipo {@link NInjaVoluntario}.
 * FabricaNinjaVoluntario solo creará exclusivamente objetos Ninja Voluntario que 
 * tengan experiencia de 4-6 y que por tanto, tendrán algún rango Ninja.
 * 
 * La clase implementa de la clase padre {@link FabricaNinjas}.
 */
public class FabricaNinjaVoluntario implements FabricaNinjas{

    @Override public Ninja crearNinja(String nombre,
                                      int edad,
                                      Clan clan,
                                      int nivel,
                                      RangoNinja rango) {
        if (nivel < 4 || nivel > 6 || rango == RangoNinja.SIN_RANGO) {
            throw new IllegalArgumentException(
                "Datos inválidos para Voluntario: Debe tener nivel entre 4 y 6 y un rango válido (Genin, Chunin, Jonin)."
            );
        }
        return new NinjaVoluntario(nombre, edad, clan, rango, nivel);
    }
}
