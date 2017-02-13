/** Double linked node implementation of ADT Deque
 * 	@author Ronald Lencevicius*/

package cs240.queue;

public class DoubleLinkedDeque<T> implements DequeInterface<T> {
	private DLNode<T> firstNode;
	private DLNode<T> lastNode;
	
	/** Default constructor for double linked deque*/
	public DoubleLinkedDeque() {
		firstNode = null;
		lastNode = null;
	} // end default constructor
	
	/** Adds a new entry to back of the queue
	 * 	@param newEntry  an object to be added*/
	public void addToBack(T newEntry) {
		DLNode<T> newNode = new DLNode<T>(lastNode, newEntry, null);
		
		if (isEmpty()) 
			firstNode = newNode;
		else
			lastNode.setNextNode(newNode);
		// end if
		lastNode = newNode;
	} // end addToBack

	/** Adds a new entry to front of the queue
	 * 	@param newEntry  an object to be added*/
	public void addToFront(T newEntry) {
		DLNode<T> newNode = new DLNode<T>(null, newEntry, firstNode);
		
		if (isEmpty())
			lastNode = newNode;
		else
			firstNode.setPreviousNode(newNode);
		// end if
		firstNode = newNode;
	} // end addToFront

	/** Removes an entry from the back of the queue
	 * 	@return  The reference to the object removed from the back of the queue*/
	public T removeBack() {
		T result = null;
		
		if (isEmpty()) {
			System.out.println("Nothing to remove, queue empty");
		} else {
			result = lastNode.getData();
			lastNode = lastNode.getPreviousNode();
			
			if (lastNode == null)
				firstNode = null;
			else
				lastNode.setNextNode(null);
			// end if
		} // end if
		return result;
	} // end removeBack

	/** Removes an entry from the front of the queue
	 * 	@return  The reference to the object removed from the front of the queue*/
	public T removeFront() {
		T result = null;
		
		if (isEmpty()) {
			System.out.println("Nothing to remove, queue empty");
		} else {
			result = lastNode.getData();
			firstNode = firstNode.getNextNode();
			
			if (firstNode == null)
				lastNode = null;
			else
				lastNode.setNextNode(null);
			// end if
		} // end if
		return result;
	} // end removeFront

	/** Gets the entry at the back of the queue
	 * 	@return  The reference to the object at the back of the queue*/
	public T getBack() {
		T value = null;
		
		if (!isEmpty()) 
			value = lastNode.getData();
		else
			System.out.println("Queue is empty");
		// end if
		return value;
	} // end getBack

	/** Gets the entry at the front of the queue
	 * 	@return  The reference to the object at the front of the queue*/
	public T getFront() {
		T value = null;
		
		if (!isEmpty())
			value = firstNode.getData();
		else
			System.out.println("Queue is empty");
		// end if
		return value;
	} // end getFront

	/** Detects whether the queue is empty
	 * 	@return  True if queue is empty, false otherwise*/
	public boolean isEmpty() {
		if (firstNode == null && lastNode == null)
			return true;
		else
			return false;
		// end if
	} // end isEmpty

	/** Clears the queue of all entries*/
	public void clear() {
		firstNode = null;
		lastNode = null;
	} // end clear

}
