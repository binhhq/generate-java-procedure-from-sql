package vn.binhhq.fun.service.gen_procedure.procedure;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.binhhq.fun.service.common.ReadFileService;
import vn.binhhq.fun.service.common.WriteFileService;
import vn.binhhq.fun.service.gen_procedure.FileUrl;
import vn.binhhq.fun.service.gen_procedure.entity_result.ReadSelectQueryService;

@Service
public class GenProcedure {

	@Autowired
	private GenParamMapping genParamMapping;
	@Autowired
	private ReadSelectQueryService readSelectQueryService;
	@Autowired
	private ReadWhereConditionService readWhereConditionService;
	@Autowired
	private GenResultMappingService genResultMappingService;
	@Autowired
	private GenParamConstant genParamConstant;

	public void gen() throws IOException {
		List<String> temps = ReadFileService.read(FileUrl.TEMP_EntityProc);
		System.out.println(temps);
		replaceParamMapping(temps);
		replaceResultMapping(temps);
		replaceConstantVariable(temps);
		WriteFileService.write(FileUrl.OUTPUT_procedure, temps);
	}

	private void replaceParamMapping(List<String> items) throws IOException {
		List<String> conditions = readWhereConditionService.read();
		int index = index(items, "KEY_PARAM_MAPPING");
		if (index > 0) {
			List<String> paramMappings = genParamMapping.gen(conditions);
			items.remove(index);
			items.addAll(index, paramMappings);
		}
	}

	private void replaceResultMapping(List<String> items) throws IOException {
		List<String> selects = readSelectQueryService.read();
		int index = index(items, "KEY_COLUMN_RESULT");
		if (index > 0) {
			List<String> paramMappings = genResultMappingService.gen(selects);
			items.remove(index);
			items.addAll(index, paramMappings);
		}
	}

	private void replaceConstantVariable(List<String> items) throws IOException {
		List<String> conditions = readWhereConditionService.read();
		int index = index(items, "KEY_DEFINE_CONSTANT_VAR");
		if (index >= 0) {
			List<String> paramMappings = genParamConstant.gen(conditions);
			items.remove(index);
			items.addAll(index, paramMappings);
		}
	}

	private int index(List<String> items, String find) {
		int i = -1;
		for (String item : items) {
			i++;
			if (item.contains(find)) {
				break;
			}
		}
		return i;
	}
}
