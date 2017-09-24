package blue.jupiterx;

public class JupiterX {

    public static final String VERSION = "1.0";
    public static final String API_VERSION = "1.0.0";
    public static final String CODENAME = "JupiterX";
    public static final String AUTHOR = "JupiterDevelopmentTeam";

    public static final String USER_PATH = System.getProperty("user.dir") + "/";
    public static final String PLUGIN_PATH = System.getProperty("user.dir") + "/plugins";
    public static final String WORLD_PATH = System.getProperty("user.dir") + "/worlds";

    public static final String OS = System.getProperty("os.name").toLowerCase();

    public static final long START_TIME = System.currentTimeMillis();


    public static void main(String args[]){
        System.out.println("Starting JupiterX server for Minecraft...");

    }

}
