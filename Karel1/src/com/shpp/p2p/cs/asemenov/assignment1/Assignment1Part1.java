package com.shpp.p2p.cs.asemenov.assignment1;

import com.shpp.karel.KarelTheRobot;

/* Declaring new class */
public class Assignment1Part1 extends KarelTheRobot {
  public void run() throws Exception {
	  
	  /*Safeguard for 1x1 worlds that performs a check if all 4 sides are blocked*/
	  
	  if (frontIsBlocked() && rightIsBlocked() && leftIsBlocked()) {
		  turnAround();
		  if (frontIsBlocked() && rightIsBlocked() && leftIsBlocked()) {
			  say("1x1 world");
			  return;
		  }
	  }
	  
	  /*Karel starts facing east when the program requires him to face north*/
	  
	  turnLeft();
	  
	  /*Program starts*/
	  
	  while(frontIsClear()) {
		  walker();
		  
	  }

  }
  
/*The moving mechanism that places beepers and calls a function to avoid walls if encountered*/ 
  
public void walker() throws Exception {  
	if (frontIsClear()) {
		 
		 /*Karel checks if front is clear,calls a beeper placer, then moves*/
		 
		if (frontIsClear()) {
			BeeperPlacer();
			move();
		}
		
		/*When Karel reaches the end of a column, he puts the last beeper and turns around*/
		
		if (frontIsBlocked() && facingNorth()) {
			BeeperPlacer();
			turnAround();
		}
		
		/*When Karel reaches the south wall, he checks if he is in a corner*/
		/*If he is - the program ends*/
		/*Else, walkToNextColumn() is called*/
		
		if (frontIsBlocked() && facingSouth()) {			
			if (frontIsBlocked() && leftIsBlocked() && facingSouth()) {
				say("Finish!");
				return;
			} else {
			
			walkToNextColumn();
			
			}
		}
	}
}

/*The fucntion checks if Karel is facing North and no beepers present*/
/*If true, Karel puts down a beeper*/

public void BeeperPlacer() throws Exception {
	if (facingNorth() && noBeepersPresent()) {
		putBeeper();
	}
}
  
/*Redirecting Karel to the next column*/
  
public void walkToNextColumn() throws Exception {
	turnLeft();
	move();
	move();
	move();
	move();
	turnLeft();
}

/*Turning around function*/

public void turnAround() throws Exception {
	turnLeft();
	turnLeft();
}

}

