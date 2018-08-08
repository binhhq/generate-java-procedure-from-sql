package vn.binhhq.fun.service.gen_procedure.entity_result;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.base.CaseFormat;

import vn.binhhq.fun.service.gen_procedure.FileUrl;
import vn.binhhq.fun.service.gen_procedure.PredictJavaType;
import vn.binhhq.fun.service.gen_procedure.WriteFileService;

@Service
public class GenEntityResultService {  
	
	public void gen(List<String> items) throws IOException {
		List<String> result = new ArrayList<String>();
		for (String item : items) {
			String temp1 = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, item);
			String temp2 = addPrivateAndType(temp1);
			result.add(temp2);
		}
		WriteFileService.write(FileUrl.OUTPUT_entityResult,result);
		System.out.println(result);
	}
 

	private String addPrivateAndType(String item) {
		String fileType = PredictJavaType.getType(item);
		item = "private " + fileType + " " + item + ";";
		return item;
	}

	 
}
