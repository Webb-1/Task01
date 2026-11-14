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
		  WalkerPlacer();
		  
	  }

  }
  
/*The moving mechanism that places beepers and calls a function to avoid walls if encountered*/ 
  
public void WalkerPlacer() throws Exception {
	if (frontIsClear()) {
		 
		 /*Karel checks if front is clear,calls a beeper placer, then moves*/
		 
		if (frontIsClear()) {
			BeeperPlacer();
			move();
		}
		
		/*then checks if left is blocked and if he is facing east, if true then he turns right*/
		  /*This is done to start a new line of beepers*/
		if (leftIsBlocked() && facingEast() && frontIsBlocked()) {
			turnRight();
			move();
			turnLeft();
		}
		if (leftIsBlocked() && facingEast()) {
			turnRight();
		}
		
		/*Karel checks if front is blocked and if he is facing south, if true then he turn around*/
		  /*We do this at the end of the line of beepers to go back*/
		
		if (frontIsBlocked() && facingSouth()) {
			turnAround();
		}
		
		/*When Karel encounters a wall he calls a function to go around it*/
		
		while (frontIsBlocked()) {
			/*This line is designed to stop Karel at the end of the program*/
			
			 if (frontIsBlocked() && rightIsBlocked() && facingNorth() && beepersPresent()) {
				  say("Finish!");
				  return;
			 }
			WallAvoiding();
		}
	}
}

/*The fucntion checks if Karel is facing North/South and no beepers present*/
/*If true, Karel puts down a beeper*/

public void BeeperPlacer() throws Exception {
	if (facingNorth() && noBeepersPresent() || facingSouth() && noBeepersPresent()) {
		putBeeper();
	}
}

/*The function checks if the wall is blocked, if yes then we turn right and check the next square*/
/*Karel then checks if he is facing east and if front is blocked in case he encounters a new wall*/

public void WallAvoiding() throws Exception {
	
	/*Karel checks if front is blocked, turns right if true*/
	
	if (frontIsBlocked()) {
		turnRight();
			if(frontIsBlocked()) {
				turnRight();
			}
		move();
		turnLeft();
		
		/*If Karel encounters a wall while facing east, he turns right, moves*/
		/*Turns left to check if there is an opening*/
		/*If not, the function will be called again to repeat*/
		
		if (facingEast() && frontIsBlocked()) {
			turnRight();
			if (frontIsClear()) {
				move();
				turnLeft();
			} else {
				turnAround();
			}
		}
	}
}
  
/*Right turn function*/
  
public void turnRight() throws Exception {
	turnLeft();
	turnLeft();
	turnLeft();
}

/*Turning around function*/

public void turnAround() throws Exception {
	turnLeft();
	turnLeft();
}

}

