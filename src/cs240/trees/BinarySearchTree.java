package cs240.trees;

import java.util.Scanner;

public class BinarySearchTree {
	TreeNode<Integer> root;
	
	public BinarySearchTree(TreeNode<Integer> root) {
		this.root = root;
	}
	
	public void add(int data) {
		if (root == null) {
			root = new TreeNode<Integer>(data);
		} else {
			add(root, data);
		}
	}
	
	private void add(TreeNode<Integer> root, int data) {
		if (data <= root.getData()) {
			if (root.getLeftChild() == null) {
				root.setLeftChild(new TreeNode<Integer>(data));
			} else {
				add(root.getLeftChild(), data);
			}
		} else {
			if (root.getRightChild() == null) {
				root.setRightChild(new TreeNode<Integer>(data));
			} else {
				add(root.getRightChild(), data);
			}
		}
	}
	
	public void Remove(int removeData){
		if(root.getData() == removeData){
			throw new RuntimeException("dont delete root :P");
			}
		Remove(root, removeData, null);
	}
	
	private void Remove(TreeNode<Integer> root, int removeData, TreeNode<Integer> parent){
		if(root == null ){
			System.out.println("does not exist");
		}
		else if(root.getData() == removeData){
			//case 1 is leaf
			if(root.getLeftChild() == null && root.getRightChild() == null){
				System.out.println("case 1");
				if(parent.getLeftChild() != null){
					if(parent.getLeftChild().getData() == removeData){
						parent.setLeftChild(null);
					}
					else{
						parent.setRightChild(null);
					}
				}
				else{
					parent.setRightChild(null);
				}
			}
			//case 2 no left
			else if(root.getLeftChild() == null){
				System.out.println("case 2");
				if(parent.getLeftChild() != null){
					if(parent.getLeftChild().getData() == removeData){
						parent.setLeftChild(root.getRightChild());
					}
					else{
						parent.setRightChild(root.getRightChild());
					}
				}
				else{
					parent.setRightChild(root.getRightChild());
				}
			}
			//casse 3 no right
			else if(root.getRightChild() == null){
				System.out.println("case 3");
				if(parent.getLeftChild() != null){
					if(parent.getLeftChild().getData() == removeData){
						parent.setLeftChild(root.getLeftChild());
					}
					else{
						parent.setRightChild(root.getLeftChild());
					}
				}
				else{
					parent.setRightChild(root.getLeftChild());
				}
			}
			//case 4 two nodes
			else{
				System.out.println("case 4");
					root.setData(root.getLeftChild().RightMost().getData());
					if(root.getLeftChild().RightMost().getLeftChild() == null){
//						root.GetLeft().RemoveRigthMost(root);
						Remove(root.getLeftChild(), root.getLeftChild().RightMost().getData(), root);
					}
					else if(root.getLeftChild() == root.getLeftChild().RightMost()){
						/*
						while(root.GetLeft().RightMost().GetLeft() != null){
							root.GetLeft().SetData(root.GetLeft().GetLeft().GetData());
							parent = root;
							root = root.GetLeft();
						}
//						root.GetLeft().RemoveRigthMost(root);
						 */
						root.getLeftChild().setData(root.getLeftChild().getLeftChild().getData());
						Remove(root.getLeftChild().getLeftChild(), root.getLeftChild().getLeftChild().getData(), root.getLeftChild());
					}
				}
			}
		else{
			if(removeData < root.getData()){
				System.out.println("less");
				Remove(root.getLeftChild(), removeData, root);
			}
			else{
				System.out.println("greater");
				Remove(root.getRightChild(), removeData, root);
			}
		}
	}
	
	public TreeNode<Integer> predecessor(int data) {
		if(root.getData() == data) {
			if (root.getLeftChild() != null) {
				return root.getLeftChild().RightMostChild();
			} else {
				return null;
			}
		}
		return predecessor(root, data, root);
	}
	
	public TreeNode<Integer> successor(int data) {
		if (root.getData() == data) {
			if (root.getRightChild() != null) {
				return root.getRightChild().LeftMostChild();
			} else {
				return null;
			}
		}
		return successor(root, data, null, root);
	}
	
