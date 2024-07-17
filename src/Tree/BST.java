package Tree;

public class BST <T extends Comparable<T>>{

    private Node root = null;

    private class Node{
         T data;
         Node left, right;

        public Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public boolean contains(T data) {
        return contains(root, data);
    }

    private boolean contains(Node node, T data) {
        if (node == null) {
            return false;
        }
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            return contains(node.left, data);
        }else if(cmp > 0) {
            return contains(node.right, data);
        }else {
            return true;
        }

    }

    public void add(T data) {
        if (contains(data)) {
            return;
        }
        root = add(root, data);
    }

    private Node add(Node node, T data) {
        if (node == null) {
            node = new Node(data,null, null);
        } else {
            int cmp = data.compareTo(node.data);
            if (cmp < 0) {
                node.left = add(node.left, data);
            }else {
                node.right = add(node.right, data);
            }
        }
        return node;
    }

    public void delete(T data) {
        if (!contains(data)) {
            return;
        }
        root = delete(root, data);
    }

    private Node delete(Node node, T data) {
        if (node == null) {
            return null;
        }
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = delete(node.left, data);
        }else if(cmp > 0) {
            node.right = delete(node.right, data);
        }else {
            if (node.left == null) {

                Node rightChild = node.right;
                node.data = null;
                node = null;
                return rightChild;
            }else if(node.right == null) {
                Node leftChild = node.left;
                node.data = null;
                node = null;
                return leftChild;
            }
            Node temp = findMin(node.right);
            node.data = temp.data;
            node.right = delete(node.right, temp.data);
        }

        return node;
    }

    private Node findMin(Node node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }


    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.add(5);
        bst.add(10);
        bst.add(2);
        bst.add(1);
        bst.add(3);
        bst.add(8);
        bst.add(12);

        bst.delete(10);

        bst.inOrderTraversal(bst.root);

    }

}
