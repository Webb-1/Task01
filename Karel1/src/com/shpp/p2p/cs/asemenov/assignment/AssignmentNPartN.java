package com.shpp.p2p.cs.asemenov.assignment;

import com.shpp.karel.KarelTheRobot;

/* Оголошення нового класу */
public class Assignment1Part1 extends KarelTheRobot { 
	  boolean NewspaperPresent = false;
  public void run() throws Exception {
	  
	  /*Починаємо рух*/
	  
	  Mover();
	  
	  /*Обходимо стіну та повертаємо*/
	  
	  if(frontIsBlocked() && leftIsBlocked()) {
		  WallAvoid();
		  Mover();
	  }
	  
	  /*Підбираємо біпер*/
	  
	  BeeperCollect();
	  
	  /*Починажмо шлях назад*/
	  
	  if (NewspaperPresent == true) {
		  Mover();
		  
	  /*Повертаємося на точку старту*/
		  
	  if (frontIsBlocked()) {
		  WallAvoid();
		  Mover();
		  say("Finish!");
	  }
	}
  }
  
  /*Ходимо по прямій якщо стіни немає*/
  
  public void Mover() throws Exception { 
	  while(frontIsClear() && noBeepersPresent()) {
		move(); 
	  };
  }
  
  /*Обходимо стіни*/
  
  public void WallAvoid() throws Exception {
	  if (NewspaperPresent == false) {
	while (frontIsBlocked()) {  
		turnLeft();
		turnLeft();
		turnLeft();
		move();
		turnLeft();
	}
  } else {
		turnLeft();
		turnLeft();
		turnLeft();
  }
 }
  
  /*Перевіряжмо якщо підбрали газету - якщо так то повертаємо назад*/
  
  public void BeeperCollect() throws Exception {
	  while (beepersPresent()) {
		  pickBeeper();
		  NewspaperPresent = true;
	  };
	  if (NewspaperPresent == true) {
		  turnLeft();
		  turnLeft();
	  }
  }
}

