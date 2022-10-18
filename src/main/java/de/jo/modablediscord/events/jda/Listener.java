package de.jo.modablediscord.events.jda;

import de.jo.modablediscord.events.api.EventManager;
import de.jo.modablediscord.events.api.impl.EventGuildMessage;
import de.jo.modablediscord.events.api.impl.EventMessage;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Listener extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.isFromGuild()) {
            EventManager.call(new EventGuildMessage(event.getGuild(), event.getMember(), event.getMessage(), event.getGuildChannel()));
        }else {
            EventManager.call(new EventMessage(event.getMember(), event.getMessage(), event.getChannel()));
        }
    }
}
