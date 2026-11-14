package com.shpp.p2p.cs.asemenov.assignment1;

import com.shpp.karel.KarelTheRobot;

/* Declaring a new class */
public class Assignment1Part3 extends KarelTheRobot {
  public void run() throws Exception {

	  /*Safeguard for 1x1 worlds that performs a check if all 4 sides are blocked*/
	  
	  if (frontIsBlocked() && rightIsBlocked() && leftIsBlocked()) {
		  turnAround();
		  if (frontIsBlocked() && rightIsBlocked() && leftIsBlocked()) {
			  say("1x1 world");
			  return;
		  }
	  }
	  
	  /*Program start*/
	  while (true) {
 	  	BeeperPutter();
 	  	
 	  	/*Safeguard when we reach the end of the board to finish the program*/
		  if (frontIsBlocked() && rightIsBlocked() && facingWest()) {
			  say("Finish!");
			  return;
		  }
	  }
	  

	 }
  
	/*We skip a square*/
  
	public void SkipASquare() throws Exception {
		
		/*Since every line ends in an empty square we check if we reached the end here*/
		
		if (frontIsBlocked() && rightIsBlocked() && facingWest()) {
			return;
		  }
		
		/*Karel checks if he hit a wall and a direction he is facing to turn*/
		
		if (frontIsBlocked() &&  facingEast()) {
			turnLeft();
		}
		if (frontIsBlocked() && facingWest()) {
			turnRight();
		}
		
		/*Karel skips the said square*/
			move();
	}
	
	/*Because Karel starts a line facing north he uses a wall to decide where to turn*/
	
	public void BeeperPutter() throws Exception {
		if (facingNorth() && rightIsBlocked()) {
			turnLeft();
		}
		if (facingNorth() && leftIsBlocked()) {
			turnRight();
		}
		
		/*Karel puts a beeper, moves to the next square*/
			putBeeper();
			move();
			
			/*Karel calls the next function to skip a square*/
			
			SkipASquare();
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


