package de.jo.modablediscord.util;

import de.jo.modablediscord.main.ModableDiscord;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
    
    private ModableDiscord discord;
    
    public FileManager(ModableDiscord discord) {
        this.discord = discord;
    }

    public void init() {
        File mods = getDirectory("mods");
        File config = getFile("config.json");
    }

    public File getFile(String dir, String file) {
        return new File(getDirectory(dir), file);
    }
    public File getFile(String file) {
        return new File(getDirectory(), file);
    }
    public File getDirectory(String sub) {
        File f = new File(getDirectory(), sub);
        if(!f.exists() || !f.isDirectory()) f.mkdirs();
        return f;
    }
    public File getDirectory() {
        Path currentRelativePath = Paths.get("");
        return new File(currentRelativePath.toAbsolutePath().toString());
    }

    public ModableDiscord getDiscord() {
        return discord;
    }
}
