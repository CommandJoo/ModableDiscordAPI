package de.jo.modablediscord.events.api.impl.message;

import de.jo.modablediscord.events.api.impl.EventMessageBase;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.channel.middleman.GuildMessageChannel;

public class EventGuildMessage extends EventMessageBase {

    private Guild guild;
    private Member member;

    public EventGuildMessage(Guild guild, Member member, Message message, GuildMessageChannel channel) {
        super(message, channel);
        this.member = member;
        this.guild = guild;
    }

    public Member member() {
        return member;
    }
    public Guild guild() {
        return guild;
    }
}