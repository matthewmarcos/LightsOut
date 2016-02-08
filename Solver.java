// Created by: Joseph Matthew R. Marcos
// Exercise 2: Solving Lights out with Brute Force
// CMSC 170 UV-1L
// 2nd Semester AY 2015-2016

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.util.*;
import java.io.*;

public class Solver {

	public static LinkedList<State> frontier =  new LinkedList<State>();

	public static void solve(myButton[][] button) {
		State currentState = null;
		boolean[][] tempActionsDone = new boolean[5][5];
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				tempActionsDone[i][j] = false;
			}
		}
		frontier.add(new State(button, tempActionsDone));
		while(!frontier.isEmpty()) {
			currentState = frontier.remove(0);

			LinkedList<Action> actions = currentState.getActions();
			// System.out.println("Actions Length: " + actions.size());

			if(LightsOut.checkGame(currentState.getState())) {
			// This state is finished.
				System.out.println("Break!");
				currentState.printMe();
				break;
			}
			else {
				for(Action a : actions) {
					frontier.add(currentState.doAction(a));
				}				
			}
		}

		printAnswer(currentState);
		//Do something about current state
	}

	public static void printAnswer(State answer) {
		System.out.println("Answer found");
		answer.printActionsDone();
		answer.displayTotalActions();
	}
}