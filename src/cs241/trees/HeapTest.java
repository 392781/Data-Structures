package cs241.trees;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class HeapTest {
	public static void main(String[] args) {
		System.out.println("Please select how to test the program:");
		System.out.println("[1] 20 sets of 100 randomly generated integers");
		System.out.println("[2] Fixed integer values 1-100");
		System.out.print("Choice: ");
		Scanner kb = new Scanner(System.in);
		int choice = kb.nextInt();
		
		if (choice == 1) {
			int avgS = 0;
			int avgR = 0;
			int rand;
			Random rng = new Random();
			
			for (int i = 0; i < 20; i++) {
				Vector<Integer> list = new Vector<Integer>();
				HeapSeq sequential = new HeapSeq();
				while (list.size() != 100) {
					rand = Math.abs((rng.nextInt()));
					if (!list.contains(rand)) {
						list.add(rand);
						sequential.add(rand);
					}
				}
				
				int[] arr = new int[100];
				for (int k = 0; k < list.size(); k++) {
					arr[k] = list.get(k);
				}
				
				HeapReh reheap = new HeapReh(arr);
				
				avgS += sequential.getSwaps();
				avgR += reheap.getSwaps();
			}
			
			avgS = avgS / 20;
			avgR = avgR / 20;
			
			System.out.println("\nAvg swaps sequential: " + avgS);
			System.out.println("Avg swaps optimal: " + avgR);
			
		} else if (choice == 2) {
			int swapsS;
			int swapsR;
			
			int[] arr = new int[100];
			int val = 1;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = val;
				val++;
			}
			
			HeapSeq sequential = new HeapSeq();
			HeapReh reheap = new HeapReh(arr);
			
			for (int i = 1; i <= 100; i++) {
				sequential.add(i);
			}
			
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
		kb.close();
	}
}
