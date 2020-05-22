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
		assertEquals(root.getData(), 10);
		assertEquals(root.getLeft().getData(), 5);
		assertEquals(root.getRight().getData(), 20);
		assertEquals(root.getLeft().getLeft().getData(), 9);
		assertEquals(root.getLeft().getRight().getData(), 18);
		assertEquals(root.getRight().getLeft().getData(), 3);
		assertEquals(root.getRight().getRight().getData(), 7);

		
		inputList.clear();
		inputList.add(10);
		inputList.add(12);
		inputList.add(15);
		inputList.add(25);
		inputList.add(30);
		inputList.add(36);
		root = testConstructCompleteBinaryTree.fromList(inputList);
		assertEquals(root.getData(), 10);
		assertEquals(root.getLeft().getData(), 12);
		assertEquals(root.getRight().getData(), 15);
		assertEquals(root.getLeft().getLeft().getData(), 25);
		assertEquals(root.getLeft().getRight().getData(), 30);
		assertEquals(root.getRight().getLeft().getData(), 36);
		assertEquals(root.getRight().getRight(), null);
	}

	@Test
	void testFromArray() {
		ConstructCompleteBinaryTree<Integer> testConstructCompleteBinaryTree = new ConstructCompleteBinaryTree<Integer>();
		Integer[] inputArr1 = { 10, 5, 20, 9, 18, 3, 7 };

		BinaryTreeNode<Integer> root = testConstructCompleteBinaryTree.fromArray(inputArr1);
		assertEquals(root.getData(), 10);
		assertEquals(root.getLeft().getData(), 5);
		assertEquals(root.getRight().getData(), 20);
		assertEquals(root.getLeft().getLeft().getData(), 9);
		assertEquals(root.getLeft().getRight().getData(), 18);
		assertEquals(root.getRight().getLeft().getData(), 3);
		assertEquals(root.getRight().getRight().getData(), 7);

		Integer[] inputArr2 = { 10, 12, 15, 25, 30, 36 };

		root = testConstructCompleteBinaryTree.fromArray(inputArr2);
		assertEquals(root.getData(), 10);
		assertEquals(root.getLeft().getData(), 12);
		assertEquals(root.getRight().getData(), 15);
		assertEquals(root.getLeft().getLeft().getData(), 25);
		assertEquals(root.getLeft().getRight().getData(), 30);
		assertEquals(root.getRight().getLeft().getData(), 36);
		assertEquals(root.getRight().getRight(), null);
	}

}
