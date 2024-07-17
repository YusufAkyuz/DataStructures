package List;

public interface List <E>{
    int size();
    boolean isEmpty();
    E get(int i) throws IndexOutOfBoundsException;
    E set(int i, E value) throws IndexOutOfBoundsException;
    void add(int i, E value) throws IndexOutOfBoundsException;
    E remove(int i) throws IndexOutOfBoundsException;
}
