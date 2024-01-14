// Ananya Soni
// 2/09/2022
// Purpose:
// This is the bear critter class extension.
// This program defines the behavior of
// the bear critter.

import java.awt.*;

// Overview of Lion Class:

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////|
// Constructor	| public Lion()                                                                                                |
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////|
// Color 	   | Randomly picks one of three colors (Color.RED, Color.GREEN, Color.BLUE) and uses that color for              |
//             | three moves, then randomly picks one of those colors again for the next three moves, then randomly           |
//             | picks another one of those colors for the next three moves, and so on.                                       |
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////|
// toString    | "L"                                                                                                          |
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////|
// getMove	   | always infect if an enemy is in front                                                                        |
//             | otherwise if a wall is in front or to the right, then turn left                                              |
//             | otherwise if a fellow Lion is in front, then turn right                                                      |
//             | otherwise hop.                                                                                               |
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////|


public class Lion extends Critter {
	
	// 2 fields:
	
	private Color startingColor;
	private int steps;
   
	///////////////////////////////////////////////////////////
   // Purpose: This  starts off the steps count at 0.
   //
   
	public Lion () {
		this.steps = 0; //sets initial step count to 0
	}
	
   //////////////////////////////////////////////////////////////////////////
   // Purpose: This method returns an L, so that the Lion critter
   //          is displayed as "L'
   //
   // output: string value of Lion --> "L"
   
	public String toString() {
		return ("L");
	}
	
   //////////////////////////////////////////////////////////////////////////
   // Purpose: This method returns a random color using Math.random.
   //          This ensures that the lion is displayed with random a
   //          random color. (Color.RED, Color.GREEN, Color.BLUE)
   //
   // output: returns Color
   
	private Color getRandomColor() {
		double random = Math.random() * 3;
		if (random < 1.0) {          // random less than 1
			return Color.GREEN;
		} else if (random < 2.0) {   // random in between 1 & 2
			return Color.RED;
		} else {                     // random greater than 2
			return Color.BLUE;
		}
	}

   //////////////////////////////////////////////////////////////////////////
   // Purpose: Ensures that the Color of the lions only changes after every
   //          3 steps by only changing the color if number of steps mod
   //          3 equals 0. If not the color should stay the same as before.
   //
   // output: returns Color	
   
	public Color getColor() {
		if (this.steps % 3 == 0) {
			this.startingColor = getRandomColor();
		} 
		return this.startingColor;
	}
	
   ///////////////////////////////////////////////////////////////////////////
   // Purpose: This method decides how the lion moves after each step
   //          in the simulation. This method takes in the CritterInfo
   //          to check where the enemy, wall, or fellow lion is and based on 
   //          the position of them it makes one type of move for each step. 
   //          The lion always infects if an enemy is in front, otherwise
   //          if a wall is in front or to the right, then the lion turns left,
   //          otherwise if a fellow lion is in front it turns right, and 
   //          as a last case resort it hops.
   //
   // input:  CritterInfo info
   // output: Action (Ex: infect, turn left, turn right, and hop)
   
	public Action getMove(CritterInfo info) {
		this.steps = this.steps + 1; // increments step count by 1 every time getMove() is used, which is once for each step
		if (info.getFront() == Neighbor.OTHER) {
			return Action.INFECT;  // infect if an enemy is in front
		} else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
			return Action.LEFT; // if a wall is in front or to the right, then turn left
		} else if (info.getFront() == Neighbor.SAME) {
			return Action.RIGHT; // if a fellow Lion is in front, then turn right
		} else {
			return Action.HOP; // otherwise hop
		}
	}
	
}




