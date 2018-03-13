package Trees;

public class Node<T>{
    private T data;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node(T data) {
        this.data = data;
        leftChild = null;
        rightChild = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setLeftChild(T data) {
        this.leftChild = new Node<>(data);
    }

    public void setRightChild(T data) {
        this.rightChild = new Node<>(data);
    }

    public Node<T> rightMost() {
        if (rightChild == null) {
            return this;
        } else {
            return rightChild.rightMost();
        }
    }

    public Node<T> leftMost() {
        if (leftChild == null) {
            return this;
        } else {
            return leftChild.leftMost();
        }
    }

    public void preorderTraverse(Node<T> root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            preorderTraverse(root.getLeftChild());
            preorderTraverse(root.getRightChild());
        }
    }

    private void inorderTraverse(Node<T> root) {
        if (root != null) {
            inorderTraverse(root.getLeftChild());
            System.out.print(root.getData() + " ");
            inorderTraverse(root.getRightChild());
        }
    }

    private void postorderTraverse(Node<T> root) {
        if (root != null) {
            postorderTraverse(root.getLeftChild());
            postorderTraverse(root.getRightChild());
            System.out.print(root.getData() + " ");
        }
    }
}
