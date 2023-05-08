package de.jo.modablediscord.events.api.impl.session;

import com.neovisionaries.ws.client.WebSocketFrame;
import de.jo.modablediscord.events.api.events.Event;

import java.time.OffsetDateTime;

/**
 * @author CommandJoo 08.05.2023
 * @Project ModableDiscord
 */
public class EventSessionDisconnect implements Event {

    protected final WebSocketFrame serverCloseFrame;
    protected final WebSocketFrame clientCloseFrame;
    protected final boolean closedByServer;
    protected final OffsetDateTime disconnectTime;


    public EventSessionDisconnect(WebSocketFrame serverCloseFrame, WebSocketFrame clientCloseFrame, boolean closedByServer, OffsetDateTime disconnectTime) {
        this.serverCloseFrame = serverCloseFrame;
        this.clientCloseFrame = clientCloseFrame;
        this.closedByServer = closedByServer;
        this.disconnectTime = disconnectTime;
    }
}
