package List;

public class ArrayList<E> implements List<E>{
    private static final int capacity = 16;
    private E[] data;
    private int size = 0;
    public ArrayList() {
        data = (E[]) new Object[capacity];
    }
    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    @Override
    public E set(int i, E value) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = value;
        return temp;
    }

    @Override
    public void add(int i, E value) throws IndexOutOfBoundsException {
        checkIndex(i, size+1);
        if (size == capacity) {
            throw new IllegalArgumentException("The Stack is Full");
        }
        for (int j = size-1 ; j > i; j--) {
            data[j] = data[j+1];
        }
        data[i] = value;
        size++;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int j = i; j < size-1; j++) {
            data[j] = data[j+1];
        }
        data[size - 1] = null;
        size--;
        return temp;
    }
    private void checkIndex(int i, int size) throws IndexOutOfBoundsException{
        if (i < 0 || i >= size) {
            throw new ArrayIndexOutOfBoundsException("Illegal Index = " + i);
        }
    }

    public static void main(String[] args) {
        ArrayList<Character> arrayList = new ArrayList<Character>(20);
        String name = "Hello ArrayList";
        for (int i = 0 ; i < name.length() ; i++) {
            arrayList.add(i, name.charAt(i));
        }
        for (int i = 0; i < arrayList.size; i++) {
            System.out.print(arrayList.get(i));
        }

    }
}
