package vn.binhhq.fun.service.gen_procedure.procedure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import vn.binhhq.fun.service.common.ReadFileService;
import vn.binhhq.fun.service.gen_procedure.FileUrl;

@Service
public class ReadWhereConditionService {

	public List<String> read() throws IOException{
		List<String> querys = ReadFileService.read(FileUrl.INPUT_whereCondition);
		return getParamFromQuery(querys);
	}
	
	public List<String> getParamFromQuery(List<String> query) { 
		List<String> matches = new ArrayList<String>();
		String regex = "v_\\w+";
		for (String queryTemp : query) {
			Matcher m = Pattern.compile(regex).matcher(queryTemp);
			while (m.find()) {
				if(!matches.contains(m.group(0))){
					matches.add(m.group(0));	
				}
			}
		}
		return matches;
	}
}
