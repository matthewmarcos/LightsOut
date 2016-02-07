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

	public static ArrayList<State> frontier =  new ArrayList<State>();

	public static void solve(myButton[][] button) {
		State currentState = null;
		boolean[][] tempActionsDone = new boolean[5][5];
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				tempActionsDone[i][j] = false;
			}
		}
		frontier.add(new State(button, tempActionsDone));
		int i = 0;
		while(!frontier.isEmpty()) {
			i++;
			System.out.println("Here~" + i);
			currentState = frontier.remove(0);
			if(LightsOut.checkGame(currentState.getState())) {
			// This state is finished.
				break;
			}
			else {
				ArrayList<Action> actions = currentState.getActions();
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
	}
}