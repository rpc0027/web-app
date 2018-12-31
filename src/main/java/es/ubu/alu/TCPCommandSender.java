/**
 * 
 */
package es.ubu.alu;

import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author rpc0027
 *
 */
public class TCPCommandSender implements CommandSender {
	private String ipAddress;
	private int port;
	
	public TCPCommandSender(String ipAddress, int port) {
		this.ipAddress = ipAddress;
		this.port = port;
	}
	
	public String getIPAddress() {
		return ipAddress;
	}
	
	public int getPort() {
		return port;
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

		case NOCOLOR:
			turnOffLEDs();
			break;

		default:
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
		// TODO Auto-generated method stub

	}

	@Override
	public void sendMessageRow0(String message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendMessageRow1(String message) {
		// TODO Auto-generated method stub

	}

	@Override
	public void adjustsPWM(PWMDevice pwmDevice, byte percentage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void adjustWhite(byte percentage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void adjustGreen(byte percentage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void adjustYellow(byte percentage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void adjustRed(byte percentage) {
		// TODO Auto-generated method stub

	}
}
