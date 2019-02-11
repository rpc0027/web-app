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

package es.ubu.alu.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.ubu.alu.controller.network.Sender;
import es.ubu.alu.controller.network.TCPSenderBean;

/**
 * Bean used by the web interface to send commands to the board.
 * <p>
 * For the submission to be successful, it is necessary that the TCP/IP data
 * provided by the user is correct.
 * 
 * @author RPC
 * @version 1.0
 *
 */
@ManagedBean(name = "board")
@SessionScoped
public class BoardBean implements Serializable {
	/** Randomly generated identifier. */
	private static final long serialVersionUID = 1L + (long) (Math.random() * (100000000000L - 1L));
	/** Address of the remote board. */
	private String ipAddress = "example: 192.168.0.x";
	/** Open TCP port on the remote board. */
	private int port = 1234;
	/** Text to be sent to the first row of the display. */
	private String row1message = "text for the 1st row";
	/** Text to be sent to the second row of the display. */
	private String row2message = "text for the 2nd row";
	/** Value of the device A regulated by PWM. */
	private String pwmA = "0";
	/** Value of the device B regulated by PWM. */
	private String pwmB = "0";
	/** Value of the device C regulated by PWM. */
	private String pwmC = "0";
	/** Value of the device D regulated by PWM. */
	private String pwmD = "0";
	/** Handler of network communications. */
	private Sender sender;

	/** Default constructor. */
	public BoardBean() {
	}

	/**
	 * Create a commandSender with the data provided by the user to establish a
	 * connection with the board and transmit packets through the TCP/IP stack.
	 */
	public void connect() {
		sender = new TCPSenderBean(ipAddress, port);
	}

	/**
	 * Order to send the command that turns on the red color.
	 */
	public void turnOnRed() {
		if (sender != null) {
			sender.turnOnRed();
		}
	}

	/**
	 * Order to send the command that turns on the green color.
	 */
	public void turnOnGreen() {
		if (sender != null) {
			sender.turnOnGreen();
		}
	}

	/**
	 * Order to send the command that turns on the blue color.
	 */
	public void turnOnBlue() {
		if (sender != null) {
			sender.turnOnBlue();
		}
	}

	/**
	 * Order to send the command that turns on the yellow color.
	 */
	public void turnOnYellow() {
		if (sender != null) {
			sender.turnOnYellow();
		}
	}

	/**
	 * Order to send the command that turns on the magenta color.
	 */
	public void turnOnMagenta() {
		if (sender != null) {
			sender.turnOnMagenta();
		}
	}

	/**
	 * Order to send the command that turns on the cyan color.
	 */
	public void turnOnCyan() {
		if (sender != null) {
			sender.turnOnCyan();
		}
	}

	/**
	 * Order to send the command that turns on the white color.
	 */
	public void turnOnWhite() {
		if (sender != null) {
			sender.turnOnWhite();
		}
	}

	/**
	 * Order to send the command that turns off all colors.
	 */
	public void turnOffLeds() {
		if (sender != null) {
			sender.turnOffLEDs();
		}
	}

	/**
	 * Order to send the command that shows a message on 1st row.
	 */
	public void sendMessageRow1() {
		if (sender != null) {
			sender.sendMessageRow1(row1message);
		}
	}

	/**
	 * Order to send the command that shows a message on 2nd row.
	 */
	public void sendMessageRow2() {
		if (sender != null) {
			sender.sendMessageRow2(row2message);
		}
	}

	/**
	 * Order to send the command that adjusts the PWM value of white led.
	 * <p>
	 * The board uses the percentage in inverse manner, being 100% the lowest value
	 * and 0% the highest value. Therefore, it is necessary to invert the values
	 * entered by the user so that the board can interpret them correctly.
	 * 
	 * @param string the percentage to adjust the duty cycle.
	 */
	public void onWhiteValueChange(String string) {
		byte value = (byte) (100 - Integer.valueOf(string));
		if (sender != null) {
			sender.adjustWhite(value);
		}
	}

