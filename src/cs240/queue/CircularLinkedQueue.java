/* Ronald Lencevicius 
 * CS 240
 * */

package cs240.queue;

public class CircularLinkedQueue<T> implements QueueInterface<T> {
	private Node<T> free;
	private Node<T> back;
	private int nodeCounter = 0;
	
	/** Adds a new entry to the back of this queue.
    @param newEntry  An object to be added. */
	public void enqueue(T newEntry) {
		if (nodeCounter == 0) {
			Node<T> node = new Node<>(newEntry);
			free = new Node<>(null);
			free.setNextNode(free);
			nodeCounter++;
			back = node;
		} else if (nodeCounter < 10) {
			Node<T> node = new Node<>(newEntry);
			back.setNextNode(node);
			back = node;
			free.setNextNode(back);
			nodeCounter++;
		} else {
			System.out.println("Queue full");
		} // end if
	} // end enqueue

	/** Removes and returns the entry at the front of this queue.
    	@return  The object at the front of the queue. */
	public T dequeue() {
		T result = null;
		if (isEmpty()){
			System.out.println("Nothing to remove, queue empty");
		} else {
			free.getNextNode().setData(null);
			free.setNextNode(free);
			nodeCounter--;
		} // end if
		return result;
	} // end dequeue

	/** Gets the value at front of queue.
    	@return  Value at front of queue. */
	public T getFront() {
		T value = null;
		if (!isEmpty()) {
			value = free.getNextNode().getData();
		} else {
			System.out.println("Queue empty");
		} // end if
		return value;
	} // end getFront

	/** Detects whether this queue is empty.
    	@return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty() {
		if (back.getData() == null) {
			return true;
		} else {
			return false;
		} // end if
	} // end isEmpty

	/** Removes all entries from this queue. */
	public void clear() {
		if (!isEmpty()) {
			this.dequeue();
		} // end if
	} // end clear
	
}
