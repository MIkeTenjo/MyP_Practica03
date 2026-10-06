package modelado.ninja.colecciones.iterador;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.NoSuchElementException;

import modelado.ninja.producto.Ninja;

/**
 * Clase que implementa un iterador para recorrer una colección de aspirantes a Ninja.
 * IteradorNinjasAspirantes implementa la interfaz Iterator<Ninja> y permite iterar sobre
 * los objetos Ninja almacenados en un Hashtable.
 */
public class IteradorNinjasAspirantes implements Iterator<Ninja>{

    /*La enumeración es parte de la Hashtable que contiene los valores (objetos Ninja) */
    private final Enumeration<Ninja> aspirantes;

    public IteradorNinjasAspirantes(Hashtable<Integer, Ninja> aspirantes) {
        // Obtenemos directamente la enumeración de los VALORES (objetos Ninja)
        this.aspirantes = aspirantes.elements();
    }

    @Override
    public boolean hasNext() {
        // hasnext de Enumeration dado la Hashtable.
        return aspirantes.hasMoreElements();
    }

    @Override
    public Ninja next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No hay más aspirantes disponibles.");
        }
        // next de Enumeration dado la Hashtable.
        return aspirantes.nextElement();
    }
}
