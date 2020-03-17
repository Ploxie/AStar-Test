package org.ploxie.pathfinding;

public class Bootstrap {

	public static void main(String[] args) {
		Window window = new Window("A Star", 800,600);
		window.setVisible(true);	
		
		while(true) {
			window.repaint();
		}
	}
	
}
