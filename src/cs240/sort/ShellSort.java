package cs240.sort;

public class ShellSort {
	private int countMove = 0;
	private int countCompare = 0;
	
	/** Sorts the array using shell sort using hibbard's sequence
	 *  @param array Array to sort
	 *  @return Sorted array*/
	public int[] iterativeSort(int[] array) {
		int[] sequence = hibbardSequence(array.length);
		int sequenceValue = sequence.length - 1;
		int increment = sequence[sequenceValue];
		
		while (increment > 0) {
			for (int i = increment; i < array.length; i++) {
				int j = i;
				int temp = array[i];
				
				while (j >= increment && array[j - increment] > temp) {
					countCompare++;
					array[j] = array[j - increment];
					j = j - increment;
					countMove++;
				} // end while
				array[j] = temp;
			} // end for
			increment = sequence[sequenceValue--];
		} // end while
		return array;
	}
	
	public int[] recursiveSort(int[] array , int increment , int first ,int next) {
		int temp = 0;
		if (increment <= 0) 
			return array;
		else if (first < array.length) {
			if (next < array.length) {
				if (array[next] < array[first]) {
					temp = array[next];
					array[next] = array[first];
					array[first] = temp;
				}
				return recursiveSort(array, increment, first, next + increment);
			} else {
				return recursiveSort(array, increment, first + increment, first + (increment*2));
			}
		} else {
			increment = (increment - 1) / 2;
			return recursiveSort(array, increment, 0, increment);
		}
	}
	/** Generates hibbard's sequence for designated array size
	 *  @param arrayLength size of the array to be sorted
	 *  @return Generated sequence into an array*/
	public int[] hibbardSequence(int arrayLength) {
		int n = 1;
		int index = 1;
		int[] hibbardSequence;
		
		// determines size of sequence needed
		while (n < (arrayLength - 1) / 2) {
			n = (2 * n) + 1;
			index++;
		} // end while
		
		hibbardSequence = new int[index + 1];
		hibbardSequence[0] = 0;
		index = 1;
		n = 1;
		
		// generates sequence
		while (index < hibbardSequence.length) {
			hibbardSequence[index] = n;
			n = (2 * n) + 1;
			index++;
		} // end while
		
		// returns array of generated sequence
		return hibbardSequence;
	}
	
    public int getCompare() {
    	return countCompare;
    }
    
    public int getMove() {
    	return countMove;
    }
}
