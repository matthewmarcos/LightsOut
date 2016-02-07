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
		frontier.add(new State(button, new int[5][5]));
		while(!frontier.isEmpty()) {
			currentState = frontier.remove(0);
			ArrayList<Action> actions = currentState.getActions();
			if(LightsOut.checkGame(currentState.getState())) {
			// This state is finished.
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
	}
}