package de.jo.modablediscord.discord.command;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

import java.io.IOException;

public interface ICommand {

    public String name();
    public boolean execute(User u, Member m, String[] args, Message message) throws IOException;

}
