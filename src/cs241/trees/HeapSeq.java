
package cs241.trees;

public class HeapSeq {
	private int[] data;
	private int last;
	private int swaps;
	private final int NECESSARY_SIZE = 101;
	
	public int getSwaps() {
		return swaps;
	}
	public HeapSeq() {
		data = new int[NECESSARY_SIZE];
		last = 0;
		swaps = 0;
	}
	
	public void add(int val) {
		last++;
		data[last] = val;
		int cursor = last;
		while (cursor > 1) {
			int parent = cursor / 2;
			if (data[parent] < data[cursor]) {
				int tmp = data[parent];
				data[parent] = data[cursor];
				data[cursor] = tmp;
				swaps++;
			}
			cursor = cursor / 2;
		}
	}
	
	public int remove() {
		int cursor 	= 1;
		int val 	= data[cursor];
		data[cursor] = data[last];
		data[last] = 0;
		last--;
		
		while (cursor <= last && cursor * 2 + 1 <= last) {
			int left 	= cursor * 2;
			int right 	= cursor * 2 + 1;
			
			if (data[right] > data[left] && data[right] > data[cursor]) {
				int tmp = data[cursor];
				data[cursor] = data[right];
				data[right] = tmp;
				cursor = cursor * 2 + 1;
				swaps++;
			} else if (data[right] < data[left] && data[left] > data[cursor]) {
				int tmp = data[cursor];
				data[cursor] = data[left];
				data[left] = tmp;
				cursor = cursor * 2;
				swaps++;
			} else {
				break;
			}
		}
		
		return val;
	}
	
	public String toString() {
		String res = "[";
		for(int i = 1; i <= 10; i++) {
			res += data[i] + "  ";
		}
		res += "]";
		return res;
	}
}
