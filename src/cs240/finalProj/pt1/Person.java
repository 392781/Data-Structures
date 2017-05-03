package cs240.finalProj.pt1;

import java.util.Vector;

import cs240.dictionary.*;
import cs240.queue.*;
import cs240.stack.*;

/*************************************************************************
Winter 2017 CS 240 Programming Exam : Person

Author: <Ronald Lencevicius>      

Dependencies: Stack, Queue, Dictionary

Description:  Models a person, a list of messages that they can
             read, and a list of their friends, so that when you
             post a message, all your friends can read it too.

**************************************************************************/
// 	Messages will be stored in a stack
//	Friends of person in a dictionary:
//		Key = Person, Values = Friends
public class Person { 
	private Dictionary<String,Person> friendsList;
	private VectorStack<String> messageList;
	private String person;
	// Create a new Person with this name.
	public Person(String name) {
		friendsList = new Dictionary<String,Person>();
		friendsList.add(name, null);
		person = name;
		messageList = new VectorStack<String>();
	}

	// Make these two people become friends with each other.
	// Throw an exception if you try to meet yourself.
	// We are allowed to assume we didn't meet this person yet.
	public void meet(Person otherPerson) {
		if (otherPerson.person != this.person) {
			friendsList.add(person, otherPerson);
		} else {
			throw new RuntimeException("Can't be your own friend");
		}
	}

	// Are these two people friends?
	// Throw an exception if you ask about knowing yourself.
	public boolean knows(Person otherPerson) {
		if (otherPerson.person != this.person) {
			Vector<Person> friends = friendsList.getValue(person);
			int i = 1;
			if (otherPerson == friends.elementAt(i)) {
				return true;
			}
		} else {
			throw new RuntimeException("Cannot check if you know yourself");
		}
		return false;
	}

	// Post a message to my list and the lists of all my friends
	public void post(String message) {
		messageList.push(message);
		int i = 1;
		while (i < friendsList.getValue(person).size()) {
			friendsList.getValue(person).elementAt(i).messageList.push(message);
			i++;
		}
	}

	// Print a header, then all messages this Person can read, newest first
	public void listMessages() {
		System.out.println("== The wall of " + person + " ==");
		while (!messageList.isEmpty()) {
			System.out.println(messageList.pop());
		}
	}
}