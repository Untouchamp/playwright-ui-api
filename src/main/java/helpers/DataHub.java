package helpers;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DataHub {
    /**
     * Generates random unique string with desired length
     *
     * @param length the size of expected string
     * @return generated string
     */
    public static String getRandomUniqueValue(int length) {
        return generateAnySizeStringByTemplate(getNoDashUUID(), length);
    }

    public static String getNoDashUUID() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 16);
    }

    private static String generateAnySizeStringByTemplate(String templateString, int newLength) {
        String template = templateString;

        if (newLength > template.length())
            template = new String(new char[(newLength / template.length()) + 1]).replace("\0", template);

        return template.substring(0, newLength);
    }

    static public String convertObjectToJsonString(Object objectToConvert){
        return new Gson().toJson(objectToConvert);
    }

    static public Map<String, String> convertObjectToMap(Object objectToConvert){
        Gson gson = new Gson();
        Map<String, String> map = new HashMap<>();
        map = gson.fromJson(convertObjectToJsonString(objectToConvert), map.getClass());
        return map;
    }

    static public String generateRandomEmail(){
        return getRandomUniqueValue(8) + "@mail.xcr";
    }
}
