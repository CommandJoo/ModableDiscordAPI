package de.jo.modablediscord.events.api.impl;

import de.jo.modablediscord.events.api.events.Event;

import java.time.OffsetDateTime;

/**
 * @author CommandJoo 08.05.2023
 * @Project ModableDiscord
 */
public class EventShutdown implements Event {

    protected final OffsetDateTime shutdownTime;
    protected final int code;

    public EventShutdown(OffsetDateTime shutdownTime, int code) {
        this.shutdownTime = shutdownTime;
        this.code = code;
    }
}
