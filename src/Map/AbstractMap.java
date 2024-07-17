package Map;

import java.util.Iterator;

public abstract class AbstractMap <K,V> implements Map<K,V>{

    protected static class MapEntry<K,V> implements java.util.Map.Entry<K,V> {
        private K key;
        private V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = value;
            this.value = value;
            return oldValue;
        }
    }

    private class KeyIterator implements Iterator<K> {
        private Iterator<java.util.Map.Entry<K,V>> entries = entrySet().iterator();
        public boolean hasNext() {
            return entries.hasNext();
        }
        public K next() {
            return entries.next().getKey();
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class KeyIterable implements Iterable<K> {
        public Iterator <K> iterator() {
            return new KeyIterator();
        }
    }

    public Iterable<K> keySet() {
        return new KeyIterable();
    }

    private class ValueIterator implements Iterator<V> {
        private Iterator<java.util.Map.Entry<K,V>> entries = entrySet().iterator();
        public boolean hasNext() {
            return entries.hasNext();
        }
        public V next () {
            return entries.next().getValue();
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    private class ValueIterable implements Iterable<V> {
        public Iterator<V> iterator () {
            return new ValueIterator();
        }
    }

    public Iterable<V> values() {
        return new ValueIterable();
    }

}
