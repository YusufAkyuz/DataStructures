package Queue;

import java.net.InetAddress;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Queue <T>{

    private ListNode front; //ön anlamı var
    private ListNode rear;  //arka anlamı var zaten
    private int length;

    private class ListNode {
        private T data;
        private ListNode next;

        public ListNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public Queue() {
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    public int length() {
        return length;
    }
    public boolean isEmpty() {
        return length == 0;
    }
    public void enqueue(T data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        length++;
    }
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;    //Bu işlemi yapıcaz ki rear hala silinmek istenen değeri göstermeye devam etmesin
        }
        length--;
        return data;
    }
    public T first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return front.data;
    }
    public T last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return rear.data;
    }
    public void display() {
        if (isEmpty()) {
            return;
        }
        ListNode current = front;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }
   



    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.display();

        queue.dequeue();
        queue.display();

        queue.dequeue();
        queue.display();

        System.out.println("First Element of Queue = " + queue.first());
        System.out.println("Last of Element of Queue = " + queue.last());
    }
}
