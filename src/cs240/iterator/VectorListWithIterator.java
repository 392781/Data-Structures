/** Vector implementation of ADT List
 * 	@author Ronald Lencevicius*/

package cs240.iterator;

import java.util.Iterator;
import java.util.Vector; 

public class VectorListWithIterator<T> implements ListInterface<T> {
	private Vector<T> list;
	private int listSize;
	private static final int SIZE = 10;
	private static final int INCREMENT = 10;
	
	/** Creates a vector of size 10 that increments by 10 
	 *  when the vector is resized upward*/
	public VectorListWithIterator() {
		Vector<T> tempStack = new Vector<T>(SIZE , INCREMENT);
		list = tempStack;
		listSize = 0;
	} // end default constructor
	
	/** Adds a new entry to end of list
	 *  @param newEntry  an object to be added*/
	public void add(T newEntry) {
		list.add(newEntry);
		listSize++;
	} // end add

	/** Adds a new entry to specific position in list
	 * 	@param position  integer position specifying where 
	 * 					 entry will be added
	 * 	@param newEntry	 an object to be added
	 * 	@throws  IndexOutOfBoundsException*/
	public void add(int position, T newEntry) {
		if (position < 0 || position > listSize) 
			throw new IndexOutOfBoundsException();
		else {
			list.add(position, newEntry);
			listSize++;
		} // end if
	} // end add

	/** Removes an entry at the given position in the list
	 * 	@param position  integer position specifying the entry
	 * 					 to be removed
	 * 	@return  A reference to the removed entry
	 * 	@throws  IndexOutOfBoundsException*/
	public T remove(int position) {
		T result = null;
		if (position < 0 || position > listSize)
			throw new IndexOutOfBoundsException();
		else {
			result = list.elementAt(position);
			list.remove(position);
			listSize--;
		} // end if
		return result;
	} // end remove

	/** Removes all entries from the list*/
	public void clear() {
		list.removeAllElements();
		Vector<T> tempStack = new Vector<T>(SIZE , INCREMENT);
		list = tempStack;
		listSize = 0;
	} // end clear

	/** Replaces the entry at the given position in the list
	 * 	@param position  integer position specifying the entry
	 * 					 to be removed
	 * 	@param newEntry	 the object that will replace the entry
	 * 	@return  the original entry that was replaced
	 * 	@throws  IndexOutOfBoundsException*/
	public T replace(int position, T newEntry) {
		T result = null;
		if (position < 0 || position > listSize)
			throw new IndexOutOfBoundsException();
		else {
			result = list.elementAt(position);
			list.setElementAt(newEntry, position);
		} // end if
		return result;
	} // end replace

	/** Retrives the entry at a given position in this list
	 * 	@param position  integer position specifying the entry
	 * 					 to be returned
	 * 	@return  a reference to the indicated entry
	 * 	@throws  IndexOutOfBoundsException*/
	public T getEntry(int position) {
		T result = null;
		if (position < 0 || position > listSize) {
			throw new IndexOutOfBoundsException();
		} else {
			result = list.elementAt(position);
		} // end if
		return result;
	} // end getEntry

	/** Retries all entries that are in this list in the order
	 * 	that they appear in
	 * 	@return  an array of all the entries in the list*/
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[listSize];
		list.copyInto(result);
		return result;
	} // end toArray

	/** Checks whether the list contains a given entry
	 * 	@param anEntry  the object that is the desired entry
	 * 	@return  true if the list contains anEntry, else false*/
	public boolean contains(T anEntry) {
		return list.contains(anEntry);
	} // end contains

	/** Gets the length of the list
	 * 	@return  integer number of entries in the list*/
	public int getLength() {
		return listSize;
	} // end getLength

	/** Sees whether the list is empty
	 * 	@return  true if the list is empty, else false*/
	public boolean isEmpty() {
		return listSize == 0;
	} // end isEmpty
	
	public Iterator<T> getIterator() {
		return new IteratorVectorList();
	}
	
	private class IteratorVectorList implements Iterator<T> {
		private int position;
		private IteratorVectorList() {
			position = 0;
		}
		
		public boolean hasNext() {
			return position < list.size();
		}

		public T next() {
			T value = null;
			if (hasNext()) {
				value = list.elementAt(position);
				position++;
			}
			return value;
		}
	}
}
