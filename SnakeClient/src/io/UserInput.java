package io;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import controller.SingletonSnakeDirection;

/**
 * @author gabriel
 *
 */
public class UserInput implements KeyListener
{
	private SingletonSnakeDirection sharedDirection = SingletonSnakeDirection.getInstance();
	
	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		System.out.println("Pressed");
		// Seta P/ baixo
		if(e.getKeyCode() == 40)
		{
			sharedDirection.produce("D");
		}
		// Seta P/ cima
		if(e.getKeyCode() == 38)
		{
			sharedDirection.produce("U");
		}
		// Seta P/ direita
		if(e.getKeyCode() == 39)
		{
			sharedDirection.produce("R");
		}
		// Seta P/ esquerda
		if(e.getKeyCode() == 37)
		{
			sharedDirection.produce("L");
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
	}
}