	/**
	 * Order to send the command that adjusts the PWM value of green led.
	 * <p>
	 * The board uses the percentage in inverse manner, being 100% the lowest value
	 * and 0% the highest value. Therefore, it is necessary to invert the values
	 * entered by the user so that the board can interpret them correctly.
	 * 
	 * @param string the percentage to adjust the duty cycle.
	 */
	public void onGreenValueChange(String string) {
		byte value = (byte) (100 - Integer.valueOf(string));
		if (sender != null) {
			sender.adjustGreen(value);
		}
	}

	/**
	 * Order to send the command that adjusts the PWM value of yellow led.
	 * <p>
	 * The board uses the percentage in inverse manner, being 100% the lowest value
	 * and 0% the highest value. Therefore, it is necessary to invert the values
	 * entered by the user so that the board can interpret them correctly.
	 * 
	 * @param string the percentage to adjust the duty cycle.
	 */
	public void onYellowValueChange(String string) {
		byte value = (byte) (100 - Integer.valueOf(string));
		if (sender != null) {
			sender.adjustYellow(value);
		}
	}

	/**
	 * Order to send the command that adjusts the PWM value of red led.
	 * <p>
	 * The board uses the percentage in inverse manner, being 100% the lowest value
	 * and 0% the highest value. Therefore, it is necessary to invert the values
	 * entered by the user so that the board can interpret them correctly.
	 * 
	 * @param string the percentage to adjust the duty cycle.
	 */
	public void onRedValueChange(String string) {
		byte value = (byte) (100 - Integer.valueOf(string));
		if (sender != null) {
			sender.adjustRed(value);
		}
	}

	/**
	 * Get the {@link #ipAddress}.
	 * 
	 * @return the {@link #ipAddress}.
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * Set the {@link #ipAddress}.
	 * 
	 * @param ipAddress the {@link #ipAddress}.
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * Get the {@link #port}.
	 * 
	 * @return the {@link #port}.
	 */
	public int getPort() {
		return port;
	}

	/**
	 * Set the {@link #port}.
	 * 
	 * @param port the {@link #port}.
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * Get the {@link #row1message}.
	 * 
	 * @return the {@link #row1message}.
	 */
	public String getRow1message() {
		return row1message;
	}

	/**
	 * Set the {@link #row1message}.
	 * 
	 * @param row1message the {@link #row1message}.
	 */
	public void setRow1message(String row1message) {
		this.row1message = row1message;
	}

	/**
	 * Get the {@link #row2message}.
	 * 
	 * @return the {@link #row2message}.
	 */
	public String getRow2message() {
		return row2message;
	}

	/**
	 * Set the {@link #row2message}.
	 * 
	 * @param row2message the {@link #row2message}.
	 */
	public void setRow2message(String row2message) {
		this.row2message = row2message;
	}

	/**
	 * Get the {@link #pwmA}.
	 * 
	 * @return the {@link #pwmA}.
	 */
	public String getPwmA() {
		return pwmA;
	}

	/**
	 * Set the {@link #pwmA}.
	 * 
	 * @param pwmA the {@link #pwmA}.
	 */
	public void setPwmA(String pwmA) {
		this.pwmA = pwmA;
	}

	/**
	 * Get the {@link #pwmB}.
	 * 
	 * @return the {@link #pwmB}.
	 */
	public String getPwmB() {
		return pwmB;
	}

	/**
	 * Set the {@link #pwmB}.
	 * 
	 * @param pwmB the {@link #pwmB}.
	 */
	public void setPwmB(String pwmB) {
		this.pwmB = pwmB;
	}

	/**
	 * Get the {@link #pwmC}.
	 * 
	 * @return the {@link #pwmC}.
	 */
	public String getPwmC() {
		return pwmC;
	}

	/**
	 * Set the {@link #pwmC}.
	 * 
	 * @param pwmC the {@link #pwmC}.
	 */
	public void setPwmC(String pwmC) {
		this.pwmC = pwmC;
	}

	/**
	 * Get the {@link #pwmD}.
	 * 
	 * @return the {@link #pwmD}.
	 */
	public String getPwmD() {
		return pwmD;
	}

	/**
	 * Set the {@link #pwmD}.
	 * 
	 * @param pwmD the {@link #pwmD}.
	 */
	public void setPwmD(String pwmD) {
		this.pwmD = pwmD;
	}
}
