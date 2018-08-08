package vn.binhhq.fun.service.gen_procedure.entity_result;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import vn.binhhq.fun.service.gen_procedure.FileUrl;
import vn.binhhq.fun.service.gen_procedure.ReadFileService;

@Service
public class ReadSelectQueryService {
	
	public List<String> read() throws IOException{
		List<String> selectItems = ReadFileService.read(FileUrl.INPUT_selectColumn);
		// gen result
		List<String> result = new ArrayList<String>();
		for (String item : selectItems) {
			// get original field
			String temp = splitStringAndGetLastString(item);
			result.add(temp);
		}
		return result;
	}

	private String splitStringAndGetLastString(String input) {
		input = input.trim();
		input = input.replace(",", "");
		input = input.toLowerCase();
		if (input.contains(" as ")) {
			String[] strings = input.split(" ");
			return strings[strings.length - 1];
		}
		String[] strings = input.split("\\.");
		return strings[strings.length - 1];
	}
}
