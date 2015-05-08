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

public class Packet06ChatMessage extends Packet {

    private String sender;
    private Long messageHash;
    private String message;
    private ArrayList<String> recipients;

    Packet06ChatMessage(String sender, String message, String... recipients) {
        this.sender = sender;
        this.message = message;
        if (recipients.length > 0) {
            Collections.addAll(this.recipients, recipients);
        } else {
            this.recipients = new ArrayList<String>() {{
                add("@");
            }};
        }
    }

    public void addRecipients(String... recipients) {
        Collections.addAll(this.recipients, recipients);
    }

    public void removeRecipients(String... recipients) {
        for (String s : recipients) {
            if (this.recipients.contains(s)) {
                this.recipients.remove(s);
            }
        }
    }

    public String[] listRecipients() {
        return this.recipients.toArray(new String[]{});
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSender() {
        return sender;
    }

    public Long getMessageHash() {
        return messageHash;
    }

    @Override
    public Packet prepare() {
        messageHash = Long.valueOf((sender + ":" + message + ":" + recipients.size()).hashCode());
        return this;
    }

    @Override
    public Integer getPacketId() {
        return 6;
    }
}
