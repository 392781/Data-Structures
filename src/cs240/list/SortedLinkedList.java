package cs240.list;

import cs240.list.SingleLinkedList;

public class SortedLinkedList<T extends Comparable<? super T>> implements SortedListInterface<T> {
	private ListInterface<T> list;
	
	/** Creates a sorted list*/
	public SortedLinkedList() {
		list = new SingleLinkedList<T>();
	} // end default constructor
	
	/** Adds a new entry to this sorted list in its proper order.
      * The list's size is increased by 1.
      * @param newEntry  The object to be added as a new entry. */
	public void add(T newEntry) {
		int position = Math.abs(getPosition(newEntry));
		list.add(position, newEntry);
	} // end add

	/** Removes the first or only occurrence of a specified entry
      * from this sorted list.
      * @param anEntry  The object to be removed.
      * @return  True if anEntry was located and removed; 
        		 otherwise returns false. */
	public boolean remove(T anEntry) {
		boolean result = false;
		int position = getPosition(anEntry);
		
		if (position > 0) {
			list.remove(position);
			result = true;
		}
		return result;
	} // end remove

	/** Gets the position of an entry in this sorted list.
      * @param anEntry  The object to be found.
      * @return  The position of the first or only occurrence of anEntry
        		 if it occurs in the list; otherwise returns the position
             	 where anEntry would occur in the list, but as a negative
             	 integer. */
	public int getPosition(T anEntry) {
		int position = 0;
		int length = list.getLength();
		
		while ( (position <= length) && (anEntry.compareTo(list.getEntry(position)) > 0))
			position++;
		// end while
		if ((position > length) || (anEntry.compareTo(list.getEntry(position)) != 0))
				position = -position;
		// end if
		return position;
	} // end getPosition

	public T getEntry(int givenPosition) {
		return list.getEntry(givenPosition);
	} // end getEntry

	public boolean contains(T anEntry) {
		return list.contains(anEntry);
	} // end contains

	public T remove(int givenPosition) {
		return list.remove(givenPosition);
	} // end remove

	public void clear() {
		list.clear();
	} // end clear

	public int getLength() {
		return list.getLength();
	} // end getLength

	public boolean isEmpty() {
		return list.isEmpty();
	} // end isEmpty

	public T[] toArray() {
		return list.toArray();
	} // end toArray
}
