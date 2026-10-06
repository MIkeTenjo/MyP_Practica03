package modelado.paquete.herramienta;

/**
 * Clase que simula una herramienta Ninja.
 * Herramienta tiene un peso el cuál importa en el momento
 * de crear paquetes.
 */
public class Herramienta {

    private final String nombre;

    /*Peso medido en gramos. */
    private final int peso;

    /**
     * Constructor que inicializa una Herramienta con nombre y peso
     * medido en gramos.
     * @param nombre El nombre de la herramienta.
     * @param peso El peso de la herramienta medido en gramos.
     */
    public Herramienta(String nombre, int peso){
        this.nombre = nombre;
        this.peso = peso;
    }

    /**
     * Retorna el nombre de la herramienta.
     * @return El nombre de la herramienta.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Retorna el peso de la herramienta medida en gramos.
     * @return El peso de la herramienta.
     */
    public int getPeso(){
        return peso;
    }

}
