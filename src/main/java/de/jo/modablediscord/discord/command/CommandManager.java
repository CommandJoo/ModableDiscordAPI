package de.jo.modablediscord.discord.command;

import de.jo.modablediscord.main.ModableDiscord;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class CommandManager {

    private final String COMMAND_PREFIX;
    private List<ICommand> commands;

    public CommandManager(String commandPrefix) {
        this.COMMAND_PREFIX = commandPrefix;
        this.commands = new ArrayList<>();

        init();
    }

    public abstract void init();

    public void addCommand(ICommand command) {
        if(this.commands == null) this.commands = new ArrayList<>();
        this.commands.add(command);
    }

    public boolean parse(User user, Member member, Message message) {
        if(user.equals(ModableDiscord.getInstance().getJda().getSelfUser())) return false;
        String content = message.getContentRaw();
        if(!content.startsWith(this.COMMAND_PREFIX)) {
            return false;
        }

        String[] split = content.split(" ");
        String name = split[0].substring(COMMAND_PREFIX.length());
        String[] arguments = Arrays.copyOfRange(split, 1, split.length);

        for(ICommand command : this.commands) {
            if(command.name().equalsIgnoreCase(name)) {
                try {
                    return command.execute(user, member, arguments, message);
                } catch(Exception ex) {
                    ex.printStackTrace();
                    return false;
                }
            }
        }
        return false;
    }

    public List<ICommand> commands() {
        return this.commands;
    }
}
