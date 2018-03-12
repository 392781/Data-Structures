public abstract class BST<T extends Comparable<T>> {
    private Node<T> root;

    public BST(Node<T> root) {
        this.root = root;
    }

    public boolean add(T data) {
        if (root == null) {
            root = new Node<>(data);
            return true;
        } else {
            return add(root, data);
        }
    }

    public boolean add(Node<T> root, T data) {
        if (data.compareTo(root.getData()) == 0) {
            return false;
        } else if (data.compareTo(root.getData()) < 0) {
            if (root.getLeftChild() == null) {
                root.setLeftChild(data);
                return true;
            } else {
                add(root.getLeftChild(), data);
            }
        } else if (data.compareTo(root.getData()) > 0) {
            if (root.getRightChild() == null) {
                root.setRightChild(data);
                return true;
            } else {
                add(root.getRightChild(), data);
            }
        }
        return false;
    }

    public boolean remove(T data) {
        if (root == null) {
            return false;
        } else if (root.getData() == data) {
            throw new RuntimeException("don't delete root :P");
        } else {
            return remove(data, root);
        }
    }

    public boolean remove(T data, Node<T> node) {
        if (data.compareTo(node.getData()) < 0) {
            if (node.getLeftChild() != null) {
                remove(data, root.getLeftChild());
            } else {
                return false;
            }
        } else if (data.compareTo(node.getData()) > 0) {
            if (node.getRightChild() != null) {
                remove(data, root.getRightChild());
            } else {
                return false;
            }
        } else {
            if (node.getRightChild() == null && node.getLeftChild() == null) {
                node = null;
            } else if (node.getRightChild() == data && node.getLeftChild() == null) {

            }
        }
    }
}
