package algorithms;

public abstract class Bubble<T>{
    public static <T extends Comparable<T>> void sortI(T[] arr) {
        boolean swap;

        for (int i = 0; i < arr.length; i++) {
            swap = false;

            for (int j = 0; j < arr.length; j++) {
                if (arr[i].compareTo(arr[i + 1]) > 1) {
                    swap(arr[i] , arr[i + 1]);
                    swap = true;
                }
            }

            if (swap == false) {
                break;
            }
        }

    }

    private static <T> void swap(T val1 , T val2) {
        T temp = val1;
        val1 = val2;
        val2 = temp;
    }
}
