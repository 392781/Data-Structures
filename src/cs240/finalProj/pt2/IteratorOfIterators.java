package cs240.finalProj.pt2;
import java.util.Iterator;

import cs240.iterator.*;


public class IteratorOfIterators<T> implements Iterator<T> {
	private VectorStackWithIterator<VectorStackWithIterator> L1 = new VectorStackWithIterator<VectorStackWithIterator>();
	private ArrayQueueWithIterator<ArrayQueueWithIterator> L2 = new ArrayQueueWithIterator<ArrayQueueWithIterator>();
	private VectorListWithIterator<VectorListWithIterator> L3 = new VectorListWithIterator<VectorListWithIterator>();
	private int lPosition = 0;
	private int iPosition = 0;
	private Iterator<VectorStackWithIterator> L1Iterator;
	private Iterator<ArrayQueueWithIterator> L2Iterator;
	private Iterator<VectorListWithIterator> L3Iterator;
	
	public IteratorOfIterators() {
		L1.push(new VectorStackWithIterator<Object>());
		L1.push(new VectorStackWithIterator<Object>());
		L1.push(new VectorStackWithIterator<Object>());
		
		L2.enqueue(new ArrayQueueWithIterator<Object>());
		L2.enqueue(new ArrayQueueWithIterator<Object>());
		L2.enqueue(new ArrayQueueWithIterator<Object>());
		
		L3.add(new VectorListWithIterator<Object>());
		L3.add(new VectorListWithIterator<Object>());
		L3.add(new VectorListWithIterator<Object>());
		
		L1Iterator = L1.getIterator();
		L2Iterator = L2.getIterator();
		L3Iterator = L3.getIterator();
		
	}
	
	public boolean hasNext() {
		return lPosition < 3;
	}

	public T next() {
		T value = null;
		if (hasNext()) {
			if (lPosition == 0) {
				@SuppressWarnings("unchecked")
				Iterator<Object>i1Iterator = L1Iterator.next().getIterator();
				
				
			}
		}
		return null;
	}
	
}
