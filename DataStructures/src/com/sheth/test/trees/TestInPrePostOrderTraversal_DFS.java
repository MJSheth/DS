package com.sheth.test.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sheth.trees.BinaryTreeNode;
import com.sheth.trees.InPrePostOrderTraversal_DFS;

class TestInPrePostOrderTraversal_DFS {


	private InPrePostOrderTraversal_DFS<Integer> testInPrePostOrderTraversal_DFS;
	private BinaryTreeNode<Integer> root;

	@BeforeEach
	void setup() {
		testInPrePostOrderTraversal_DFS = new InPrePostOrderTraversal_DFS<Integer>();
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
	void testInOrder() {
		testInPrePostOrderTraversal_DFS.inOrder(root);
		List<Integer> visitedNodes = testInPrePostOrderTraversal_DFS.getVisited();
		assertEquals(visitedNodes.get(0).intValue(), 9);
		assertEquals(visitedNodes.get(3).intValue(), 10);
		assertEquals(visitedNodes.get(6).intValue(), 7);
	}

	@Test
	void testPreOrder() {
		testInPrePostOrderTraversal_DFS.preOrder(root);
		List<Integer> visitedNodes = testInPrePostOrderTraversal_DFS.getVisited();
		assertEquals(visitedNodes.get(0).intValue(), 10);
		assertEquals(visitedNodes.get(3).intValue(), 18);
		assertEquals(visitedNodes.get(6).intValue(), 7);
	}

	@Test
	void testPostOrder() {
		testInPrePostOrderTraversal_DFS.postOrder(root);
		List<Integer> visitedNodes = testInPrePostOrderTraversal_DFS.getVisited();
		assertEquals(visitedNodes.get(0).intValue(), 9);
		assertEquals(visitedNodes.get(3).intValue(), 3);
		assertEquals(visitedNodes.get(6).intValue(), 10);

	}


}
