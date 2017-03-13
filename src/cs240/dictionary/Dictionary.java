package cs240.dictionary;

import java.util.Iterator;
import java.util.Vector;

public class Dictionary<K , V> implements DictionaryInterface<K , V> {
	private Vector<Entry> dictionary;
	private int numberOfKeys;
	
	public Dictionary() {
		dictionary = new Vector<Entry>();
		numberOfKeys = 0;
	}
	
	public V add(K key, V value) {
		V result = null;
		
		if (!contains(key)) {
			Entry newEntry = new Entry(key, value);
			dictionary.addElement(newEntry);
			result = dictionary.lastElement().getValues().lastElement();
			numberOfKeys++;
		} else if (contains(key)) {
			int index = getKeyIndex(key);
			dictionary.elementAt(index).addValue(value);
			result = dictionary.elementAt(index).getValues().lastElement();
		}
		
		return result;
	}

	public Vector<V> remove(K key) {
		Vector<V> result = null;
		
		if (contains(key)) {
			int keyIndex = getKeyIndex(key);
			result = dictionary.elementAt(keyIndex).getValues();
			dictionary.remove(keyIndex);
			numberOfKeys--;
		}
		
		return result;
	}
	
	public Vector<V> getValue(K key) {
		Vector<V> result = null;
		
		if (contains(key)) {
			int keyIndex = getKeyIndex(key);
			result = dictionary.elementAt(keyIndex).getValues();
		}
		
		return result;
	}

	public boolean contains(K key) {
		int i = 0;
		Entry testEntry;
		
		while (i < numberOfKeys) {
			testEntry = dictionary.get(i);
			if (key.equals(testEntry.getKey())) {
				return true;
			} else {
				i++;
			}
		}
		
		return false;
	}
	
	private int getKeyIndex(K key) {
		int index = -1;
		int i = 0;
		Entry testEntry;
		
		while (i < numberOfKeys) {
			testEntry = dictionary.get(i);
			if (key.equals(testEntry.getKey())) {
				index = i;
				break;
			} else {
				i++;
			}
		}
		
		return index;
	}

	private class KeyIterator implements Iterator<K> {
		private int keyPosition;
		
		public KeyIterator() {
			keyPosition = 0;
		}
		public boolean hasNext() {
			return keyPosition < numberOfKeys;
		}

		public K next() {
			K key = null;
			
			if (hasNext()) {
				key = dictionary.elementAt(keyPosition).getKey();
				keyPosition++;
			}
			
			return key;
		}
	}
	
	public Iterator<K> getKeyIterator() {
		return new KeyIterator();
	}

	private class ValueIterator implements Iterator<V> {
		private int keyPosition;
		private int valPosition;
		
		public ValueIterator() {
			keyPosition = 0;
			valPosition = 0;
		}
		
		public boolean hasNext() {
			return keyPosition + 1 < numberOfKeys;
		}

		public V next() {
			V val = null;
		
			if (!hasNext()) {
				return val = null;
			} else if (!(valPosition < dictionary.elementAt(keyPosition).getValues().size())) {
				keyPosition+= 1;
				valPosition = 0;
			} else if (keyPosition == dictionary.size() && 
					   valPosition == dictionary.elementAt(keyPosition).getValues().size()) {
				val = dictionary.elementAt(keyPosition).getValues().elementAt(valPosition);
				keyPosition++;
				return val;
			}
			
			val = dictionary.elementAt(keyPosition).getValues().elementAt(valPosition);
			valPosition++;
			return val;
		}
		
	}
	
	public Iterator<V> getValueIterator() {
		return new ValueIterator();
	}

	public boolean isEmpty() {
		return numberOfKeys == 0;
	}

	public int getSize() {
		return numberOfKeys;
	}

	public void clear() {
		dictionary.clear();
		numberOfKeys = 0;
	}
	
	private class Entry {
		private K key;
		private Vector<V> values = new Vector<V>();
		
		private Entry(K key, V value) {
			this.key = key;
			values.addElement(value);
		}
		
		private K getKey() {
			return key;
		}
		
		
		private Vector<V> getValues() {
			@SuppressWarnings("unchecked")
			Vector<V> exportValues = (Vector<V>) values.clone();
			return exportValues;
		}
		
		private void addValue(V newValue) {
			values.addElement(newValue);
		}
	}
}
