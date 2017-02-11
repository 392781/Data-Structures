/* Ronald Lencevicius 
 * CS 240
 * */

package cs240.queue;

public class Node<T> {
	private T data;
	private Node<T> nextNode;
	
	public Node(T data) {
		this.data = data;
	}
	
	public Node<T> getNextNode() {
		return nextNode;
	}
	
	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
}

