package com.sheth.trees.traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.sheth.trees.common.BinaryTreeNode;

/**
 * InOrder, PreOrder and PostOrder traversal are called Depth First Traversal
 * 
 * @author mesheth
 *
 * @param <T>
 */
public class InPrePostOrderTraversal_DFT<T> {

	private List<T> inOrderVisited = new ArrayList<T>();
	private List<T> preOrderVisited = new ArrayList<T>();
	private List<T> postOrderVisited = new ArrayList<T>();

	// If applied on BST then it gives nodes in ascending order
	public void inOrder(BinaryTreeNode<T> node) {
		if (node != null) {
			inOrder(node.getLeft());
			inOrderVisited.add(node.getData());
			inOrder(node.getRight());
		}
	}

	/**
	 * This is also referred as Iterative InOrder Traversal
	 * 
	 * Since we are not using recursion, best alternate is Stack for iterative
	 * approach
	 * 
	 * 1. If node is not null then push to stack and update node to node.left
	 * 
	 * 2. If node is null and stack is not empty then pop element from stack and
	 * update node to node.right
	 * 
	 * @param node
	 */
	public void inOrderWithoutRecursion(BinaryTreeNode<T> node) {
		if (node == null) {
			return;
		}

//		// Store root node in traverse node
//		BinaryTreeNode<T> trav = node;

		// Create Stack to store nodes (replacement of recursive call)
		Stack<BinaryTreeNode<T>> stack = new Stack<BinaryTreeNode<T>>();

		while (true) {
			if (node != null) {
				stack.push(node);
				node = node.getLeft();
			} else {
				if (stack.isEmpty()) {
					break;
				}
				node = stack.pop();
				inOrderVisited.add(node.getData());
				node = node.getRight();
			}
		}
	}

	// Root node is always the first node to be visited
	public void preOrder(BinaryTreeNode<T> node) {
		if (node != null) {
			preOrderVisited.add(node.getData());
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}

	// Root node is always the last node to be visited
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

	public void clearAllLists() {
		inOrderVisited.clear();
		preOrderVisited.clear();
		postOrderVisited.clear();
	}
}
