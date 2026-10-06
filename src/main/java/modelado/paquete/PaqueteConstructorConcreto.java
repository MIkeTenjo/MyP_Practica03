package modelado.paquete;
/**
 * Clase que representa un Paquete Constructor Concreto, el cual implementa la interfaz {@link PaqueteConstructor}.
 * Esta clase es responsable de construir un objeto de tipo {@link PaqueteHerramientas}
 * PaqueteConstructorConcreto proporciona métodos para agregar diferentes tipos de herramientas al paquete,
 * como kunais, shurikens, papeles bomba, bombas de humo y botiquines. Además, permite obtener el resultado
 * final del paquete construido y reiniciar el proceso de construcción.
 */
public final class PaqueteConstructorConcreto implements PaqueteConstructor{

    private PaqueteHerramientas paquete;

    public PaqueteConstructorConcreto() {
        this.reiniciar();
    }

    @Override public void reiniciar() {
        this.paquete = new PaqueteHerramientas();
    }

    @Override public void agregarKunais(int cantidad) {
        this.paquete.agregarKunais(cantidad);
    }

    @Override public void agregarShurikens(int cantidad) {
        this.paquete.agregarShurikens(cantidad);
    }

    @Override public void agregarPapelesBomba(int cantidad) {
        this.paquete.agregarPapelesBomba(cantidad);
    }

    @Override public void agregarBombasDeHumo(int cantidad){
        this.paquete.agregarBombasDeHumo(cantidad);
    }

    @Override public void agregarBotiquines(int cantidad) {
        this.paquete.agregarBotiquines(cantidad);
    }

    @Override public PaqueteHerramientas obtenerResultado() {
        PaqueteHerramientas resultado = this.paquete;
        this.reiniciar();
        return resultado;
    }
}
