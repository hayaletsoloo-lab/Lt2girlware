package lt2girlware.utility.discord;

import java.util.Arrays;
import java.util.List;
import lt2girlware.utility.discord.callbacks.JoinGameCallback;
import lt2girlware.utility.discord.callbacks.ErroredCallback;
import lt2girlware.utility.discord.callbacks.ReadyCallback;
import lt2girlware.utility.discord.callbacks.SpectateGameCallback;
import lt2girlware.utility.discord.callbacks.JoinRequestCallback;
import lt2girlware.utility.discord.callbacks.DisconnectedCallback;
import com.sun.jna.Structure;

public class DiscordEventHandlers extends Structure {
    public DisconnectedCallback disconnected;
    public JoinRequestCallback joinRequest;
    public SpectateGameCallback spectateGame;
    public ReadyCallback ready;
    public ErroredCallback errored;
    public JoinGameCallback joinGame;
    
    protected List<String> getFieldOrder() {
        return Arrays.asList("ready", "disconnected", "errored", "joinGame", "spectateGame", "joinRequest");
    }
}