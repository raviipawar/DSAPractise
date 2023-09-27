package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeSum {

	public static class BinaryTree {
		int value;
		BinaryTree left;
		BinaryTree right;

		public BinaryTree(int value) {
			this.value = value;
		}
	}

	public static List<Integer> branchSum(BinaryTree node) {
		return sumOfBranch(node, 0, new ArrayList<Integer>());
	}

	private static List<Integer> sumOfBranch(BinaryTree root, int sum, ArrayList<Integer> sums) {
		if (root.left == null && root.right == null) {
			sums.add(sum + root.value);
		}
		sum = sum + root.value;
		if (root.left != null) {
			sumOfBranch(root.left, sum, sums);
		}
		if (root.right != null) {
			sumOfBranch(root.right, sum, sums);
		}
		return sums;
	}

	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(10);

		root.left = new BinaryTree(5);
		root.right = new BinaryTree(7);

		System.out.println(sumOfBranch(root, 0, new ArrayList<Integer>()));
	}

}
