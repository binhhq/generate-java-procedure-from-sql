package vn.binhhq.fun.service.gen_procedure.procedure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import org.springframework.stereotype.Service;

import vn.binhhq.fun.service.common.PredictJavaType;
import vn.binhhq.fun.service.common.WriteFileService;
import vn.binhhq.fun.service.gen_procedure.FileUrl; 

/**
 * @StoredProcedureParameter(mode = ParameterMode.IN, name = ServiceReqLinkProc.v_id, type = Long.class),
 * @author binhhq
 *
 */
@Service
public class GenParamMapping { 
	
	public List<String> gen(List<String> items) throws IOException{
		List<String> result = new ArrayList();
		for(String item : items){
			String temp = genStringParam(item);
			result.add(temp);
		}
		return result;
	}

	public String genStringParam(String item) {
		String type = PredictJavaType.getType(item);
		String template = "@StoredProcedureParameter(mode = ParameterMode.IN, name =  ServiceReqLinkProc." + item +", type = "
				+ type + ".class),";
		return template;
	}
	 
}
