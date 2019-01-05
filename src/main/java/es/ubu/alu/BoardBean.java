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

	CommandSender tcpCommandSender;

	public BoardBean() {
		tcpCommandSender = new TCPCommandSender(ipAddress, port);
	}

	public void connect() {
		tcpCommandSender = new TCPCommandSender(ipAddress, port);
	}

	public void turnOnRed() {
		tcpCommandSender.turnOnLed(CommandSender.Color.RED);
	}

	public void turnOnGreen() { 
		tcpCommandSender.turnOnLed(CommandSender.Color.GREEN);
	}

	public void turnOnBlue() {
		tcpCommandSender.turnOnLed(CommandSender.Color.BLUE);
	}

	public void turnOnYellow() { 
		tcpCommandSender.turnOnLed(CommandSender.Color.YELLOW);
	}

	public void turnOnMagenta() { 
		tcpCommandSender.turnOnLed(CommandSender.Color.MAGENTA);
	}

	public void turnOnCyan() { 
		tcpCommandSender.turnOnLed(CommandSender.Color.CYAN);
	}

	public void turnOnWhite() { 
		tcpCommandSender.turnOnLed(CommandSender.Color.WHITE);
	}

	public void turnOffLeds() { 
		tcpCommandSender.turnOffLEDs();
	}

	public void sendMessageRow1() {
		tcpCommandSender.sendMessageRow0(row1message);
	}

	public void sendMessageRow2() {
		tcpCommandSender.sendMessageRow1(row2message);
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
