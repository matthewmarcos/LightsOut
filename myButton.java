// Created by: Joseph Matthew R. Marcos
// Exercise 2: Solving Lights out with Brute Force
// CMSC 170 UV-1L
// 2nd Semester AY 2015-2016

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.util.*;

public class myButton extends JToggleButton {
	public int i;
	public int j;

	Random random = new Random();

	myButton(int i, int j, boolean status) {
		super("", null, status);
		this.i = i;
		this.j = j;
	}

	public void toggle() {
		System.out.println("Toggle from myButton");
	}
}