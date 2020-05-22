package com.sheth.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Complete Binary Tree is a Tree where all levels are completely filled except
 * the last level
 * 
 * 1. Use queue to discover nodes.
 * 
 * 2. If discovered node has left or right child empty then insert new node as
 * its left or right child respectively
 * 
 * 3. Add this new node back to the queue so that it can be further discovered
 * 
 * 4. Repeat until input list/array is traversed completely
 * 
 * @author mesheth
 *
 * @param <T>
 */
public class ConstructCompleteBinaryTree<T> {

	public BinaryTreeNode<T> fromList(List<T> inputList) {
		if (inputList.isEmpty()) {
			return null;
		}
		int listIndex = 0;
		BinaryTreeNode<T> root = new BinaryTreeNode<T>(inputList.get(listIndex++));
		Queue<BinaryTreeNode<T>> discovered = new LinkedList<BinaryTreeNode<T>>();

		// Add root to discovered queue
		discovered.add(root);
		while (!discovered.isEmpty()) {
			
			// Remove top node from the queue (discovered) 
			BinaryTreeNode<T> node = discovered.remove();

			// Check if you can add left node
			if (listIndex < inputList.size()) {
				BinaryTreeNode<T> leftNode = new BinaryTreeNode<T>(inputList.get(listIndex++));
				node.setLeft(leftNode);
				discovered.add(leftNode);
			}

			// Check if you can add right node
			if (listIndex < inputList.size()) {
				BinaryTreeNode<T> rightNode = new BinaryTreeNode<T>(inputList.get(listIndex++));
				node.setRight(rightNode);
				discovered.add(rightNode);
			}

			// Break the loop if inputList is traversed
			if (listIndex >= inputList.size()) {
				discovered.clear();
				break;
			}
		}

		return root;
	}

	public BinaryTreeNode<T> fromArray(T[] inputArr) {
		if (inputArr.length == 0) {
			return null;
		}
		// First element is root
		int arrIndex = 0;
		BinaryTreeNode<T> root = new BinaryTreeNode<T>(inputArr[arrIndex++]);
		Queue<BinaryTreeNode<T>> discovered = new LinkedList<BinaryTreeNode<T>>();

		// Root is already discovered
		discovered.add(root);

		while (!discovered.isEmpty()) {
			BinaryTreeNode<T> visited = discovered.remove();

			// Add left node
			if (arrIndex < inputArr.length) {
				BinaryTreeNode<T> leftNode = new BinaryTreeNode<T>(inputArr[arrIndex++]);
				visited.setLeft(leftNode);
				discovered.add(leftNode);
			}

			// Add right node
			if (arrIndex < inputArr.length) {
				BinaryTreeNode<T> rightNode = new BinaryTreeNode<T>(inputArr[arrIndex++]);
				visited.setRight(rightNode);
				discovered.add(rightNode);
			}

			// Break the loop when all the elements of input Array are traversed
			if (arrIndex >= inputArr.length) {
				discovered.clear();
				break;
			}

		}

		return root;
	}

}
