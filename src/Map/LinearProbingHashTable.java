package Map;

class LinearProbingHashTable<K, V> {
    private class HashNode<K, V> {
        K key;
        V value;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashNode<K, V>[] table;
    private int M;  // Boyut
    private int size;  // Eleman sayısı

    @SuppressWarnings("unchecked")
    public LinearProbingHashTable(int M) {
        this.M = M;
        this.size = 0;
        table = new HashNode[M];
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void insert(K key, V value) {
        int index = hash(key);
        int i = 0;
        while (table[(index + i) % M] != null && !table[(index + i) % M].key.equals(key)) {
            i++;
        }
        table[(index + i) % M] = new HashNode<>(key, value);
        size++;
    }

    public V search(K key) {
        int index = hash(key);
        int i = 0;
        while (table[(index + i) % M] != null) {
            if (table[(index + i) % M].key.equals(key)) {
                return table[(index + i) % M].value;
            }
            i++;
        }
        return null;  // Anahtar bulunamazsa null döndür
    }

    public boolean delete(K key) {
        int index = hash(key);
        int i = 0;
        while (table[(index + i) % M] != null) {
            if (table[(index + i) % M].key.equals(key)) {
                table[(index + i) % M] = null;
                size--;
                return true;
            }
            i++;
        }
        return false;  // Anahtar bulunamazsa false döndür
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        LinearProbingHashTable<Integer, String> hashTable = new LinearProbingHashTable<Integer,String>(10);

        hashTable.insert(15, "Value for 15");
        hashTable.insert(25, "Value for 25");
        hashTable.insert(35, "Value for 35");
        hashTable.insert(25, "New value for 25"); // Bu işlem, key 25'in değerini günceller
        hashTable.insert(45, "Value for 45");
        hashTable.insert(55, "Value for 55");

        System.out.println("Search key 25: " + hashTable.search(25));  // Output: New value for 25
        System.out.println("Delete key 25: " + hashTable.delete(25));  // Output: true
        System.out.println("Search key 25: " + hashTable.search(25));  // Output: null
    }
}
