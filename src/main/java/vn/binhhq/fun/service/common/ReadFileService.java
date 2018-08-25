package vn.binhhq.fun.service.common;

import java.io.File;
import java.io.IOException;
import java.util.List;
import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class ReadFileService {

	public static List<String> read(String fileName) 
	  throws IOException {
		   File file = new File(fileName);
		   List<String> result = Files.readLines(file, Charsets.UTF_8);
//		   System.out.println(result);
		   return result;
	}
	 
}
