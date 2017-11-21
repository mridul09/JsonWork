package automate;


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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

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

public class jav2 {	

	public static void main(String[] args)  throws IOException {
		String fileName=null;
		File[] list=new FilesFinder().FileSearcher("C:/Users/mridulshukla/Desktop/workspace/Excelt/src/main/resources/Files");
		
		for(int counter=0;counter<list.length;counter++) {
			BufferedReader br = new BufferedReader(new FileReader(list[counter]));	
			
		
			String line = br.readLine();
			String[] header =br.readLine().split(",");
			
		
	
		while ((line = br.readLine()) != null && !line.isEmpty()) { 
			
		try {	
			String[] fields = line.split(",");
			
			 JsonBuilderFactory factory = Json.createBuilderFactory(null);
			 JsonObject value = factory.createObjectBuilder()
			     .add(header[0], fields[0])
			 	.add(header[1], fields[1])
			     .add(header[2], fields[2])
			     .add(header[3], fields[3])
			     .add(header[4], fields[4])
			     .add(header[5], fields[5])
			     .add(header[6], fields[6])
			     .add(header[7], fields[7])
			     .add(header[8], fields[8])
			     .add(header[9], fields[9])
			     .add(header[10], fields[10])
			     .add(header[11], fields[11])
			     .add(header[12], fields[12])
			     .add(header[13], fields[13])
			     .add(header[14], fields[14])
			     .build();
			 	fileName=list[counter].getName().split(".csv")[0];
			 	System.out.println(fileName);
			 
			 	
			 	
		 try {
				FileWriter fileWriter = new FileWriter("C:/Users/mridulshukla/Desktop/workspace/Excelt/src/test/resources/JsonFile/"+fileName+counter+".json");
					fileWriter.write(value.toString());
					fileWriter.flush();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			 counter++;
			 System.out.println("counter");
		}catch(Exception e) {
			e.printStackTrace();
		}
			
			} 
		br.close();
		System.out.println("Done.................................");
		}
		 
		
	}

}