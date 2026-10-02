package modelado.iterador;

import java.util.Iterator;
import java.util.NoSuchElementException;

import modelado.ninja.producto.Ninja;

public class IteradorNinjasVoluntarios implements Iterator<Ninja> {

    private Ninja[] voluntarios;

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
