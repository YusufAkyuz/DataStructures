package PriorityQueue;

public class MaxPQ {
    Integer [] heap;
    int n;
    public MaxPQ(int capacity) {
        heap = new Integer[capacity +1];
        n = 0;
    }
    public boolean isEmpty() {
        return n == 0;
    }
    public int size() {
        return n;
    }
    public void insert(int x) {
        if (n == heap.length -1) {
            resize(2*heap.length);
        }
        n++;
        heap[n] = x;
        percolateUp(n);
    }
    private void percolateUp(int k) {
        while (k > 1 && heap[k/2] < heap[k]) {
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = temp;
            k = k/2;
        }
    }
    private void resize(int newCapacity) {
        Integer [] tempArr = new Integer[newCapacity];
        for (int i = 0; i < heap.length; i++) {
            tempArr[i] = heap[i];
        }
        heap = tempArr;
    }

    public void printMaxHeap() {
        for (int i = 1; i < heap.length; i++) {
            System.out.print(heap[i] + " ");
        }
    }

    public int deleteMax() {
        int max = heap[1];
        swap(1,n);
        n--;
        sink(1);
        heap[n+1] = null;
        if (n > 0 && (n == (heap.length - 1)/4)) {
            resize(heap.length/2);
        }
        return max;
    }

    private void sink (int k) {
        while (2*k <= n) {
            int j = 2*k;        //Childlara erişim için kullanıldı
            if (j < n && heap[j] < heap[j+1]) {    //Burda childları karşılaştırcak right ile swap edebilmesi için ilerde 1 artırdı
                j++;
            }
            if (heap[k] >= heap[j]) {
                break;
            }
            swap(k,j);
            k = j;
        }
    }


    public void swap(int a , int b) {
        int temp = heap[a];
        heap[a] = b;
        heap[b] = temp;
    }

    public static void main(String[] args) {
        MaxPQ maxPQ = new MaxPQ(3);
        maxPQ.insert(4);
        maxPQ.insert(5);
        maxPQ.insert(2);
        maxPQ.insert(6);
        maxPQ.insert(1);
        maxPQ.insert(3);
        maxPQ.deleteMax();
        System.out.println(maxPQ.size());
        maxPQ.printMaxHeap();
    }
}
