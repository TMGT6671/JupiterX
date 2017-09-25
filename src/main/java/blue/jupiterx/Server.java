package blue.jupiterx;

import blue.jupiterx.utils.MainLogger;

/**     _             _ _          __  __
 *     | |_   _ _ __ (_) |_ ___ _ _\ \/ /
 *  _  | | | | | '_ \| | __/ _ \ '__\  /
 * | |_| | |_| | |_) | | ||  __/ |  /  \
 *  \___/ \__,_| .__/|_|\__\___|_| /_/\_\
 *             |_|
 *
 * These codes are from PocketMine-MP.
 * We have never used Nukkit's codes.
 * 
 * @author JupiterDevelopmentTeam
 * @link http://jupiterdevelopmentteam.github.io
 */

public class Server {

    public static final String VERSION = "1.0";
    public static final String JUPITER_VERSION = "1.2.0.81.0";
    public static final String CODENAME = "JupiterX";
    public static final String API_VERSION = "1.0.0";
    public static final String AUTHOR = "JupiterDevelopmentTeam";

    public static final String DATA_PATH = System.getProperty("user.dir") + "/";
    public static final String PLUGIN_PATH = DATA_PATH + "plugins/";
    public static final String PLAYER_PATH = DATA_PATH + "players/";
    public static final String WORLD_PATH = DATA_PATH + "worlds/";

    Server(MainLogger logger, final String filePath, String dataPath, String pluginPath) {

    }

    public String getName() {
        return "JupiterX";
    }

    public String getJupiterVersion() {
        return JUPITER_VERSION;
    }

    public String getCodename() {
        return CODENAME;
    }

    public String getApiVersion() {
        return API_VERSION;
    }

    public String getDataPath() {
        return DATA_PATH;
    }

    public String getPluginPath() {
        return PLUGIN_PATH;
    }
}
