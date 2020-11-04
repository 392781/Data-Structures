package cs240.sort;

public class SelectiveSort {
	private int countMove = 0;
	private int countCompare = 0;
	
	/** Iterative selection sort
	 * 	@return Sorted array*/
    public int[] iterativeSort(int[] array) {
    	int temp; 			// used for switching
    	int smallest = 0; 	// sets index of smallest value
    	for (int i = 0; i < array.length; i++) {
            	smallest = i;
            	
            	// finds index of smallest value
            	for (int j = i; j < array.length; j++){
            		if (array[j] < array[smallest]){
            			countCompare++;
            			smallest = j;
                    } // end if
                } // end for

            	// swaps smallest value into correct position
                temp                    = array[smallest];
                array[smallest]         = array[i];
                array[i]                = temp;
                countMove++;
    	} // end for
    	return array;
    } // end iterativeSort
    
    /** Recursive selection sort
     * 	@return Sorted array*/
    public int[] recursiveSort(int[] array, int index) {
        if (index == array.length - 1) {
            return array;
        } // end if
        
        int temp, smallest = index;
        
        for (int i = index + 1; i < array.length; i++) {
            // finds index of smallest value
        	if (array[i] < array[smallest]) {
                smallest = i;
            } // end if
        } // end for
        
        // swaps smallest value into correct position
        temp = array[index];
        array[index] = array[smallest];
        array[smallest] = temp;
        // recursive call
        return recursiveSort(array, index + 1);
    } // end recursiveSort
    
    public int getCompare() {
    	return countCompare;
    }
    
    public int getMove() {
    	return countMove;
    }
}