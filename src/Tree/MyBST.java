package Tree;


public class MyBST<T extends Comparable<T>>{
    private TreeNode root;
    private class TreeNode {
        private T data;
        private TreeNode left, right;

        public TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private boolean isExist(T data) {
        return isExist(root, data);
    }

    private boolean isExist(TreeNode root, T data) {
        if (root == null) {
            return false;
        }else {
            int cmp = data.compareTo(root.data);
            if (cmp < 0) {
                return isExist(root.left, data);
            }else if(cmp > 0){
                return isExist(root.right, data);
            }else {
                return true;
            }
        }
    }

    public void add(T data) {
        if (isExist(data)) {
            return;
        }
        root = add(root, data);
    }

    private TreeNode add(TreeNode node, T data) {
        if (node == null) {
            node = new TreeNode(data);
        }else {
            int cmp = data.compareTo(node.data);
            if (cmp < 0) {
                root.left = add(root.left, data);
            }else {
                root.right = add(root.right, data);
            }
        }
        return node;
    }

    private void delete(T data) {
        if (!isExist(data)) {
            return;
        }
        root = delete(root, data);
    }

    private TreeNode delete(TreeNode node, T data) {
        if (node == null) {
            return null;
        }
        int cmp = data.compareTo(node.data);
        if (cmp < 0 ) {
            node.left = delete(node.left, data);
        }else if(cmp > 0){
            node.right = delete(node.right, data);
        }else {
            if (node.left == null) {
                TreeNode rightChild = node.right;
                node.data = null;
                node = null;
                return rightChild;
            }else if(node.right == null) {
                TreeNode rightChild = node.right;
                node.data = null;
                node = null;
                return rightChild;
            }else {
                TreeNode resultNode = findMinNode(node);
                node = resultNode;
                node.right = delete(node.right, resultNode.data);
            }
        }
        return node;
    }

    private TreeNode findMinNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
