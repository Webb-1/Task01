package com.shpp.p2p.cs.asemenov.assignment1;

import com.shpp.karel.KarelTheRobot;

/* Оголошення нового класу */
public class Assignment1Part2 extends KarelTheRobot {
  public void run() throws Exception {

	  
	  mover();
	  finder();
	  mover();
	  finder();
	  say("Middle found!");
	 }
  
	/*Виміряємо сторону*/
  
	public void mover() throws Exception {
		while (frontIsClear()) {
			putBeeper();
			move();
		}
	}
	
	/*Знаходимо середину*/
	
	public void finder() throws Exception {
		turnLeft();
		turnLeft();
		while(frontIsClear()) {
			move();
			 if (noBeepersPresent()) {
					turnLeft();
					turnLeft();
					move();
					if (beepersPresent()) {
					pickBeeper();
					} else {
						turnLeft();
						return;
					}
				}
			 if (frontIsBlocked()) {
					turnLeft();
					turnLeft();
					pickBeeper();
					move();
				}
		}
	}
	
  }
  


