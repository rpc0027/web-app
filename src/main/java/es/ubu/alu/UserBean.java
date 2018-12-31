package es.ubu.alu;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;

	TCPCommandSender commandSender = new TCPCommandSender("192.168.1.100", 1234);

	public UserBean() {}

	public String getIP() {
		return commandSender.getIPAddress();
	}

	public int getPort() {
		return commandSender.getPort();
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
}
