package modelado.ninja.gruponinja;

import modelado.ninja.colecciones.ColeccionNinjas;
import modelado.ninja.producto.Ninja;
import modelado.ninja.producto.NinjaVoluntario;
import modelado.paquete.PaqueteHerramientas;

/**
 * Clase que simula un grupo de Ninjas. 
 * Un grupo de Ninjas esta conformado de un Ninja de Rango junto a un conjunto de Ninjas 
 * sin rango aspirantes. El grupo también posee un paquete de herramientas ninja que 
 * ya fue asignado por un encargado de asignarlo al grupo.
 */
public class Grupo {

    private final NinjaVoluntario jefeGrupo;

    private final ColeccionNinjas aspirantes;

    private final PaqueteHerramientas paquete;

    /*Un contador global para saber el número del grupo global */
    private static int numGrupo;

    private final int idGrupo;

    /**
     * Constructor que asigna un Ninja Voluntario como jefe de grupo de la colección de
     * Ninjas Aspirantes junto a un Paquete de Herrramientas que fue asignado para el
     * grupo a conformar.
     * @param jefeGrupo El jefe de grupo del grupo.
     * @param aspirantes La colección de Ninjas aspirantes para conformar el grupo.
     * @param paquete El paquete asignado al grupo.
     */
    public Grupo(NinjaVoluntario jefeGrupo, ColeccionNinjas aspirantes, PaqueteHerramientas paquete){
        numGrupo++;
        this.idGrupo = numGrupo;
        this.jefeGrupo = jefeGrupo;
        this.aspirantes = aspirantes;
        this.paquete = paquete;
    }

    /**
     * Retorna el Ninja Asignado como Jefe de Grupo.
     * @return El NInja Jefe de Grupo
     */
    public NinjaVoluntario getJefeGrupo(){
        return jefeGrupo;
    }

    /**
     * Retorna la colección de Ninjas Aspirantes que conforma el grupo.
     * @return Los NInjas Aspirantes.
     */
    public ColeccionNinjas aspirantes(){
        return aspirantes;
    }

    /**
     * Retorna el Paquete de Herramientas asignado para el grupo de Ninjas.
     * @return El paquete de Herramientas del grupo Ninja.
     */
    public PaqueteHerramientas paquete(){
        return paquete;
    }

    /**
     * Calcula el total de niveles de habilidad del grupo Ninja, sumando el nivel del jefe de grupo
     * junto con el nivel de habilidad de cada uno de los aspirantes asignados al grupo.
     * @return El total de niveles de habilidad del grupo.
     */
    public int totalNiveles(){
        int total = 0;
        for (Ninja ninja : aspirantes) {
            total += ninja.getNivelHabilidad();
        }
        return jefeGrupo.getNivelHabilidad() + total;
    }

    /**
     * Genera una presentación del grupo Ninja, mostrando la información del jefe de grupo, los aspirantes asignados,
     * el paquete de herramientas asignado y el total de niveles de habilidad del grupo.
     * @return La representación en cadena del grupo.
     */
    public String presentación(){
        StringBuilder sb = new StringBuilder();
        String separador = "═".repeat(60);
        String lineaFina = "─".repeat(60);

        sb.append(separador).append("\n");
        sb.append(String.format("                ACADEMIA NINJA - GRUPO #%02d               \n", idGrupo));
        sb.append(separador).append("\n");
        
        sb.append("JEFE DE GRUPO (VOLUNTARIO):\n");
        sb.append(jefeGrupo.getDetalles()).append("\n");
        
        sb.append(lineaFina).append("\n");
        
        sb.append("ASPIRANTES ASIGNADOS:\n");
        int contador = 1;
        for (Ninja aspirante : aspirantes) {
            sb.append(aspirante.getDetalles()).append("\n");
        }
        
        sb.append(lineaFina).append("\n");

        sb.append("  EQUIPAMIENTO DEL GRUPO:\n");
        if (paquete != null) {
            sb.append(String.format("%s\n", paquete.getResumen()));
        } else {
            sb.append(" Sin paquete de herramientas asignado.\n");
        }
        
        sb.append(lineaFina).append("\n");
        sb.append(String.format("PODER TOTAL COMBINADO DEL GRUPO: %d pts\n", totalNiveles()));
        sb.append(separador).append("\n");

        return sb.toString();

    }

}
