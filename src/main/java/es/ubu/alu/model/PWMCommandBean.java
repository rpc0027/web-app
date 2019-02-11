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

package es.ubu.alu.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
@ManagedBean(name = "pwmCommandBean")
@SessionScoped
public class PWMCommandBean implements Serializable {
	/** Randomly generated identifier. */
	private static final long serialVersionUID = 1L + (long) (Math.random() * (100000000000L - 1L));
	/**
	 * Name of the command to vary the intensity of the light of the LEDs
	 * in the Basic I/O shield.
	 */
	private static final String COMMAND_PWM = "pwm";
	/**
	 * Character used as a separator between the command and its arguments.
	 */
	private static final String SEPARATOR = ":";
	/**
	 * The intensity of the brightness of the LEDs in the Basic I/O shield 
	 * can be varied using Pulse Width Modulation (PWM). 
	 * The enum has the four colors of the four LEDs that can be used.
	 * <p>
	 * Using PWM, the user can control different types of devices
	 * such as servo motors or LEDs. In this case, only LEDs 
	 * of different colors are implemented.
	 * 
	 * @author RPC
	 * @version 1.0
	 */
	private enum PWMDevice {
		/** LED of white color. */
	    WHITE('w'),
	    /** LED of green color. */
	    GREEN('g'),
	    /** LED of yellow color. */
	    YELLOW('y'),
	    /** LED of red color. */
	    RED('r');
		
		/**
		 * Character that represents a single device.
		 */
	    private final char character;
	    
	    /**
	     * Create a device controlled by PWM.
	     * 
	     * @param c the character that will be used as the argument 
	     * 			of the command that uses them.
	     */
	    PWMDevice (char c) {
	    	character = c;
	    }
	    
	    /**
	     * Return the character that represents the device.
	     * 
	     * @return the indicated character when the device was created.
	     */
	    public char getCharacter() {
	    	return character;
	    }
	}
	/**
	 * Command for white color.
	 */
	private String commandW = COMMAND_PWM + SEPARATOR + PWMDevice.WHITE.getCharacter() + SEPARATOR;
	/**
	 * Command for green color.
	 */
	private String commandG = COMMAND_PWM + SEPARATOR + PWMDevice.GREEN.getCharacter() + SEPARATOR;
	/**
	 * Command for yellow color.
	 */
	private String commandY = COMMAND_PWM + SEPARATOR + PWMDevice.YELLOW.getCharacter() + SEPARATOR;
	/**
	 * Command for red color.
	 */
	private String commandR = COMMAND_PWM + SEPARATOR + PWMDevice.RED.getCharacter() + SEPARATOR;
	
	/** Default constructor. */
	public PWMCommandBean() {
	}

	/**
	 * @return the commandW
	 */
	public String getCommandW() {
		return commandW;
	}

	/**
	 * @param commandW the commandW to set
	 */
	public void setCommandW(String commandW) {
		this.commandW = commandW;
	}

	/**
	 * @return the commandG
	 */
	public String getCommandG() {
		return commandG;
	}

	/**
	 * @param commandG the commandG to set
	 */
	public void setCommandG(String commandG) {
		this.commandG = commandG;
	}

	/**
	 * @return the commandY
	 */
	public String getCommandY() {
		return commandY;
	}

	/**
	 * @param commandY the commandY to set
	 */
	public void setCommandY(String commandY) {
		this.commandY = commandY;
	}

	/**
	 * @return the commandR
	 */
	public String getCommandR() {
		return commandR;
	}

	/**
	 * @param commandR the commandR to set
	 */
	public void setCommandR(String commandR) {
		this.commandR = commandR;
	}
}
