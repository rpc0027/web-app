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
 * Bean used to model MSG commands.
 * 
 * @author RPC
 * @version 1.0
 */
@ManagedBean(name = "msgCommandBean")
@SessionScoped
public class MSGCommandBean implements Serializable {
	/** Randomly generated identifier. */
	private static final long serialVersionUID = 1L + (long) (Math.random() * (100000000000L - 1L));
	/**
	 * Name of the command to show a string in one of the lines of the LCD.
	 */
	public static final String COMMAND_MSG = "msg";
	/**
	 * Character used as a separator between the command and its arguments.
	 */
	private static final String SEPARATOR = ":";
	/**
	 * Command for 1st row.
	 */
	private String command1st = COMMAND_MSG + SEPARATOR + "0" + SEPARATOR;
	/**
	 * Command for 2nd row.
	 */
	private String command2nd = COMMAND_MSG + SEPARATOR + "1" + SEPARATOR;
	
	/** Default constructor. */
	public MSGCommandBean() {
	}

	/**
	 * @return the command1st
	 */
	public String getCommand1st() {
		return command1st;
	}

	/**
	 * @param command1st the command1st to set
	 */
	public void setCommand1st(String command1st) {
		this.command1st = command1st;
	}

	/**
	 * @return the command2nd
	 */
	public String getCommand2nd() {
		return command2nd;
	}

	/**
	 * @param command2nd the command2nd to set
	 */
	public void setCommand2nd(String command2nd) {
		this.command2nd = command2nd;
	}
}
