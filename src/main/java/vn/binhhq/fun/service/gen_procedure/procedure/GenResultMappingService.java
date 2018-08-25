package vn.binhhq.fun.service.gen_procedure.procedure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import vn.binhhq.fun.service.common.PredictJavaType;

@Service
public class GenResultMappingService {

	public List<String> gen(List<String> items) throws IOException {
		List<String> result = new ArrayList();
		for (String item : items) {
			String temp = genColumnResult(item);
			result.add(temp);
		} 
		return result;
	}

	private String genColumnResult(String item) {
		String type = PredictJavaType.getType(item);
		String template =  "@ColumnResult(name = " + '"' + item + '"' +", type = " +type+ ".class),";
		return template;
	}
}
