package blue.jupiterx;

import java.io.File;

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
 * JupiterX Project
 *
 * @author JupiterDevelopmentTeam
 * @link http://jupiterdevelopmentteam.github.io
 */

public class Server {

    private String filePath;

    private String dataPath;

    private String pluginPath;

    private MainLogger logger;

    Server(MainLogger logger, final String filePath, String dataPath, String pluginPath) {
        this.logger = logger;
        this.filePath = filePath;
        this.dataPath = dataPath;
        this.pluginPath = pluginPath;

        if(!new File(this.getPluginPath()).exists()){
            new File(this.getPluginPath()).mkdirs();
        }

        if(!new File(this.getWorldPath()).exists()){
            new File(this.getWorldPath()).mkdirs();
        }

        if(!new File(this.getPlayerPath()).exists()){
            new File(this.getPlayerPath()).mkdirs();
        }
    }

    public MainLogger getLogger(){
        return logger;
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

    public String getAuthor(){
        return JupiterX.AUTHOR;
    }

    public String getWorldPath(){
        return JupiterX.WORLD_PATH;
    }

    public String getFilePath(){
        return this.filePath;
    }

    public String getDataPath() {
        return this.dataPath;
    }

    public String getPluginPath() {
        return this.pluginPath;
    }

    public String getPlayerPath() {
        return JupiterX.PLAYER_PATH;
    }

    public String getLogPath() {
        return JupiterX.LOG_PATH;
    }
}
