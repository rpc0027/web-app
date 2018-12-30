/**
 * 
 */
package es.ubu.alu;

/**
 * @author rpc0027
 *
 */
public interface CommandSender {
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
	abstract void turnOnRed();
	abstract void turnOnGreen();
	abstract void turnOnBlue();
	abstract void turnOnYellow();
	abstract void turnOnMagenta();
	abstract void turnOnCyan();
	abstract void turnOnWhite();
	abstract void turnOffLEDs();
	
	public void sendMessage(byte row, String message);
	abstract void sendMessageRow0(String message);
	abstract void sendMessageRow1(String message);
	
	public void adjustsPWM(PWMDevice pwmDevice, byte percentage);
	abstract void adjustWhite(byte percentage);
	abstract void adjustGreen(byte percentage);
	abstract void adjustYellow(byte percentage);
	abstract void adjustRed(byte percentage);	
}
