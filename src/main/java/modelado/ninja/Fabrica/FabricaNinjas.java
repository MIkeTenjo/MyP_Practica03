package modelado.ninja.Fabrica;

import modelado.ninja.enumeraciones.Clan;
import modelado.ninja.enumeraciones.RangoNinja;
import modelado.ninja.producto.Ninja;

/**
 * Clase interfaz que simula la fabrica que generá objetos de tipo {@link Ninja}.
 * FabricaNinjas solo tiene un método para crear Ninjas.
 */
public interface  FabricaNinjas {

    /**
     * Método que crea un objeto de Tipo {@link Ninja}.
     * @param nombre EL nombre a dar al Ninja.
     * @param edad La edad a dar al Ninja.
     * @param clan El clan de procedencia a dar al Ninja.
     * @param nivel El nivel a dar al Ninja.
     * @param rango EL rango que tendrá el Ninja.
     * @return Un objeto Ninja con los atributos declarados.
     */
    public abstract  Ninja crearNinja(String nombre,
                            int edad,
                            Clan clan,
                            int nivel,
                            RangoNinja rango);

}
