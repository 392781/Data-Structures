package cs240.sort;

public class InsertionSort {
	private int countMove = 0;
	private int countCompare = 0;
	
	/** Iterative insertion sort
	 * 	@param Integer array to sort
	 * 	@return Sorted array*/
	public int[] iterativeSort(int[] array) {
		int j, temp;
		for (int i = 1; i < array.length; i++) {
			j = i;
			while (j > 0 && array[j] < array[j - 1]){
				countCompare++;
				temp = array[j];
				array[j] = array[j - 1];
				array[j - 1] = temp;
				j = j - 1;
				countMove++;
			} // end while
		} // end for
		// returns sorted array
		return array;
	}
	
	/** Recursive insertion sort
	 * 	@param array array to be sorted 
	 * 	@param arrayLength length of array
	 * 	@return Sorted array*/
	public int[] recursiveSort(int[] array, int sortedIndex, int index) {
        if (sortedIndex < array.length) {
            if (index < array.length) {
                if (array[sortedIndex] > array[index]) {
                    array[sortedIndex] += array[index];
                    array[index] = array[sortedIndex] - array[index];
                    array[sortedIndex] = array[sortedIndex] - array[index];
                }
                recursiveSort(array, sortedIndex, index + 1);
                return array;
            }
            if (index == array.length) {
                sortedIndex++;
            }
            recursiveSort(array, sortedIndex, sortedIndex + 1);
        }
        return null;
    }
	
    public int getCompare() {
    	return countCompare;
    }
    
    public int getMove() {
    	return countMove;
    }
}
