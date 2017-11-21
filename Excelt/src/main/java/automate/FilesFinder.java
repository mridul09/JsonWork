package automate;

import java.io.File;

public class FilesFinder {
	public File[] FileSearcher(String src) {
		
	// "C:/Users/mridulshukla/Desktop/workspace/Excelt/src/main/resources/Files"
	File folder = new File(src);
	File[] listOfFiles = folder.listFiles();

	    for (int i = 0; i < listOfFiles.length; i++) {
	      if (listOfFiles[i].isFile()) {
	        System.out.println( listOfFiles[i].getName());
	      } else if (listOfFiles[i].isDirectory()) {
	        System.out.println("Directory " + listOfFiles[i].getName());
	      }
	    }
		return listOfFiles;
	}
}
