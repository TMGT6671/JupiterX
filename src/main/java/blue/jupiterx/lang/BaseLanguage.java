package blue.jupiterx.lang;

import java.util.ArrayList;
import java.util.List;

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
			return true;
		}else{
			return false;
		}
	}

}
