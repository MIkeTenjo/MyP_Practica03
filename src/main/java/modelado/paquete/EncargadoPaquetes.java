package modelado.paquete;

public class EncargadoPaquetes {

    public void construirPaqueteBasico(PaqueteBuilder paquete) {
        paquete.reset();
        paquete.agregarKunais(3);
        paquete.agregarShurikens(5);
        paquete.agregarPapelesBomba(1);
        paquete.agregarBotiquines(0);
    }

    public void construirPaqueteAvanzado(PaqueteBuilder paquete) {
        paquete.reset();
        paquete.agregarKunais(8);
        paquete.agregarShurikens(12);
        paquete.agregarPapelesBomba(4);
        paquete.agregarBotiquines(2);
    }

}
