package com.sheth.test.trees.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sheth.trees.common.BinaryTreeNode;
import com.sheth.trees.util.BinaryTreeUtil;

class TestBinaryTreeUtil {

	BinaryTreeNode<Integer> root;

	@BeforeEach
	void setup() {
		root = new BinaryTreeNode<Integer>(10);
		BinaryTreeNode<Integer> n1 = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> n2 = new BinaryTreeNode<Integer>(20);
		BinaryTreeNode<Integer> n3 = new BinaryTreeNode<Integer>(9);
		BinaryTreeNode<Integer> n4 = new BinaryTreeNode<Integer>(18);
		BinaryTreeNode<Integer> n5 = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> n6 = new BinaryTreeNode<Integer>(7);

		root.setLeft(n1);
		root.setRight(n2);
		n1.setLeft(n3);
		n1.setRight(n4);
		n2.setLeft(n5);
		n2.setRight(n6);
	}

	@Test
	void testGetHeight() {
		int height = BinaryTreeUtil.getHeightOrMaxDepth(root);
		assertEquals(3, height);

	}

}
