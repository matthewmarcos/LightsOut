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