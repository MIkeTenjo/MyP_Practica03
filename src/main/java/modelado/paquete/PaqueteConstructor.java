package modelado.paquete;

/**
 * Clase que representa la clase Builder en la creación de paquetes Ninja
 * utilizando el patrón de diseño Builder.
 * PaqueteBuilder tiene el comportamiento de agregar las herramientas 
 * necesarias al paquete, reiniciar sus valores para cada paquete nuevo
 * que se creará y entregar el paquete producido.
 */
public interface PaqueteConstructor {

    /**
     * Reinicia los valores del paquete vacío.
     */
    public void reset();

    /**
     * Agrega una Herramienta Kunai tantas veces como la
     * cantidad establecida como argumento.
     * @param cantidad La cantidad de Kunais a agregar al paquete.
     */
    public void agregarKunais(int cantidad);

    /**
     * Agrega una Herramienta Shuriken tantas veces como la
     * cantidad establecida como argumento.
     * @param cantidad La cantidad de Shurikens a agregar al paquete.
     */
    public void agregarShurikens(int cantidad);

    /**
     * Agrega una Herramienta Papel Bomba tantas veces como la 
     * cantidad establecida como argumento.
     * @param cantidad La cantidad de Papel Bomba a agregar al paquete.
     */
    public void agregarPapelesBomba(int cantidad);

    /**
     * Agrega una Herramienta Boma de Humo tantas veces como la 
     * cantidad establecida como argumento.
     * @param cantidad La cantidad de Bombas de Humo a agregar al paquete.
     */
    public void agregarBombasDeHumo(int cantidad);

    /**
     * Agrega una Herramienta Botiquín tantas veces como la cantidad
     * establecida como argumento.
     * @param cantidad La cantidad de Botiquines a agregar al paquete.
     */
    public void agregarBotiquines(int cantidad);

    /**
     * Obtiene el paquete final lleno de Herramientas establecidas
     * anteriormente y reinicia los parametros de la fabricación 
     * para uno nuevo.
     * @return EL paquete especifico construido.
     */
    public PaqueteHerramientas obtenerResultado();

}
