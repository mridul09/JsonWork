package v2;


import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.json.Json; 
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject; 
import javax.json.JsonObjectBuilder; 
import javax.json.JsonValue;
import javax.json.JsonWriter; 

public class jav2 {	

	public static void main(String[] args)  throws IOException {
		
		final Logger LOGGER = Logger.getLogger(jav2.class);
		BasicConfigurator.configure();
		
		String fileName=null;
		File[] list=new FilesFinder().FileSearcher("C:/Users/mridulshukla/Desktop/Mridul/personall/Excelt/src/main/resources/Files");
		JsonBuilderFactory factory = Json.createBuilderFactory(null);
		JsonArrayBuilder Pvalue = Json.createArrayBuilder();
		JsonObjectBuilder value=Json.createObjectBuilder();
	
		
		for(int counter=0;counter<list.length;counter++) {
			
			LOGGER.info("reading the File"+list[counter]);
			
			BufferedReader br = new BufferedReader(new FileReader(list[counter]));
			String line = br.readLine();
			String[] header =br.readLine().split(",");
		
			
			while ((line = br.readLine()) != null && !line.isEmpty()) { 
			
				
					String[] fields = line.split(",");
			
					for(int i=0;i<header.length;i++) {
						value.add(header[i], fields[i]);
					}
				
					
					Pvalue.add(value);
					
			 	 	
				
				
				
			} 
		
			try {
			 
			
				fileName=list[counter].getName().split(".csv")[0];
				LOGGER.info("the File is been processd"+fileName);
				FileWriter fileWriter = new FileWriter("C:/Users/mridulshukla/Desktop/Mridul/personall/Excelt/src/test/resources/JsonFile/"+fileName+".json");
				
				fileWriter.write(Pvalue.build().toString());
				fileWriter.flush();
				
			} catch (Exception e) {
	
				LOGGER.error(e);
			}
		 
			
			
			br.close();
			LOGGER.info("the process is completed fr the FILE"+fileName);
		}
		
		LOGGER.info("..................completer making of "+list.length+" json Files.......................");
		
	}

}