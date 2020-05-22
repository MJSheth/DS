package com.sheth.trees.util;

import com.sheth.trees.common.BinaryTreeNode;

public class BinaryTreeUtil<T> {

	public static<T> int getHeightOrMaxDepth(BinaryTreeNode<T> node) {
		if (node == null) {
			return 0;
		} else {
			int leftSubTreeHeight = getHeightOrMaxDepth(node.getLeft());
			int rightSubTreeHeight = getHeightOrMaxDepth(node.getRight());

			return Integer.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
		}
	}

}
