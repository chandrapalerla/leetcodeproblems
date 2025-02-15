package com.datastructure.graph;

import java.util.ArrayList;

import com.datastructure.node.WeightedNode;

public class FloydWarshall {
	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

	public FloydWarshall(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}

	public void addWeightedEdge(int i, int j, int d) {
		WeightedNode first = nodeList.get(i - 1);
		WeightedNode second = nodeList.get(j - 1);
		first.getNeighbors().add(second);
		first.getWeightMap().put(second, d);

	}

	public void floydWarshall() {
		int size = nodeList.size();
		int[][] V = new int[size][size];

		for (int i = 0; i < size; i++) {
			WeightedNode first = nodeList.get(i);
			for (int j = 0; j < size; j++) {
				WeightedNode second = nodeList.get(j);
				if (i == j)
					V[i][j] = 0;
				else if (first.getWeightMap().containsKey(second)) {// we have direct edge between i & j
					V[i][j] = first.getWeightMap().get(second);

				} else {// no direct edge between i & j, so mark it as infinity [divided by 10 to avoid
						// arithmetic overflow]
					V[i][j] = Integer.MAX_VALUE / 10;
				}
			}
		}

		for (int i = 0; i < nodeList.size(); i++) {
			for (int j = 0; j < nodeList.size(); j++) {
				for (int k = 0; k < nodeList.size(); k++) {
					if (V[i][j] > V[i][k] + V[k][j]) { // if update possible, then update path
						V[i][j] = V[i][k] + V[k][j];// this will keep a track on path
					}
				}
			}
		}
		// Print table of node with minimum distance and shortest path from each source
		for (int i = 0; i < size; i++) {
			System.out.print("Printing distance list for node " + nodeList.get(i) + ": ");
			for (int j = 0; j < size; j++) {
				System.out.print(V[i][j] + " ");
			}
			System.out.println();
		}

	}

}
