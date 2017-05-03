package cs240.trees;

public class TreeNode<T extends Comparable<T>> {
	private T data;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;
	
	public TreeNode() { }
	
	public TreeNode(T data) { 
		this.data = data;
		leftChild = null;
		rightChild = null;
	}
	
	public TreeNode(T data, TreeNode<T> leftChild, TreeNode<T> rightChild) {
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public int compareTo(T object) {
		if (this == object)
		return 0;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public TreeNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}

	public boolean isLeaf() {
		return rightChild == null && leftChild == null;
	}
	
	public void preorderTraverse() {
		preorderTraverse(this);
	}
	
	public void postorderTraverse() {
		postorderTraverse(this);
	}
	
	public void inorderTraverse() {
		inorderTraverse(this);
	}
	
	private void preorderTraverse(TreeNode<T> root) {
		if (root != null) {
			System.out.print(root.getData() + " ");
			preorderTraverse(root.getLeftChild());
			preorderTraverse(root.getRightChild());
		}
	}

	private void inorderTraverse(TreeNode<T> root) {
		if (root != null) {
			inorderTraverse(root.getLeftChild());
			System.out.print(root.getData() + " ");
			inorderTraverse(root.getRightChild());
		}
	}
	
	private void postorderTraverse(TreeNode<T> root) {
		if (root != null) {
			postorderTraverse(root.getLeftChild());
			postorderTraverse(root.getRightChild());
			System.out.print(root.getData() + " ");
		}
	}
	
	public TreeNode<T> RightMostChild() {
		if (rightChild != null) {
			return rightChild.RightMostChild();
		} else {
			return this;
		}
	}
	
	public TreeNode<T> LeftMostChild() {
		if (leftChild != null) {
			return leftChild.LeftMostChild();
		} else {
			return this;
		}
	}
	
	public TreeNode<T> removeRightmost() {
		if (rightChild == null) {
			return leftChild;
		} else {
			rightChild = rightChild.removeRightmost();
			return this;
		}
	}
}
