package lt2girlware.utility.discord.callbacks;

import lt2girlware.utility.discord.DiscordUser;
import com.sun.jna.Callback;

public interface ReadyCallback extends Callback {
    void apply(final DiscordUser p0);
}
