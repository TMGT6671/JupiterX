package blue.jupiterx.lang;

import java.util.ArrayList;

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

import java.util.List;

/**     _             _ _          __  __
 *     | |_   _ _ __ (_) |_ ___ _ _\ \/ /
 *  _  | | | | | '_ \| | __/ _ \ '__\  /
 * | |_| | |_| | |_) | | ||  __/ |  /  \
 *  \___/ \__,_| .__/|_|\__\___|_| /_/\_\
 *             |_|
 *
 * These codes are from PocketMine-MP.
 *
 * JupiterX Project
 *
 * @author JupiterDevelopmentTeam
 * @link http://jupiterdevelopmentteam.github.io
 */

public class BaseLanguage {
    
    private List<String> langTypes = new ArrayList<String>();
    public static String LANGUAGE;
    
    public BaseLanguage(){
        initLanguages();
    }
    
    private void initLanguages(){
        langTypes.clear();
        langTypes.add("jpn");
        langTypes.add("eng");
    }
    
    public boolean setLanguage(String lang){
        if(langTypes.contains(lang)){
            LANGUAGE = lang;
            loadLanguages();
            return true;
        }else{
            return false;
        }
    }
    
    private void loadLanguages(){
        
    }

}
