package SinglyLinkedList;

import java.util.LinkedList;

public class SinglyLinkedList{

    private ListNode head;
    private static class ListNode {

        private final int data;
        private ListNode next;
        public ListNode(int data) {
            this.data = data;
        }
    }

    public void display() {
        if(head == null) {
            System.out.println("null");
            return;
        }
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public int length() {
        if (head == null) {
            return 0;
        }
        ListNode currency = head;
        int count = 0;
        while (currency != null) {
            count++;
            currency = currency.next;
        }
        return count;
    }

    public void insertFirst(int value) {
        ListNode listNode = new ListNode(value);
        listNode.next = head;
        head = listNode;
    }

    public void insertEnd(int value) {
        ListNode listNode = new ListNode(value);
        if (head == null) {
            head = listNode;
            return;
        }
        ListNode currency = head;
        while (currency.next != null) {
            currency = currency.next;
        }
        currency.next = listNode;
    }
    public void insertSpecific(int value, int position) {
        ListNode listNode = new ListNode(value);
        if (position == 1) {
            listNode.next = head;
            head = listNode;
        }else {
            ListNode previous = head;
            for (int i = 0; i < position - 1; i++) {
                previous = previous.next;
            }
            ListNode currency = previous.next;
            listNode.next = currency.next;
            previous.next = listNode;
        }
    }

    public ListNode deleteFirst() {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    public ListNode deleteEnd() {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;

    }

    public void deleteSpecific(int position) {
        if (position == 1) {
            head = head.next;
        }else {
            ListNode previous = head;
            for (int i = 1; i < position - 1; i++) {
                previous = previous.next;
            }
            ListNode currency = previous.next;
            previous.next = currency.next;

        }
    }

    public boolean search(int element) {
        ListNode currency = head;
        while (currency != null) {
            if (currency.data == element) {
                return true;
            }
            currency = currency.next;
        }
        return false;
    }

    public ListNode reverse(ListNode head){

        if (head == null) {
            return head;
        }

        ListNode currency = head;
        ListNode previous = null;
        ListNode next = null;
        while (currency.next != null) {
            next = currency.next;
            currency.next = previous;
            previous = currency;
            currency = next;
        }
        return previous; 
    }

    public ListNode getNthNodeFromEnd(int n) {
        if (head == null) {
            return null;
        }
        if (n <= 0){
            throw new IllegalArgumentException("Invalid Value = " + n);
        }
        ListNode maintPtr = head;
        ListNode refPtr = head;

        int count = 0;

        while (count < n) {
            if (refPtr == null) {
                throw  new IllegalArgumentException(n + " is grater than number of nıdes");
            }
            refPtr = refPtr.next;
            count++;
        }

        while (refPtr != null) {
            refPtr = refPtr.next;
            maintPtr = maintPtr.next;
        }
        return maintPtr;
    }



    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(10);

        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode fourth = new ListNode(40);

        sll.head.next = second;
        second.next = third;
        third.next = fourth;
        //fourth.next = null; yazmamıza pek gerek böyle çünkü

        sll.display();

        System.out.println(sll.length());

        sll.insertFirst(50);
        sll.display();

        sll.insertEnd(77);
        sll.display();

        sll.insertSpecific(99,4 );
        sll.display();

        sll.deleteFirst();
        sll.display();

        sll.deleteEnd();
        sll.display();

        sll.deleteSpecific(3);
        sll.display();

        boolean elementIsExist = sll.search(99);
        System.out.println(elementIsExist);

        sll.insertSpecific(4,1);
        sll.insertSpecific(4,1);
        sll.insertSpecific(4,1);

        sll.display();

        ListNode reverseListHead = sll.reverse(sll.head);
        sll.head = reverseListHead;
        sll.display();

    }
}
