package DynamicArray;

import java.util.Iterator;

@SuppressWarnings("unchecked")
class DynamicArray<T> implements Iterable<T> {
    private T arr[];
    private int len = 0;    //Dizide kaç eleman olduğunu gösterecek
    private int capacity = 0;

    public DynamicArray() {
        this(16);
    }

    ;

    public DynamicArray(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal Argument : " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public T get(int index) {
        return arr[index];
    }

    public void set(int index, T value) {
        arr[index] = value;
    }

    public void clear() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = null;
            len = 0;
        }
    }

    public void add(T element) {
        if (len + 1 > capacity) {
            if (capacity == 0) {
                capacity = 1;
            } else {
                capacity *= 2;
            }
            T[] newArr = (T[]) new Object[capacity];
            for (int i = 0; i < len; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }
        arr[len++] = element;
    }

    public T removeAt(int index) {
        if (index >= len || index < 0) throw new IndexOutOfBoundsException();

        T data = arr[index];
        T[] newArr = (T[]) new Object[capacity];

        for (int i = 0, j = 0; i < len; i++) {
            if (i == index) {
                continue; // index'teki elemanı atla
            }
            newArr[j++] = arr[i];
        }

        arr = newArr;
        len--;
        return data;
    }

    public boolean remove(Object obj) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == obj) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == obj) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;

            public boolean hasNext() {
                return index < len;
            }

            public T next() {
                return arr[index++];
            }
        };
    }

    @Override
    public String toString() {
        if (len == 0) return "[]";
        else {
            StringBuilder stringBuilder = new StringBuilder().append("[");
            for (int i = 0; i < len - 1; i++) {
                stringBuilder.append(arr[i] + " ,");
            }
            return stringBuilder.append(arr[len - 1] + "]").toString();
        }
    }
}
