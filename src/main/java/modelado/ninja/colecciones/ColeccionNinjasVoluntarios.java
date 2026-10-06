package modelado.ninja.colecciones;

import java.util.Iterator;

import modelado.ninja.colecciones.iterador.IteradorNinjasVoluntarios;
import modelado.ninja.producto.Ninja;

/**
 * Clase que representa la colección de elementos {@link NinjaVoluntario}.
 * La clase utiliza un arreglo para coleccionar los elementos de tipo NinjaVoluntario.
 * ColeccionNInjasVoluntarios tendrá comportamientos para agregar, eliminar Ninjas, 
 * decirnos si está vacía o el tamaño de la colección. Así mismo, tendrá un iterador
 * el cuál nos ayudará para iterar sobre los elementos.
 */
public class ColeccionNinjasVoluntarios implements ColeccionNinjas{

    /*La colección en arreglo. */
    private Ninja[] ninjas;

    /*El identificador del i-esimo elemento. */
    private int i;

    public ColeccionNinjasVoluntarios(int n){
        this.ninjas = new Ninja[n];
        i = 0;
    }

    @Override
    public void agregar(Ninja ninja) {
        ninjas[i] = ninja;
        i++;
    }

    @Override
    public void elimina(Ninja ninja) {
        Ninja[] nuevoNinjas = new Ninja[i - 1];
        for (int idx = 0; idx < ninjas.length; idx++) {
            Ninja n = ninjas[idx];
            if(n.equals(ninja)){
                ninjas[idx] = null;
                i--;
                continue;
            }
            nuevoNinjas[idx] = n; 

        }
        ninjas = nuevoNinjas;
    }

    @Override
    public boolean estaVacia() {
        return i == 0;
    }

    @Override
    public int getTamano() {
        return i;
    }

    @Override public void limpia(){
        Ninja[] nuevoNinjas = new Ninja[i];
        ninjas = nuevoNinjas;
    }

    @Override
    public Iterator<Ninja> iterator() {
        return new IteradorNinjasVoluntarios(ninjas);
    }

}
