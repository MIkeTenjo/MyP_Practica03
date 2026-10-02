package modelado.iterador;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.NoSuchElementException;

import modelado.ninja.producto.Ninja;

public class IteradorNinjasAspirantes implements Iterator<Ninja>{

    private Enumeration<Ninja> aspirantes;

    public IteradorNinjasAspirantes(Hashtable<Integer, Ninja> aspirantes) {
        // Obtenemos directamente la enumeración de los VALORES (objetos Ninja)
        this.aspirantes = aspirantes.elements();
    }

    @Override
    public boolean hasNext() {
        return aspirantes.hasMoreElements();
    }

    @Override
    public Ninja next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No hay más aspirantes disponibles.");
        }
        return aspirantes.nextElement();
    }
}
