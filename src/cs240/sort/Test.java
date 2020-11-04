package cs240.sort;

import java.util.Random;

public class Test {
	private static SelectiveSort ss = new SelectiveSort();
	private static InsertionSort is = new InsertionSort();
	private static ShellSort shS 	= new ShellSort();
	private static MergeSort ms		= new MergeSort();
	private static QuickSort qs		= new QuickSort();
	private static RadixSort rs		= new RadixSort();
	
	public static int[] randArray(int size) {
		Random rng = new Random();
		int[] array = new int[size];
		for (int i = 0; i < array.length; i++) 
			array[i] = rng.nextInt(1000);
		
		return array;
	}
	
	public static void displayArray(int[] testArray) {
		System.out.print("{ ");
		for (int i = 0; i < testArray.length; i++)
			System.out.print(testArray[i] + " " );
		System.out.print("}\n");
	}
	
	public static void main(String[] args) {
		int arrayTen = 10;
		int arrayOneH = 100;
		int arrayOneK = 1000;
		int[] array1 = randArray(arrayTen);
		int[] array2 = randArray(arrayTen);
		int[] array3 = randArray(arrayTen);
		int[] array4 = randArray(arrayTen);
		int[] array5 = randArray(arrayTen);
		int[] array6 = randArray(arrayTen);
		int[] array10 = randArray(arrayOneH);
		int[] array20 = randArray(arrayOneH);
		int[] array30 = randArray(arrayOneH);
		int[] array40 = randArray(arrayOneH);
		int[] array50 = randArray(arrayOneH);
		int[] array60 = randArray(arrayOneH);
		int[] array100 = randArray(arrayOneK);
		int[] array200 = randArray(arrayOneK);
		int[] array300 = randArray(arrayOneK);
		int[] array400 = randArray(arrayOneK);
		int[] array500 = randArray(arrayOneK);
		int[] array600 = randArray(arrayOneK);
		
		// Array size 10 iterative test
		System.out.println("\nArray SIZE 10");
		ss.iterativeSort(array1);
		System.out.println("SS Compare: " + ss.getCompare() + " Move: " + ss.getMove());
		is.iterativeSort(array2);
		System.out.println("IS Compare: " + is.getCompare() + " Move: " + is.getMove());
		shS.iterativeSort(array3);
		System.out.println("Sh Compare: " + shS.getCompare() + " Move: " + shS.getMove());
		ms.mergeSort(array4);
		System.out.println("MS Compare: " + ms.getCompare() + " Move: " + ms.getMove());
		qs.quickSort(array5);
		System.out.println("QS Compare: " + qs.getCompare() + " Move: " + qs.getMove());
		rs.radixSort(array6);
		System.out.println("RS Compare: " + rs.getCompare() + " Move: " + rs.getMove());
		
		// Array size 100 iterative test
		System.out.println("\nArray SIZE 100");
		ss.iterativeSort(array10);
		System.out.println("SS Compare: " + ss.getCompare() + " Move: " + ss.getMove());
		is.iterativeSort(array20);
		System.out.println("IS Compare: " + is.getCompare() + " Move: " + is.getMove());
		shS.iterativeSort(array30);
		System.out.println("Sh Compare: " + shS.getCompare() + " Move: " + shS.getMove());
		ms.mergeSort(array40);
		System.out.println("MS Compare: " + ms.getCompare() + " Move: " + ms.getMove());
		qs.quickSort(array50);
		System.out.println("QS Compare: " + qs.getCompare() + " Move: " + qs.getMove());
		rs.radixSort(array60);
		System.out.println("RS Compare: " + rs.getCompare() + " Move: " + rs.getMove());
		
		// Array size 1000 iterative test
		System.out.println("\nArray SIZE 1000");
		ss.iterativeSort(array100);
		System.out.println("SS Compare: " + ss.getCompare() + " Move: " + ss.getMove());
		is.iterativeSort(array200);
		System.out.println("IS Compare: " + is.getCompare() + " Move: " + is.getMove());
		shS.iterativeSort(array300);
		System.out.println("Sh Compare: " + shS.getCompare() + " Move: " + shS.getMove());
		ms.mergeSort(array400);
		System.out.println("MS Compare: " + ms.getCompare() + " Move: " + ms.getMove());
		qs.quickSort(array500);
		System.out.println("QS Compare: " + qs.getCompare() + " Move: " + qs.getMove());
		rs.radixSort(array600);
		System.out.println("RS Compare: " + rs.getCompare() + " Move: " + rs.getMove());
	}
}
