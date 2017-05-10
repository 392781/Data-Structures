package cs241.trees;

import java.util.Scanner;
import java.util.Vector;

public class HeapTest {
	public static void main(String[] args) {
		int swaps = 0;
		
		System.out.println("Please select how to test the program:");
		System.out.println("[1] 20 sets of 100 randomly generated integers");
		System.out.println("[2] Fixed integer values 1-100");
		System.out.print("Choice: ");
		Scanner kb = new Scanner(System.in);
		int choice = kb.nextInt();
		
		if (choice == 1) {
			
		} else if (choice == 2) {
			int swapsS;
			int swapsR;
			
			Vector<Integer> list = new Vector<Integer>();
			int[] arr = new int[100];
			int val = 1;
			for (int i : list) {
				list.add(val++);
			}
			
			HeapSeq sequential = new HeapSeq();
			HeapReh reheap = new HeapReh(arr);
			
			for (int i = 1; i <= 100; i++) {
				sequential.add(i);
			}
			
//			for (int i = 0; i < arr.length; i++) {
//				sequential.add(arr[i]);
//			}
			
			swapsS = sequential.getSwaps();
			swapsR = reheap.getSwaps();
			
			System.out.println("\nSequential: " + sequential.toString());
			System.out.println("Swaps: " + swapsS);
			for (int i = 0; i < 10; i++) { sequential.remove(); }
			System.out.println("After 10 removals: " + sequential.toString() + "\n");
			
			System.out.println("Optimal: " + reheap.toString());
			System.out.println("Swaps: " + swapsR);
			for (int i = 0; i < 10; i++) { reheap.remove(); }
			System.out.println("After 10 removals: " + reheap.toString());
		}
	}
}
