package Map;
import java.util.LinkedList;

public class SeparateChainingHT<K,V> {
    private class HashNode<K,V> {
        K key;
        V value;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private LinkedList<HashNode<K,V>> [] chainArr;
    private int M;
    private int size;
    public SeparateChainingHT(int M) {
        this.M = M;
        size = 0;
        chainArr = new LinkedList[M];
        for (int i = 0; i < M; i++) {
            chainArr[i] = new LinkedList<>();
        }
    }
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }
    public void insert(K key, V value) {
        int index = hash(key);
        for (HashNode<K,V> node : chainArr[index]) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        chainArr[index].add(new HashNode<>(key, value));
        size++;
    }
    public V search(K key) {
        int index = hash(key);
        for (HashNode<K,V> node : chainArr[index]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }
    public boolean delete(K key) {
        int index = hash(key);
        for (HashNode<K,V> node : chainArr[index]) {
            if (node.key.equals(key)) {
                chainArr[index].remove(node);
                size--;
                return true;
            }
        }
        return false;
    }
    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        SeparateChainingHT<Integer,String> ht = new SeparateChainingHT<Integer, String>(5);
        ht.insert(1,"Yusuf");
        ht.insert(2,"Ali");
        ht.insert(3,"Mehmet");
        ht.insert(4,"Can");
        ht.insert(5,"Ahmet");
    }
}
