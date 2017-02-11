/* Ronald Lencevicius 
 * CS 240
 * */

package cs240.queue;

public class SingleLinkedQueue<T> implements QueueInterface<T> {
	private Node<T> front;
	private Node<T> back;
	
	/** Adds a new entry to the back of this queue.
    @param newEntry  An object to be added. */
	public void enqueue(T newEntry) {
		Node<T> node = new Node<>(newEntry);
		if (isEmpty()) {
			front = back = node;
		}else{
			back.setNextNode(node);
			back = node;
		} // end if
	} // end enqueue

	/** Removes and returns the entry at the front of this queue.
    @return  The object at the front of the queue. 
    @throws  EmptyQueueException if the queue is empty before the operation. */
	public T dequeue() {
		T result = null;
		
		if (isEmpty()) {
			System.out.println("Nothing to remove, queue empty");
		} else {
			Node<T> temp = front.getNextNode();
			front = null;
			front = temp;
			result = front.getData();
		} // end if
		return result;
	} // end dequeue

	/**  Retrieves the entry at the front of this queue.
    @return  The object at the front of the queue.
    @throws  EmptyQueueException if the queue is empty. */
	public T getFront() {
		T value = null;
		if(!isEmpty())
			value = front.getData();
			// end if
		return value;
	} //end getFront

	/** Detects whether this queue is empty.
    @return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty() {
		return front == null;
	} //end isEmpty

	/** Removes all entries from this queue. */
	public void clear() {
		front = null;
	} //end clear
}
