package de.jo.modablediscord.discordmod;

import de.jo.modablediscord.discord.command.ICommand;
import de.jo.modablediscord.main.ModableDiscord;
import de.jo.modablediscord.mod.impl.Mod;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import java.io.IOException;

public class CommandMods implements ICommand {
    @Override
    public String name() {
        return "mods";
    }

    @Override
    public boolean execute(User u, Member m, java.lang.String[] args, Message message) throws IOException {
        StringBuilder builder = new StringBuilder("(");
        builder.append(ModableDiscord.getInstance().getMods().size()).append(") ");
        builder.append("Loaded Mods: ");
        int it = 0;
        for(Mod mod : ModableDiscord.getInstance().getMods()) {
            if(it > 0) {
                builder.append(", ");
            }else{
                it++;
            }
            builder.append(mod.getInfo().name).append(" ").append(mod.getInfo().version).append(" by ").append(mod.getInfo().author);
        }

        message.getChannel().sendMessage(builder.toString()).queue();

        return false;
    }
}
