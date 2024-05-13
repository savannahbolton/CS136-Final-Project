package array;

import java.util.*;
import java.io.*;
import array.Movie.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MovieGraphics extends JFrame{
	CardLayout cardLayout;
	JPanel mainPanel;
	JLabel mainLabel;
	Movie movie;
	JTextArea moviePanel;

	public MovieGraphics(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 800);

		cardLayout = new CardLayout();
		mainPanel = new JPanel(cardLayout);
		movie = new Movie();
		movie.injestData(false);

		JButton backButton = new JButton("<html><font face='Comic Sans MS' font size='100' color=black> back to menu");
		backButton.setBackground(Color.BLACK);
		backButton.setOpaque(true);

		//main menu
		JPanel panel1 = new JPanel();
        panel1.setBackground(Color.PINK);
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(Color.PINK);
        // Load image
        ImageIcon icon = new ImageIcon(new ImageIcon("figs/catbackground.png").getImage().getScaledInstance(637, 637, Image.SCALE_DEFAULT)); 
        JLabel imageLabel = new JLabel(icon);
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        panel1.add(imagePanel);
        JTextPane textbox2 = new JTextPane();
        textbox2.setContentType("text/html");
        textbox2.setText("<html><font face='Comic Sans MS' font size='500' color=black> HATboxd");
        textbox2.setBounds(150, 100, 800, 800);
        textbox2.setBackground(Color.WHITE);
        textbox2.setOpaque(true);
        panel1.add(textbox2);


        //sorting menu
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.PINK);
        //text panels
        JTextPane textbox1 = new JTextPane();
        textbox1.setContentType("text/html");
        textbox1.setText("<html><font face='Comic Sans MS' font size='300' color=black> Choose a query to filter & sort by: ");
        textbox1.setBounds(150, 100, 800, 800);
        textbox1.setBackground(Color.WHITE);
        textbox1.setOpaque(true);
        panel2.add(textbox1);

        //all buttons on sorting menu
        JButton rating = new JButton("<html><font face='Comic Sans MS' font size='100' color=black> rating");
        rating.setBackground(Color.BLACK);
		rating.setOpaque(true);
        JButton genre = new JButton("<html><font face='Comic Sans MS' font size='100' color=black> genre");
        genre.setBackground(Color.BLACK);
        genre.setOpaque(true);
        JButton year = new JButton("<html><font face='Comic Sans MS' font size='100' color=black> year");
        year.setBackground(Color.BLACK);
        year.setOpaque(true);
        JButton director = new JButton("<html><font face='Comic Sans MS' font size='100' color=black> director");
        director.setBackground(Color.BLACK);
        director.setOpaque(true);
        JButton star = new JButton("<html><font face='Comic Sans MS' font size='100' color=black> star");
        star.setBackground(Color.BLACK);
        star.setOpaque(true);
        panel2.add(rating);
        panel2.add(genre);
        panel2.add(year);
        panel2.add(director);
        panel2.add(star);
        panel2.add(backButton);

        moviePanel = new JTextArea();
        moviePanel.setBackground(Color.PINK);
        Font font = new Font("Comic Sans MS", Font.PLAIN, 45);
        moviePanel.setFont(font);
        moviePanel.setLineWrap(true);
		moviePanel.setWrapStyleWord(true);
		moviePanel.setPreferredSize(new Dimension(700, 600));
		moviePanel.setBackground(Color.WHITE);
        panel2.add(moviePanel);

		rating.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String userInput = JOptionPane.showInputDialog(null, "Which rating? [G, PG, PG-13, R, Unrated]");
        		if(userInput != null) {
            		movie.graphics(userInput);
            		moviePanel.setText("Movies (Sorted by score): " + movie.getArray().toString());
				}
			}
		});

		genre.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String userInput = JOptionPane.showInputDialog(null, "Which genre? [Horror, Action, Drama, Comedy, etc.]");
        		if(userInput != null) {
            		movie.graphics(userInput);
            		moviePanel.setText("Movies (Sorted by score): " + movie.getArray().toString());
				}
			}
		});

		year.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String userInput = JOptionPane.showInputDialog(null, "Which year? [1986-2020]");
        		if(userInput != null) {
            		movie.graphics(userInput);
            		moviePanel.setText("Movies (Sorted by score): " + movie.getArray().toString());
				}
			}
		});

		director.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String userInput = JOptionPane.showInputDialog(null, "Which director? [type their full name]");
        		if(userInput != null) {
            		movie.graphics(userInput);
            		moviePanel.setText("Movies (Sorted by score): " + movie.getArray().toString());
				}
			}
		});

		star.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String userInput = JOptionPane.showInputDialog(null, "Which star? [type their full name]");
        		if(userInput != null) {
            		movie.graphics(userInput);
            		moviePanel.setText("Movies (Sorted by score): " + movie.getArray().toString());
				}
			}
		});

		backButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cardLayout.first(mainPanel);
			}
		});


        //review menu
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.PINK);

        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.PINK);

		//SORT BUTTON
		JButton sortButton = new JButton("<html><font face='Comic Sans MS' font size='200' color=black> Get a Recommendation");
		sortButton.setBackground(Color.BLACK);
		sortButton.setOpaque(true);
		buttonPanel.add(sortButton);

		//REVIEW BUTTON
		JButton reviewButton = new JButton("<html><font face='Comic Sans MS' font size = '300' color=black> Write a Review");
		reviewButton.setBackground(Color.BLACK);
		reviewButton.setOpaque(true);
		buttonPanel.add(reviewButton);

        panel1.add(buttonPanel);

		//checks when sort button is clicked
		sortButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cardLayout.next(mainPanel);
			}
		});

		//checks when review button is clicked
		reviewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				cardLayout.last(mainPanel);
			}
		});

		getContentPane().add(mainPanel);
        getContentPane().setBackground(Color.PINK);

        setVisible(true);
	}


	public static void main(String[] args) {
		new MovieGraphics();

	}

}

	
