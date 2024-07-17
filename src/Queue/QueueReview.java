package Queue;

import java.util.NoSuchElementException;

public class QueueReview {
    private Node front;
    private Node rear;
    private int length;

    private class Node{
        private Node next;
        private int data;
        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public QueueReview() {
        front = null;
        rear = null;
        length = 0;
    }
    public int length(){
        return length;
    }
    public boolean isEmpty() {
        return length == 0;
    }

    public void enqueu(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = newNode;
        }else {
            rear.next = newNode;
        }
        rear = newNode;
        length++;
    }
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int result = front.data;
        front = front.next;
        if(front == null) {
            rear = null;
        }
        length--;
        return result;
    }
    public int first() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return front.data;
    }
    public int last() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return rear.data;
    }
    public void display() {
        if (isEmpty()) {
            return;
        }
        Node current = front;
        while (current != null) {
            System.out.println(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        QueueReview queue = new QueueReview();
        queue.enqueu(10);
        queue.enqueu(20);
        queue.enqueu(30);
        queue.enqueu(40);

        queue.display();
    }
}
