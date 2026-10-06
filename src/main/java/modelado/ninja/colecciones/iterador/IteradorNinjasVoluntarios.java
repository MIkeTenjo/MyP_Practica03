package modelado.ninja.colecciones.iterador;

import java.util.Iterator;
import java.util.NoSuchElementException;

import modelado.ninja.producto.Ninja;

/**
 * Clase que implementa un iterador para recorrer una colección de Ninja voluntarios.
 * IteradorNinjasVoluntarios implementa la interfaz Iterator<Ninja> y permite iterar sobre
 * los objetos Ninja almacenados en un arreglo.
 */
public class IteradorNinjasVoluntarios implements Iterator<Ninja> {

    private final Ninja[] voluntarios;

    private int posicion;

    public IteradorNinjasVoluntarios(Ninja[] voluntarios){
        this.voluntarios = voluntarios;
        this.posicion = 0;
    }

    @Override
    public boolean hasNext() {
        return posicion < voluntarios.length && voluntarios[posicion] != null;
    }

    @Override
    public Ninja next() {
        if(!hasNext()){
            throw new NoSuchElementException("NO hay más voluntarios disponibles");
        }
        return voluntarios[posicion++];
    }

}
