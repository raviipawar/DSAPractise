package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

// Write a function that takes in a Binary Tree and returns a list of its branch sums 
// ordered from left most branch sum to rightmost branch sum

// Where a branch sum is the sum of the values in a Binary Tree branch. 
// A Binary tree branch is a path of nodes in a tree that starts at a node and end at any leaf node

// Each binary tree node has an integer value, a left child node, and a right child node.
// Children nodes can either be Binarytree nodes themselves or None/ null

//Approach : 
// Explanation
// keep moving left and adding the all the values in sum.
// when leaf node is reached add the sum of branches in the array;
// return to the previous recursive step and move right and then keep moving left again until reach leaf node
public class BranchSum {

	public static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	public static List<Integer> branchSums(BinaryTree root) {
		return sumofBranch(root, 0, new ArrayList<Integer>());
	}

	private static List<Integer> sumofBranch(BinaryTree node, int sum, ArrayList<Integer> sums) {
		if (node.left == null && node.right == null) {
			sums.add(sum + node.value);
		}
		sum = sum + node.value;
		// keep going left until left is null
		if (node.left != null) {
			sumofBranch(node.left, sum, sums);
		}
		// if right is not null then move one step right
		// in the next iteration it will again move left
		if (node.right != null) {
			sumofBranch(node.right, sum, sums);
		}
		return sums;
	}

	public static void main(String args[]) {

		// create a root node with value as 5
		BinaryTree root = new BinaryTree(5);

		// Create the first level of child nodes
		root.left = new BinaryTree(2);
		root.right = new BinaryTree(3);

		// Create the second level of child nodes

		root.left.left = new BinaryTree(4);
		root.left.right = new BinaryTree(5);
		root.right.left = new BinaryTree(6);
		root.right.right = new BinaryTree(7);

		// Create the third level of child nodes
		root.left.left.left = new BinaryTree(8);
		root.left.left.right = new BinaryTree(9);
		root.left.right.left = new BinaryTree(10);
		root.left.right.right = new BinaryTree(11);
		root.right.left.left = new BinaryTree(12);
		root.right.left.right = new BinaryTree(13);
		root.right.right.left = new BinaryTree(14);
		root.right.right.right = new BinaryTree(15);
		System.out.println(branchSums(root));
	}
}
