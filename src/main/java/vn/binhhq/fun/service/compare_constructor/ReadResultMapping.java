package vn.binhhq.fun.service.compare_constructor;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import vn.binhhq.fun.service.common.ReadFileService;

@Service
public class ReadResultMapping {

	public Map<String, String> run() throws IOException{
		Map<String, String> result = new LinkedHashMap<>();
		List<String> items = ReadFileService.read(FileUrlCC.INPUT_RESULT_MAPPING);
		Pattern p1 = Pattern.compile("(\\w+)\\W+class");
		Pattern p2 = Pattern.compile( '"' + "[a-z]\\w+" + '"');
		
		for(String item : items){
			String temp1 = null;
			String temp2 = null;
			//get type
			Matcher m1 = p1.matcher(item);
			if (m1.find())
				temp1 = m1.group(1).trim();
			// get name
			Matcher m2 = p2.matcher(item);
			if (m2.find())
				temp2 = m2.group(0).trim();
			result.put(temp2, temp1);
		}
		
		System.out.println(result);
		return result;
	}
}
