package cs240.sort;

public class RadixSort {
	private int countMove = 0;
	private int countCompare = 0;
	
	/** Sorts the array using radix sort
	 * 	@param array Array to be sorted
	 * 	@return Sorted array*/
    public int[] radixSort(int[] array) {
        int m = array[0], exp = 1;
        int[] helper = new int[array.length];

        for (int i = 0; i < array.length; i++)
            if (array[i] > m) {
            	countCompare++;
                m = array[i];
            }
        while (m / exp > 0) {
            int[] bucket = new int[10];

            for (int i = 0; i < array.length; i++)
                bucket[(array[i] / exp) % 10]++;
            for (int i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            for (int i = array.length - 1; i >= 0; i--) {
                helper[--bucket[(array[i] / exp) % 10]] = array[i];
            	countMove++;
            }
            for (int i = 0; i < array.length; i++)
                array[i] = helper[i];
            exp *= 10;        
        }
        return array;
    }    
    
    public int getCompare() {
    	return countCompare;
    }
    
    public int getMove() {
    	return countMove;
    }
}