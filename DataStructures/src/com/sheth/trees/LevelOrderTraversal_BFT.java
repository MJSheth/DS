package com.sheth.trees;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// https://www.youtube.com/watch?v=86g8jAQug04

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
			// Check if node is null before adding to the Queue otherwise it will add null
			// in queue
			if (temp.getLeft() != null)
				discovered.add(temp.getLeft());
			if (temp.getRight() != null)
				discovered.add(temp.getRight());
		}
		return visited;
	}

	public Map<Integer, List<T>> getListOfNodesAtEachLevel(BinaryTreeNode<T> node) {
		// Map will container level as its Key and List (of node values) as its value
		Map<Integer, List<T>> levelNodesMap = new LinkedHashMap<Integer, List<T>>();
		if (node == null) {
			return levelNodesMap;
		}

		// Create a container that can hold node and corresponding level
		class Pair {
			BinaryTreeNode<T> node;
			int level;

			Pair(BinaryTreeNode<T> node, int level) {
				this.node = node;
				this.level = level;
			}

			public BinaryTreeNode<T> getNode() {
				return node;
			}

			public int getLevel() {
				return level;
			}

		}

		// Queue of discovered nodes
		Queue<Pair> discovered = new LinkedList<Pair>();
		// Root node is at level 1
		discovered.add(new Pair(node, 1));

		while (!discovered.isEmpty()) {

			// Visited Node
			Pair visited = discovered.remove();

			// Add visited node value and its level to Map
			addToLevelNodesMap(visited.getLevel(), visited.getNode().getData(), levelNodesMap);

			// Add left and right node to the discovered queue by increasing their level
			if (visited.getNode().getLeft() != null) {
				discovered.add(new Pair(visited.getNode().getLeft(), visited.getLevel() + 1));
			}

			if (visited.getNode().getRight() != null) {
				discovered.add(new Pair(visited.getNode().getRight(), visited.getLevel() + 1));
			}
		}

		return levelNodesMap;
	}

	private void addToLevelNodesMap(int key, T value, Map<Integer, List<T>> levelNodesMap) {
		if (levelNodesMap.containsKey(key)) {
			List<T> levelNodesList = levelNodesMap.get(key);
			levelNodesList.add(value);
			levelNodesMap.put(key, levelNodesList);
		} else {
			List<T> levelNodesList = new LinkedList<T>();
			levelNodesList.add(value);
			levelNodesMap.put(key, levelNodesList);
		}
	}
}
