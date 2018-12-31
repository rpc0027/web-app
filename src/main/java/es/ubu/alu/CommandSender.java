/**
 * 
 */
package es.ubu.alu;

/**
 * @author rpc0027
 *
 */
public interface CommandSender {
	public static final String COMMAND_LED = "led";
	public static final String COMMAND_MSG = "msg";
	public static final String COMMAND_PWM = "pwm";
	public static final String SEPARATOR = ":";
	
	public enum Color {
	    RED('r'),
	    GREEN('g'),
	    BLUE('b'),
	    YELLOW('y'),
	    MAGENTA('m'),
	    CYAN('c'),
	    WHITE('w'),
	    NOCOLOR('o');
		
	    private final char character;
	    
	    Color (char c) {
	    	character = c;
	    }
	    
	    public char getCharacter() {
	    	return character;
	    }
	}
	
	public enum PWMDevice {
	    WHITE('w'),
	    GREEN('g'),
	    YELLOW('y'),
	    RED('r');
		
	    private final char character;
	    
	    PWMDevice (char c) {
	    	character = c;
	    }
	    
	    public char getCharacter() {
	    	return character;
	    }
	}
	
	public void sendCommand(String command);
	
	public void turnOnLed(Color color);
	void turnOnRed();
	void turnOnGreen();
	void turnOnBlue();
	void turnOnYellow();
	void turnOnMagenta();
	void turnOnCyan();
	void turnOnWhite();
	void turnOffLEDs();
	
	public void sendMessage(byte row, String message);
	void sendMessageRow0(String message);
	void sendMessageRow1(String message);
	
	public void adjustsPWM(PWMDevice pwmDevice, byte percentage);
	void adjustWhite(byte percentage);
	void adjustGreen(byte percentage);
	void adjustYellow(byte percentage);
	void adjustRed(byte percentage);	
}
