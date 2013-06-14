/*
 * This file is part of DropletConfig.
 *
 * Copyright (c) 2013 Spout LLC <http://www.spout.org/>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.spout.droplet.config.commands;

import java.util.List;

import org.spout.api.command.CommandArguments;
import org.spout.api.command.CommandSource;
import org.spout.api.command.annotated.Command;
import org.spout.api.command.annotated.Permissible;
import org.spout.api.exception.CommandException;
import org.spout.api.exception.ConfigurationException;

import org.spout.droplet.config.DropletConfig;
import org.spout.droplet.config.configuration.DropletConfigFile;

public class DropletCommands {
	DropletConfig plugin = new DropletConfig();

	public DropletCommands(DropletConfig instance) {
		plugin = instance;
	}

	@Command(aliases = {"i", "int"}, usage = "<integer>", desc = "Edits the integer portion of the config.")
	@Permissible("droplet.command.int")
	public void i(CommandSource source, CommandArguments args) throws CommandException {
		if (args.length() == 1) {
			int value = args.getInteger(0);
			DropletConfigFile.INT.setValue(value);
			try {
				plugin.configFile.save();
			} catch (ConfigurationException e) {
				e.printStackTrace();
			}
			source.sendMessage(value + " was added to the integer config file.");
		} else {
			source.sendMessage("Syntax: /c <int/i> <integer>");
		}
	}

	@Command(aliases = {"s", "string"}, usage = "<string>", desc = "Edits the string portion of the config.")
	@Permissible("droplet.command.int")
	public void s(CommandSource source, CommandArguments args) throws CommandException {
		if (args.length() >= 1) {
			String value = "";
			for (int i = 0; i < args.length(); i++) {
				if (value.equalsIgnoreCase("")) {
					value = args.getString(i);
				} else {
					value = value + " " + args.getString(i);
				}
			}
			DropletConfigFile.STRING.setValue(value);
			try {
				plugin.configFile.save();
			} catch (ConfigurationException e) {
				e.printStackTrace();
			}
			source.sendMessage(value + " was added to the string config file.");
		} else {
			source.sendMessage("Syntax: /c <string/s> <string>");
		}
	}

	@Command(aliases = {"sl", "stringlist"}, usage = "<stringlist>", desc = "Adds the string to the string list portion of the config.")
	@Permissible("droplet.command.int")
	public void sl(CommandSource source, CommandArguments args) throws CommandException {
		if (args.length() >= 1) {
			String value = "";
			for (int i = 0; i < args.length(); i++) {
				if (value.equalsIgnoreCase("")) {
					value = args.getString(i);
				} else {
					value = value + " " + args.getString(i);
				}
			}
			List<String> stringList = DropletConfigFile.STRINGLIST.getStringList();
			stringList.add(value);
			DropletConfigFile.STRINGLIST.setValue(stringList);
			try {
				plugin.configFile.save();
			} catch (ConfigurationException e) {
				e.printStackTrace();
			}
			source.sendMessage(value + " was added to the string list config file.");
		} else {
			source.sendMessage("Syntax: /c <stringlist/sl> <string>");
		}
	}
}
