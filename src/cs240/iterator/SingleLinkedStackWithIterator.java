/* Ronald Lencevicius 
 * CS 240
 * */

package cs240.iterator;

import java.util.EmptyStackException;
import java.util.Iterator;

public class SingleLinkedStackWithIterator<T> implements StackInterface<T> {
	private Node<T> head;
	private int count;
	
	/** Adds a new entry to the top of this stack.
    	@param newEntry  An object to be added to the stack. */
	public void push(T newEntry) {
		Node<T> node = new Node<>(newEntry);
		if (head == null) { 
			head = node;
			count++;
		} else {
			if(head.getNextNode() == null) {
				head.setNextNode(node);
				count++;
			}else{
				Node<T> temp = head.getNextNode();
				temp.setNextNode(node);
				head.setNextNode(temp);
				count++;
			}
		} // end if
	} // end push
	
	/** Removes and returns this stack's top entry.
    	@return  The object at the top of the stack. 
    	@throws  EmptyStackException if the stack is empty before the operation. */
	public T pop() {
		
		if(isEmpty() == true) {
			throw new EmptyStackException();
		} // end if
		
		Node<T> temp = head.getNextNode();
		T popped = null;
		
		if (temp.getNextNode() == null) {
			popped = temp.getData();
			clear();
		} // end if
		
		while (temp != null) {
			if(temp.getNextNode() != null) {
				temp = temp.getNextNode();
			} else {
				popped = temp.getData();
				temp.setNextNode(null);
				temp = temp.getNextNode();
			}
		} // end while
		return popped;
	} // end pop

	/** Retrieves this stack's top entry.
    	@return  The object at the top of the stack.
    	@throws  EmptyStackException if the stack is empty. */
	public T peek(){
		
		if(isEmpty() == true) {
			throw new EmptyStackException();
		} // end if
		
		Node<T> temp = head.getNextNode();
		T peeked = null;
		
		if (temp.getNextNode() == null) {
			peeked = temp.getData();
		} // end if
		
		while (temp != null) {
			if(temp.getNextNode() != null) {
				temp = temp.getNextNode();
			} else {
				peeked = temp.getData();
				temp = temp.getNextNode();
			} // end if
		} // end while
		return peeked;
	}

	/** Detects whether this stack is empty.
    	@return  True if the stack is empty. */
	public boolean isEmpty() {
		return head == null;
	} // end isEmpty

	/** Removes all entries from this stack. */
	public void clear() {
		head = null;
	} // end clear
	
	public Iterator<T> getIterator() {
		return new IteratorLinkedStack();
	}
	
	private class IteratorLinkedStack implements Iterator<T> {
		private Node<T> nextNode;
		
		private IteratorLinkedStack() {
			nextNode = head;
		}
		
		public boolean hasNext() {
			return nextNode != null;
		}

		public T next() {
			T value = null;
			if (hasNext()) {
				Node<T> returnNode = nextNode;
				nextNode = nextNode.getNextNode();
				value = returnNode.getData();
			}
			return value;
		}
		
	}

}
