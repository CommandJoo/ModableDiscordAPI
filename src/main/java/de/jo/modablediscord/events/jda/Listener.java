package de.jo.modablediscord.events.jda;

import de.jo.modablediscord.discord.command.CommandManager;
import de.jo.modablediscord.events.api.EventManager;
import de.jo.modablediscord.events.api.impl.message.EventGuildMessage;
import de.jo.modablediscord.events.api.impl.message.EventMessage;
import de.jo.modablediscord.events.api.impl.message.EventMessageReaction;
import de.jo.modablediscord.main.ModableDiscord;
import de.jo.modablediscord.mod.impl.Mod;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.GenericMessageReactionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Listener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().equals(ModableDiscord.getInstance().getJda().getSelfUser())) return;
        if(event.isFromGuild()) {
            EventManager.call(new EventGuildMessage(event.getGuild(), event.getMember(), event.getMessage(), event.getGuildChannel()));
        }else {
            if(event.getChannel().getType() == ChannelType.PRIVATE) {
                EventManager.call(new EventMessage(event.getAuthor(), event.getMessage(), event.getChannel().asPrivateChannel()));
            }
        }
        for(Mod mod : ModableDiscord.getInstance().getMods()) {
            CommandManager commandManager = mod.getCommands();
            if(commandManager != null) {
                commandManager.parse(event.getAuthor(), event.getMember(), event.getMessage());
            }
        }
    }

    @Override
    public void onGenericMessageReaction(GenericMessageReactionEvent event) {
        if(event.getUser().equals(ModableDiscord.getInstance().getJda().getSelfUser())) return;
        MessageChannel channel = null;
        if(event.isFromGuild()) {
            channel = event.getGuildChannel();
        }else {
            channel = event.getChannel();
        }
        EventManager.call(new EventMessageReaction(event.getChannel().getHistory().getMessageById(event.getMessageId()), channel, event.getMember(), event.getUser(), event.getEmoji(), event.getReaction()));
    }
}
