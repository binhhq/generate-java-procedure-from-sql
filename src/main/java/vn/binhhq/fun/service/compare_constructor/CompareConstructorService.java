package vn.binhhq.fun.service.compare_constructor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;

import vn.binhhq.fun.service.common.WriteFileService;

@Service
public class CompareConstructorService {

	@Autowired
	private ReadConstructorService readConstructorService;
	@Autowired
	private ReadResultMapping readResultMapping;

	public void run() throws IOException {

		Map<String, String> constructorItems = readConstructorService.run();

		Map<String, String> resultMappingItems = readResultMapping.run();
		List<String> result = new ArrayList<>();

//		Preconditions.checkState(constructorItems.size() == resultMappingItems.size());
		Iterator<Entry<String, String>> iter1 = constructorItems.entrySet().iterator();
		Iterator<Entry<String, String>> iter2 = resultMappingItems.entrySet().iterator();
		int index = 0;
		while (iter1.hasNext() || iter2.hasNext()) {
			Entry<String, String> constructorEntry= iter1.next();
			Entry<String, String> resultMappingEntry = iter2.next();
			String text = "";
			
			String resultMapType = resultMappingEntry.getValue();
			String resultMapField = resultMappingEntry.getKey();
			
			String constructorType = constructorEntry.getValue();
			String constructorField = constructorEntry.getKey();
			
			if (!resultMapType.equalsIgnoreCase(constructorType)) {
				text = constructorField + " " + constructorType + ", " + resultMapField + " " + resultMapType +". Error Index : " + index;
				System.err.println(text);
			} else {
				text = constructorField + " " + constructorType + ", " + resultMapField + " " + resultMapType;
				System.out.println(text);
			}
			result.add(text);
			index++;
		}

		WriteFileService.write(FileUrlCC.OUTPUT, result);

	}
}
