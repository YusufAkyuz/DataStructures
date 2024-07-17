package List2;

public class ArrayList <E> implements List<E>{

    private static final int capacity = 16;
    E data[];
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

    private void checkIndex(int i, int size) {
        if (i >= size || i < 0) {
            throw new ArrayIndexOutOfBoundsException("Illegal index = " + i);
        }
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    @Override
    public E set(int position, E value) throws IndexOutOfBoundsException {
        checkIndex(position, size);
        E result = data[position];
        data[position] = value;
        return result;
    }

    @Override
    public void add(int postion, E value) throws IndexOutOfBoundsException {
        checkIndex(postion, size+1);
        if (size == capacity) {
            throw new IllegalArgumentException("The Stack is Full");
        }
        for (int i = size -1; i > postion -1; i--) {
            data[i] = data[i+1];
        }
        data[postion] = value;
        size++;
    }

    @Override
    public E remove(int position) throws IndexOutOfBoundsException {
        checkIndex(position, size);
        E result = data[position];
        for (int i = position; i < size-1; i++) {
            data[i] = data[i+1];
        }
        data[size-1] = null;
        size--;
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(20);
        for (int i = 0; i < 16; i++) {
            arrayList.add(i, i);
        }
        for (int i = 0; i < arrayList.size; i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
