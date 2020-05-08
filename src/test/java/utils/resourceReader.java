package utils;


/*
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
*/

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.location;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class resourceReader {
    
    public static String fileToStringConverter(String fileName)
    {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file=new File(classLoader.getResource(fileName).getFile());
        Scanner myReader = null;
        try {
            myReader = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String content="";
        while (myReader.hasNextLine()) {
            content =  content + myReader.nextLine();
        }
        myReader.close();
        
        return content;
    }
    
    public static location mapValueToClass(String json)   {
        
        ObjectMapper objectMapper = new ObjectMapper();
        location employee=null;
        try {
            employee = objectMapper.readValue(json, location.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }
    
    
   /* public static void readYaml(String fileName){
        //yml for storing data
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(classLoader.getResource("Employee.yaml").getFile());
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
    
        // Mapping the employee from the YAML file to the Employee class
      //  employee = om.readValue(file, Employee.class);
    
    }*/
}
