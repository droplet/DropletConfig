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

import org.spout.api.command.CommandContext;
import org.spout.api.command.CommandSource;
import org.spout.api.command.annotated.Command;
import org.spout.api.command.annotated.NestedCommand;
import org.spout.api.exception.CommandException;

import org.spout.droplet.config.DropletConfig;

public class DropletCommand {
	private final DropletConfig plugin;

	/**
	 * We must pass in an instance of our plugin's object for the annotation to register under the factory.
	 * @param instance
	 */
	public DropletCommand(DropletConfig instance) {
		plugin = instance;
	}

	// This is the command. Will detail all the options later.
	@Command(aliases = {"c", "config"}, usage = "", desc = "Access droplet config commands")
	// This is the class with all subcommands under /config
	@NestedCommand(DropletCommands.class)
	public void config(CommandContext args, CommandSource source) throws CommandException {
	}
}
