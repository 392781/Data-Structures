/** Interface for ADT Deque
 * 	@author Ronald Lencevicius*/

package cs240.queue;

public interface DequeInterface<T> {
	
	/** Adds a new entry to back of the queue
	 * 	@param newEntry  an object to be added*/
	public void addToBack(T newEntry);
	
	/** Adds a new entry to front of the queue
	 * 	@param newEntry  an object to be added*/
	public void addToFront(T newEntry);
	
	/** Removes an entry from the back of the queue
	 * 	@return  The reference to the object at the back of the queue*/
	public T removeBack();
	
	/** Removes an entry from the front of the queue
	 * 	@return  The reference to the object at the front of the queue*/
	public T removeFront();
	
	/** Gets the entry at the back of the queue
	 * 	@return  The reference to the object at the back of the queue*/
	public T getBack();
	
	/** Gets the entry at the front of the queue
	 * 	@return  The reference to the object at the front of the queue*/
	public T getFront();
	
	/** Detects whether the queue is empty
	 * 	@return  True if queue is empty, false otherwise*/
	public boolean isEmpty();
	
	/** Clears the queue of all entries*/
	public void clear();
} // end DequeInterface
