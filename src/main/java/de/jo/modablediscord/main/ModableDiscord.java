package de.jo.modablediscord.main;

import de.jo.modablediscord.discord.ModableDiscordConfig;
import de.jo.modablediscord.discordmod.DiscordMod;
import de.jo.modablediscord.events.jda.Listener;
import de.jo.modablediscord.mod.ModLoader;
import de.jo.modablediscord.mod.impl.Mod;
import de.jo.modablediscord.mod.impl.ModManager;
import de.jo.modablediscord.util.FileManager;
import de.jo.modablediscord.util.GsonUtil;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModableDiscord {

    private JDA jda;
    private FileManager fileManager;

    private static ModableDiscord instance;

    private ModableDiscordConfig config;
    private List<Mod> mods = new ArrayList<>();

    public static final String VERSION = "v1.0.5";

    public ModableDiscord() {
        instance = this;
        preInit();
        this.jda = JDABuilder.createDefault(config.botToken)
                .enableIntents(GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS))
                .enableCache(Arrays.asList(CacheFlag.values()))
                .setActivity(Activity.of(config.activity.type, config.activity.name))
                .setStatus(config.onlineStatus)
                .setEnableShutdownHook(true)
                .build();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                shutdown();
            }
        }));
        init();
    }

    public void preInit() {
        this.fileManager = new FileManager(this);
        this.fileManager.init();

        File configFile = this.fileManager.getFile("config.json");
        if(!configFile.exists()) {
            GsonUtil.writeFile(new ModableDiscordConfig(), "config.json");
            System.out.println("Shutting down -> please configure your config first!");
            this.shutdown();
            Runtime.getRuntime().exit(-1);
        }
        this.config = GsonUtil.toObject(ModableDiscordConfig.class, configFile);

        if(this.config.botToken.isEmpty()) {
            System.out.println("Shutting down -> please configure your config first -> bot token!");
            this.shutdown();
            Runtime.getRuntime().exit(-1);
        }
    }

    public void init() {
        this.registerJDAEvent(new Listener());

        this.mods = new ArrayList<>();
        this.mods.add(new DiscordMod());
        this.mods.addAll(new ModLoader().loadDirectory(this.fileManager.getDirectory("mods")));
        for(Mod mod : this.mods) {
            mod.onEnable();
        }
    }

    public void shutdown() {
        for(Mod mod : this.mods) {
            mod.onDisable();
        }
        this.jda.getPresence().setStatus(OnlineStatus.OFFLINE);
        this.jda.shutdownNow();
    }

    public void registerJDAEvent(ListenerAdapter adapter) {
        this.getJda().addEventListener(adapter);
    }
    public static ModableDiscord getInstance() {
        return instance;
    }
    public JDA getJda() {
        return jda;
    }
    public FileManager getFileManager() {
        return fileManager;
    }
    public List<Mod> getMods() {
        return mods;
    }
    public ModableDiscordConfig getConfig() {
        return config;
    }
}
