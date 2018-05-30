package controller;

/**
 * All possible movements for the snakes. 
 * Based on: http://mrmcgeek.blogspot.com/2009/06/custom-string-values-for-enum-in-java.html
 */
public enum EnumSnakeDirection
{
	/** move up. */
	UP ("U"),
	
	/** move left. */
	LEFT ("L"),
	
	/** move down. */
	DOWN ("D"),
	
	/** move right. */
	RIGHT ("R"),
	
	/** don't move. */
	DONT_MOVE ("N");
	
	private String direction;
	
	private EnumSnakeDirection(String direction)
	{
		this.direction = direction;
	}
	
	public String toString()
	{
		return direction;
	}
	
	public static EnumSnakeDirection getValue(String snakeDirection)
	{
		for(EnumSnakeDirection direction : EnumSnakeDirection.values())
		{
			if(direction.toString().equalsIgnoreCase(snakeDirection))
			{
				return direction;
			}
		}
		
		return null;
	}
}