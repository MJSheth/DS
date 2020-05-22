package com.sheth.test.trees.misc;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sheth.trees.common.BinaryTreeNode;
import com.sheth.trees.misc.ValidateCompletenessOfABinaryTree;

class TestValidateCompletenessOfABinaryTree {

	/* Input 1
	 * 
				10
		    /         \  
		  5           20  
		 /  \         /  \
		9    18     3     7

	 *
	 */

	/* Input 2
	 * 
				10
		    /         \  
		  5           20  
		 /  \         /  \
		9    18     3     7
	   / \    \
	  11  17   17	
	 *
	 */

	
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
		
		root.setLeft(n1);
		root.setRight(n2);
		n1.setLeft(n3);
		n1.setRight(n4);
		n2.setLeft(n5);
		n2.setRight(n6);
	}

	@Test
	void testIsCompleteBinaryTree() {
		boolean isCompleteBinaryTree = testValidateCompletenessOfABinaryTree.isCompleteBinaryTree(root);
		assertEquals(true, isCompleteBinaryTree);
		
		BinaryTreeNode<Integer> n7 = new BinaryTreeNode<Integer>(11);
		BinaryTreeNode<Integer> n8 = new BinaryTreeNode<Integer>(17);
		BinaryTreeNode<Integer> n9 = new BinaryTreeNode<Integer>(17);
		root.getLeft().getLeft().setLeft(n7);
		root.getLeft().getLeft().setRight(n8);
		root.getLeft().getRight().setRight(n9);
		isCompleteBinaryTree = testValidateCompletenessOfABinaryTree.isCompleteBinaryTree(root);
		assertEquals(false, isCompleteBinaryTree);

	}

}
