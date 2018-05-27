package main;

import controller.Game;
import controller.SharedSnakeDirection;
import domain.Board;
import io.UserInput;
import presentation.FrmBoard;

public class Main 
{
	public static void main(String[] args)
	{
		FrmBoard frmBoard = new FrmBoard(50, 50);
		frmBoard.setVisible(true);
		Board board = new Board(50, 50);
		
		Game controller = new Game(frmBoard, board);
		
		SharedSnakeDirection sharedDirection = new SharedSnakeDirection(null);
		UserInput myInput = new UserInput(sharedDirection);
		controller.createSnake(sharedDirection);
		

		
		
	}
}
