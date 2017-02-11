/* Ronald Lencevicius 
 * CS 240
 * */

package cs240.stack;

import java.util.EmptyStackException;

public class ArrayStack<T> implements StackInterface<T> {
	private final T[] stack;
	private int numberOfEntries;
	private static final int SIZE = 10;
	
	/** Creates an array stack of size 10*/
	public ArrayStack() {
		@SuppressWarnings("unchecked")
		T[] tempStack = (T[]) new Object[SIZE];
		stack = tempStack;
		numberOfEntries = 0;
	} // end default constructor
	
	/** Adds a new entry to stack
	 *  @param newEntry The object to be added as an entry */
	public void push(T newEntry){
		if (!isFull()){
			stack[numberOfEntries] = newEntry;
			numberOfEntries++;
		} else {
			System.out.println("Array Stack Full");
		} // end if
	} // end push
	
	/** Removes top most entry of the array stack
	 *  @return The object at the top of the stack
	 *  @throws EmptyStackException if stack is empty*/
	public T pop() {
		T result = null;
		if (!isEmpty()) {
			stack[numberOfEntries - 1] = null;
			numberOfEntries--;
			result = stack[numberOfEntries - 1];
		} else 
			throw new EmptyStackException();
			// end if
		return result;
	} // end pop
	
	/** Retrieves this stack's top entry.
      *	@return  The object at the top of the stack.
      *	@throws  EmptyStackException if the stack is empty. */
	public T peek() {
		T result = null;
		if (!isEmpty()) {
			result = stack[numberOfEntries - 1];
		} else
			throw new EmptyStackException();
			// end if
		return result;
	} // end peek
	
	
	/** Checks if array stack is empty
	 *  @return True if array stack is empty, false if not*/
	public boolean isEmpty() {
		return numberOfEntries == 0;
	} // end isEmpty
	
	/** Checks if array stack is full
	 * 	@return True if array stack is full, false if not*/
	public boolean isFull() {
		return numberOfEntries >= stack.length;
	} // end isFull
	
	/** Removes all entries from this stack. */
	public void clear() {
		for(int i = 0; i < stack.length; i++) {
			stack[i] = null;
		} // end for
		
		numberOfEntries = 0;
	} // end clear
}
