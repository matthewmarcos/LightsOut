import java.util.*;

public class State {
	public myButton[][] state = new myButton[5][5];
	public boolean[][] actionsDone = new boolean[5][5];
	// public LinkedList<Action> actions = new LinkedList<Action>();

	public State(myButton[][] state, boolean[][] actions) {
		// this.state = state;
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				this.state[i][j] = new myButton(i, j, state[i][j].isSelected());
				this.actionsDone[i][j] = !!(actions[i][j]);
			}
		}
		// this.actionsDone = actions;
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

	public LinkedList<Action> getActions () {
		// return this.actions;
		int x = 0;
		LinkedList<Action> actions = new LinkedList<Action>();
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++, x++) {
				if(!actionsDone[i][j]) {
				// Pwede pang gawin ang action na ito
					actions.add(new Action(i, j));
					// System.out.println("Action " + x);
				}
			}
		}

		return actions;
	}

	public State doAction(Action a) {
		myButton[][] tempState = new myButton[5][5];
		boolean[][] tempActionsDone = new boolean[5][5];

		if(this.actionsDone[a.getI()][a.getJ()]) {
			System.out.println("Cannot pressthis state");
			return null;
		}

		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				tempState[i][j] = new myButton(i, j, state[i][j].isSelected());
			}
		}

		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				tempActionsDone[i][j] = !!(this.actionsDone[i][j]);
			}
		}

		myButton toPress = tempState[a.getI()][a.getJ()];
		actionsDone[a.getI()][a.getJ()] = true;
		State temp = new State(LightsOut.toggle(tempState, toPress), tempActionsDone);
		// temp.printMe();
		temp.printActionsDone();
		return temp;
	}

	public void printMe() {
		System.out.println("Board: ");
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				if(state[i][j].isSelected()) {
					System.out.print("0 ");
				} else {
					System.out.print("1 ");
				}
			}
			System.out.println("");
		}
		System.out.println("=========");
	}

	public void printActionsDone() {
		System.out.println("ActionsDone: ");
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				if(actionsDone[i][j]) {
					System.out.print("0 ");
				} else {
					System.out.print("1 ");
				}
			}
			System.out.println("");
		}
		System.out.println("=========");
	}
}
