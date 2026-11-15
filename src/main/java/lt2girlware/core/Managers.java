package lt2girlware.core;

import lt2girlware.Lt2Girlware;
import lt2girlware.core.manager.IManager;
import lt2girlware.core.manager.client.*;
import lt2girlware.core.manager.player.CombatManager;
import lt2girlware.core.manager.player.FriendManager;
import lt2girlware.core.manager.player.PlayerManager;
import lt2girlware.core.manager.world.HoleManager;
import lt2girlware.core.manager.world.WayPointManager;
import lt2girlware.utility.ThunderUtility;

import static lt2girlware.Lt2Girlware.EVENT_BUS;

/**
 * Class with all Lt2Girlware Managers' instances
 *
 * @author 06ED
 * @see IManager - base interface for all managers
 * @see Lt2Girlware - managers init process
 * @since 1.7
 */
public class Managers {
    // Player
    public static final CombatManager COMBAT = new CombatManager();
    public static final FriendManager FRIEND = new FriendManager();
    public static final PlayerManager PLAYER = new PlayerManager();

    // World
    public static final HoleManager HOLE = new HoleManager(); //todo ???
    public static final WayPointManager WAYPOINT = new WayPointManager();

    // Client
    public static final AddonManager ADDON = new AddonManager();
    public static final AsyncManager ASYNC = new AsyncManager();
    public static final ModuleManager MODULE = new ModuleManager();
    public static final ConfigManager CONFIG = new ConfigManager();
    public static final MacroManager MACRO = new MacroManager();
    public static final NotificationManager NOTIFICATION = new NotificationManager();
    public static final ProxyManager PROXY = new ProxyManager();
    public static final ServerManager SERVER = new ServerManager();
    public static final ShaderManager SHADER = new ShaderManager();
    public static final SoundManager SOUND = new SoundManager();
    public static final TelemetryManager TELEMETRY = new TelemetryManager();
    public static final CommandManager COMMAND = new CommandManager();

    public static void init() {
        ADDON.initAddons();
        CONFIG.load(CONFIG.getCurrentConfig());
        MODULE.onLoad("none");
        FRIEND.loadFriends();
        MACRO.onLoad();
        WAYPOINT.onLoad();
        PROXY.onLoad();
        SOUND.registerSounds();

        ASYNC.run(() -> {
            ThunderUtility.syncContributors();
            ThunderUtility.parseStarGazer();
            ThunderUtility.parseCommits();
            TELEMETRY.fetchData();
        });
    }

    public static void subscribe() {
        EVENT_BUS.subscribe(NOTIFICATION);
        EVENT_BUS.subscribe(SERVER);
        EVENT_BUS.subscribe(PLAYER);
        EVENT_BUS.subscribe(COMBAT);
        EVENT_BUS.subscribe(ASYNC);
        EVENT_BUS.subscribe(TELEMETRY);
    }
}
