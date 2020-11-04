package cs240.sort;

public class QuickSort {
	private int countMove = 0;
	private int countCompare = 0;
	private int[] numbers;
    private int number;

    public int[] quickSort(int[] array) {
            // check for empty or null array
            if (array == null || array.length == 0) {
                    return null;
            }
            this.numbers = array;
            number = array.length;
            sort(0, number - 1);
            return numbers;
    }

    private void sort(int low, int high) {
    	int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
        	while (numbers[i] < pivot) {
        		countCompare++;    
                   	i++;
            }

            while (numbers[j] > pivot) {
               	countCompare++;
                j--;
            }

            if (i <= j) {
              	exchange(i, j);
               	countMove++;
               	i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
        	sort(low, j);
        
            if (i < high)
            	sort(i, high);
    }

    private void exchange(int i, int j) {
    	int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
    
    public int getCompare() {
    	return countCompare;
    }
    
    public int getMove() {
    	return countMove;
    }
}
