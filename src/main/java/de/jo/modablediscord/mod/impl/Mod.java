package de.jo.modablediscord.mod.impl;

import de.jo.modablediscord.discord.command.CommandManager;
import de.jo.modablediscord.main.ModableDiscord;
import de.jo.modablediscord.mod.ModInfo;

public class Mod {

    private ModInfo info;
    private ModManager manager;
    private CommandManager commands;

    public void onEnable() {}
    public void onDisable() {}




    public ModInfo getInfo() {
        return info;
    }
    public void setInfo(ModInfo info) {
        this.info = info;
    }

    public ModManager getManager() {
        return manager;
    }
    public void setManager(ModManager manager) {
        this.manager = manager;
    }

    public CommandManager getCommands() {
        return commands;
    }
    public void setCommands(CommandManager manager) {
        this.commands = manager;
    }

    public ModableDiscord getDiscord() {
        return getManager().getDiscord();
    }

}
