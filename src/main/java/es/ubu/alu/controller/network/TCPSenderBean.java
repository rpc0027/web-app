/**
 * Copyright 2019 rpc0027
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package es.ubu.alu.controller.network;

import java.io.PrintWriter;
import java.net.Socket;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import es.ubu.alu.model.LEDCommandBean;
import es.ubu.alu.model.MSGCommandBean;
import es.ubu.alu.model.PWMCommandBean;

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
@ManagedBean(name = "tcpsender")
@SessionScoped
public class TCPSenderBean implements Sender {
	/** IP address of the remote board. */
	private String ipAddress;
	/** TCP port of the remote board. */
	private int port;
	/** Bean for rgb leds commands. */
	@ManagedProperty(value="#{ledCommandBean}")
	private LEDCommandBean ledCommandBean;
	/** Bean for msg commands. */
	@ManagedProperty(value="#{msgCommandBean}")
	private MSGCommandBean msgCommandBean;
	/** Bean for pwm leds commands. */
	@ManagedProperty(value="#{pwmCommandBean}")
	private PWMCommandBean pwmCommandBean;

	/**
	 * Create a new TCPCommandSender with the data provided.
	 * 
	 * @param ipAddress the address of the remote board.
	 * @param port      the opened TCP port of the remote board.
	 */
	public TCPSenderBean(String ipAddress, int port) {
		this.ipAddress = ipAddress;
		this.port = port;
		
		ledCommandBean = new LEDCommandBean();
		msgCommandBean = new MSGCommandBean();
		pwmCommandBean = new PWMCommandBean();
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
	public void turnOnRed() {
		String command = ledCommandBean.getCommandR();
		sendCommand(command);
	}

	@Override
	public void turnOnGreen() {
		String command = ledCommandBean.getCommandG();
		sendCommand(command);
	}

	@Override
	public void turnOnBlue() {
		String command = ledCommandBean.getCommandB();
		sendCommand(command);
	}

	@Override
	public void turnOnYellow() {
		String command = ledCommandBean.getCommandY();
		sendCommand(command);
	}

	@Override
	public void turnOnMagenta() {
		String command = ledCommandBean.getCommandM();
		sendCommand(command);
	}

	@Override
	public void turnOnCyan() {
		String command = ledCommandBean.getCommandC();
		sendCommand(command);
	}

	@Override
	public void turnOnWhite() {
		String command = ledCommandBean.getCommandW();
		sendCommand(command);
	}

	@Override
	public void turnOffLEDs() {
		String command = ledCommandBean.getCommandO();
		sendCommand(command);
	}

	@Override
	public void sendMessageRow1(String message) {
		String command = msgCommandBean.getCommand1st() + message;
		sendCommand(command);
	}

	@Override
	public void sendMessageRow2(String message) {
		String command = msgCommandBean.getCommand2nd() + message;
		sendCommand(command);
	}

	@Override
	public void adjustWhite(byte percentage) {
		String command = pwmCommandBean.getCommandW() + percentage + "w";
		sendCommand(command);
	}

	@Override
	public void adjustGreen(byte percentage) {
		String command = pwmCommandBean.getCommandG() + percentage + "g";
		sendCommand(command);
	}

	@Override
	public void adjustYellow(byte percentage) {
		String command = pwmCommandBean.getCommandY() + percentage + "y";
		sendCommand(command);
	}

	@Override
	public void adjustRed(byte percentage) {
		String command = pwmCommandBean.getCommandR() + percentage + "r";
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
