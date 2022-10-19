package de.jo.modablediscord.events.api.impl.message;

import de.jo.modablediscord.events.api.impl.EventMessageBase;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.entities.emoji.EmojiUnion;

public class EventMessageReaction extends EventMessageBase {

    private Member member;
    private User user;
    private EmojiUnion emoji;
    private MessageReaction reaction;

    public EventMessageReaction(Message message, MessageChannel channel, Member member, User user, EmojiUnion emoji, MessageReaction reaction) {
        super(message, channel);
        this.member = member;
        this.user = user;
        this.emoji = emoji;
        this.reaction = reaction;
    }

    public Member member() {
        return member;
    }

    public User user() {
        return user;
    }

    public EmojiUnion emoji() {
        return emoji;
    }

    public MessageReaction reaction() {
        return reaction;
    }
}
