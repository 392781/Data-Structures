package cs240.iterator;

public interface Iterator<T> {
	/** Detects whether this iterator has completed its traversal
	  *	and gone beyond the last entry in the collection of data.
	  *	@return true if the iterator has another entry to return */
	public boolean hasNext();
	
	/** Retrieves the next entry in the collection and
	  *	advances this iterator by one position.
	  *	@return a reference to the next entry in the iteration,
	  *	        if one exists
	  *	@throws NoSuchElementException if the iterator had reached the
	  *	        end already, that is, if hasNext() is false */
	public T next();
}
