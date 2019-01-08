package es.ubu.alu;

import java.io.PrintWriter;
import java.net.Socket;

/**
 * Implements the functions for each operation available in the remote board.
 * <p>
 * The commands are sent inside packets through the network
 * using Transmission Control Protocol (TCP).
 * To achieve this, it is necessary to know the IP address and the port 
 * of the board that will receive the package.
 * 
 * @author RPC
 * @version 1.0
 */
public class TCPCommandSender implements CommandSender {
	/** IP address of the remote board. */
	private String ipAddress;
	/** TCP port of the remote board. */
	private int port;

	/**
	 * Create a new TCPCommandSender with the data provided.
	 * 
	 * @param ipAddress the address of the remote board.
	 * @param port      the opened TCP port of the remote board.
	 */
	public TCPCommandSender(String ipAddress, int port) {
		this.ipAddress = ipAddress;
		this.port = port;
	}

	@Override
	public void sendCommand(String command) {
		try {
			Socket socket =  new Socket(ipAddress, port);
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

			// Send command over TCP.
			printWriter.print(command);

			printWriter.close();
			socket.close();
		} catch (Exception e) {

		}
	}

	@Override
	public void turnOnLed(Color color) {
		switch(color) {
		case RED:
			turnOnRed();
			break;

		case GREEN:
			turnOnGreen();
			break;

		case BLUE:
			turnOnBlue();
			break;

		case YELLOW:
			turnOnYellow();
			break;

		case MAGENTA:
			turnOnMagenta();
			break;

		case CYAN:
			turnOnCyan();
			break;

		case WHITE:
			turnOnWhite();
			break;

		case NOCOLOR:
			turnOffLEDs();
			break;
		}
	}

	@Override
	public void turnOnRed() {
		String command = COMMAND_LED + SEPARATOR + Color.RED.getCharacter();
		System.out.println(command);
		sendCommand(command);
	}

	@Override
	public void turnOnGreen() {
		String command = COMMAND_LED + SEPARATOR + Color.GREEN.getCharacter();
		sendCommand(command);
	}

	@Override
	public void turnOnBlue() {
		String command = COMMAND_LED + SEPARATOR + Color.BLUE.getCharacter();
		sendCommand(command);
	}

	@Override
	public void turnOnYellow() {
		String command = COMMAND_LED + SEPARATOR + Color.YELLOW.getCharacter();
		sendCommand(command);
	}

	@Override
	public void turnOnMagenta() {
		String command = COMMAND_LED + SEPARATOR + Color.MAGENTA.getCharacter();
		sendCommand(command);
	}

	@Override
	public void turnOnCyan() {
		String command = COMMAND_LED + SEPARATOR + Color.CYAN.getCharacter();
		sendCommand(command);
	}

	@Override
	public void turnOnWhite() {
		String command = COMMAND_LED + SEPARATOR + Color.WHITE.getCharacter();
		sendCommand(command);
	}

	@Override
	public void turnOffLEDs() {
		String command = COMMAND_LED + SEPARATOR + Color.NOCOLOR.getCharacter();
		sendCommand(command);
	}

	@Override
	public void sendMessage(byte row, String message) {
		switch(row) {
		case 0:
			sendMessageRow0(message);
			break;

		case 1:
			sendMessageRow1(message);
			break;
		}
	}

	@Override
	public void sendMessageRow0(String message) {
		String command = COMMAND_MSG + SEPARATOR + "0" + SEPARATOR + message;
		sendCommand(command);
	}

	@Override
	public void sendMessageRow1(String message) {
		String command = COMMAND_MSG + SEPARATOR + "1" + SEPARATOR + message;
		sendCommand(command);
	}

	@Override
	public void adjustsPWM(PWMDevice pwmDevice, byte percentage) {
		switch(pwmDevice) {
		case WHITE:
			adjustWhite(percentage);
			break;
		case GREEN:
			adjustGreen(percentage);
			break;
		case YELLOW:
			adjustYellow(percentage);
			break;
		case RED:
			adjustRed(percentage);
			break;
		}
	}

	@Override
	public void adjustWhite(byte percentage) {
		String command = COMMAND_PWM + SEPARATOR + "w" + SEPARATOR + percentage + "w";
		sendCommand(command);
	}

	@Override
	public void adjustGreen(byte percentage) {
		String command = COMMAND_PWM + SEPARATOR + "g" + SEPARATOR + percentage + "g";
		sendCommand(command);
	}

	@Override
	public void adjustYellow(byte percentage) {
		String command = COMMAND_PWM + SEPARATOR + "y" + SEPARATOR + percentage + "y";
		sendCommand(command);
	}

	@Override
	public void adjustRed(byte percentage) {
		String command = COMMAND_PWM + SEPARATOR + "r" + SEPARATOR + percentage + "r";
		sendCommand(command);
	}

	/**
	 * Return the address of the board to which commands are being sent.
	 * 
	 * @return the string with the IP address.
	 */
	public String getIPAddress() {
		return ipAddress;
	}

	/**
	 * Return the port of the board to which commands are being sent.
	 * 
	 * @return the integer with the port number.
	 */
	public int getPort() {
		return port;
	}
}
