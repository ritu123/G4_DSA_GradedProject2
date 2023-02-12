package com.gl.dsa.question2;

public class BSTTreeToSkewed {

	static class Node {
		int data;
		Node leftNode, rightNode;

		public Node(int data) {
			this.data = data;
			leftNode = rightNode = null;
		}
	}

	static Node createNode(int nodeData) {
		Node newNode = new Node(nodeData);
		return newNode;
	}

	Node insert(Node root, int key) {
		if (root == null) {
			return createNode(key);
		}
		if (key < root.data)
			root.leftNode = insert(root.leftNode, key);
		else
			root.rightNode = insert(root.rightNode, key);

		return root;
	}

	static Node prevNode = null;
	static Node headNode = null;

	static void bstToSkew(Node root) {
		if (root == null) {
			return;
		}

		bstToSkew(root.leftNode);
		Node rightNode = root.rightNode;
		Node leftNode = root.leftNode;

		if (headNode == null) {

			headNode = root;
			root.leftNode = null;
			prevNode = root;

		} else {
			prevNode.rightNode = root;
			root.leftNode = null;
			prevNode = root;

		}
		bstToSkew(rightNode);

	}

	static void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		traverseRightSkewed(root.rightNode);
	}

	public static void main(String[] args) {
		Node root = null;
		BSTTreeToSkewed bst = new BSTTreeToSkewed();

		root = bst.insert(root, 50);
		root = bst.insert(root, 30);
		root = bst.insert(root, 60);
		root = bst.insert(root, 10);
		root = bst.insert(root, 55);

		// System.out.println("Inorder traversal");
		// inorder(root);

		bstToSkew(root);

		System.out.println("Right Skew tree traversal");
		traverseRightSkewed(headNode);

	}

	private static void inorder(Node root) {
		if (root != null) {
			inorder(root.leftNode);
			System.out.print(root.data + " ");
			inorder(root.rightNode);

		}
	}

}
