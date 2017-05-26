package cs241.graph;

import java.io.*;
import java.util.*;

public class Project3 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner kb = new Scanner(System.in);
		Scanner read1 = new Scanner(new File("city.dat"));
		Scanner read2 = new Scanner(new File("road.dat"));
		ArrayList<String> code 		= new ArrayList<String>();
		ArrayList<String> name 		= new ArrayList<String>();
		ArrayList<Integer> data1 	= new ArrayList<Integer>();
		ArrayList<Integer> data2 	= new ArrayList<Integer>();
		Digraph<Integer> graph 		= new Digraph<Integer>(20);
		code.add(null);
		name.add(null);
		data1.add(null);
		data2.add(null);
		
		int counter = 0;
		while (read1.hasNext()) {
			int temp = read1.nextInt();
			String cdName = read1.next();
			String tnName = read1.next();
			if (!read1.hasNextInt()) {
				tnName += " " + read1.next();
			}
			int in1 = read1.nextInt();
			int in2 = read1.nextInt();
			
			graph.setLabel(counter, temp);
			code.add(cdName);
			name.add(tnName);
			data1.add(in1);
			data2.add(in2);
		}
		
		while (read2.hasNextLine()) {
			int src = read2.nextInt();
			int trg = read2.nextInt();
			int dis = read2.nextInt();
			graph.addEdge(src, trg, dis);
		}

		String value;
		boolean flag = false;
		while (!flag) {
			System.out.print("Command? ");
			value = kb.next();
			switch (value) {
				case "Q" : {
					System.out.print("City Code: ");
					String val = kb.next();
					int index = code.indexOf(val);
					System.out.println(index + " " + code.get(index) + " " + name.get(index) + " "
									+ data1.get(index) + " " + data2.get(index));
					break;
				} case "D" : {
					System.out.print("City Codes: ");
					String val1 = kb.next();
					String val2 = kb.next();
					int id1 = code.indexOf(val1);
					int id2 = code.indexOf(val2);
					Stack<Integer> trace = graph.dijkstra(id1, id2);
					
					System.out.print("The minimum distance between " + name.get(id1) + " and " 
									+ name.get(id2) + " is " + graph.getDistance(id2) 
									+ " through route: ");
					if (trace != null) {
						while (!trace.isEmpty()) {
							int temp = trace.pop();
							System.out.print(code.get(temp) + " ");
						}
						System.out.println();
					}
					break;
				} case "I" : {
					System.out.print("City Codes and Distance: ");
					String val1 = kb.next();
					String val2 = kb.next();
					int id1 = code.indexOf(val1);
					int id2 = code.indexOf(val2);
					int dist = kb.nextInt();
					
					if (graph.isEdge(id1, id2)) {
						System.out.println("Edge already exists, remove before changing");
						break;
					}
					
					graph.addEdge(id1, id2, dist);
					System.out.println("You have inserted a road from " + name.get(id1) + " to " 
									+ name.get(id2) + " with a distance of " + dist + ".");
					break;
				} case "R" : {
					System.out.print("City Codes: ");
					String val1 = kb.next();
					String val2 = kb.next();
					int id1 = code.indexOf(val1);
					int id2 = code.indexOf(val2);
					
					if (!graph.isEdge(id1, id2)) {
						System.out.println("The road from " + name.get(id1) + " to " + name.get(id2)
									+ " doesn't exist.");
						break;
					}
					
					graph.removeEdge(id1, id2);
					System.out.println("You have removed the road from " + name.get(id1) + " to " 
									+ name.get(id2));
					break;
				} case "H" : {
					System.out.println("Q Query the city information by entering the city code. "
									+ "\nD Find the minimum distance between two cities. "
									+ "\nI Insert a road by entering two city codes and distance. "
									+ "\nR Remove an existing road by entering two city codes. "
									+ "\nH Display this message. "
									+ "\nE Exit. ");
					break;
				} case "E" : {
					flag = true;
					break;
				} default : {
					value = "H";
				}
			}
		}
		read1.close();
		read2.close();
		kb.close();
	}
}
