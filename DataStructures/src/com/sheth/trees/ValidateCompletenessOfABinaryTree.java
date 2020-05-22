package com.sheth.trees;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateCompletenessOfABinaryTree<T> {

	public boolean isCompleteBinaryTree(BinaryTreeNode<T> node) {
		boolean flag = false;
		Queue<BinaryTreeNode<T>> discovered = new LinkedList<BinaryTreeNode<T>>();
		discovered.add(node);

		while (!discovered.isEmpty()) {
			BinaryTreeNode<T> visited = discovered.remove();

			if (visited.getLeft() != null) {
				if (flag == true) {
					return false;
				}
				discovered.add(visited.getLeft());
			} else {
				flag = true;
			}

			if (visited.getRight() != null) {
				if (flag == true) {
					return false;
				}
				discovered.add(visited.getRight());
			} else {
				flag = true;
			}
		}

		return flag;
	}

}
