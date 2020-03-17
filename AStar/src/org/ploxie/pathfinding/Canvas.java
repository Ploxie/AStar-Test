package org.ploxie.pathfinding;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Canvas extends JPanel{

	private Grid grid;
	private int cellSize = 20;
	
	public Canvas() {

	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		if(this.grid == null) {
			this.grid = new Grid(getWidth() / cellSize, getHeight() / cellSize, cellSize);
			addMouseListener(this.grid);
		}
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		grid.draw(g);
	}
}