package de.jo.modablediscord.events.api.impl;

import de.jo.modablediscord.events.api.events.Event;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

public class EventMessageBase implements Event {

    private Message message;
    private MessageChannel channel;

    public EventMessageBase(Message message, MessageChannel channel) {
        this.message = message;
        this.channel = channel;
    }

    public Message message() {
        return message;
    }

    public MessageChannel channel() {
        return channel;
    }
}
