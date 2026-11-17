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
	  
	  /*Safeguard for vertical line worlds*/
	  
	  /*If Karel detects a wall in front of him he turns around*/
	  
	  if(frontIsBlocked()) {
		  turnAround();
		  
		  /*Karel detects a second wall in front of him*/
		  /*Determines he is in vertical 1xY world*/
		  /*Turns right and calls verticalPutter()*/
		  if(frontIsBlocked()) {
			  turnRight();
			  verticalPutter();
			  
			  /*Safeguard when we reach the end of the board to finish the program*/
			  
			  if (frontIsBlocked() && leftIsBlocked() && rightIsBlocked() && facingNorth()) {
				  say("Finish!");
					return;
				  }
		  }
	  }
	  
	  /*Program start*/
	  while (true) {
		  
 	  	beeperPutter();
 	  	
 	  	/*Safeguard when we reach the end of the board to finish the program*/
 	  	/*With extra check to factor in even coordinates*/
		  if (frontIsBlocked() && rightIsBlocked() && facingWest()) {
			  turnAround();
			  move();
				if (beepersPresent()) {
					turnAround();
					move();
				} else {
					turnAround();
					move();
					putBeeper();
				}
			  say("Finish!");
			  return;
		  }
		  if (frontIsBlocked() && leftIsBlocked() && facingEast()) {
			  turnAround();
			  move();
				if (beepersPresent()) {
					turnAround();
					move();
				} else {
					turnAround();
					move();
					putBeeper();
				}
			  say("Finish!");
				return;
			  }
	  }
	  

	 }
  
	/*We skip a square*/
  
	public void skipASquare() throws Exception {
		
		/*If line ends in an empty square we check if we reached the end here*/
		
		if (frontIsBlocked() && rightIsBlocked() && facingWest()) {
			return;
		}
		if (frontIsBlocked() && leftIsBlocked() && facingEast()) {
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
	
	public void beeperPutter() throws Exception {
		
		/*If line ends in a beeper we check if we reached the end here*/
		
		if (frontIsBlocked() && leftIsBlocked() && facingEast()) {
			return;
		  }
		if (frontIsBlocked() && rightIsBlocked() && facingWest()) {
			return;
		}
		
		/*Karel checks if he hit a wall and a direction he is facing to turn*/
		
		if (frontIsBlocked() &&  facingEast()) {
			putBeeper();
			turnLeft();
			move();
			turnLeft();
			move();
		}
		if (frontIsBlocked() && facingWest()) {
			putBeeper();
			turnRight();
			move();
			turnRight();
			move();
		}
		
		/*Because Karel sometimes starts a line facing north he uses a wall to decide where to turn*/
		
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
			
			skipASquare();
	}	
	
/*Right turn function*/
	  
public void turnRight() throws Exception {
		turnLeft();
		turnLeft();
		turnLeft();
	}

/*Turn around function*/

public void turnAround() throws Exception {
		turnLeft();
		turnLeft();
	}

/*Vertical world solution*/

public void verticalPutter() throws Exception {
	while(true) {
		putBeeper();
		
		if (frontIsClear() ) {
			move();
		} else {
			return;
		}
		if (frontIsClear() ) {
			move();
		} else {
			return;
		}
	}
	
}

}


