

import java.awt.List;
import java.io.BufferedReader;
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

public class ja {	

	public static void main(String[] args) throws IOException {
		String reportId="dvsdv"; 
		String title="vdsv"; 
		
	     String subTitle="ddvs"; 
	    String description="vsv"; 
	    String recordPath="dvs";
		JsonObjectBuilder report = Json.createObjectBuilder(); 
		jason jb = new jason();
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/mridulshukla/Desktop/workspace/Excelt/src/main/resources/pb1.csv")); 
		
		Scanner sc = new Scanner(System.in);
		String line = br.readLine(); 
		String[] header =br.readLine().split(",");
		System.out.println(header[0]);
		while ((line = br.readLine()) != null && !line.isEmpty()) { 
			String[] fields = line.split(",");

			jb.setCtin(fields[0]);
		
			jb.setIdt(fields[1]);
			jb.setVal(fields[2]);
			jb.setPos(fields[3]);
			jb.setRchrg(fields[4]);
			jb.setEtin(fields[5]);
			jb.setInv_typ(fields[6]);
			jb.setNum(fields[7]);
			jb.setRt(fields[8]);
			jb.setTxval(fields[9]);
			jb.setIamt(fields[10]);
			jb.setCamt(fields[11]);
			jb.setSamt(fields[12]);
			jb.setCsamt(fields[13]);
			jb.setInum(fields[14]);
		
			
			} 
		br.close();
		 
		 JsonBuilderFactory factory = Json.createBuilderFactory(null);
		 JsonObject value = factory.createObjectBuilder()
		     .add(header[0], jb.getCtin())
		     .add(header[1], jb.getIdt())
		     .add(header[2], jb.getVal())
		     .add(header[3], jb.getPos())
		     .add(header[4], jb.getRchrg())
		     .add(header[5], jb.getEtin())
		     .add(header[6], jb.getInv_typ())
		     .add(header[7], jb.getNum())
		     .add(header[8], jb.getRt())
		     .add(header[9], jb.getTxval())
		     .add(header[10], jb.getIamt())
		     .add(header[11], jb.getCamt())
		     .add(header[12], jb.getSamt())
		     .add(header[13], jb.getCsamt())
		     .add(header[14], jb.getInum())
		     .build();
		 System.out.println(value);
		 
		 try {
			 FileWriter fileWriter = new FileWriter("C:/Users/mridulshukla/Desktop/workspace/Excelt/src/main/resources/info.json");
				fileWriter.write(value.toString());
				fileWriter.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}

	}

}