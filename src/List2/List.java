package List2;

public interface List <E>{
    int size();
    boolean isEmpty();
    E get(int i) throws IndexOutOfBoundsException;
    E set(int position, E value) throws IndexOutOfBoundsException;
    void add(int postion, E value) throws IndexOutOfBoundsException;
    E remove(int position) throws IndexOutOfBoundsException;

}
