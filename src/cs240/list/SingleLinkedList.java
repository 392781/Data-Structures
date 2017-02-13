/** Single linked node implementation of ADT List
 * 	@author Ronald Lencevicius*/

package cs240.list;

public class SingleLinkedList<T> implements ListInterface<T> {
	private Node<T> front;
	private Node<T> back;
	private int listSize;
	
	/** Default constructor for single linked list*/
	public SingleLinkedList() {
		front = null;
		back = null;
		listSize = 0;
	} // end default constructor
	
	/** Adds a new entry to end of list
	 *  @param newEntry  an object to be added*/
	public void add(T newEntry) {
		Node<T> newNode = new Node<T>(newEntry, null);
		
		if (isEmpty())
			front = newNode;
		else
			back.setNextNode(newNode);
		// end if
		back = newNode;
		listSize++;
	} // end add

	/** Adds a new entry to specific position in list
	 * 	@param position  integer position specifying where 
	 * 					 entry will be added
	 * 	@param newEntry	 an object to be added
	 * 	@throws IndexOutOfBoundsException*/
	public void add(int position, T newEntry) {
		if (position < 0 || position > listSize) {
			throw new IndexOutOfBoundsException();
		} else if (position == listSize - 1) {
			add(newEntry);
			listSize++;
		} else if (position == 0) {
			Node<T> newNode = new Node<T>(newEntry, front);
			front = newNode;
			listSize++;
		} else if (position > 0 && position < listSize) {
			Node<T> nodeBefore = getNodeAt(position - 1);
			Node<T> nodeAfter = getNodeAt(position);
			Node<T> newNode = new Node<T>(newEntry, nodeAfter);
			nodeBefore.setNextNode(newNode);
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
		if (position < 0 || position > listSize) {
			throw new IndexOutOfBoundsException();
		} else if (position == 0) {
			front = front.getNextNode();
			listSize--;
		} else {
			Node<T> nodeBefore = getNodeAt(position - 1);
			Node<T> nodeToRemove = nodeBefore.getNextNode();
			result = nodeToRemove.getData();
			Node<T> nodeAfter = nodeToRemove.getNextNode();
			nodeBefore.setNextNode(nodeAfter);
			nodeToRemove = null;
			listSize--;
		} // end if
		return result;
	} // end remove

	/** Removes all entries from the list*/
	public void clear() {
		front = null;
		back = null;
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
		if (position < 0 || position > listSize) {
			throw new IndexOutOfBoundsException();
		} else if (position == 0) {
			result = front.getData();
			Node<T> newNode = new Node<T>(newEntry, front.getNextNode());
			front = newNode;
		} else {
			Node<T> nodeBefore = getNodeAt(position - 1);
			Node<T> nodeToReplace = getNodeAt(position);
			result = nodeToReplace.getData();
			Node<T> newNode = new Node<T>(newEntry, nodeToReplace.getNextNode());
			nodeBefore.setNextNode(newNode);
			nodeToReplace = null;
		} // end if
		return result;
	} // end replace

	/** Retrives the entry at a given position in this list
	 * 	@param position  integer position specifying the entry
	 * 					 to be returned
	 * 	@return  a reference to the indicated entry
	 * 	@throws  IndexOutOfBoundsException*/
	public T getEntry(int position) {
		return getNodeAt(position).getData();
	} // end getEntry

	/** Retries all entries that are in this list in the order
	 * 	that they appear in
	 * 	@return  an array of all the entries in the list*/
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[listSize];
		Node<T> currentNode = front;
		int index = 0;
		
		while ((index < listSize) && (currentNode != null)) {
			result[index] = currentNode.getData();
			currentNode = currentNode.getNextNode();
			index++;
		} // end while
		return result;
	} // end toArray

	/** Checks whether the list contains a given entry
	 * 	@param anEntry  the object that is the desired entry
	 * 	@return  true if the list contains anEntry, else false*/
	public boolean contains(T anEntry) {
		Node<T> currentNode = front;
		int index = 0;
		
		while (index < listSize) {
			if(currentNode.getData() == anEntry)
				return true;
			else {
				currentNode = currentNode.getNextNode();
				index++;
			} // end if
		} // end while
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
		return listSize == 0;
	} // end isEmpty
	
	/** Used locally in order to look through list
	 * 	@param position  integer position of node to be returned
	 * 	@return  Node at given position
	 * 	@throws IndexOutOfBoundsException*/
	private Node<T> getNodeAt(int position) {
		if (position < 0 || position > listSize) {
			throw new IndexOutOfBoundsException();
		} else {
			Node<T> currentNode = front;
			
			for (int i = 0; i < position; i++)
				currentNode = currentNode.getNextNode();
			return currentNode;
		}
	}
}
