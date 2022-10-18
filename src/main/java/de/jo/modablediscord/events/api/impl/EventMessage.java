package de.jo.modablediscord.events.api.impl;

import de.jo.modablediscord.events.api.events.Event;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;

public class EventMessage implements Event {

    private Member member;
    private Message message;
    private MessageChannel channel;

    public EventMessage(Member member, Message message, MessageChannel channel) {
        this.member = member;
        this.message = message;
        this.channel = channel;
    }

    public Member member() {
        return member;
    }

    public Message message() {
        return message;
    }

    public MessageChannel channel() {
        return channel;
    }

}
