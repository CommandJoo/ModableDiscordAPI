package de.jo.modablediscord.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import de.jo.modablediscord.main.ModableDiscord;
import net.dv8tion.jda.api.entities.Activity;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;

public class GsonUtil {

    public static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static <T>T toObject(Class<T> clazz, String json) {
        return gson.fromJson(json, clazz);
    }
    public static <T>T toObject(Class<T> clazz, File f) {
        return toObject(clazz, FileUtil.text(f));
    }

    public static void writeFile(Object obj, File file) {
        try {
            String s = gson.toJson(obj);
            if(!file.exists()) {
                System.out.println("test");
                file.createNewFile();
            }
            FileUtil.write(file, s);
        } catch(Exception ex) {ex.printStackTrace();}
    }
    public static void writeFile(Object obj, String file) {
        writeFile(obj, ModableDiscord.getInstance().getFileManager().getFile(file));
    }

}
