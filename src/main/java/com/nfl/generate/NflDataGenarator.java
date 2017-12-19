package com.nfl.generate;

import java.util.List;
import java.util.Map;

import com.nfl.model.GameSnapShot;
import com.nfl.reader.JsonReader;
import com.nfl.report.ExcelReport;

public class NflDataGenarator {

	public static void main(String[] args) {
		JsonReader jsonReader = new JsonReader();
		jsonReader.readAll();

		ExcelReport reporter = new ExcelReport(jsonReader.getJsonToListGamechip(), jsonReader.getFileNames());
		reporter.generateReport();
	}

}
