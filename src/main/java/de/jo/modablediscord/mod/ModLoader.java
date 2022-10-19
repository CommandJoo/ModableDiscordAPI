package de.jo.modablediscord.mod;

import com.google.gson.GsonBuilder;
import de.jo.modablediscord.main.ModableDiscord;
import de.jo.modablediscord.mod.impl.Mod;
import de.jo.modablediscord.mod.impl.ModManager;
import de.jo.modablediscord.util.FileUtil;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ModLoader {

    public ModInfo loadInfo(File f) throws IOException {
        if(!f.exists() || !f.getName().endsWith(".jar")) return null;

        JarFile jar = new JarFile(f);
        JarEntry modInfo = jar.getJarEntry("mod.json");

        InputStream stream = jar.getInputStream(modInfo);
        String s = FileUtil.text(stream);

        return new GsonBuilder().setPrettyPrinting().create().fromJson(s, ModInfo.class);
    }
    public Mod loadMod(ModInfo modInfo, File f) throws ClassNotFoundException, InstantiationException, IllegalAccessException, MalformedURLException {
        URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{f.toURI().toURL()});
        Class<?> rawClass = Class.forName(modInfo.main, true, classLoader);

        if(!rawClass.getSuperclass().equals(Mod.class)) return null;
        Class<Mod> modClass = ((Class<Mod>) rawClass);

        Mod mod = modClass.newInstance();
        mod.setInfo(modInfo);

        mod.setManager(new ModManager(ModableDiscord.getInstance()));
        return mod;
    }

    public Mod loadFile(File file) {
        Mod mod = null;
        try {
            ModInfo info = loadInfo(file);
            mod = loadMod(info, file);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return mod;
    }
    public List<Mod> loadDirectory(File dir) {

        List<Mod> mods = new ArrayList<>();

        if(dir.exists() && dir.isDirectory()) {
            for(File f : Objects.requireNonNull(dir.listFiles())) {
                Mod mod = loadFile(f);
                if(mod == null) continue;
                mods.add(mod);
            }
        }

        return mods;
    }

}
