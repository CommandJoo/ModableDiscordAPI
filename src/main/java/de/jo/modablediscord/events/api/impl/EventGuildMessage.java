package de.jo.modablediscord.events.api.impl;

import de.jo.modablediscord.events.api.events.Event;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.entities.channel.middleman.GuildMessageChannel;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;

public class EventGuildMessage extends EventMessage {

    private Guild guild;

    public EventGuildMessage(Guild guild, Member member, Message message, GuildMessageChannel channel) {
        super(member, message, channel);
        this.guild = guild;
    }

    public Guild guild() {
        return guild;
    }
}