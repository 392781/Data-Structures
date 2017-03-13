package cs240.test;

import cs240.list.*;
import cs240.queue.*;
import cs240.stack.*;

import java.util.Iterator;

import cs240.dictionary.*;

public class Test {
	public static void main(String[] args) {
		Dictionary<Object, Object> D = new Dictionary<Object, Object>();
	
		D.add(1, 'a');
		D.add(1, 'b');
		D.add(2, 'c');
		D.add(3, 'D');
		
		Iterator<Object> k = D.getKeyIterator();
		Iterator<Object> v = D.getValueIterator();
		
		System.out.println(v.hasNext());
		System.out.println(v.next());
		System.out.println(v.hasNext());
		
		System.out.println(v.next());
		System.out.println(v.hasNext());
		
		System.out.println(v.next());
		System.out.println(v.hasNext());
		
		System.out.println(v.next());
		System.out.println(v.hasNext());
		
		System.out.println(v.next());
		System.out.println(v.hasNext());
		
		System.out.println(v.next());
		System.out.println(v.hasNext());
		
		System.out.println(v.next());
		System.out.println(v.hasNext());
	}
}
