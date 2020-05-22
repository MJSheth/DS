package com.sheth.test.trees.misc;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sheth.trees.common.BinaryTreeNode;
import com.sheth.trees.misc.ValidateCompletenessOfABinaryTree;

class TestValidateCompletenessOfABinaryTree {

	private ValidateCompletenessOfABinaryTree<Integer> testValidateCompletenessOfABinaryTree;
	private BinaryTreeNode<Integer> root;

	@BeforeEach
	void setup() {
		testValidateCompletenessOfABinaryTree = new ValidateCompletenessOfABinaryTree<Integer>();
		root = new BinaryTreeNode<Integer>(10);
		BinaryTreeNode<Integer> n1 = new BinaryTreeNode<Integer>(5);
		BinaryTreeNode<Integer> n2 = new BinaryTreeNode<Integer>(20);
		BinaryTreeNode<Integer> n3 = new BinaryTreeNode<Integer>(9);
		BinaryTreeNode<Integer> n4 = new BinaryTreeNode<Integer>(18);
		BinaryTreeNode<Integer> n5 = new BinaryTreeNode<Integer>(3);
		BinaryTreeNode<Integer> n6 = new BinaryTreeNode<Integer>(7);
		BinaryTreeNode<Integer> n7 = new BinaryTreeNode<Integer>(11);
		BinaryTreeNode<Integer> n8 = new BinaryTreeNode<Integer>(17);
		BinaryTreeNode<Integer> n9 = new BinaryTreeNode<Integer>(17);
		
		root.setLeft(n1);
		root.setRight(n2);
		n1.setLeft(n3);
		n1.setRight(n4);
		n2.setLeft(n5);
		n2.setRight(n6);
//		n3.setLeft(n7);
//		n3.setRight(n8);
//		n4.setRight(n9);
	}

	@Test
	void testIsCompleteBinaryTree() {
		boolean isCompleteBinaryTree = testValidateCompletenessOfABinaryTree.isCompleteBinaryTree(root);
		assertEquals(true, isCompleteBinaryTree);
	}

}
