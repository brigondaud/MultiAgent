package automata.schelling;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Represents a set designed for the Schelling simulation.
 * This set is based on Java util's Collections.
 * 
 * It performs the following operations:
 * - Add in O(1) ;
 * - Remove in O(1) ;
 * - Remove random in O(1) ;
 * 
 * @author Team 22 in Teide
 * @param <T> The class of the content of this set (here, SchellingCell).
 */
public class SchellingSet<T> extends AbstractSet<T> implements Set<T> {

    /**
     * The list for fast random access.
     */
    private List<T> list = new ArrayList<>();
    
    /**
     * The map for fast addition and remove operations.
     */
    private Map<T, Integer> indexMap = new HashMap<>();

    @Override
    public boolean add(T t) {
        if (contains(t)) {
            return false;
        }

        indexMap.put(t, list.size());
        list.add(t);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Integer indexBoxed = indexMap.remove(o);
        if (indexBoxed == null) {
            return false;
        }

        int index = indexBoxed;
        int last = list.size() - 1;

        T element = list.remove(last);
        if (index != last) {
            indexMap.put(element, index);
            list.set(index, element);
        }

        return true;
    }

    /**
     * Remove a random element from the set.
     * 
     * @see SchellingSet#remove
     * @return null if the set is empty
     */
    public T removeRandom() {
        if (list.isEmpty()) {
            return null;
        }

        T element = list.get((int) (Math.random() * size()));
        remove(element);

        return element;
    }

    /**
     * Remove all elements from the set.
     * 
     * @see SchellingSet#remove
     */
    public void removeAll() {
        list = new ArrayList<>();
        indexMap = new HashMap<>();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public boolean contains(Object o) {
        return indexMap.containsKey((T) o);
    }

    @Override
    public int size() {
        return list.size();
    }
}
