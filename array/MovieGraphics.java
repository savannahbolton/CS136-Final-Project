package array;

import java.util.*;
import java.io.*;
import array.HAT.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class MovieGraphics extends JFrame{
	JFrame mainWindow;
	JLabel mainLabel;
	public MovieGraphics(){
		mainWindow = new JFrame();
		mainWindow.setSize(800, 800);

		//SORT BUTTON
		JButton sortButton = new JButton("<html><font size='300' color=blue> SORT");
		sortButton.setBounds(150, 600, 500, 100);
		sortButton.setBackground(Color.RED);
		sortButton.setOpaque(true);

		//MAIN LABEL
		mainLabel = new JLabel();
		JPanel label = new JPanel();
		mainLabel.setText("HATboxd!!!!");
		label.add(mainLabel);
		label.setOpaque(true);
		label.setBackground(Color.WHITE);
		label.setBounds(300, 200, 200, 200);

		mainWindow.add(sortButton);
		mainWindow.setLayout(null);
		mainWindow.setVisible(true);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.getContentPane().setBackground(Color.frePINK);
		mainWindow.add(label);
	}
	// public Movie graphicslist; 

	// public BufferedImage bf = new BufferedImage(800, 800, 
	// 		BufferedImage.TYPE_INT_RGB);
	
	// public MovieGraphics() {
	// 	this.graphicslist = new Movie(); 

	// 	CoinMouseListener listener = new CoinMouseListener();
	// 	addMouseListener(listener);
	// 	addMouseMotionListener(listener);
		

	// 	JPanel panel = new JPanel();
	// 	JButton sortButton = new JButton("SORT");
	// 	panel.add(sortButton);
	// 	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// 	setSize(800, 800);
	// 	setVisible(true);

	// }

	// private int getCoinSquareIndex(int x, int y) {
	// 	return 0; 
	// }
	
	// public void paint(Graphics g) {
	// 	Graphics2D g2 = (Graphics2D) bf.getGraphics();;

	// 	g2.setPaint(Color.WHITE);

	// 	g.drawImage(bf,0,0,null);	
	// }
		
	/**
	 * An inner class to respond to mouse events.
	 */
	// private class CoinMouseListener implements MouseListener, MouseMotionListener {
		
	// 	public void mousePressed(MouseEvent event) {
			
	// 	}

	// 	private boolean clickedOnCoin(int x, int y) {
	// 		return true; 
	// 	}
		
	// 	public void mouseReleased(MouseEvent event) {
			
	// 	}

	// 	public void mouseDragged(MouseEvent event) {
			
	// 	}

	// 	public void mouseClicked(MouseEvent event) {}
	// 	public void mouseEntered(MouseEvent event) {}
	// 	public void mouseExited(MouseEvent event) {}
	// 	public void mouseMoved(MouseEvent event) {}
	// }

	public static void main(String[] args) {
		new MovieGraphics();
		// JFrame mainWindow = new JFrame();
		// mainWindow.setSize(800, 800);
		// JButton sortButton = new JButton("SORT");
		// sortButton.setBounds(100, 100, 500, 100);
		// mainWindow.add(sortButton);
		// mainWindow.setLayout(null);
		// mainWindow.setVisible(true);

	}

}

	
