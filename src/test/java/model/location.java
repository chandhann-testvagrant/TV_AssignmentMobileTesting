package model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import org.json.JSONObject;

public class location {
    
    public location(String jsonString){
    
        JSONObject body=new JSONObject(jsonString);
        setLatitude(body.getDouble("latitude"));
        setLogitude(body.getDouble("logitude"));
        setAltitude(body.getDouble("altitude"));
    }
    
    private double latitude;
    private double logitude;
    private double altitude;
    
    public void setLatitude(double latitude){
        this.latitude=latitude;
    }
    public double getLatitude(){
      return latitude;
    }
    
    public void setLogitude(double logitude){
        this.logitude=logitude;
    }
    public double getLogitude(){
        return logitude;
    }
    
    public void setAltitude(double altitude){
        this.altitude=altitude;
    }
    public double getAltitude(){
        return altitude;
    }
    
}
