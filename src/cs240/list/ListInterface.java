/** Interface for ADT List
 * 	@author Ronald Lencevicius*/

package cs240.list;

public interface ListInterface<T> {
	
	/** Adds a new entry to end of list
	 *  @param newEntry  an object to be added*/
	public void add(T newEntry);
	
	/** Adds a new entry to specific position in list
	 * 	@param position  integer position specifying where 
	 * 					 entry will be added
	 * 	@param newEntry	 an object to be added
	 * 	@throws  IndexOutOfBoundsException*/
	public void add(int position, T newEntry);
	
	/** Removes an entry at the given position in the list
	 * 	@param position  integer position specifying the entry
	 * 					 to be removed
	 * 	@return  A reference to the removed entry
	 * 	@throws  IndexOutOfBoundsException*/
	public T remove(int position);
	
	/** Removes all entries from the list*/
	public void clear();
	
	/** Replaces the entry at the given position in the list
	 * 	@param position  integer position specifying the entry
	 * 					 to be removed
	 * 	@param newEntry	 the object that will replace the entry
	 * 	@return  the original entry that was replaced
	 * 	@throws  IndexOutOfBoundsException*/
	public T replace(int position, T newEntry);
	
	/** Retrives the entry at a given position in this list
	 * 	@param position  integer position specifying the entry
	 * 					 to be returned
	 * 	@return  a reference to the indicated entry
	 * 	@throws  IndexOutOfBoundsException*/
	public T getEntry(int position);
	
	/** Retries all entries that are in this list in the order
	 * 	that they appear in
	 * 	@return  an array of all the entries in the list*/
	public T[] toArray();
	
	/** Checks whether the list contains a given entry
	 * 	@param anEntry  the object that is the desired entry
	 * 	@return  true if the list contains anEntry, else false*/
	public boolean contains(T anEntry);
	
	/** Gets the length of the list
	 * 	@return  integer number of entries in the list*/
	public int getLength();
	
	/** Sees whether the list is empty
	 * 	@return  true if the list is empty, else false*/
	public boolean isEmpty();
} // end ListInterface
