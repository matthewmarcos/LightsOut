// Created by: Joseph Matthew R. Marcos
// Exercise 2: Solving Lights out with Brute Force
// CMSC 170 UV-1L
// 2nd Semester AY 2015-2016

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.util.*;
import java.io.*;

public class LightsOut {

	public static int row = 5, col = 5;
	public static int[][] initialState = new int[row][col];
	public static Random random = new Random();
	private static myButton[][] button = new myButton[row][col]; 

	public static void main(String[] args) throws Exception {

		// Initialize the frame
		JFrame frame = new JFrame("LightsOut by Matthew Marcos");
		frame.setSize(new Dimension(600, 620));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		// Panel
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(600, 600));
		panel.setLayout(new GridLayout(row, col));

		// Solver button
		JButton solver = new JButton("Solve");
		solver.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent ev){
				LightsOut.solve();
			}
			public void mousePressed(MouseEvent ev){}
			public void mouseEntered(MouseEvent ev){}
			public void mouseReleased(MouseEvent ev){}
			public void mouseExited(MouseEvent ev){}

		});

		// Read the initial state of the board
		initialState = readState("lightsout.in");
		
		// Initialize the board
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				boolean state = (initialState[i][j] == 1) ? false : true;
				button[i][j] = new myButton(i, j, state);
				button[i][j].setSize(120, 120);
				
				button[i][j].setText("Button" + i + j);
				button[i][j].addMouseListener(new MouseListener() {
					public void mouseClicked(MouseEvent ev){
						((myButton)ev.getSource()).setSelected(!((myButton)ev.getSource()).isSelected());
						LightsOut.button = toggle(LightsOut.button, (myButton)ev.getSource());
						if(checkGame(LightsOut.button)) endGame();
					}
					public void mousePressed(MouseEvent ev){}
					public void mouseEntered(MouseEvent ev){}
					public void mouseReleased(MouseEvent ev){}
					public void mouseExited(MouseEvent ev){}
 	
				});

				panel.add(button[i][j]);
			}
		}
		frame.add(panel, BorderLayout.CENTER);
		frame.add(solver, BorderLayout.PAGE_END);
		// frame.pack();
		frame.setVisible(true);
	}

	public static void solve() {
		// Put state of the board into another object
		Solver.solve(LightsOut.button);
	}

	public static boolean randomB() {
		return random.nextBoolean();
	}


	public static int[][] readState(String fTitle) {
		int[][] initialState = new int[row][col];
		String line;
		try {
			FileReader fileReader = new FileReader(fTitle);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
            for(int i = 0 ; i < row ; i++) { 
            	line = bufferedReader.readLine();
            	if(line == null) {
					break;
				}               
				for(int j = 0 ; j < col ; j++) {
					initialState[i][j] = line.charAt(j*2) - 48;
				}
            }
			bufferedReader.close(); 

		} catch (Exception e) {
			System.out.println("Error at readState()");
		}

		return initialState;
	}


	public static myButton[][] toggle(myButton[][] buttons, myButton b) {
		int i = b.i, j = b.j;
		System.out.println(i + " " + j);
		myButton[][] button = buttons; 
		LinkedList<myButton> toToggle = new LinkedList<myButton>();
		toToggle.add(button[i][j]);

		if(i == 0 && j == 0) {
			toToggle.add(button[i+1][j]);
			toToggle.add(button[i][j+1]);

		}
		else if(i == 0 && j == col-1) {
			toToggle.add(button[i+1][j]);
			toToggle.add(button[i][j-1]);

		}
		else if(i == row-1 && j == 0) {
			toToggle.add(button[i-1][j]);
			toToggle.add(button[i][j+1]);

		}
		else if(i == row-1 && j == col-1) {
			toToggle.add(button[i-1][j]);
			toToggle.add(button[i][j-1]);

		}
		else if(i == 0) {
			toToggle.add(button[i+1][j]);
			toToggle.add(button[i][j-1]);
			toToggle.add(button[i][j+1]);
		}
		else if(i == row-1) {
			toToggle.add(button[i-1][j]);
			toToggle.add(button[i][j-1]);
			toToggle.add(button[i][j+1]);
		}
		else if(j == 0) {
			toToggle.add(button[i-1][j]);
			toToggle.add(button[i+1][j]);
			toToggle.add(button[i][j+1]);
		}
		else if(j == col-1) {
			toToggle.add(button[i-1][j]);
			toToggle.add(button[i+1][j]);
			toToggle.add(button[i][j-1]);
		}
		else {
			toToggle.add(button[i-1][j]);
			toToggle.add(button[i+1][j]);
			toToggle.add(button[i][j-1]);
			toToggle.add(button[i][j+1]);

		}


		for(myButton s: toToggle) {
			s.setSelected(!s.isSelected());
		}

		return button;
	}


	public static boolean checkGame(myButton[][] button) {
		int numbers = 0;
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				if(button[i][j].isSelected()) {
					numbers++;
				}
			}
		}

		if(numbers == 25){
			return true;
		}

		return false;
	}


	public static void endGame() {
		JFrame dialogue = new JFrame("Message");
		dialogue.setSize(new Dimension(200, 100));
		JOptionPane.showMessageDialog(dialogue,
			"Done");
	}
}
