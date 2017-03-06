package cs240.test;

import cs240.list.*;

public class Test {
	public static void main(String[] args) {
		SingleLinkedList<Object> AL = new SingleLinkedList<Object>();
		
		AL.add(1);
		AL.add(2);
		AL.add(3);
		AL.add(4);
		AL.add(5);
		System.out.print("\n{ ");
		for(int i = 0; i < AL.getLength(); i++) {
			System.out.print(AL.getEntry(i) + " ");
		}System.out.print("}\n");
		
		AL.add(2, "h");
		System.out.println(AL.contains("h"));
	//	AL.replace(2, "x");
	//	AL.clear();
		
		System.out.print("\n{ ");
		for(int i = 0; i < AL.getLength(); i++) {
			System.out.print(AL.getEntry(i) + " ");
		}System.out.print("}");
		
		System.out.println("Position 5: " + AL.getEntry(5));
		
	}
}
