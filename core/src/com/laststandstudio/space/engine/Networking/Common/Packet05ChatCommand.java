package com.laststandstudio.space.engine.Networking.Common;

import java.util.ArrayList;
import java.util.Collections;

/**
 * ***************************************************************************
 * Space Shooter Software License
 * Version 0.0.2-alpha
 * <p>
 * Copyright (C) 2015 Last Stand Studio
 * <p>
 * SpaceShooter is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * SpaceShooter is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with SpaceShooter.  If not, see <http://www.gnu.org/licenses/>.
 * ***************************************************************************
 */

public class Packet05ChatCommand extends Packet {

    private String sender;
    private Long commandHash;
    private String command;
    private ArrayList<String> commandArgs;

    Packet05ChatCommand(String sender, String command, String... commandArgs) {
        this.sender = sender;
        this.command = command;
        if (commandArgs.length > 0) {
            Collections.addAll(this.commandArgs, commandArgs);
        } else {
            this.commandArgs = new ArrayList<String>() {{
                add("@");
            }};
        }
    }

    public void addCommandArgs(String... commandArgs) {
        Collections.addAll(this.commandArgs, commandArgs);
    }

    public String[] listCommandArgs() {
        return this.commandArgs.toArray(new String[]{});
    }

    public void setCommand(String message) {
        this.command = message;
    }

    public String getCommand() {
        return this.command;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSender() {
        return sender;
    }

    public Long getMessageHash() {
        return commandHash;
    }

    @Override
    public Packet prepare() {
        commandHash = Long.valueOf((sender + ":" + command + ":" + commandArgs.size()).hashCode());
        return this;
    }

    @Override
    public Integer getPacketId() {
        return 5;
    }
}
