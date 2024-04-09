package org.zerock.oauthutil;

public class JsonParser {

	
	public static String jsonCatcher(String maybeJson) {
		if(maybeJson.startsWith("<200,")) {
			int start = maybeJson.indexOf("{");
			int end = maybeJson.indexOf("}");
			
			return maybeJson.substring(start, end);
		}else {
			System.out.println("Response is NOT 200");
		}
		
		return "null";
	}
	
  public static String extractValue(String jsonString, String key) {
    int start = jsonString.indexOf("\"" + key + "\":") + key.length() + 3;
    int end = jsonString.indexOf(",", start);
    if (end == -1) {
        end = jsonString.indexOf("}", start);
    }
    return jsonString.substring(start, end);
}
}
