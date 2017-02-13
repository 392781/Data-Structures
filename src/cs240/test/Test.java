package cs240.test;

import cs240.list.*;

public class Test {
	public static void main(String[] args) {
		SingleLinkedList<Object> SLL = new SingleLinkedList<Object>();
		
		SLL.add(1);
		SLL.add(2);
		SLL.add(3);
		SLL.add(4);
		SLL.add(5);
		System.out.print("\n{ ");
		for(int i = 0; i < SLL.getLength(); i++) {
			System.out.print(SLL.getEntry(i) + " ");
		}System.out.print("}\n");
		
		SLL.add(2, "h");
		System.out.println(SLL.contains("h"));
		SLL.replace(2, "x");
		SLL.clear();
		
		System.out.print("\n{ ");
		for(int i = 0; i < SLL.getLength(); i++) {
			System.out.print(SLL.getEntry(i) + " ");
		}System.out.print("}");
		
	}
}
