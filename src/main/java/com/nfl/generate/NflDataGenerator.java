package com.nfl.generate;

import java.util.List;
import java.util.Map;

import com.nfl.model.GameSnapShot;
import com.nfl.reader.JsonReader;
import com.nfl.report.NflDataExporter;

public class NflDataGenerator {

	public static void main(String[] args) {
		JsonReader jsonReader = new JsonReader();
		jsonReader.readAll();

		NflDataExporter reporter = new NflDataExporter(jsonReader.getJsonToListGamechip(), jsonReader.getFileNames());
		reporter.generateReport();
	}

}
