package vn.binhhq.fun.service.gen_procedure.procedure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import vn.binhhq.fun.service.gen_procedure.FileUrl;
import vn.binhhq.fun.service.gen_procedure.WriteFileService;

/**
 * 
 * @author binhhq public static final String v_id = "v_id";
 */
@Service
public class GenParamConstant {

	public List<String> gen(List<String> items) throws IOException {
		List<String> result = new ArrayList();
		for (String item : items) {
			String temp = genStaticVariable(item);
			result.add(temp);
		}
		return result;
	}

	public String genStaticVariable(String item) {
		String template = "public static final String " + item + "  = " + '"' + item + '"' + ";";
		return template;
	}

}
