import java.util.*;

public class State {
	public myButton[][] state = new myButton[5][5];
	public int[][] actionsDone = new int[5][5];
	// public ArrayList<Action> actions = new ArrayList<Action>();

	public State(myButton[][] state, int[][] actions) {
		this.state = state;
		this.actionsDone = actions;
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

	public ArrayList<Action> getActions () {
		// return this.actions;
		ArrayList<Action> actions = new ArrayList<Action>();
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				if(actionsDone[i][j] == 0) {
				// Pwede pang gawin ang action na ito
					actions.add(new Action(i, j));
				}
			}
		}

		return actions;
	}

	public State doAction(Action a) {
		myButton toPress = state[a.getI()][a.getJ()];
		int[][] actionsDone = this.actionsDone;
		actionsDone[a.getI()][a.getJ()] = 1;
		State temp = new State(LightsOut.toggle(this.state, toPress), actionsDone);
	}

}
