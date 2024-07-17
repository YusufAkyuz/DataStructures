package CircularSinglyLinkedList;

import org.w3c.dom.ls.LSInput;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {

    private ListNode last;
    private int length;


    private static class ListNode{
        private ListNode next;
        private int data;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public CircularSinglyLinkedList() {
        last = null;
        length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }
    public int length() {
        return length;
    }
    public void createCircularSinglyLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(10);
        ListNode fourth = new ListNode(15);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        last = fourth;
    }
    public void display() {
        if (last == null) {
            return;
        }
        ListNode temp = last.next;
        while (temp != last) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.print(temp.data + " --> ");
        System.out.println("null");
    }
    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        if (last == null) {
            last = newNode;
        }else {
            newNode.next = last.next;
        }
        last.next = newNode;
        length++;
    }
    public void inserLast(int value) {
        ListNode newNode = new ListNode(value);
        if (last == null) {
            last = newNode;
            last.next = last;
        }else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public ListNode deleteFirst() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        ListNode temp = last.next;
        if (last.next == last){
            last = null;
        }else {
            last.next = temp.next;
        }
        temp.next = null;
        length--;
        return temp;
    }



    public static void main(String[] args) {

        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.createCircularSinglyLinkedList();

        csll.display();

        csll.insertFirst(99);
        csll.display();

        csll.inserLast(77);
        csll.display();

        csll.deleteFirst();
        csll.display();


    }
}
