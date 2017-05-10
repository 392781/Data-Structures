package cs241.trees;

public class HeapReh {
	private int[] data;
	private int last;
	private int swaps;
	private final int NECESSARY_SIZE = 101;
	
	public int getSwaps() {
		return swaps;
	}
	
	public HeapReh(int[] arr) {
		data = new int[NECESSARY_SIZE];
		last = 0;
		for (int i = 0; i < arr.length; i++) {
			data[i + 1] = arr[i];
			last++;
		}
		
		for (int i = last / 2; i > 0; i--) {
			reheap(i);
		}
	}
	
	public int remove() {
		int val = data[1];
		data[1] = data[last];
		last--;
		reheap(1);
		return val;
	}
	
	private void reheap(int index) {
		int cursor = index;
		while (cursor < last) {
			int left = cursor * 2;
			int right = cursor * 2 + 1;
			int larger = left;
			if (right <= last && data[right] > data[larger]) 
				larger = right;
			if (larger <= last && data[larger] > data[cursor]) {
				int tmp = data[larger];
				data[larger] = data[cursor];
				data[cursor] = tmp;
				cursor = larger;
				swaps++;
			} else {
				break;
			}
		}
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
