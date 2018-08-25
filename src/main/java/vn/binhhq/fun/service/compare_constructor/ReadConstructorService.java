package vn.binhhq.fun.service.compare_constructor;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import vn.binhhq.fun.service.common.ReadFileService;

@Service
public class ReadConstructorService {

	public Map<String, String> run() throws IOException{ 
		Map<String, String> result = new LinkedHashMap<>();
		List<String> items = ReadFileService.read(FileUrlCC.INPUT_CONSTRUCTOR);
		for(String item : items){
			String[] temp = item.split(",");
			for(int i = 0; i < temp.length ; i++){
				String [] temp1 = temp[i].split(" ");
				result.put(getWordByIndex(temp1,1), getWordByIndex(temp1,0));
			}
		}
		System.out.println(result);
		return result;
	}
	
	 
	
	public static String getWordByIndex(String [] arr, int index){
		int temp = 0;
		for(int i = 0; i< arr.length; i++){
			if(!arr[i].isEmpty()){
				if(temp == index){
					return arr[i].trim();
				}
				temp++;	
			}		
		}
		return null;
	}
}
