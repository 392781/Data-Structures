package cs240.queue;

public class DLNode<T> {
	private T data;
	private DLNode<T> nextNode;
	private DLNode<T> previousNode;
	
	public DLNode(DLNode<T> previousNode, T data, DLNode<T> nextNode) {
		this.data = data;
		this.previousNode = previousNode;
		this.nextNode = nextNode;
	}
	
	public DLNode<T> getNextNode() {
		return nextNode;
	}
	
	public void setNextNode(DLNode<T> nextNode) {
		this.nextNode = nextNode;
	}
	
	public DLNode<T> getPreviousNode() {
		return previousNode;
	}
	
	public void setPreviousNode(DLNode<T> previousNode) {
		this.previousNode = previousNode;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
}
