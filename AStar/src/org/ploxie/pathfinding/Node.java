package org.ploxie.pathfinding;

public class Node {

	private int row;
	private int column;

	private int g;
	private int f;
	private int h;

	private boolean blocked;
	private Node parent;

	public Node(int row, int col) {
		this.row = row;
		this.column = col;
	}

	public void calculateHeuristic(Node goalNode) {
		this.h = Math.abs(goalNode.getRow() - getRow()) + Math.abs(goalNode.getColumn() - getColumn());
	}

	public void setNodeData(Node currentNode, int cost) {
		int gCost = currentNode.getG() + cost;
		setParent(currentNode);
		setG(gCost);
		calculateFinalCost();
	}

	public boolean checkBetterPath(Node currentNode, int cost) {
		int gCost = currentNode.getG() + cost;
		if (gCost < getG()) {
			setNodeData(currentNode, cost);
			return true;
		}
		return false;
	}

	private void calculateFinalCost() {
		int finalCost = getG() + getH();
		setF(finalCost);
	}

	@Override
	public boolean equals(Object obj) {
		Node other = (Node) obj;
		return this.getRow() == other.getRow() && this.getColumn() == other.getColumn();
	}

	@Override
	public String toString() {
		return "Node [row=" + row + ", col=" + column + "]";
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int col) {
		this.column = col;
	}
}
