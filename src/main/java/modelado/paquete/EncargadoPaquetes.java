package modelado.paquete;
/**
 * Clase que representa un Encargado de Paquetes, el cual tiene la responsabilidad de construir diferentes tipos de paquetes Ninja
 * utilizando el patrón de diseño Builder. El EncargadoPaquetes proporciona métodos para construir paquetes
 * básicos, avanzados, tácticos y personalizados, agregando las herramientas necesarias a cada paquete según el tipo de construcción.
 * EncargadoPaquetes utiliza la interfaz {@link PaqueteConstructor} para interactuar con los constructores de paquetes y obtener
 *  el resultado final del paquete construido.
 */
public class EncargadoPaquetes {

    /**
     * Construye un paquete básico de herramientas Ninja, que incluye una cantidad
     * predeterminada de kunais, shurikens y botiquines.
     * @param paquete El constructor de paquetes que se utilizará para construir el paquete básico.
     */
    public void construirPaqueteBasico(PaqueteConstructor paquete) {
        paquete.reiniciar();
        paquete.agregarKunais(1);
        paquete.agregarShurikens(1);
        paquete.agregarBotiquines(1);
    }

    /**
     * Construye un paquete avanzado de herramientas Ninja, que incluye una cantidad
     * predeterminada de shurikens, papeles bomba, bombas de humo y botiquines.
     * @param paquete El constructor de paquetes que se utilizará para construir el paquete avanzado.
     */
    public void construirPaqueteAvanzado(PaqueteConstructor paquete) {
        paquete.reiniciar();
        paquete.agregarShurikens(2);
        paquete.agregarPapelesBomba(3);
        paquete.agregarBombasDeHumo(2);
        paquete.agregarBotiquines(2);
    }

    /**
     * Construye un paquete táctico de herramientas Ninja, que incluye una cantidad
     * predeterminada de kunais, shurikens, papeles bomba y bombas de humo.
     * @param paquete El constructor de paquetes que se utilizará para construir el paquete táctico.
     */
    public void construirPaqueteTactico(PaqueteConstructor paquete){
        paquete.reiniciar();
        paquete.agregarKunais(3);
        paquete.agregarShurikens(2);
        paquete.agregarPapelesBomba(4);
        paquete.agregarBombasDeHumo(2);
    }

    /**
     * Construye un paquete personalizado de herramientas Ninja, que permite al usuario especificar
     * la cantidad de cada tipo de herramienta que desea incluir en el paquete.
     * @param paquete El constructor de paquetes que se utilizará para construir el paquete personalizado.
     * @param numKunais La cantidad de kunais que se incluirán en el paquete.
     * @param numShurikens La cantidad de shurikens que se incluirán en el paquete.
     * @param numPapelesBomba La cantidad de papeles bomba que se incluirán en el paquete.
     * @param numBombasHumo La cantidad de bombas de humo que se incluirán en el paquete.
     * @param numBotiquines La cantidad de botiquines que se incluirán en el paquete.
     */
    public void construirPaquetePersonalizado(PaqueteConstructor paquete,
                                              int numKunais,
                                              int numShurikens,
                                              int numPapelesBomba,
                                              int numBombasHumo,
                                              int numBotiquines){
        paquete.reiniciar();
        paquete.agregarKunais(numKunais);
        paquete.agregarShurikens(numKunais);
        paquete.agregarPapelesBomba(numKunais);
        paquete.agregarBombasDeHumo(numKunais);
        paquete.agregarBotiquines(numKunais);
        
    }

}
