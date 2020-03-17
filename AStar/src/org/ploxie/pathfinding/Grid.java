package org.ploxie.pathfinding;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class Grid implements MouseListener{

	private int rows;
	private int columns;
	private int cellSize;
	
	private Node start;
	private Node end;
	
	private AStar astar;
	private List<Node> nodes;
	
	public Grid(int columns, int rows, int cellSize) {
		this.columns = columns;
		this.rows = rows;
		this.cellSize = cellSize;
		
		astar = new AStar(rows, columns);
	}
	
	public void draw(Graphics g) {
		if(astar != null) {
			g.setColor(Color.GRAY);
			for(Node node : astar.getClosedSet()) {
				g.fillRect(node.getColumn() * cellSize , node.getRow() * cellSize, cellSize, cellSize);
			}
		}
		
		g.setColor(Color.CYAN);
		if(nodes != null) {
	    	for(Node node : nodes) {
	    		g.fillRect(node.getColumn() * cellSize , node.getRow() * cellSize, cellSize, cellSize);
	    	}
		}
		
		if(start != null) {
			g.setColor(Color.GREEN);
			g.fillRect(start.getColumn() * cellSize, start.getRow() * cellSize, cellSize, cellSize);
		}
		
		if(end != null) {
			g.setColor(Color.RED);
			g.fillRect(end.getColumn() * cellSize, end.getRow() * cellSize, cellSize, cellSize);
		}
		
		g.setColor(Color.BLACK);
		for(int y = 0 ;y < rows; y++) {
			for(int x = 0; x < columns; x++) {
				g.drawRect(x * cellSize, y * cellSize, cellSize, cellSize);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		int x = e.getX() / cellSize;
		int y = e.getY() / cellSize;
		
		if(e.getButton() == MouseEvent.BUTTON1) {
			start = new Node(y,x);
		}else if(e.getButton() == MouseEvent.BUTTON3) {
			end = new Node(y,x);
		}		
		else if(e.getButton() == MouseEvent.BUTTON2) {
			astar.addBlock(x, y);
		}
		
		if(start != null && end != null) {
			
			astar.setInitialNode(start);
			astar.setFinalNode(end);
			nodes = astar.findPath();
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
