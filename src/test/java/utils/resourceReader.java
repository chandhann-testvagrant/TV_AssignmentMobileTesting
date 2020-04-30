package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;

public class resourceReader {
    
    
    public static void readYaml(String fileName){
        //yml for storing data
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(classLoader.getResource("Employee.yaml").getFile());
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
    
        // Mapping the employee from the YAML file to the Employee class
      //  employee = om.readValue(file, Employee.class);
    
    }
}
