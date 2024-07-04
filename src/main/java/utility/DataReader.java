package utility;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private static JSONObject testData;
    private static JSONObject config;

    static {
        try {
            FileReader testDataReader = new FileReader("src/main/java/testdata/TestData.json");
            JSONTokener testDataTokener = new JSONTokener(testDataReader);
            testData = new JSONObject(testDataTokener);

            FileReader configReader = new FileReader("src/main/java/configdata/config.json");
            JSONTokener configTokener = new JSONTokener(configReader);
            config = new JSONObject(configTokener);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to read data files.");
        }
    }

    public static String getStringValue(String key, String file) {
        JSONObject jsonObject;
        if ("TestData".equalsIgnoreCase(file)) {
            jsonObject = testData;
        } else if ("Config".equalsIgnoreCase(file)) {
            jsonObject = config;
        } else {
            throw new IllegalArgumentException("Invalid file name: " + file);
        }

        if (jsonObject.has(key)) {
            Object value = jsonObject.get(key);
            if (value instanceof String) {
                return (String) value;
            }
            throw new IllegalArgumentException("Value for key '" + key + "' is not a string.");
        } else {
            throw new IllegalArgumentException("Key '" + key + "' not found in " + file + ".json");
        }
    }

    public static int getIntValue(String key, String file) {
        JSONObject jsonObject;
        if ("TestData".equalsIgnoreCase(file)) {
            jsonObject = testData;
        } else if ("Config".equalsIgnoreCase(file)) {
            jsonObject = config;
        } else {
            throw new IllegalArgumentException("Invalid file name: " + file);
        }

        if (jsonObject.has(key)) {
            Object value = jsonObject.get(key);
            if (value instanceof Integer) {
                return (Integer) value;
            }
            throw new IllegalArgumentException("Value for key '" + key + "' is not an integer.");
        } else {
            throw new IllegalArgumentException("Key '" + key + "' not found in " + file + ".json");
        }
    }

    public static boolean getBooleanValue(String key, String file) {
        JSONObject jsonObject;
        if ("TestData".equalsIgnoreCase(file)) {
            jsonObject = testData;
        } else if ("Config".equalsIgnoreCase(file)) {
            jsonObject = config;
        } else {
            throw new IllegalArgumentException("Invalid file name: " + file);
        }

        if (jsonObject.has(key)) {
            Object value = jsonObject.get(key);
            if (value instanceof Boolean) {
                return (Boolean) value;
            }
            throw new IllegalArgumentException("Value for key '" + key + "' is not a boolean.");
        } else {
            throw new IllegalArgumentException("Key '" + key + "' not found in " + file + ".json");
        }
    }

    public static double getDoubleValue(String key, String file) {
        JSONObject jsonObject;
        if ("TestData".equalsIgnoreCase(file)) {
            jsonObject = testData;
        } else if ("Config".equalsIgnoreCase(file)) {
            jsonObject = config;
        } else {
            throw new IllegalArgumentException("Invalid file name: " + file);
        }

        if (jsonObject.has(key)) {
            Object value = jsonObject.get(key);
            if (value instanceof Double) {
                return (Double) value;
            }
            throw new IllegalArgumentException("Value for key '" + key + "' is not a double.");
        } else {
            throw new IllegalArgumentException("Key '" + key + "' not found in " + file + ".json");
        }
    }

    public static List<String> getStringList(String key, String file) {
        JSONObject jsonObject;
        if ("TestData".equalsIgnoreCase(file)) {
            jsonObject = testData;
        } else if ("Config".equalsIgnoreCase(file)) {
            jsonObject = config;
        } else {
            throw new IllegalArgumentException("Invalid file name: " + file);
        }

        if (jsonObject.has(key)) {
            Object value = jsonObject.get(key);
            if (value instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) value;
                List<String> stringList = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    stringList.add(jsonArray.getString(i));
                }
                return stringList;
            }
            throw new IllegalArgumentException("Value for key '" + key + "' is not a list of strings.");
        } else {
            throw new IllegalArgumentException("Key '" + key + "' not found in " + file + ".json");
        }
    }
}
