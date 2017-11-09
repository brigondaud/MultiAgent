package automata.schelling;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class SchellingSet<T> extends AbstractSet<T> implements Set<T> {

    private List<T> list = new ArrayList<>();
    private Map<T, Integer> indexMap = new HashMap<>();
    
    @Override
    public boolean add(T t) {
        if (contains(t))
            return false;
        
        indexMap.put(t, list.size());
        list.add(t);
        return true;
    }
    
    @Override
    public boolean remove(Object o) {
        Integer indexBoxed = indexMap.remove((T) o);
        if (indexBoxed == null)
            return false;
        
        int index = indexBoxed;
        int last = list.size() - 1;
        
        T element = list.remove(last);
        if (index != last) {
            indexMap.put(element, index);
            list.set(index, element);
        }
        
        return true;
    }
    
    public T removeRandom() {
        if (list.isEmpty())
            return null;
        
        T element = list.get((int)(Math.random() * size()));
        remove(element);
        
        return element;
    }
    
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
