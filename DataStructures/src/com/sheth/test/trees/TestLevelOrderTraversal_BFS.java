package com.sheth.test.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.sheth.trees.BinaryTreeNode;
import com.sheth.trees.LevelOrderTraversal_BFS;

class TestLevelOrderTraversal_BFS {

	@Test
	void testGetLevelOrder_BFS_Traversal() {
		LevelOrderTraversal_BFS<Integer> levelOrderTraversal_BFS = new LevelOrderTraversal_BFS<Integer>();
		List<Integer> visitedNodes = new LinkedList<Integer>();

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(10);
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

		visitedNodes = levelOrderTraversal_BFS.getLevelOrder_BFS_Traversal(root);
		assertEquals(visitedNodes.get(0).intValue(), 10);
		assertEquals(visitedNodes.get(2).intValue(), 20);
		assertEquals(visitedNodes.get(4).intValue(), 18);
		assertEquals(visitedNodes.get(6).intValue(), 7);
	}

}
