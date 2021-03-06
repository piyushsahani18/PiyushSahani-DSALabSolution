package com.greatlearning.main;

import java.util.ArrayList;

public class LongestPathBTree {
	// Node
	static class Node {
		Node left;
		Node right;
		int data;
	};

	// Node Creation
	static Node newNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}
	// Function to Find the longest path of the binary tree
	public static ArrayList<Integer> longestPath(Node root) {
		if (root == null) {
			ArrayList<Integer> path = new ArrayList<>();  // to store the longest path
			return path;
		}
		ArrayList<Integer> right = longestPath(root.right);  // if left longest path
		ArrayList<Integer> left = longestPath(root.left);    // if right longest path
		if (right.size() < left.size()) {
			left.add(root.data);
		} else {
			right.add(root.data);
		}
		if (left.size() > right.size())
			return left;
	        else 
			return right;
	}

	// Driver Class
	public static void main(String[] args) {
		// Input is hardcoded
		Node root = newNode(100);
		root.left = newNode(20);
		root.right = newNode(130);
		root.right.left = newNode(110);
		root.right.right = newNode(140);
		root.left.left = newNode(10);
		root.left.right = newNode(50);
		root.left.left.left = newNode(5);
		ArrayList<Integer> path = longestPath(root);
		int n = path.size();
		System.out.print(path.get(n - 1));
		for (int i = n - 2; i >= 0; i--) {
			System.out.print(" -> " + path.get(i));
		}
	}
}
