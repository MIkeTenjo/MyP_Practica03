package modelado.paquete;

public class EncargadoPaquetes {

    public void construirPaqueteBasico(PaqueteConstructor paquete) {
        paquete.reset();
        paquete.agregarKunais(1);
        paquete.agregarShurikens(1);
        paquete.agregarBotiquines(1);
    }

    public void construirPaqueteAvanzado(PaqueteConstructor paquete) {
        paquete.reset();
        paquete.agregarShurikens(2);
        paquete.agregarPapelesBomba(3);
        paquete.agregarBombasDeHumo(2);
        paquete.agregarBotiquines(2);
    }

    public void construirPaqueteTactico(PaqueteConstructor paquete){
        paquete.reset();
        paquete.agregarKunais(3);
        paquete.agregarShurikens(2);
        paquete.agregarPapelesBomba(4);
        paquete.agregarBombasDeHumo(2);
    }

    public void construirPaquetePersonalizado(PaqueteConstructor paquete,
                                              int numKunais,
                                              int numShurikens,
                                              int numPapelesBomba,
                                              int numBombasHumo,
                                              int numBotiquines){
        paquete.reset();
        paquete.agregarKunais(numKunais);
        paquete.agregarShurikens(numKunais);
        paquete.agregarPapelesBomba(numKunais);
        paquete.agregarBombasDeHumo(numKunais);
        paquete.agregarBotiquines(numKunais);
        
    }

}
