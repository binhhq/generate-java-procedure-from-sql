package vn.binhhq.fun.service.gen_procedure;

import java.util.ArrayList;
import java.util.List;

public class PreditOracleType {

	private static final List<String> TIME_LIST = new ArrayList<>();
	private static final List<String> AMOUNT_LIST = new ArrayList<>();

	static {
		TIME_LIST.add("created");
		TIME_LIST.add("updated");
		TIME_LIST.add("time");

		AMOUNT_LIST.add("amount");
		AMOUNT_LIST.add("discount");
		AMOUNT_LIST.add("fee");
	}

	public static String getFileType(String item) {
		String fileType = "VARCHAR2";
		
		if (item.toLowerCase().contains("id")) {
			return "NUMBER";
		}

		for (String temp : TIME_LIST) {
			if (item.toLowerCase().contains(temp))
				return "TIMESTAMP";
		}

		return fileType;
	}
}
