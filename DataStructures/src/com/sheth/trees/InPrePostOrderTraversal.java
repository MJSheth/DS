package com.sheth.trees;

import java.util.ArrayList;
import java.util.List;

public class InPrePostOrderTraversal<T> {

	private List<T> visited = new ArrayList<T>();

	public void inOrder(BinaryTreeNode<T> node) {
		if (node != null) {
			inOrder(node.getLeft());
			visited.add(node.getData());
			inOrder(node.getRight());
		}
	}

	public void preOrder(BinaryTreeNode<T> node) {
		if (node != null) {
			visited.add(node.getData());
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}

	public void postOrder(BinaryTreeNode<T> node) {
		if (node != null) {
			postOrder(node.getLeft());
			postOrder(node.getRight());
			visited.add(node.getData());
		}
	}

	public List<T> getVisited() {
		return visited;
	}

}
