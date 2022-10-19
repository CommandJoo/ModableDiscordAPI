package de.jo.modablediscord.discord;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

public class ModableDiscordConfig {

    public String botToken = "Bot Token Here";
    public OnlineStatus onlineStatus = OnlineStatus.ONLINE;
    public Activity activity = new Activity("Discord", net.dv8tion.jda.api.entities.Activity.ActivityType.PLAYING);

    public class Activity {
        public String name;
        public net.dv8tion.jda.api.entities.Activity.ActivityType type;

        public Activity(String name, net.dv8tion.jda.api.entities.Activity.ActivityType type) {
            this.name = name;
            this.type = type;
        }
    }

}
