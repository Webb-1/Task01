package com.shpp.p2p.cs.asemenov.assignment1;

import com.shpp.karel.KarelTheRobot;

/* Оголошення нового класу */
public class Assignment1Part1 extends KarelTheRobot {
  public void run() throws Exception {
	  
	  turnLeft();
	  
	   
	 while(true) {
		 mover();
		 turner1();
		 turner2();
		 mover();
		 turner3();
	 }
  }
  
  
  /* Алгоритм руху*/
  
public void mover() throws Exception {
	while (frontIsClear()) {
		/*Ставимо біпери*/
		if (noBeepersPresent()) {
			putBeeper();
		}
		move();
		if (frontIsBlocked() && rightIsBlocked()) {
			say("Finish!");
			pause();
		}
	}
  }

/*Закінчення рядка і повертаємо*/

public void turner1() throws Exception {
	  if (frontIsBlocked() && beepersPresent()) {
		  turnLeft();
		  turnLeft();
		  turnLeft();
		  move();
	  };
	  
  
}

 /*Переходимо до наступного рядка*/

public void turner2() throws Exception {
	  if(leftIsClear()) {
		  while(leftIsClear()) {
			  move();
		  }
	  } if(leftIsBlocked()) {
		  turnLeft();
		  turnLeft();
		  turnLeft();
	  }
}

/*Закінчили рядок і повертаємося*/

public void turner3() throws Exception {
	  if(frontIsBlocked()) {
		  turnLeft();
		  turnLeft();
	  }
}
}

