package cs240.iterator;

import java.util.Iterator;

public class ArrayListWithIterator<T> implements ListInterface<T> {
	private T[] list;
	private int listSize;
	private final int SIZE = 10;
	/** Creates an array list of size 10 */
	public ArrayListWithIterator() {
		@SuppressWarnings( "unchecked" )
		T[] tempList = (T[]) new Object[SIZE]; // Unchecked cast
        list = tempList;
        listSize = 0;
	} // end default constructor
	
	/** Adds a new entry to end of list
	 *  @param newEntry  an object to be added*/
	public void add(T newEntry) {
		if (listSize < 10) {
			list[listSize] = newEntry;
			listSize++;
		} else {
			System.out.println("List full! Remove some items.");
		} // end if
	} // end add

	/** Adds a new entry to specific position in list
	 * 	@param position  integer position specifying where 
	 * 					 entry will be added
	 * 	@param newEntry	 an object to be added
	 * 	@throws  IndexOutOfBoundsException*/
	public void add(int position, T newEntry) {
		if (position <= 9 && position >= 0) {
			@SuppressWarnings( "unchecked" )
			T[] tempList = (T[]) new Object[SIZE];
			int counter = 0;
			for (int i = 0; i < list.length; i++) {
				if (i == position) {
					tempList[i] = newEntry;
					listSize++;
				} else {
					tempList[i] = list[counter];
					counter++;
				} // end if
			} // end for
			list = tempList;
		} else if (listSize == 10) {
			System.out.println("List full! Remove some items.");
		} else {
			throw new ArrayIndexOutOfBoundsException();
		} // end if
	} // end add

	/** Removes an entry at the given position in the list
	 * 	@param position  integer position specifying the entry
	 * 					 to be removed
	 * 	@return  A reference to the removed entry
	 * 	@throws  IndexOutOfBoundsException*/
	public T remove(int position) {
		T result = null;
		if (position <= 9 && position >= 0) {
			result = list[position];
			list[position] = null;
			@SuppressWarnings( "unchecked" )
			T[] tempList = (T[]) new Object[SIZE];
			int counter = 0;
			for (int i = 0; i < list.length; i++) {
				if (list[i] != null) {
					tempList[i] = list[counter];
					counter++;
				} else {
					counter++;
				} // end if
			} // end for
			list = tempList;
			listSize--;
		} else {
			System.out.println("List size is 10, please choose position 0-9");
		} // end if
		return result;
	} // end remove

	/** Removes all entries from the list*/
	public void clear() {
		@SuppressWarnings( "unchecked" )
		T[] tempList = (T[]) new Object[SIZE];
		list = tempList;
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
		if (position <= 9 || position >= 0){
			result = list[position];
			list[position] = newEntry;
		} else {
			System.out.println("List size is 10, please choose position 0-9");
		} // end if
		return result;
	} // end replace

	/** Retrives the entry at a given position in this list
	 * 	@param position  integer position specifying the entry
	 * 					 to be returned
	 * 	@return  a reference to the indicated entry
	 * 	@throws  IndexOutOfBoundsException*/
	public T getEntry(int position) {
		if (position <= 9 || position >= 0){
			return list[position];
		} else {
			System.out.println("List size is 10, please choose position 0-9");
			return null;
		} // end if
	} // end getEntry

	/** Retries all entries that are in this list in the order
	 * 	that they appear in
	 * 	@return  an array of all the entries in the list*/
	public T[] toArray() {
		@SuppressWarnings( "unchecked" )
		T[] tempList = (T[]) new Object[SIZE];
		tempList = list.clone();
		return tempList;
	} // end toArray

	/** Checks whether the list contains a given entry
	 * 	@param anEntry  the object that is the desired entry
	 * 	@return  true if the list contains anEntry, else false*/
	public boolean contains(T anEntry) {
		for (int i = 0; i < listSize; i++) {
			if (anEntry.equals(list[i])) {
				return true;
			} // end if
		} // end for
		return false;
	} // end contains

	/** Gets the length of the list
	 * 	@return  integer number of entries in the list*/
	public int getLength() {
		return listSize;
	} // end getLength

	/** Sees whether the list is empty
	 * 	@return  true if the list is empty, else false*/
	public boolean isEmpty() {
		if (listSize == 0) {
			return true;
		} else {
			return false;
		} // end if
	} // end isEmpty
	
	public Iterator<T> getIterator() {
		return new IteratorArrayList();
	}
	
	private class IteratorArrayList implements Iterator<T> {
		private int position;
		private IteratorArrayList() {
			position = 0;
		}
		
		public boolean hasNext() {
			return position < listSize;
		}

		public T next() {
			T value = null;
			if (hasNext()) {
				value = list[position];
				position++;
			}
			return value;
		}
	}
}