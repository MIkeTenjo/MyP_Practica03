package modelado.paquete;

public final class PaqueteConstructorConcreto implements PaqueteConstructor{

    private PaqueteHerramientas paquete;

    public PaqueteConstructorConcreto() {
        this.reset();
    }

    @Override public void reset() {
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
        this.reset();
        return resultado;
    }
}
