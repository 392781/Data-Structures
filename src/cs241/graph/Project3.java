package cs241.graph;

import java.io.*;
import java.util.*;

public class Project3 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner kb = new Scanner(System.in);
		Scanner read1 = new Scanner(new File("city.dat"));
		Scanner read2 = new Scanner(new File("road.dat"));
		ArrayList<String> code = new ArrayList<String>();
		ArrayList<String> town = new ArrayList<String>();
		Digraph<Integer> graph = new Digraph<Integer>(20);
		
		int counter = 0;
		while (read1.hasNextLine()) {
			int temp = read1.nextInt();
			String cdName = read1.next();
			String info = read1.nextLine();
			System.out.println(temp + cdName + info);
			graph.setLabel(counter, temp);
			code.add(cdName);
			town.add(info);
		}
		
		
		while (read2.hasNextLine()) {
			int src = read2.nextInt();
			int trg = read2.nextInt();
			int dis = read2.nextInt();
			graph.addEdge(src, trg, dis);
		}
		
		read1.close();
		read2.close();
	}
}
