package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import controller.SingletonSnakeDirectionChange;

/**
 * Makes the client-side communication between the player's game, that behaves
 * as a client, and the game's server. The client sends commands to the server
 * to change the direction of a snake, and receives a copy of the current state
 * of the board.
 */
public class SocketClient
{
	/** Socket by which the communication will be made. */
	private DatagramSocket socket;
	
	/** Singleton instance  whose snake direction changes will be caught of. */
	private SingletonSnakeDirectionChange snakeDirection = SingletonSnakeDirectionChange.getInstance();

	/**
	 * Initializes the socket and calls its main method.
	 */
	public void initSocket()
	{
		try
		{
			socket = new DatagramSocket();
			sendDataToServer();
		}

		catch (SocketException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Sends data to the server.
	 * Every 2000 milliseconds it sends a snake direction change to the server.
	 */
	public void sendDataToServer()
	{
		String direction;

		try
		{
			// ip address of the player
			InetAddress ip = InetAddress.getByName("localhost");

			while(true)
			{
				// catches the direction change from the singleton
				direction = snakeDirection.consume().toString();
				
				System.out.println("direction sent to server: " + direction);

				// builds the package to be sent to the server
				byte[] dataToSend = direction.getBytes();
				DatagramPacket packToSend = new DatagramPacket(dataToSend, dataToSend.length, ip, 6666);
				
				// sends the packet
				socket.send(packToSend);

				// the next package is sent after 2000ms
				Thread.sleep(2000);
			}

		}

		catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
