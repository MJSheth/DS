package com.sheth.test.trees.traversal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sheth.trees.common.BinaryTreeNode;
import com.sheth.trees.traversal.LevelOrderTraversal_BFT;

class TestLevelOrderTraversal_BFT {

	/* Input
	 * 
				10
		    /         \  
		  5           20  
		 /  \         /  \
		9    18     3     7

	 *
	 */

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
		assertEquals(10, visitedNodes.get(0).intValue());
		assertEquals(20, visitedNodes.get(2).intValue());
		assertEquals(18, visitedNodes.get(4).intValue());
		assertEquals(7, visitedNodes.get(6).intValue());
	}

	@Test
	void testGetListOfNodesAtEachLevel() {
		Map<Integer, List<Integer>> levelNodesMap = testLevelOrderTraversal_BFS.getListOfNodesAtEachLevel(root);

		assertEquals(10, levelNodesMap.get(1).get(0));
		assertEquals(1, levelNodesMap.get(1).size());

		assertEquals(5, levelNodesMap.get(2).get(0));
		assertEquals(20, levelNodesMap.get(2).get(1));
		assertEquals(2, levelNodesMap.get(2).size());

		assertEquals(9, levelNodesMap.get(3).get(0));
		assertEquals(18, levelNodesMap.get(3).get(1));
		assertEquals(3, levelNodesMap.get(3).get(2));
		assertEquals(7, levelNodesMap.get(3).get(3));
		assertEquals(4, levelNodesMap.get(3).size());
	}

}
