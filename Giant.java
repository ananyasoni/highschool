// Ananya Soni
// 2/09/2022

import java.awt.*;

// Overview of Giant Class:

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////|
// Constructor	| public Giant()                                                                                               |
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////|
// Color 	   | Color.GRAY                                                                                                   |
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////|
// toString    | "fee" for 6 moves, then "fie" for 6 moves, then "foe" for 6 moves, then "fum" for 6 moves, then repeat.      |                                                                                                   |
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////|
// getMove	   | always infect if an enemy is in front                                                                        |
//             | otherwise hop if possible                                                                                    |
//             | otherwise turn right.                                                                                        |
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////|

public class Giant extends Critter {

	// 3 fields:
	private String[] nameOptions = {"fee", "fie", "foe", "fum"};
	private int steps;
   	private final int switchFrequency = 6;
 
   ///////////////////////////////////////////////////////////
   // Purpose: Thisconstructor sets the number of steps to 0 and sets the
   //          switch frequncy to 6 because after every 6 steps
   //          the String name of the Giant changes
   
	public Giant() {
		this.steps = 0; // sets steps to 0    
	}
   /////////////////////////////////////////////////////////////////
   // Purpose: This method returns the color gray to display the 
   //          Giant as gray.
   //
   // output: Color
   
	public Color getColor() {
		return Color.GRAY;
	}
   
	//////////////////////////////////////////////////////////////////////////
   // Purpose: This method returns the String value of the Giant based on the
   //          amount of steps divided by the frequency of switches which is 
   //          6. The result gives the position in the array of nameOptions
   //          from which to return the current String Name.
   //
   // output: string value of Giant
   
	public String toString() {
		int index = (this.steps/this.switchFrequency);
		return nameOptions[index];
	}
	
   
   ///////////////////////////////////////////////////////////////////////////
   // Purpose: This method decides how the Giant moves after each step
   //          in the simulation. This method takes in the CritterInfo
   //          to check where the enemy is and based on the position of 
   //          the enemy it makes one type of move for each step. 
   //          The Giant always infects if an enemy is in front otherwise
   //          it hops if possible, and if it is not possible for it to hop,
   //          it turns right. It also resets the steps to 0 after every 
   //          24 steps to avoid array out of bounds exception.
   //
   // input:  CritterInfo info
   // output: Action (Ex: infect, hop, turn right)
   
	public Action getMove(CritterInfo info) {
		this.steps++;
      		if (this.steps == (this.switchFrequency * nameOptions.length)) { // resets steps to 0 after every 24 steps to                                                             
		   this.steps = 0;	                                         // avoid array out of bounds exception. 	
		}    
      
		if (info.getFront() == Neighbor.OTHER) {          // checks if the enemy is in front
			return Action.INFECT;                          // infects if an enemy is in front
		} else if (info.getFront() == Neighbor.EMPTY) {
			return Action.HOP;                             // hops if possible otherwise
		} else {
			return Action.RIGHT;                           // last case scenario, turns right
		}
	}
}








