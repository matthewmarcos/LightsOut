import java.util.*;

public class State {
	public int[][] state = new int[5][5];
	public int[][] actions = new int[5][5];
	// public ArrayList<Action> actions = new ArrayList<Action>();

	public State(int[][] state, int[][] actions) {
		this.state = state;
		this.actions = actions;
	}

	public int getCost () {
	// Return the cost of reaching a certain state from the original state
		int tempCost = 0;
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				if(actions[i][j] == 1) {
					tempCost++;
				}
			}
		}

		return tempCost;
	}

	public myButton[][] getState () {
	// Return a board representation with this state
		myButton[][] button = new myButton[5][5]; 

		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				if(state[i][j] == 1) {
					button[i][j] = new myButton(i, j, true);
				}
				else {
					button[i][j] = new myButton(i, j, false);
				}				
			}
		}

		return button;
	}

	public int[][] getActions () {
		return this.actions;
	}
}
