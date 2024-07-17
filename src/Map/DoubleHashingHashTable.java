package Map;

class DoubleHashingHashTable<K, V> {
    private class HashNode<K, V> {
        K key;
        V value;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashNode<K, V>[] table;
    private int M;  // Tablo boyutu
    private int size;  // Eleman sayısı
    private final HashNode<K, V> DEFUNCT = new HashNode<>(null, null);  // Özel DEFUNCT nesnesi
    private final int R;  // İkinci hash fonksiyonu için asal sayı

    @SuppressWarnings("unchecked")
    public DoubleHashingHashTable(int M) {
        this.M = M;
        this.size = 0;
        table = new HashNode[M];
        this.R = getPrimeLessThan(M);
    }

    // Tablo boyutundan küçük bir asal sayı bul
    private int getPrimeLessThan(int num) {
        for (int i = num - 1; i >= 2; i--) {
            if (isPrime(i)) {
                return i;
            }
        }
        return 3;  // Varsayılan asal sayı
    }

    // Sayının asal olup olmadığını kontrol et
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int hash1(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private int hash2(K key) {
        return R - (key.hashCode() & 0x7fffffff) % R;
    }

    public void insert(K key, V value) throws Exception {
        if (size == M) {
            throw new Exception("Hash table is full");
        }

        int index = hash1(key);
        int stepSize = hash2(key);
        int i = 0;
        while (table[(index + i * stepSize) % M] != null && table[(index + i * stepSize) % M] != DEFUNCT && !table[(index + i * stepSize) % M].key.equals(key)) {
            i++;
        }

        table[(index + i * stepSize) % M] = new HashNode<>(key, value);
        size++;
    }

    public V search(K key) {
        int index = hash1(key);
        int stepSize = hash2(key);
        int i = 0;
        while (table[(index + i * stepSize) % M] != null) {
            HashNode<K, V> c = table[(index + i * stepSize) % M];
            if (c != DEFUNCT && c.key.equals(key)) {
                return c.value;
            }
            i++;
        }
        return null;  // Anahtar bulunamazsa null döndür
    }

    public V remove(K key) {
        int index = hash1(key);
        int stepSize = hash2(key);
        int i = 0;
        while (table[(index + i * stepSize) % M] != null) {
            HashNode<K, V> c = table[(index + i * stepSize) % M];
            if (c != DEFUNCT && c.key.equals(key)) {
                V value = c.value;
                table[(index + i * stepSize) % M] = DEFUNCT;  // Hücreyi DEFUNCT ile işaretle
                size--;
                return value;
            }
            i++;
        }
        return null;  // Anahtar bulunamazsa null döndür
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        try {
            DoubleHashingHashTable<Integer, String> hashTable = new DoubleHashingHashTable<Integer,String>(10);

            hashTable.insert(15, "Value for 15");
            hashTable.insert(25, "Value for 25");
            hashTable.insert(35, "Value for 35");
            hashTable.insert(25, "New value for 25"); // Bu işlem, key 25'in değerini günceller
            hashTable.insert(45, "Value for 45");
            hashTable.insert(55, "Value for 55");

            System.out.println("Search key 25: " + hashTable.search(25));  // Output: New value for 25
            System.out.println("Delete key 25: " + hashTable.remove(25));  // Output: New value for 25
            System.out.println("Search key 25: " + hashTable.search(25));  // Output: null
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

