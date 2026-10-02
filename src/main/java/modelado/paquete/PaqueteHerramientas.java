package modelado.paquete;

import java.util.ArrayList;

import modelado.herramienta.Herramienta;

/**
 * Clase que simula el paquete de herramientas que llevarán los grupos de Ninjas en la selección
 * de la Academia.
 * PaqueteHerramientas tendrá un número de herramientas distribuidos entre: Kunais, Shurikens, Papeles Bomba,
 * Bombas de Humo y Botiquines, por lo cuál, tendrá un peso representativo de la carga de cada Herramienta.
 */
public class PaqueteHerramientas {

    private int numKunais;

    private int numShurikens;

    private int numPapelesBomba;

    private int numBombasDeHumo;
    
    private int numBotiquines;

    private ArrayList<Herramienta> herramientas;

    /**
     * Constructor por defecto.
     */
    public PaqueteHerramientas(){
        herramientas = new ArrayList<>();
        numKunais = 0;
        numShurikens = 0;
        numPapelesBomba = 0;
        numBombasDeHumo = 0;
        numBotiquines = 0;
    }

    /**
     * Agrega un número de Herramientas Kunai al paquete igual al
     * número establecido como argumento.
     * @param numKunais La cantidad de Kunais a agregar al paquete.
     */
    public void agregarKunais(int numKunais) {
        agregaPor(numKunais, new Herramienta("Kunai", 150));
        this.numKunais = numKunais;
    }

    /**
     * Agrega un número de Herramientas Shurikens al paquete igual al 
     * número establecido como argumento.
     * @param numShurikens La cantidad de Shurikens a agregar al paquete.
     */
    public void agregarShurikens(int numShurikens) {
        agregaPor(numShurikens, new Herramienta("Shuriken", 60));
        this.numShurikens = numShurikens;
    }

    /**
     * Agrega un número de Herramientas Papeles Bomba al paquete igual al número
     * establecido como argumento.
     * @param numPapelesBomba La cantidad de Shurikens a agregar al paquete.
     */
    public void agregarPapelesBomba(int numPapelesBomba) {
        agregaPor(numPapelesBomba, new Herramienta("Papel Bomba", 3));
        this.numPapelesBomba = numPapelesBomba;
    }

    /**
     * Agrega un número de Herramientas Bombas de Humo al paquete igual al
     * número establecido como argumento.
     * @param numBombasDeHumo La cantidad de Bombas de Humo a agregar al paquete.
     */
    public void agregarBombasDeHumo(int numBombasDeHumo){
        agregaPor(numBombasDeHumo, new Herramienta("Bomba de Humo", 60));
        this.numBombasDeHumo = numBombasDeHumo;
    }

    /**
     * Agrega un número de Herramientas Botiquines al paquete igual al número 
     * establecido como argumento.
     * @param numBotiquines La cantidad de Botiquines a agregar al paquete.
     */
    public void agregarBotiquines(int numBotiquines) {
        agregaPor(numBotiquines, new Herramienta("Botiquín", 450));
        this.numBotiquines = numBotiquines;
    }

    /**
     * Comportamiento privado solo para agregar un número especifico de Herramientas
     * al paquete.
     * @param cantidad La cantidad de veces que se agregará la Herramienta al paquete.
     * @param herramienta La Herramienta a agregar al paquete.
     */
    private void agregaPor(int cantidad, Herramienta herramienta){
        for(int i = 0; i < cantidad; i++){
            herramientas.add(herramienta);
        }
    }

    /**
     * Calcula el peso total de las herramientas sumadas del paquete.
     * @return EL peso total del paquete.
     */
    public double calcularPesoTotal() {
        int total = 0;
        for (Herramienta herramienta : herramientas) {
            total = total + herramienta.getPeso();
        }
        return total;
    }

}
