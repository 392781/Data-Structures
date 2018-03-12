public class NodeTest {
    public static void main(String[] args) {
        Node<Integer> node = new Node<>(10);

        node.setLeftChild(new Node<>(11));
        node.setRightChild(new Node<>(13));
        node.getLeftChild().setLeftChild(new Node<>(9));
        node.getLeftChild().setRightChild(new Node<>(8));
        node.getRightChild().setLeftChild(new Node<>(4));
        node.getRightChild().setRightChild(new Node<>(1));

        node.preorderTraverse(node);
    }
}
