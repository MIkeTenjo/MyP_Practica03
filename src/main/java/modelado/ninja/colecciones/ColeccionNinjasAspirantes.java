package modelado.ninja.colecciones;

import java.util.Hashtable;
import java.util.Iterator;

import modelado.ninja.colecciones.iterador.IteradorNinjasAspirantes;
import modelado.ninja.producto.Ninja;

/**
 * Clase que representa la colección de elementos {@link NInjaAspirante}.
 * La clase utiliza una colección {@link HashTable} para guardar los objetos
 * NInjaAspirante.
 * ColeccionNinjasAspirantes tendrá el comportamiento de agregar, eliminar NInjas de la
 * colección, decirnos si está vacía y el tamaño de la colección. Así mismo
 * nos va a generar un iterador para poder iterar sobre los elementos de la HashTable.
 */
public class ColeccionNinjasAspirantes implements  ColeccionNinjas{

    /*La colección donde se guardaran los Ninjas. */
    private final Hashtable<Integer, Ninja> ninjas;

    public ColeccionNinjasAspirantes(){
        this.ninjas = new Hashtable<>();
    }

    @Override
    public void agregar(Ninja ninja) {
        ninjas.put(ninja.getId(), ninja);
    }

    @Override
    public void elimina(Ninja ninja) {
        ninjas.remove(ninja.getId());
    }

    @Override
    public boolean estaVacia() {
        return ninjas.isEmpty();
    }

    @Override
    public int getTamano() {
        return ninjas.size();
    }

    @Override public void limpia(){
        ninjas.clear();
    }

    @Override
    public Iterator<Ninja> iterator() {
        return new IteradorNinjasAspirantes(ninjas);
    }

    
}
