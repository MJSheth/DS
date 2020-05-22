package com.sheth.trees.misc;

import java.util.LinkedList;
import java.util.Queue;

import com.sheth.trees.common.BinaryTreeNode;

/**
 * Use queue (BFT) to iterate through nodes for Complete Binary Tree
 * 
 * 1. Mark flag to true if left or right is null for current node
 * 
 * 2. Keep adding left and right node of the current node to queue only if flag
 * is not set to true
 * 
 * 3. If flag is set to true, it represents that previous node in the traversal
 * was already null which disqualifies for Complete Binary Tree
 * 
 * @author mesheth
 *
 * @param <T>
 */
public class ValidateCompletenessOfABinaryTree<T> {

	public boolean isCompleteBinaryTree(BinaryTreeNode<T> node) {
		boolean encounteredNull = false;

		// Create Queue
		Queue<BinaryTreeNode<T>> discovered = new LinkedList<BinaryTreeNode<T>>();

		// Add root node
		discovered.add(node);

		while (!discovered.isEmpty()) {

			// Visit node
			BinaryTreeNode<T> visited = discovered.remove();

			if (visited.getLeft() != null) {
				// If encountered null node already then return
				if (encounteredNull == true) {
					return false;
				}

				// Keep adding it to queue for further traversal
				discovered.add(visited.getLeft());
			} else {
				// If left is null then mark flag to true. It will be used in subsequent calls
				encounteredNull = true;
			}

			if (visited.getRight() != null) {
				// If encountered null node already then return
				if (encounteredNull == true) {
					return false;
				}

				// Keep adding it to queue for further traversal
				discovered.add(visited.getRight());
			} else {
				// If right is null then mark flag to true. It will be used in subsequent calls
				encounteredNull = true;
			}
		}

		return encounteredNull;
	}

}
