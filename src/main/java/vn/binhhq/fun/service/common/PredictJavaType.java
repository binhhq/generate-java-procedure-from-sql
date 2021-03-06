package vn.binhhq.fun.service.common;

import java.util.ArrayList;
import java.util.List;

public class PredictJavaType {

	private static final List<String> TIME_LIST = new ArrayList<>();
	private static final List<String> AMOUNT_LIST = new ArrayList<>();
	private static final List<String> PAGE = new ArrayList<>();

	static {
		TIME_LIST.add("created");
		TIME_LIST.add("updated");
		TIME_LIST.add("time");

		AMOUNT_LIST.add("amount");
		AMOUNT_LIST.add("discount");
		AMOUNT_LIST.add("fee");
		AMOUNT_LIST.add("balance");
		
		PAGE.add("pagenum");
		PAGE.add("pagesize");
		
	}
	
	public static String getType(String item) {
		String fileType = "String";
		if (item.toLowerCase().contains("id")) {
			return "Long";
		}

		for (String temp : TIME_LIST) {
			if (item.toLowerCase().contains(temp))
				return "OffsetDateTime";
		}

		for (String temp : AMOUNT_LIST) {
			if (item.toLowerCase().contains(temp))
				return "Double";
		}
		
		for (String temp : PAGE) {
			if (item.toLowerCase().contains(temp))
				return "Integer";
		}

		return fileType;
	}
}
