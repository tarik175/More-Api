package utils;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtil {
    private static ObjectMapper mapper;


    static {
        mapper=new ObjectMapper();
    }



    //Method to convert json data to java object(De-serialization)
    public static <T> T convertJsonToJavaObject(String json, Class<T> cls)  {//generic method

        T javaResult=null;
        try {
            javaResult=mapper.readValue(json,cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return javaResult;
    }


    //Method to convert  java object to json data (serialization)

    public static String convertJavaObjectToJson(Object obj){

        String jsonResult=null;
        try {
            jsonResult=mapper.writeValueAsString(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return jsonResult;
    }














}
