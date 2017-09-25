package blue.jupiterx;

import blue.jupiterx.lang.BaseLanguage;

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

public class JupiterX {

    public static final String VERSION = "1.0";
    public static final String API_VERSION = "1.0.0";
    public static final String CODENAME = "JupiterX";
    public static final String AUTHOR = "JupiterDevelopmentTeam";

    public static final String USER_PATH = System.getProperty("user.dir") + "/";
    public static final String PLUGIN_PATH = USER_PATH + "plugins";
    public static final String WORLD_PATH = USER_PATH + "worlds";

    public static final String OS = System.getProperty("os.name").toLowerCase();
    public static final String JAVA_VERSION = System.getProperty("java.version");

    public static final long START_TIME = System.currentTimeMillis();

    private static BaseLanguage lang;


    public static void main(String[] args) {
        System.out.println("Starting JupiterX server for Minecraft...");

        if(!(JAVA_VERSION.startsWith("1.8") || JAVA_VERSION.startsWith("1.9"))){
            System.out.println("[CRITICAL] This program runs on JRE(JRE) 1,8 or 1.9.");
            System.out.println("[CRITICAL] You must use JRE(JDK) 1.8 or 1.9.");
            System.out.println("[CRITICAL] Java version: " + JAVA_VERSION);

            System.exit(0);
        }


    }

}
