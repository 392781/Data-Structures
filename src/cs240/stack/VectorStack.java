/* Ronald Lencevicius 
 * CS 240
 * */

package cs240.stack;

import java.util.Vector;

public class VectorStack<T> implements StackInterface<T> {
	private final Vector<T> stack;
	private int numberOfEntries;
	private static final int SIZE = 10;
	private static final int INCREMENT = 10;
	
	/** Creates a vector of size 10 that increments by 10 
	 *  when the vector is resized upward*/
	public VectorStack() {
		Vector<T> tempStack = new Vector<T>(SIZE , INCREMENT);
		stack = tempStack;
		numberOfEntries = -1;
	} // end default constructor
	
	/** Adds a new entry to the top of this stack.
    @param newEntry  An object to be added to the stack. */
	public void push(T newEntry) {
		stack.add(newEntry);
		numberOfEntries++;
	} // end push

	/** Removes and returns this stack's top entry.
      *	@return  The object at the top of the stack. 
      *	@throws  EmptyStackException if the stack is empty before the operation. */
	public T pop() {
		T result = null;
		if (!stack.isEmpty()) {
			stack.remove(numberOfEntries);
			numberOfEntries--;
			result = stack.get(numberOfEntries);
		} else {
			System.out.println("Stack empty");
		} // end if
		return result;
	} // end pop

	/** Retrieves this stack's top entry.
      *	@return  The object at the top of the stack.
      *	@throws  EmptyStackException if the stack is empty. */
	public T peek() {
		T result = null;
		if(!stack.isEmpty()) {
			result = stack.get(numberOfEntries);
		} // end if
		return result;
	} // end peek

	/** Detects whether this stack is empty.
      *@return  True if the stack is empty. */
	public boolean isEmpty() {
		return stack.isEmpty();
	} // end isEmpty

	/** Removes all entries from this stack. */
	public void clear() {
		while(!stack.isEmpty()) {
			stack.remove(numberOfEntries);
			numberOfEntries--;
		} // end while
	} // end clear
}
