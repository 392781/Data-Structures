package cs240.trees;

public class TreeNodeG<T extends Comparable<T>> {
	private T data;
	private TreeNodeG<T> left;
	private TreeNodeG<T> right;
	
	public TreeNodeG() { }
	
	public TreeNodeG(T data) { 
		this.data = data;
		left = null;
		right = null;
	}
	
	public TreeNodeG(T data, TreeNodeG<T> left, TreeNodeG<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public TreeNodeG<T> getLeft() {
		return left;
	}

	public void setLeft(TreeNodeG<T> left) {
		this.left = left;
	}

	public TreeNodeG<T> getRight() {
		return right;
	}

	public void setRight(TreeNodeG<T> right) {
		this.right = right;
	}

	public boolean isLeaf() {
		return right == null && left == null;
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
	
	private void preorderTraverse(TreeNodeG<T> root) {
		if (root != null) {
			System.out.print(root.getData() + " ");
			preorderTraverse(root.getLeft());
			preorderTraverse(root.getRight());
		}
	}

	private void inorderTraverse(TreeNodeG<T> root) {
		if (root != null) {
			inorderTraverse(root.getLeft());
			System.out.print(root.getData() + " ");
			inorderTraverse(root.getRight());
		}
	}
	
	private void postorderTraverse(TreeNodeG<T> root) {
		if (root != null) {
			postorderTraverse(root.getLeft());
			postorderTraverse(root.getRight());
			System.out.print(root.getData() + " ");
		}
	}
	
	public TreeNodeG<T> RightMost() {
		if (right != null) {
			return right.RightMost();
		} else {
			return this;
		}
	}
	
	public TreeNodeG<T> LeftMost() {
		if (left != null) {
			return left.LeftMost();
		} else {
			return this;
		}
	}
	
	public TreeNodeG<T> removeRightmost() {
		if (right == null) {
			return left;
		} else {
			right = right.removeRightmost();
			return this;
		}
	}

	public int compareTo(T data) {
		return this.getData().compareTo(data);
	}
}
