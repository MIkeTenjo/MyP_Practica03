package modelado.ninja.Fabrica;

import modelado.ninja.enumeraciones.Clan;
import modelado.ninja.enumeraciones.RangoNinja;
import modelado.ninja.producto.Ninja;
import modelado.ninja.producto.NinjaAspirante;

/**
 * Clase que fabrica Ninjas de tipo Aspirante.
 * FabricaNinjaAspirante tendrá la responsabilidad de generar exclusivamente Ninjas con un 
 * nivel de experiencia 1-3 y por tanto ningún Ninja que generé tendrá Rango de Ninja.
 * 
 * La clase implementa de la clase padre {@link FabricaNinjas}.
 */
public class FabricaNinjaAspirante implements FabricaNinjas{

    @Override public Ninja crearNinja(String nombre,
                                      int edad,
                                      Clan clan,
                                      int nivel,
                                      RangoNinja rango){

        if (nivel < 1 || nivel > 3 || rango != RangoNinja.SIN_RANGO) {
            throw new IllegalArgumentException(
                "Datos inválidos para Aspirante: Debe tener nivel entre 1 y 3 y no poseer rango."
            );
        }
        return new NinjaAspirante(nombre, edad, clan, nivel);
                                      }
}

