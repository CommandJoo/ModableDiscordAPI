package de.jo.modablediscord.discordmod;

import de.jo.modablediscord.discord.command.CommandManager;
import de.jo.modablediscord.main.ModableDiscord;
import de.jo.modablediscord.mod.ModInfo;
import de.jo.modablediscord.mod.impl.Mod;
import de.jo.modablediscord.mod.impl.ModManager;
import net.dv8tion.jda.api.entities.User;

public class DiscordMod extends Mod {

    public DiscordMod() {
        ModInfo discordModInfo = new ModInfo();
        discordModInfo.name = "ModableDiscord";
        discordModInfo.author = User.fromId(814472040907014145L).getAsMention();
        discordModInfo.version = ModableDiscord.VERSION;
        discordModInfo.description = "The Default Mod for ModableDiscord";
        this.setInfo(discordModInfo);
        this.setManager(new ModManager(ModableDiscord.getInstance()));
    }

    @Override
    public void onEnable() {
        System.out.println("Enabled ModableDiscord default Mod");
        setCommands(new CommandManager("~") {
            @Override
            public void init() {
                addCommand(new CommandMods());
            }
        });
    }

    @Override
    public void onDisable() {
        System.out.println("Disabled ModableDiscord default Mod");
    }
}
