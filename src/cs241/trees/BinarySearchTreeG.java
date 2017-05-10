package cs241.trees;

import java.util.Scanner;

public class BinarySearchTreeG<T extends Comparable<T>> {
	TreeNodeG<T> root;
	
	public BinarySearchTreeG(TreeNodeG<T> root) {
		this.root = root;
	}
	
	public void add(T data) {
		if (root == null) {
			root = new TreeNodeG<T>(data);
		} else {
			add(root, data);
		}
	}
	
	private void add(TreeNodeG<T> root, T data) {
		if (root.getData().compareTo(data) == 1) {
			if (root.getLeft() == null) {
				root.setLeft(new TreeNodeG<T>(data));
			} else {
				add(root.getLeft(), data);
			}
		} else {
			if (root.getRight() == null) {
				root.setRight(new TreeNodeG<T>(data));
			} else {
				add(root.getRight(), data);
			}
		}
	}
	
	private void remove(TreeNodeG<T> root, TreeNodeG<T> parent, T data) {
		if (root.compareTo(data) == 0) {
			//1st Case
			if (root.isLeaf()) {
				if (parent.getLeft() != null && parent.getLeft().getData().compareTo(data) == 0) {
					parent.setLeft(null);
				} else {
					parent.setRight(null);
				}
			}
			
			//2nd Case
			else if (root.getLeft() == null) {
				if (parent.getLeft() != null && parent.getLeft().getData().compareTo(data) == 0) {
					parent.setLeft(root.getRight());
				} else {
					parent.setRight(root.getRight());
				}
			} else if (root.getRight() == null) {
				if (parent.getLeft() != null && parent.getLeft().getData().compareTo(data) == 0) {
					parent.setLeft(root.getLeft());
				} else {
					parent.setRight(root.getRight());
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public void remove(int data) {
		if (root.getData() == data) {
			throw new RuntimeException(" No ");
		}
		remove(root, data, null);
	}
	
	private void remove(TreeNode<Integer> root, int data, TreeNode<Integer> parent) {
		if (data == root.getData()) {
			//1st Case
			if (root.getLeftChild() == null && root.getRightChild() == null) {
				if (parent.getLeftChild() != null) {
					if (parent.getLeftChild().getData() == data) {
						parent.setLeftChild(null);
						System.out.println("1st Case Left");
					} else {
						parent.setRightChild(null);
					}
				} else {
					parent.setRightChild(null);
				}
			}
			
			//2nd Case
			else if (root.getLeftChild() == null) {
				if (parent.getLeftChild() != null) {
					if (parent.getLeftChild().getData() == data) {
						parent.setLeftChild(root.getRightChild());
					} else {
						parent.setRightChild(root.getRightChild());
					}
				}
				System.out.println("2nd Case Right");
			} else if (root.getRightChild() == null) {
				if (parent.getLeftChild() != null) {
					if (parent.getLeftChild().getData() == data) {
						parent.setLeftChild(root.getLeftChild());
					} else {
						parent.setRightChild(root.getLeftChild());
					}
				} 
				System.out.println("2nd Case Left");
			}
			
			//3rd Case
			else {
				//Doesn't work, ran out of ideas and honestly started getting lost
				if (parent.getLeftChild().getData() == data) {
					parent.setLeftChild(root.getLeftChild().RightMostChild());
				} else if (parent.getRightChild().getData() == data) {
					parent.setRightChild(root.getLeftChild().RightMostChild());
				} 
			}
		} else {
			if (data < root.getData()) {
				remove(root.getLeftChild(), data, root);
			} else {
				remove(root.getRightChild(), data, root);
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
	}*/
	
	public static void main(String[] args) {
		TreeNodeG<Integer> root = new TreeNodeG<Integer>();
		BinarySearchTreeG<Integer> tree;
		
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
		tree = new BinarySearchTreeG<Integer>(root);
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
				//tree.remove(input);
				root.inorderTraverse();
				System.out.println("Command? ");
			} else if (value.equals("P")) {
				input = kb.nextInt();
			//	TreeNodeG<Integer> temp = tree.predecessor(input);
			//	if (temp != null) {
			//		System.out.println(temp.getData());
				} else {
					System.out.println("Predecessor doesn't exist");
				}
				System.out.println("Command? ");
		//	} else if (value.equals("S")) {
				input = kb.nextInt();
			//	TreeNodeG<Integer> temp = tree.successor(input);
				//if (temp != null) {
					//System.out.println(temp.getData());
			//	} else {
					System.out.println("Successor doesn't exist");
				}
				System.out.println("Command? ");
			//} else if (value.equals("E")) {
				exit = true;
				System.out.println("Good-bye");
			}
		
	}

