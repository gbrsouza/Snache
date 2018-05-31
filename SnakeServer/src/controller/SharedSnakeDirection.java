package controller;

/**
 * Wraps a EnumSnakeDirection object to be shared between a snake and a player.
 * This wrapper follows the producer-consumer paradigm. When the shared
 * direction is used, it becomes null
 */
public class SharedSnakeDirection
{
	/** The direction to be shared. */
	private EnumSnakeDirection direction;

	/**
	 * Instantiates a new wrapper.
	 *
	 * @param direction
	 *            the object to be shared
	 */
	public SharedSnakeDirection(EnumSnakeDirection direction)
	{
		this.direction = direction;
	}

	/**
	 * Consumes the current direction. The direction is set to null when this method
	 * is called.
	 *
	 * @return the current snake direction
	 */
	public EnumSnakeDirection consume()
	{
		EnumSnakeDirection dir = direction;

		if(direction != null)
			direction = null;

		return dir;
	}

	/**
	 * Sets the current direction to a specific value if it is null.
	 *
	 * @param direction
	 *            *the* string representation of the EnumSnakeDirection object
	 *            corresponding to the new direction
	 */
	public void produce(String direction)
	{
		produce(EnumSnakeDirection.getValue(direction));
	}

	/**
	 * Sets the current direction to a specific value if it is null..
	 *
	 * @param direction
	 *            the EnumSnakeDirection object corresponding to the new direction
	 */
	public void produce(EnumSnakeDirection direction)
	{
		if(this.direction != null)
			this.direction = direction;

		else
		{
			// ignore;
		}
	}

	/**
	 * Checks for resource.
	 *
	 * @return true, if successful
	 */
	public boolean hasResource()
	{
		return direction != null;
	}
}
