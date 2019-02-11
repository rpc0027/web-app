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
public interface Sender {	
	/**
	 * Send any command to the remote board over the network.
	 * 
	 * @param command string to be sent.
	 */
	public void sendCommand(String command);
	
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
	 * Send the command with the message that the user wants to show 
	 * in the first line of the display.
	 * 
	 * @param message the text string to show.
	 */
	void sendMessageRow1(String message);
	
	/**
	 * Send the command with the message that the user wants to show 
	 * in the second line of the display.
	 * 
	 * @param message the text string to show.
	 */
	void sendMessageRow2(String message);
	
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
