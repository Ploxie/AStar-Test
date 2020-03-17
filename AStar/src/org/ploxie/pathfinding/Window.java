package org.ploxie.pathfinding;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window extends JFrame{

	public Window(String title, int width, int height) {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (dim.width - width) / 2;
		int y = (dim.height - height) / 2;

		setLocation(x, y);
		
		setSize(width, height);
		setTitle(title);
		
		
		Canvas canvas = new Canvas();
		add(canvas);
		
	}
	
}
