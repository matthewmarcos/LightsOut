import java.util.*;

public class State {
	public myButton[][] state = new myButton[5][5];
	public boolean[][] actionsDone = null;
	// public ArrayList<Action> actions = new ArrayList<Action>();

	public State(myButton[][] state, boolean[][] actions) {
		this.state = state;
		this.actionsDone = actions;
	}

	public int getCost () {
	// Return the cost of reaching a certain state from the original state
		int tempCost = 0;
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				if(actionsDone[i][j]) {
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
		int x = 0;
		ArrayList<Action> actions = new ArrayList<Action>();
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++, x++) {
				if(!actionsDone[i][j]) {
				// Pwede pang gawin ang action na ito
					actions.add(new Action(i, j));
					System.out.println("Action " + x);
				}
			}
		}

		return actions;
	}

	public State doAction(Action a) {
		if(this.actionsDone[a.getI()][a.getJ()]) {
			System.out.println("Cannot pressthis state");
		}
		myButton[][] tempState = this.state;
		myButton toPress = tempState[a.getI()][a.getJ()];
		boolean[][] actionsDone = this.actionsDone;
		actionsDone[a.getI()][a.getJ()] = true;
		return new State(LightsOut.toggle(this.state, toPress), actionsDone);
	}

}
