package cs240.test;

import cs240.queue.*;

public class Test {
	public static void main(String[] args) {
		CircularLinkedQueue<Object> cdt = new CircularLinkedQueue<>();
		
		cdt.enqueue(1);
		cdt.enqueue(2);
		cdt.enqueue(1);
		cdt.clear();
		cdt.dequeue();

		
	}
}
