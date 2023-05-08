package de.jo.modablediscord.events.jda;

import de.jo.modablediscord.discord.command.CommandManager;
import de.jo.modablediscord.events.api.EventManager;
import de.jo.modablediscord.events.api.impl.EventShutdown;
import de.jo.modablediscord.events.api.impl.message.EventGuildMessage;
import de.jo.modablediscord.events.api.impl.message.EventMessage;
import de.jo.modablediscord.events.api.impl.message.EventMessageReaction;
import de.jo.modablediscord.events.api.impl.session.EventSessionDisconnect;
import de.jo.modablediscord.events.api.impl.session.EventSessionRecreate;
import de.jo.modablediscord.events.api.impl.session.EventSessionResume;
import de.jo.modablediscord.main.ModableDiscord;
import de.jo.modablediscord.mod.impl.Mod;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.*;
import net.dv8tion.jda.api.events.channel.ChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.ChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.GenericChannelEvent;
import net.dv8tion.jda.api.events.channel.forum.ForumTagAddEvent;
import net.dv8tion.jda.api.events.channel.forum.ForumTagRemoveEvent;
import net.dv8tion.jda.api.events.channel.forum.GenericForumTagEvent;
import net.dv8tion.jda.api.events.channel.forum.update.ForumTagUpdateEmojiEvent;
import net.dv8tion.jda.api.events.channel.forum.update.ForumTagUpdateModeratedEvent;
import net.dv8tion.jda.api.events.channel.forum.update.ForumTagUpdateNameEvent;
import net.dv8tion.jda.api.events.channel.forum.update.GenericForumTagUpdateEvent;
import net.dv8tion.jda.api.events.channel.update.*;
import net.dv8tion.jda.api.events.emoji.EmojiAddedEvent;
import net.dv8tion.jda.api.events.emoji.EmojiRemovedEvent;
import net.dv8tion.jda.api.events.emoji.GenericEmojiEvent;
import net.dv8tion.jda.api.events.emoji.update.EmojiUpdateNameEvent;
import net.dv8tion.jda.api.events.emoji.update.EmojiUpdateRolesEvent;
import net.dv8tion.jda.api.events.emoji.update.GenericEmojiUpdateEvent;
import net.dv8tion.jda.api.events.guild.*;
import net.dv8tion.jda.api.events.guild.invite.GenericGuildInviteEvent;
import net.dv8tion.jda.api.events.guild.invite.GuildInviteCreateEvent;
import net.dv8tion.jda.api.events.guild.invite.GuildInviteDeleteEvent;
import net.dv8tion.jda.api.events.guild.member.*;
import net.dv8tion.jda.api.events.guild.member.update.*;
import net.dv8tion.jda.api.events.guild.override.GenericPermissionOverrideEvent;
import net.dv8tion.jda.api.events.guild.override.PermissionOverrideCreateEvent;
import net.dv8tion.jda.api.events.guild.override.PermissionOverrideDeleteEvent;
import net.dv8tion.jda.api.events.guild.override.PermissionOverrideUpdateEvent;
import net.dv8tion.jda.api.events.guild.update.*;
import net.dv8tion.jda.api.events.guild.voice.*;
import net.dv8tion.jda.api.events.http.HttpRequestEvent;
import net.dv8tion.jda.api.events.interaction.GenericAutoCompleteInteractionEvent;
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent;
import net.dv8tion.jda.api.events.interaction.ModalInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.*;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.GenericComponentInteractionCreateEvent;
import net.dv8tion.jda.api.events.interaction.component.SelectMenuInteractionEvent;
import net.dv8tion.jda.api.events.message.*;
import net.dv8tion.jda.api.events.message.react.*;
import net.dv8tion.jda.api.events.role.GenericRoleEvent;
import net.dv8tion.jda.api.events.role.RoleCreateEvent;
import net.dv8tion.jda.api.events.role.RoleDeleteEvent;
import net.dv8tion.jda.api.events.role.update.*;
import net.dv8tion.jda.api.events.self.*;
import net.dv8tion.jda.api.events.session.*;
import net.dv8tion.jda.api.events.stage.GenericStageInstanceEvent;
import net.dv8tion.jda.api.events.stage.StageInstanceCreateEvent;
import net.dv8tion.jda.api.events.stage.StageInstanceDeleteEvent;
import net.dv8tion.jda.api.events.stage.update.GenericStageInstanceUpdateEvent;
import net.dv8tion.jda.api.events.stage.update.StageInstanceUpdatePrivacyLevelEvent;
import net.dv8tion.jda.api.events.stage.update.StageInstanceUpdateTopicEvent;
import net.dv8tion.jda.api.events.sticker.GenericGuildStickerEvent;
import net.dv8tion.jda.api.events.sticker.GuildStickerAddedEvent;
import net.dv8tion.jda.api.events.sticker.GuildStickerRemovedEvent;
import net.dv8tion.jda.api.events.sticker.update.*;
import net.dv8tion.jda.api.events.thread.GenericThreadEvent;
import net.dv8tion.jda.api.events.thread.ThreadHiddenEvent;
import net.dv8tion.jda.api.events.thread.ThreadRevealedEvent;
import net.dv8tion.jda.api.events.thread.member.GenericThreadMemberEvent;
import net.dv8tion.jda.api.events.thread.member.ThreadMemberJoinEvent;
import net.dv8tion.jda.api.events.thread.member.ThreadMemberLeaveEvent;
import net.dv8tion.jda.api.events.user.GenericUserEvent;
import net.dv8tion.jda.api.events.user.UserActivityEndEvent;
import net.dv8tion.jda.api.events.user.UserActivityStartEvent;
import net.dv8tion.jda.api.events.user.UserTypingEvent;
import net.dv8tion.jda.api.events.user.update.*;
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
    @Override
    public void onSessionDisconnect(SessionDisconnectEvent event) {
        EventManager.call(new EventSessionDisconnect(event.getServiceCloseFrame(), event.getClientCloseFrame(), event.isClosedByServer(), event.getTimeDisconnected()));
    }
    @Override
    public void onSessionResume(SessionResumeEvent event) {
        EventManager.call(new EventSessionResume());
    }
    @Override
    public void onSessionRecreate(SessionRecreateEvent event) {
        EventManager.call(new EventSessionRecreate());
    }
    @Override
    public void onShutdown(ShutdownEvent event) {
        EventManager.call(new EventShutdown(event.getTimeShutdown(), event.getCode()));
    }

}
