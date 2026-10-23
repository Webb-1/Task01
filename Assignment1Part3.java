package com.shpp.p2p.cs.asemenov.assignment1;

import com.shpp.karel.KarelTheRobot;

/* Оголошення нового класу */
public class Assignment1Part3 extends KarelTheRobot {
  public void run() throws Exception {

	  while(true) {
	  putter();
	  turner();
	  skipper();
	  turner();
	  }
	 }
  
	/*НЕ ставимо біпер*/
  
	public void skipper() throws Exception {
			move();
	}
	
	/*Ставимо біпер*/
	
	public void putter() throws Exception {
		if (facingNorth() && rightIsBlocked()) {
			turnLeft();
		}
		if (facingNorth() && leftIsBlocked()) {
			turnLeft();
			turnLeft();
			turnLeft();
		}
			putBeeper();
			move();
	}
	
	/*Повертаємо*/
	
	public void turner() throws Exception {
		  if (frontIsBlocked() && rightIsBlocked() && facingWest()) {
			  say("Finish!");
			  pause();
		  }
		if (frontIsBlocked() &&  facingEast()) {
			turnLeft();
		}
		if (frontIsBlocked() && facingWest()) {
			turnLeft();
			turnLeft();
			turnLeft();
		}
	}
	
}
  


