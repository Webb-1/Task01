package com.shpp.p2p.cs.asemenov.assignment1;

import com.shpp.karel.KarelTheRobot;

/* Declaring a new class */
public class Assignment1Part2 extends KarelTheRobot {
  public void run() throws Exception {

	  /*Safeguard for 1x1 worlds that performs a check if all 4 sides are blocked*/
	  
	  if (frontIsBlocked() && rightIsBlocked() && leftIsBlocked()) {
		  turnAround();
		  if (frontIsBlocked() && rightIsBlocked() && leftIsBlocked()) {
			  say("1x1 world");
			  putBeeper();
			  return;
		  }
	  }
	  
	  /*Program start*/
	  
	  walkerPutter();
	  say("Middle found!");
	 }
  
/*Karel walks forward while putting beepers so we can use them to find the middle of this side*/
  
public void walkerPutter() throws Exception {
	while (frontIsClear()) {
		putBeeper();
		move();
	}
		
	/*When we reach a wall we call finder to find the middle*/
	
	if (frontIsBlocked()) {
		finder();
	}
}
	
/*Finding the middle by collecting the beepers on each side*/
/*Then Karel checks if any walls are present next to him*/
	
public void finder() throws Exception {
	
	/*Karel turns around first to face opposite of the all*/
	
	turnAround();
	
	/*Karel moves until he encounters a wall or an empty square*/
	
	while(frontIsClear()) {
			move();
			
		if (noBeepersPresent()) {
			
				/*Karel turns around and goes to the other side */
			
				turnAround();
				move();
				
				/*Karel picks up the last beeper in line*/
				
				if (beepersPresent()) {
				pickBeeper();
				
				}
				
				/*When beepers run out Karel checks if he needs to put one down*/
				/*if true Karel puts down a beeper and ends the program*/
				
				else {
					if (noBeepersPresent()) {
						putBeeper();
						return;
					}
				}
			}
		
		/*Safeguard if Karel encounters a wall*/
		
		if (frontIsBlocked()) {	
				turnAround();
				pickBeeper();
				move();
			}
		}
	}

/*Turning around function*/

public void turnAround() throws Exception {
	turnLeft();
	turnLeft();

	
}

}
  


