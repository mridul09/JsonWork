package v2;

import java.io.File;

public class FilesFinder {
	public File[] FileSearcher(String src) {
		
	// "C:/Users/mridulshukla/Desktop/workspace/Excelt/src/main/resources/Files"
	File folder = new File(src);
	File[] listOfFiles = folder.listFiles();
	return listOfFiles;
	}
	
	
}
