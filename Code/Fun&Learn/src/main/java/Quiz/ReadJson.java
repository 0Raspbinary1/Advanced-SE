package main.java.Quiz;
//package Quiz;
//
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.Map.Entry;
//
//import javax.json.Json;
//import javax.json.JsonArray;
//import javax.json.JsonObject;
//import javax.json.JsonReader;
//import javax.json.JsonStructure;
//import javax.json.JsonValue;
//import javax.json.JsonValue.ValueType;
//
//public class ReadJson {
//
//    public static void main(String[] args) {
//        FileReader fr;
//        JsonStructure struct;
//        try {
//            fr = new FileReader("test.txt");
//            JsonReader reader = Json.createReader(fr);
//            struct = reader.read();
//            JsonValue value = struct;
//            print(value);
//            reader.close();
//            fr.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void print(JsonValue value) {
//        JsonObject object = null;
//        if (value.getValueType() == ValueType.OBJECT) {
//            object = (JsonObject) value;
//            for (Entry<String, JsonValue> set : object.entrySet()) {
//                if (set.getValue() instanceof JsonArray) {
//                    System.out.println("Array: ");
//                    print((JsonValue) set.getValue());
//                } else {
//                    System.out.println(set.getKey() + ": " + set.getValue());
//                }
//            }
//        } else if (value.getValueType() == ValueType.ARRAY) {
//            JsonArray array = (JsonArray) value;
//            for (JsonValue val : array)
//                print(val);
//        }
//    }
//} 