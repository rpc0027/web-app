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
	    NOCOLOR('o');
		
	    private final char assignedLetter;
	    
	    Color (char c) {
	    	assignedLetter = c;
	    }
	    
	    public char getAssignedLetter() {
	    	return assignedLetter;
	    }
	}
	
	public enum PWMDevice {
	    WHITE('w'),
	    GREEN('g'),
	    YELLOW('y'),
	    RED('r');
		
	    private final char assignedLetter;
	    
	    PWMDevice (char c) {
	    	assignedLetter = c;
	    }
	    
	    public char getAssignedLetter() {
	    	return assignedLetter;
	    }
	}
	
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
