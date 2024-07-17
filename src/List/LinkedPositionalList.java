package List;

public class LinkedPositionalList <E> implements PositionalList{
    private Node<E> header;
    private Node<E> trailer;
    private int size;

    public LinkedPositionalList() {
        this.header = new Node<E>(null, null, null);
        this.trailer = new Node<E>(null, header, null);
        this.size = 0;
    }
    private Node<E> validate(Position<E> p) throws IllegalArgumentException{
        if (!(p instanceof Node<E>)) {
            throw new IllegalArgumentException("Invalid Position");
        }
        Node<E> node =(Node<E>) p;
        if (node.getNext() == null) {
            throw new IllegalArgumentException("Postion is no longer");
        }
        return node;
    }
    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer) {
            return null;
        }
        return node;
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
    public Position first() {
        return position(header.getNext());
    }

    @Override
    public Position<E> last() {
        return position(header.getPrev());
    }

    @Override
    public Position<E> addFirst(Object o) {
        return null;
    }

    @Override
    public Position<E> addLast(Object o) {
        return null;
    }

    @Override
    public Object set(Position p, Object o) {
        return null;
    }

    @Override
    public Object get(Position p) {
        return null;
    }

    @Override
    public Object remove(Position p) {
        return null;
    }

    @Override
    public Position addAfter(Position p, Object o) {
        return null;
    }

    @Override
    public Position addBefore(Position p, Object o) {
        return null;
    }
}
