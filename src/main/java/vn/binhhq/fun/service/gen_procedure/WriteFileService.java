package vn.binhhq.fun.service.gen_procedure;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.io.CharSink;
import com.google.common.io.Files;

public class WriteFileService { 
	
	public static void write(String fileName, List<String> input) throws IOException {
	    File file = new File(fileName);
	    CharSink sink = Files.asCharSink(file, Charsets.UTF_8);
	    sink.writeLines(input);   
	} 
	
}
