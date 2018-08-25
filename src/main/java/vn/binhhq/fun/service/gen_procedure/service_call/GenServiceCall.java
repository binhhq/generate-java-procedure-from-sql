package vn.binhhq.fun.service.gen_procedure.service_call;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.binhhq.fun.service.common.WriteFileService;
import vn.binhhq.fun.service.gen_procedure.FileUrl;
import vn.binhhq.fun.service.gen_procedure.procedure.ReadWhereConditionService;

@Service
public class GenServiceCall {

	@Autowired
	private ReadWhereConditionService readWhereConditionService;
	
	public List<String> gen() throws IOException{
		List<String> items = readWhereConditionService.read();
		List<String> result = new ArrayList();
		for (String item : items) {
			String temp = "query.setParameter(CLASS_NAME."+ item +", "+removeV(item)+");";
			result.add(temp);
		} 
		WriteFileService.write(FileUrl.OUTPUT_serviceCall, result);
		return result;
	}
	
	private String removeV(String item){
		item = item.replaceAll("v_", "");
		return item;
	}
}
