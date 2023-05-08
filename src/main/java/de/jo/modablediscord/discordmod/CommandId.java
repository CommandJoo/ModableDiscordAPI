package de.jo.modablediscord.discordmod;

import de.jo.modablediscord.discord.command.ICommand;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

import java.io.IOException;

/**
 * @author CommandJoo 08.05.2023
 * @Project ModableDiscord
 */
public class CommandId implements ICommand {
    @Override
    public String name() {
        return "id";
    }

    @Override
    public boolean execute(User u, Member m, String[] args, Message message) throws IOException {
        message.reply("Your User-ID is: "+u.getIdLong()).queue();
        return false;
    }
}
