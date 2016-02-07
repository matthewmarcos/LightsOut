import java.util.*;

public class State {
	public myButton[][] state = new myButton[5][5];
	public int[][] actions = new int[5][5];
	// public ArrayList<Action> actions = new ArrayList<Action>();

	public State(myButton[][] state, int[][] actions) {
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
		return this.state;
	}

	public myButton[] getActions () {
		// return this.actions;
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				if(actions[i][j] == 1) {
					tempCost++;
				}
			}
		}
	}

}
