// Ananya Soni
// 2/09/2022
// Purpose:
// This is the bear critter class extension.
// This program defines the behavior of
// the bear critter.

import java.awt.*;

// Overview of Bear Class:

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////|
// Constructor	| public Bear(boolean polar)                                                                                   |
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////|
// toString	   | Should alternate on each different move between a slash character (/) and a backslash character (\)          |
//             | starting with a slash.                                                                                       |
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////|
// Color	      | Color.WHITE for a polar bear (when polar is true), Color.BLACK otherwise (when polar is false)               |
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////|
// getMove	   | always infect if an enemy is in front                                                                        |
//             | otherwise hop if possible                                                                                    |
//             | otherwise turn left.                                                                                         |
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////|


public class Bear extends Critter {
	
	// 3 fields:
	
	private boolean polar; // polar used to decide color of Bear
	private int steps;     // will be used to count steps: since this is an
	                       // instance field that is incremented every time getMove() is called
	
   ///////////////////////////////////////////////////////////
   // Purpose: This constructor takes a boolean parameter 
   //          specifying whether it is a black bear or a
   //          polar bear, which will change how its color
   //          is displayed. It also starts off the steps 
   //          at 0.
   //
   // input: boolean polar
   
	public Bear(boolean polar) {		                        
		this.polar = polar;
		this.steps = 0;         //starts steps count at 0
	}
   
   //////////////////////////////////////////////////////////////////////////
   // Purpose: This method alternates on each different move between
   //          a slash character (/) and a backslash character (\),
   //          starting with a slash character. This means
   //          that for every even step in the simulation, the bear should
   //          turn to a forward slash and for every odd step it should turn
   //          to a backslash. 
   //
   // output: string value of bear
   	
	public String toString() {
		if (steps % 2 == 1) {
			return "\\";      // odd steps --> backslash
		} else {
			return "/";       // even steps --> slash, and starts the game (step 0) with bears displayed as
                           // slash (/) character because 0 % 2 = 0 not 1. 
		}
	}
	
   /////////////////////////////////////////////////////////////////
   // Purpose: This method looks at the boolean polar value
   //          and displays the bear as black if the value is false
   //          but white if polar is true.
   //
   
	public Color getColor() {
		if (!this.polar) {     //checks if polar is false
			return Color.BLACK; //turns the bear black
		} else {
			return Color.WHITE; //turns the bear white if polar is true
		}
	}
	
   ///////////////////////////////////////////////////////////////////////////
   // Purpose: This method decides how the bear moves after each step
   //          in the simulation. This method takes in the CritterInfo
   //          to check where the enemy is and based on the position of 
   //          the enemy it makes one type of move for each step. 
   //          The bear always infects if an enemy is in front otherwise
   //          it hops if possible, and if it is not possible for it to hop,
   //          it turns left.
   //
   // input:  CritterInfo info
   // output: Action (Ex: infect, hop, turn left)
   
	public Action getMove(CritterInfo info) {
		this.steps++;
		if (info.getFront() == Neighbor.OTHER) {        // checks if the enemy is in front
			return Action.INFECT;                        // infects if an enemy is in front
		} else if (info.getFront() == Neighbor.EMPTY) {
			return Action.HOP;                           // hops if possible otherwise
		} else {
			return Action.LEFT;                          // last case scenario, turns left
		}
	}
}




