/* Ronald Lencevicius 
 * CS 240
 * */

package cs240.queue;

public class ArrayQueue<T> implements QueueInterface<T> {
	private final T[] array;
	private int front, back;
	private static final int SIZE = 10;
	
	/** Initializes an array queue */
	public ArrayQueue() {
		@SuppressWarnings("unchecked")
		T[] tempArray = (T[]) new Object[SIZE];
		array = tempArray;
		front = 0;
		back = 0;
	} // end default constructor
	
	/** Adds a new entry to the back of this queue.
    	@param newEntry  An object to be added. */
	public void enqueue(T newEntry) {
		if(front == (back + 1) % SIZE){
			System.out.println("Queue is full");
		}else{
		array[back] = newEntry;
		back = (back + 1) % array.length;
		} // end if
	} // end enqueue

	/** Removes and returns the entry at the front of this queue.
    	@return  The object at the front of the queue. */
	public T dequeue() {
		T value = null;
		if (!isEmpty()){
			array[front] = null;
			front = (front + 1) % array.length;
			value = array[front];
		} else {
			System.out.println("Queue empty");
		} // end if
		return value;
	} // end dequeue

	/**  Retrieves the entry at the front of this queue.
    	 @return  The object at the front of the queue. */
	public T getFront() {
		T value = null;
		if (!isEmpty()) {
			value = array[front];
		} else {
			System.out.println("Queue empty");
		} // end if
		return value;
	} // end getFront

	/** Detects whether this queue is empty.
    	@return  True if the queue is empty, or false otherwise. */
	public boolean isEmpty() {
		return array == null;
	} // end isEmpty

	/** Removes all entries from this queue. */
	public void clear() {
		for(int i = 0; i < array.length; i++)
			array[i] = null;
		// end for
		front = back = 0;
		
	} // end clear
}
