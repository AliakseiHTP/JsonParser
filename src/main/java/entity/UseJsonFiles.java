package entity;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class UseJsonFiles {
    private JSONObject jObject;

    public UseJsonFiles(String LOCALFILE){

        JSONParser parser = new JSONParser();
        try{
            jObject = (JSONObject) parser.parse(new FileReader(LOCALFILE));
        }
        catch (IOException | ParseException ex){
            Logger.getLogger(UseJsonFiles.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    public String getString (String s1){
        return (String) jObject.get(s1);
    }
}
