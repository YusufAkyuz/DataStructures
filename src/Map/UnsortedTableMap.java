package Map;

import List2.ArrayList;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class UnsortedTableMap <K,V> extends AbstractMap<K,V>{
    private ArrayList<MapEntry<K,V>> table = new ArrayList<>();
    public UnsortedTableMap(){}

    private int findIndex(K key) {
        int n = table.size();
        for (int i = 0; i < n; i++) {
            if (table.get(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return table.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public V get(K key) {
        int j = findIndex(key);
        if (j == -1) {
            return null;
        }
        return table.get(j).getValue();
    }

    public V put(K key, V value) {
        int j = findIndex(key);
        if (j == -1) {
            table.add(size(),new MapEntry<>(key, value));
            return null;
        }else {
            return table.get(j).setValue(value);
        }
    }

    public V remove(K key) {
        int j = findIndex(key);
        int n = size();
        if (j == -1) {
            return null;
        }
        V answer = table.get(j).getValue();
        if(j != n-1) {
            table.set(j, table.get(n-1));
        }
        table.remove(n-1);
        return answer;
    }

    private class EntryIterator implements Iterator<Map.Entry<K,V>>{
        private int j = 0;
        public boolean hasNext(){
            return j < table.size();
        }
        public Map.Entry<K,V> next() {
            if (j == table.size()) throw new NoSuchElementException();
            return table.get(j++);
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    private class EntryIterable implements Iterable<Map.Entry<K,V>> {
        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }
    }
    public Iterable<Map.Entry<K, V>> entrySet() {
        return new EntryIterable();
    }
}
