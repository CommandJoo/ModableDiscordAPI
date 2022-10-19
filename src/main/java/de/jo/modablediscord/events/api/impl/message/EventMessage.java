package de.jo.modablediscord.events.api.impl.message;

import de.jo.modablediscord.events.api.events.Event;
import de.jo.modablediscord.events.api.impl.EventMessageBase;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;

public class EventMessage extends EventMessageBase {

    private User user;

    public EventMessage(User user, Message message, MessageChannel channel) {
        super(message, channel);
        this.user = user;
    }

    public User user() {
        return user;
    }

}
