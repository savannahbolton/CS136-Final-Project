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

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MovieGraphics extends JFrame {

	public Movie graphicslist; 

	public BufferedImage bf = new BufferedImage(500, 500, 
			BufferedImage.TYPE_INT_RGB);
	
	public MovieGraphics() {
		this.graphicslist = new Movie(); 

		// --- only add code above here in this method --- //
		// This chunk of code manages the user clicking 
		CoinMouseListener listener = new CoinMouseListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);

	}

	private int getCoinSquareIndex(int x, int y) {
		return 0; 
	}
	
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) bf.getGraphics();;

		g2.setPaint(Color.WHITE);

		g.drawImage(bf,0,0,null);	
	}
		
	/**
	 * An inner class to respond to mouse events.
	 */
	private class CoinMouseListener implements MouseListener, MouseMotionListener {
		
		public void mousePressed(MouseEvent event) {
			
		}

		private boolean clickedOnCoin(int x, int y) {
			return true; 
		}
		
		public void mouseReleased(MouseEvent event) {
			
		}

		public void mouseDragged(MouseEvent event) {
			
		}

		public void mouseClicked(MouseEvent event) {}
		public void mouseEntered(MouseEvent event) {}
		public void mouseExited(MouseEvent event) {}
		public void mouseMoved(MouseEvent event) {}
	}

	public static void main(String[] args) {
		MovieGraphics test = new MovieGraphics(); 
	}

}

	
