package cs240.sort;

public class MergeSort {
	private int countMove = 0;
	private int countCompare = 0;
    private int[] numbers;
    private int[] helper;

    private int number;

    /** Sorts the values
     *  @param array Array to be sorted 
     *  @return Sorted array*/
    public int[] mergeSort(int[] array) {
            this.numbers = array;
            number = array.length;
            this.helper = new int[number];
            sort(0, number - 1);
            return numbers;
    }

    /** Splits and merges the array
     * 	@param low Lower bound to start sort at
     * 	@param high Upper bound to sort to */
    private void sort(int low, int high) {
            // check if low is smaller then high, if not then the array is sorted
            if (low < high) {
                    // Get the index of the element which is in the middle
                    int middle = low + (high - low) / 2;
                    // Sort the left side of the array
                    sort(low, middle);
                    // Sort the right side of the array
                    sort(middle + 1, high);
                    // Combine them both
                    merge(low, middle, high);
            }
    }
    
    /** Sorts and merges the split values
     * 	@param low Lower bound to start sort at
     *  @param middle Lower/Upper bound depending on array split
     *  @param high Upper bound of left side of array*/
    private void merge(int low, int middle, int high) {
    	// Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
        	helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
        	if (helper[i] <= helper[j]) {
        		countCompare++;
                numbers[k] = helper[i];
                i++;
                countMove++;
            } else {
            	countCompare++;
                numbers[k] = helper[j];
                j++;
                countMove++;
            }
            	k++;
            }
            // Copy the rest of the left side of the array into the target array
            while (i <= middle) {
            	numbers[k] = helper[i];
            	countMove++;
                k++;
                i++;
            }
    }
    
    public int getCompare() {
    	return countCompare;
    }
    
    public int getMove() {
    	return countMove;
    }
}
