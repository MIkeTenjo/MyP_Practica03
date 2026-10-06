package modelado.ninja.colecciones;

import java.util.Iterator;

import modelado.ninja.producto.Ninja;

/**
 * Interfaz que representa una Colección de objertos {@link Ninja} 
 * y su comportamiento.
 * ColeccionNinjas puede tener el comportamiento de agregar, eliminar
 * y crear un Iterador que iteré sobre cada elemento Ninja de la
 * colección.
 * 
 * La clase extiende de la clase {@link Iterable} por lo que tiene que 
 * tener un comportamiento para retornar un iterador de acuerdo al tipo de
 * colección que se utiliza en el momento.
 * 
 */
public interface ColeccionNinjas extends Iterable<Ninja>{

    /**
     * Agrega un elemento {@link Ninja} a la colección.
     * @param ninja EL Ninja a agregar a la colección.
     */
    public void agregar(Ninja ninja);

    /**
     * ELimina un elemento {@link Ninja} de la colección.
     * @param ninja El Ninja a agregar a la colección.
     */
    public void elimina(Ninja ninja);

    /**
     * Retorna un valor booleano que nos dice si la colección está
     * vacía.
     * @return True si la colección está vacía. False en otro caso.
     */
    public boolean estaVacia();

    /**
     * Retorna un valor que representa el tamaño de elementos
     * Ninja que contiene la colección.
     * @return un valor entero que represente el tamaño de objetos
     * que contiene la colección.
     */
    public int getTamano();

    /**
     * Limpia la colección para no tener elementos.
     */
    public void limpia();
    
    /**    (non-Javadoc)
     * Regresa un elemento {@link Iterator} de tipo {@link Ninja}.
     * @see java.lang.Iterable#iterator()
     */
    @Override public Iterator<Ninja> iterator();
}
