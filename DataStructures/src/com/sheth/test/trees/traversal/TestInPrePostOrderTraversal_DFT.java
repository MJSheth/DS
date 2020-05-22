package com.sheth.test.trees.traversal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sheth.trees.common.BinaryTreeNode;
import com.sheth.trees.traversal.InPrePostOrderTraversal_DFT;

class TestInPrePostOrderTraversal_DFT {

	/* Input
	 * 
				10
		    /         \  
		  5           20  
		 /  \         /  \
		9    18     3     7

	 *
	 */

	private InPrePostOrderTraversal_DFT<Integer> testInPrePostOrderTraversal_DFT;
	private BinaryTreeNode<Integer> root;

	@BeforeEach
	void setup() {
		testInPrePostOrderTraversal_DFT = new InPrePostOrderTraversal_DFT<Integer>();
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
	
	@AfterEach
	void tearDown() {
		testInPrePostOrderTraversal_DFT.clearAllLists();
	}

	@Test
	void testInOrder() {
		testInPrePostOrderTraversal_DFT.inOrder(root);
		List<Integer> visitedNodes = testInPrePostOrderTraversal_DFT.getInOrderVisited();
		assertEquals(9 , visitedNodes.get(0).intValue());
		assertEquals(10, visitedNodes.get(3).intValue());
		assertEquals(7, visitedNodes.get(6).intValue());
	}

	@Test
	void testInOrderNonRecursive() {
		testInPrePostOrderTraversal_DFT.inOrderWithoutRecursion(root);
		List<Integer> visitedNodes = testInPrePostOrderTraversal_DFT.getInOrderVisited();
		assertEquals(9 , visitedNodes.get(0).intValue());
		assertEquals(10, visitedNodes.get(3).intValue());
		assertEquals(7, visitedNodes.get(6).intValue());
	}

	
	@Test
	void testPreOrder() {
		testInPrePostOrderTraversal_DFT.preOrder(root);
		List<Integer> visitedNodes = testInPrePostOrderTraversal_DFT.getPreOrderVisited();
		assertEquals(10, visitedNodes.get(0).intValue());
		assertEquals(18, visitedNodes.get(3).intValue());
		assertEquals(7, visitedNodes.get(6).intValue());
	}

	@Test
	void testPostOrder() {
		testInPrePostOrderTraversal_DFT.postOrder(root);
		List<Integer> visitedNodes = testInPrePostOrderTraversal_DFT.getPostOrderVisited();
		assertEquals(9, visitedNodes.get(0).intValue());
		assertEquals(3, visitedNodes.get(3).intValue());
		assertEquals(10, visitedNodes.get(6).intValue());

	}

}
