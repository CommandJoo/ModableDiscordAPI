package de.jo.modablediscord.util;

import java.io.*;
import java.nio.file.Files;

public class FileUtil {

    public static String text(InputStream stream) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            String line = "";
            StringBuilder sb = new StringBuilder();
            while((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch(Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
    public static String text(File file) {
        if(!file.exists()) return "";
        try {
            return text(Files.newInputStream(file.toPath()));
        } catch(Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public static void write(File file, String s) {
        try {
            if(!file.exists() || !file.isFile()) file.createNewFile();

            FileOutputStream stream = new FileOutputStream(file);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stream));
            writer.write(s);

            writer.flush();
            writer.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void write(String file, String s) {
        write(new File(file), s);
    }

}
