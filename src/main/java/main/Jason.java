package main;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Jason {
    private static final Logger LOGGER = Logger.getLogger(Jason.class);
    public static void main(String [] argv){

        try {
            FileReader reader = new FileReader("C:\\Java\\ForSql\\src\\main\\resources\\json\\Mentor.json");

            JSONParser jsonParser = new JSONParser();

            Object obj = jsonParser.parse(reader);

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray array = (JSONArray)jsonObject.get("Mentor");

            for (int i=0; i<array.size(); i++){

                JSONObject mentor = (JSONObject) array.get(i);

                Long idMentor = (Long) mentor.get("idMentor");
                Long idUniversity = (Long) mentor.get("idUniversity");
                String Name = (String) mentor.get("Name");
                String Surname = (String) mentor.get("Surname");
//                Integer Age = (Integer) mentor.get("Age");
                String Gender = (String) mentor.get("Gender");

                LOGGER.info("Information About Mentor is  " + i);

                LOGGER.info("idMentor: " + idMentor);
                LOGGER.info("idUniversity: " + idUniversity);
                LOGGER.info("Name: " + Name);
                LOGGER.info("Surname: " + Surname);
//                LOGGER.info("Age: " + Age);
                LOGGER.info("Gender" + Gender);
            }

        } catch (ParseException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
