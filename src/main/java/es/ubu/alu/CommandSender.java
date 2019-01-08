package es.ubu.alu;

/**
 * Declares a function for each operation available in the remote board.
 * <p>
 * To perform a certain operation, a command is sent indicating its name. 
 * In addition, depending on the operation, the necessary arguments are added 
 * so that the operation can be carried out.
 * 
 * @author RPC
 * @version 1.0
 */
public interface CommandSender {
	/**
	 * Name of the command to change the color of the light 
	 * emitted by the on-board RGB LEDs.
	 */
	public static final String COMMAND_LED = "led";
	/**
	 * Name of the command to show a string in one of the lines of the LCD.
	 */
	public static final String COMMAND_MSG = "msg";
	/**
	 * Name of the command to vary the intensity of the light of the LEDs
	 * in the Basic I/O shield.
	 */
	public static final String COMMAND_PWM = "pwm";
	/**
	 * Character used as a separator between the command and its arguments.
	 */
	public static final String SEPARATOR = ":";
	
	/**
	 * Each of the colors that can be illuminated using the RGB LEDs.
	 * If the user wants to turn off the LEDs, a special character is sent.
	 * 
	 * @author RPC
	 * @version 1.0
	 */
	public enum Color {
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
	public enum PWMDevice {
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
	 * Send any command to the remote board over the network.
	 * 
	 * @param command string to be sent.
	 */
	public void sendCommand(String command);
	
	/**
	 * Send the command that turns on the given color.
	 * 
	 * @param color the color chosen by the user.
	 */
	public void turnOnLed(Color color);
	
	/**
	 * Send the command that turns on the red color.
	 */
	void turnOnRed();

	/**
	 * Send the command that turns on the green color.
	 */
	void turnOnGreen();
	
	/**
	 * Send the command that turns on the blue color.
	 */
	void turnOnBlue();
	
	/**
	 * Send the command that turns on the yellow color.
	 */
	void turnOnYellow();
	
	/**
	 * Send the command that turns on the magenta color.
	 */
	void turnOnMagenta();
	
	/**
	 * Send the command that turns on the cyan color.
	 */
	void turnOnCyan();
	
	/**
	 * Send the command that turns on the white color.
	 */
	void turnOnWhite();
	
	/**
	 * Send the command that turns off all colors.
	 */
	void turnOffLEDs();
	
	/**
	 * Send the command with the message that the user wants to show.
	 * <p>
	 * The message is composed of a text string that will be shown 
	 * in one of the lines of the display.
	 * 
	 * @param row     the row of the display to show the message.
	 * @param message the text string to show.
	 */
	public void sendMessage(byte row, String message);
	
	/**
	 * Send the command with the message that the user wants to show 
	 * in the first line of the display.
	 * 
	 * @param message the text string to show.
	 */
	void sendMessageRow0(String message);
	
	/**
	 * Send the command with the message that the user wants to show 
	 * in the second line of the display.
	 * 
	 * @param message the text string to show.
	 */
	void sendMessageRow1(String message);
	
	/**
	 * Send the command to adjust the duty cycle of the indicated device.
	 * <p>
	 * The duty cycle is changed to the given percentage.
	 * Being 0 the minimum value, turning the device off.
	 * Or being 100 the maximum value, putting the device at maximum duty.
	 * 
	 * @param pwmDevice  the device to adjust.
	 * @param percentage the new duty cycle. 
	 */
	public void adjustsPWM(PWMDevice pwmDevice, byte percentage);
	
	/**
	 * Send the command to adjust the duty cycle of the white led device.
	 * 
	 * @param percentage the new duty cycle. 
	 */
	void adjustWhite(byte percentage);
	
	/**
	 * Send the command to adjust the duty cycle of the green led device.
	 * 
	 * @param percentage the new duty cycle. 
	 */
	void adjustGreen(byte percentage);
	
	/**
	 * Send the command to adjust the duty cycle of the yellow led device.
	 * 
	 * @param percentage the new duty cycle. 
	 */
	void adjustYellow(byte percentage);
	
	/**
	 * Send the command to adjust the duty cycle of the red led device.
	 * 
	 * @param percentage the new duty cycle. 
	 */
	void adjustRed(byte percentage);	
}
