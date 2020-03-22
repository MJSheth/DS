package com.sheth.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal_BFS<T> {
	public List<T> getLevelOrder_BFS_Traversal(BinaryTreeNode<T> node) {
		// Maintains list of all visited nodes in level order traversal
		List<T> visited = new LinkedList<T>();

		// Queue to keep reference of all discovered but yet to be visited nodes
		Queue<BinaryTreeNode<T>> discovered = new LinkedList<BinaryTreeNode<T>>();

		// Adding root node
		discovered.add(node);

		while (!discovered.isEmpty()) {
			// Visit the first discovered node from the queue
			BinaryTreeNode<T> temp = discovered.remove();
			visited.add(temp.getData());

			// Insert children of visited node to queue.
			// Check if node is null before adding to the Queue otherwose it will add null
			// in queue
			if (temp.getLeft() != null)
				discovered.add(temp.getLeft());
			if (temp.getRight() != null)
				discovered.add(temp.getRight());
		}
		return visited;
	}
}
