package List;

public class Node <E> implements Position<E>{

    private E element;
    private Node<E> prev;
    private Node<E> next;

    public Node(E value, Node<E>prev, Node<E> next)
    {
        this.element = value;
        this.prev = prev;
        this.next = next;
    }
    @Override
    public E getElement() throws IllegalArgumentException {
        if(next == null) {
            throw new IllegalArgumentException("Position is no longer valid");
        }
        return element;
    }
    public Node<E> getPrev() {
        return prev;
    }
    public Node<E> getNext() {
        return next;
    }
    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }
    public void setNext(Node<E> next) {
        this.next = next;
    }
}
