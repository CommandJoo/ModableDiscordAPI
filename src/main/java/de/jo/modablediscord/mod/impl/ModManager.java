package de.jo.modablediscord.mod.impl;

import de.jo.modablediscord.events.api.EventManager;
import de.jo.modablediscord.main.ModableDiscord;
import de.jo.modablediscord.util.FileManager;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ModManager {

    private ModableDiscord discord;

    public ModManager(ModableDiscord discord) {
        this.discord = discord;
    }

    public void registerDiscordEvent(ListenerAdapter listener) {
        this.discord.registerJDAEvent(listener);
    }
    public void registerEvent(Object listener) {
        EventManager.register(listener);
    }
    public void unregisterEvent(Object listener) {
        EventManager.unregister(listener);
    }

    public ModableDiscord getDiscord() {
        return this.discord;
    }
    public FileManager getFileManager() {
        return this.discord.getFileManager();
    }

}
