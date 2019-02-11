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
@ManagedBean(name = "ledCommandBean")
@SessionScoped
public class LEDCommandBean implements Serializable {
	/** Randomly generated identifier. */
	private static final long serialVersionUID = 1L + (long) (Math.random() * (100000000000L - 1L));
	/**
	 * Name of the command to change the color of the light 
	 * emitted by the on-board RGB LEDs.
	 */
	private static final String COMMAND_LED = "led";
	/**
	 * Character used as a separator between the command and its arguments.
	 */
	private static final String SEPARATOR = ":";
	/**
	 * Each of the colors that can be illuminated using the RGB LEDs.
	 * If the user wants to turn off the LEDs, a special character is sent.
	 * 
	 * @author RPC
	 * @version 1.0
	 */
	private enum Color {
		/** Red color. */
	    RED('r'),
	    /** Green color. */
	    GREEN('g'),
	    /** Blue color. */
	    BLUE('b'),
	    /** Yellow color, mix of red and green color. */
	    YELLOW('y'),
	    /** Magenta color, mix of red and blue color. */
	    MAGENTA('m'),
	    /** Cyan color, mix of green and blue color. */
	    CYAN('c'),
	    /** White color, mix of red, green and blue color.*/
	    WHITE('w'),
	    /** Turn off the LEDs. */
	    NOCOLOR('o');
		
		/**
		 * Character that represents a single color.
		 */
	    private final char character;
	    
	    /**
	     * Create a color with its corresponding representative character.
	     * 
	     * @param c the character that will be used as the argument 
	     * 			of the command that uses them.
	     */
	    Color (char c) {
	    	character = c;
	    }
	    
	    /**
	     * Return the character that represents the color.
	     * 
	     * @return the indicated character when the color was created.
	     */
	    public char getCharacter() {
	    	return character;
	    }
	}
	/**
	 * Command for red color.
	 */
	private String commandR = COMMAND_LED + SEPARATOR + Color.RED.getCharacter();
	/**
	 * Command for green color.
	 */
	private String commandG = COMMAND_LED + SEPARATOR + Color.GREEN.getCharacter();
	/**
	 * Command for blue color.
	 */
	private String commandB = COMMAND_LED + SEPARATOR + Color.BLUE.getCharacter();
	/**
	 * Command for cyan color.
	 */
	private String commandC = COMMAND_LED + SEPARATOR + Color.CYAN.getCharacter();
	/**
	 * Command for magenta color.
	 */
	private String commandM = COMMAND_LED + SEPARATOR + Color.MAGENTA.getCharacter();
	/**
	 * Command for yellow color.
	 */
	private String commandY = COMMAND_LED + SEPARATOR + Color.YELLOW.getCharacter();
	/**
	 * Command for white color.
	 */
	private String commandW = COMMAND_LED + SEPARATOR + Color.WHITE.getCharacter();
	/**
	 * Command for no color.
	 */
	private String commandO = COMMAND_LED + SEPARATOR + Color.NOCOLOR.getCharacter();
	
	/** Default constructor. */
	public LEDCommandBean() {
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
	 * @return the commandB
	 */
	public String getCommandB() {
		return commandB;
	}

	/**
	 * @param commandB the commandB to set
	 */
	public void setCommandB(String commandB) {
		this.commandB = commandB;
	}

	/**
	 * @return the commandC
	 */
	public String getCommandC() {
		return commandC;
	}

	/**
	 * @param commandC the commandC to set
	 */
	public void setCommandC(String commandC) {
		this.commandC = commandC;
	}

	/**
	 * @return the commandM
	 */
	public String getCommandM() {
		return commandM;
	}

	/**
	 * @param commandM the commandM to set
	 */
	public void setCommandM(String commandM) {
		this.commandM = commandM;
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
	 * @return the commandO
	 */
	public String getCommandO() {
		return commandO;
	}

	/**
	 * @param commandO the commandO to set
	 */
	public void setCommandO(String commandO) {
		this.commandO = commandO;
	}
}
