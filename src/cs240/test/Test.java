package cs240.test;

import cs240.list.*;
import cs240.finalProj.pt1.*;
import cs240.queue.*;
import cs240.stack.*;

import cs240.dictionary.*;

public class Test {
	public static void main(String[] args) {
		Person adam = new Person("Adam");
		Person susan = new Person("Susan");
		
		adam.meet(susan);
		System.out.println(adam.knows(susan));
		adam.post("hello world");
		adam.listMessages();
		susan.listMessages();
	}
}