	private TreeNode<Integer> predecessor(TreeNode<Integer> root, int data, TreeNode<Integer> topRoot) {
		//1st Case
		if (root == null) {
			System.out.println("Root is null");
			return null;
		} 
		//2nd Case
		else if (root.getData() == data) {
			TreeNode<Integer> predecessor = null;
			if (root.getLeftChild() != null) {
				return root.getLeftChild().RightMostChild();
			} else {
				while (topRoot != null) { 
					if (data == topRoot.getData()) {
						break;
					} else if ( data < topRoot.getData()) {
						topRoot = topRoot.getLeftChild();
					} else if ( data > topRoot.getData()) {
						predecessor = topRoot;
						topRoot = topRoot.getRightChild();
					}
				}
				return predecessor;
			}
		} else if (root.getData() > data) {
			return predecessor(root.getLeftChild(), data, topRoot);
		} else {
			return predecessor(root.getRightChild(), data, topRoot);
		}
	}
	
	private TreeNode<Integer> successor(TreeNode<Integer> root, int data, TreeNode<Integer> parent, TreeNode<Integer> topRoot) {
		//1st Case
		if (root == null) {
			System.out.println("Root is null");
			return null;
		} 
		//2nd Case
		else if (root.getData() == data) {
			if (root.getRightChild() != null) {
				return root.getRightChild().LeftMostChild();
			} else {
				if (root.getData() < topRoot.getData()) {
					return parent;
				} else {
					return null;
				}
			}
		} else if (root.getData() > data) {
			return successor(root.getLeftChild(), data, root, topRoot);
		} else {
			return successor(root.getRightChild(), data, root, topRoot);
		}
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> root = new TreeNode<Integer>();
		BinarySearchTree tree;
		
		System.out.println("Please enter the initial sequence of values: ");
		
		String str;
		Scanner readIn = new Scanner(System.in);
		str = readIn.nextLine();
		String[] nums = str.split(" ");
		int[] finalArray = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			finalArray[i] = Integer.parseInt(nums[i]);
		}
		
		root.setData(finalArray[0]);
		tree = new BinarySearchTree(root);
		for(int i = 1; i < finalArray.length; i++) {
			tree.add(finalArray[i]);
		}
		
		System.out.print("Pre-Order:  ");
		root.preorderTraverse();
		System.out.print("\nIn-order:   ");
		root.inorderTraverse();
		System.out.print("\nPost-Order: ");
		root.postorderTraverse();
		
		System.out.println("\nCommand? ");
		Boolean exit = false;
		Scanner kb = new Scanner(System.in);
		String value;
		int input;
		while(!exit) {
			value = kb.next();
			
			if (value.equals("H")) {
				System.out.println("  I   Insert a value");
				System.out.println("  D   Delete a value");
				System.out.println("  P   Find predecessor");
				System.out.println("  S   Find successor");
				System.out.println("  E   Exit the program");
				System.out.println("  H   Display this message");
			} else if (value.equals("I")) {
				input = kb.nextInt();
				tree.add(input);
				root.inorderTraverse();
				System.out.println("Command? ");
			} else if (value.equals("D")) {
				input = kb.nextInt();
				tree.Remove(input);
				root.inorderTraverse();
				System.out.println("Command? ");
			} else if (value.equals("P")) {
				input = kb.nextInt();
				TreeNode<Integer> temp = tree.predecessor(input);
				if (temp != null) {
					System.out.println(temp.getData());
				} else {
					System.out.println("Predecessor doesn't exist");
				}
				System.out.println("Command? ");
			} else if (value.equals("S")) {
				input = kb.nextInt();
				TreeNode<Integer> temp = tree.successor(input);
				if (temp != null) {
					System.out.println(temp.getData());
				} else {
					System.out.println("Successor doesn't exist");
				}
				System.out.println("Command? ");
			} else if (value.equals("E")) {
				exit = true;
				System.out.println("Good-bye");
			}
		}
	}
}