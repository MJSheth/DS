package com.sheth.test.trees;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sheth.trees.BinaryTreeNode;
import com.sheth.trees.LevelOrderTraversal_BFT;

class TestLevelOrderTraversal_BFT {

	private LevelOrderTraversal_BFT<Integer> testLevelOrderTraversal_BFS;
	private BinaryTreeNode<Integer> root;

	@BeforeEach
	void setup() {
		testLevelOrderTraversal_BFS = new LevelOrderTraversal_BFT<Integer>();
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
	void testGetLevelOrder_BFS_Traversal() {
		List<Integer> visitedNodes = testLevelOrderTraversal_BFS.getLevelOrder_BFS_Traversal(root);
		assertEquals(visitedNodes.get(0).intValue(), 10);
		assertEquals(visitedNodes.get(2).intValue(), 20);
		assertEquals(visitedNodes.get(4).intValue(), 18);
		assertEquals(visitedNodes.get(6).intValue(), 7);
	}

	@Test
	void testGetListOfNodesAtEachLevel() {
		Map<Integer, List<Integer>> levelNodesMap = testLevelOrderTraversal_BFS.getListOfNodesAtEachLevel(root);

		assertEquals(levelNodesMap.get(1).get(0), 10);
		assertEquals(levelNodesMap.get(1).size(), 1);

		assertEquals(levelNodesMap.get(2).get(0), 5);
		assertEquals(levelNodesMap.get(2).get(1), 20);
		assertEquals(levelNodesMap.get(2).size(), 2);

		assertEquals(levelNodesMap.get(3).get(0), 9);
		assertEquals(levelNodesMap.get(3).get(1), 18);
		assertEquals(levelNodesMap.get(3).get(2), 3);
		assertEquals(levelNodesMap.get(3).get(3), 7);
		assertEquals(levelNodesMap.get(3).size(), 4);
	}

}
