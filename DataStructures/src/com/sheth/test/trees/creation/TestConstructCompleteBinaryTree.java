package com.sheth.test.trees.creation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.sheth.trees.common.BinaryTreeNode;
import com.sheth.trees.creation.ConstructCompleteBinaryTree;

class TestConstructCompleteBinaryTree {

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
		  12           15  
		 /  \         /  
		25   30     36     

	 *
	 */

	
	@Test
	void testFromList() {

		ConstructCompleteBinaryTree<Integer> testConstructCompleteBinaryTree = new ConstructCompleteBinaryTree<Integer>();
		List<Integer> inputList = new LinkedList<Integer>();
		inputList.add(10);
		inputList.add(5);
		inputList.add(20);
		inputList.add(9);
		inputList.add(18);
		inputList.add(3);
		inputList.add(7);

		BinaryTreeNode<Integer> root = testConstructCompleteBinaryTree.fromList(inputList);
		assertEquals(10, root.getData());
		assertEquals(5, root.getLeft().getData());
		assertEquals(20, root.getRight().getData());
		assertEquals(9, root.getLeft().getLeft().getData());
		assertEquals(18, root.getLeft().getRight().getData());
		assertEquals(3, root.getRight().getLeft().getData());
		assertEquals(7, root.getRight().getRight().getData());

		
		inputList.clear();
		inputList.add(10);
		inputList.add(12);
		inputList.add(15);
		inputList.add(25);
		inputList.add(30);
		inputList.add(36);
		root = testConstructCompleteBinaryTree.fromList(inputList);
		assertEquals(10, root.getData());
		assertEquals(12, root.getLeft().getData());
		assertEquals(15, root.getRight().getData());
		assertEquals(25, root.getLeft().getLeft().getData());
		assertEquals(30, root.getLeft().getRight().getData());
		assertEquals(36, root.getRight().getLeft().getData());
		assertEquals(null, root.getRight().getRight());
	}

	@Test
	void testFromArray() {
		ConstructCompleteBinaryTree<Integer> testConstructCompleteBinaryTree = new ConstructCompleteBinaryTree<Integer>();
		Integer[] inputArr1 = { 10, 5, 20, 9, 18, 3, 7 };

		BinaryTreeNode<Integer> root = testConstructCompleteBinaryTree.fromArray(inputArr1);
		assertEquals(10, root.getData());
		assertEquals(5, root.getLeft().getData());
		assertEquals(20, root.getRight().getData());
		assertEquals(9, root.getLeft().getLeft().getData());
		assertEquals(18, root.getLeft().getRight().getData());
		assertEquals(3, root.getRight().getLeft().getData());
		assertEquals(7, root.getRight().getRight().getData());

		Integer[] inputArr2 = { 10, 12, 15, 25, 30, 36 };

		root = testConstructCompleteBinaryTree.fromArray(inputArr2);
		assertEquals(10, root.getData());
		assertEquals(12, root.getLeft().getData());
		assertEquals(15, root.getRight().getData());
		assertEquals(25, root.getLeft().getLeft().getData());
		assertEquals(30, root.getLeft().getRight().getData());
		assertEquals(36, root.getRight().getLeft().getData());
		assertEquals(null, root.getRight().getRight());
	}

}
