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

    Server(MainLogger logger, final String filePath, String dataPath, String pluginPath) {

    }

    public String getName() {
        return "JupiterX";
    }

    public String getJupiterXVersion() {
        return JupiterX.JUPITERX_VERSION;
    }

    public String getCodename() {
        return JupiterX.CODENAME;
    }

    public String getApiVersion() {
        return JupiterX.API_VERSION;
    }

    public String getDataPath() {
        return JupiterX.DATA_PATH;
    }

    public String getPluginPath() {
        return JupiterX.PLUGIN_PATH;
    }
}
