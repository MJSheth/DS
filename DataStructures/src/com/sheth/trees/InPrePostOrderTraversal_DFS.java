package com.sheth.trees;

import java.util.ArrayList;
import java.util.List;

public class InPrePostOrderTraversal_DFS<T> {

	private List<T> inOrderVisited = new ArrayList<T>();
	private List<T> preOrderVisited = new ArrayList<T>();
	private List<T> postOrderVisited = new ArrayList<T>();

	public void inOrder(BinaryTreeNode<T> node) {
		if (node != null) {
			inOrder(node.getLeft());
			inOrderVisited.add(node.getData());
			inOrder(node.getRight());
		}
	}

	public void preOrder(BinaryTreeNode<T> node) {
		if (node != null) {
			preOrderVisited.add(node.getData());
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}

	public void postOrder(BinaryTreeNode<T> node) {
		if (node != null) {
			postOrder(node.getLeft());
			postOrder(node.getRight());
			postOrderVisited.add(node.getData());
		}
	}

	public List<T> getInOrderVisited() {
		return inOrderVisited;
	}

	public List<T> getPreOrderVisited() {
		return preOrderVisited;
	}

	public List<T> getPostOrderVisited() {
		return postOrderVisited;
	}
}
