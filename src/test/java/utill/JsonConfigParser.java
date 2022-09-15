package utill;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonConfigParser {
    public static String getConfig(String key) {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("src/test/resources/config.json")) {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            return (String) jsonObject.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
