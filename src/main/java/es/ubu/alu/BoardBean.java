package es.ubu.alu;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "board")
@SessionScoped
public class BoardBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L + (long) (Math.random() * (100000000000L - 1L));

	private String ipAddress = "example: 192.168.0.x";
	private int port = 1234;
	private String row1message = "text for the 1st row";
	private String row2message = "text for the 2nd row";

	TCPCommandSender commandSender;

	public BoardBean() {
		commandSender = new TCPCommandSender(ipAddress, port);
	}

	public void connect() {
		commandSender = new TCPCommandSender(ipAddress, port);
	}

	public void turnOnRed() {
		commandSender.turnOnLed(CommandSender.Color.RED);
	}

	public void turnOnGreen() { 
		commandSender.turnOnLed(CommandSender.Color.GREEN);
	}

	public void turnOnBlue() {
		commandSender.turnOnLed(CommandSender.Color.BLUE);
	}

	public void turnOnYellow() { 
		commandSender.turnOnLed(CommandSender.Color.YELLOW);
	}

	public void turnOnMagenta() { 
		commandSender.turnOnLed(CommandSender.Color.MAGENTA);
	}

	public void turnOnCyan() { 
		commandSender.turnOnLed(CommandSender.Color.CYAN);
	}

	public void turnOnWhite() { 
		commandSender.turnOnLed(CommandSender.Color.WHITE);
	}

	public void turnOffLeds() { 
		commandSender.turnOffLEDs();
	}

	public void sendMessageRow1() {
		commandSender.sendMessageRow0(row1message);
	}

	public void sendMessageRow2() {
		commandSender.sendMessageRow1(row2message);
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getRow1message() {
		return row1message;
	}

	public void setRow1message(String row1message) {
		this.row1message = row1message;
	}

	public String getRow2message() {
		return row2message;
	}

	public void setRow2message(String row2message) {
		this.row2message = row2message;
	}
}
