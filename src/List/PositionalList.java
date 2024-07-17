package List;

public interface PositionalList <E>{
    // Listenin boyutunu döndürür
    int size();

    // Liste boş mu kontrol eder
    boolean isEmpty();

    // İlk pozisyonu döndürür
    Position<E> first();

    // Son pozisyonu döndürür
    Position<E> last();

    // Önceki bir pozisyonu verilen pozisyondan sonra ekler
    Position<E> addBefore(Position<E> p, E e);

    // Sonraki bir pozisyonu verilen pozisyondan sonra ekler
    Position<E> addAfter(Position<E> p, E e);

    // İlk pozisyona eleman ekler
    Position<E> addFirst(E e);

    // Son pozisyona eleman ekler
    Position<E> addLast(E e);

    // Verilen pozisyondaki elemanı kaldırır ve döndürür
    E remove(Position<E> p);

    // Verilen pozisyondaki elemanı döndürür
    E get(Position<E> p);

    // Verilen pozisyondaki elemanı günceller
    E set(Position<E> p, E e);

}
