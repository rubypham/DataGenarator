package com.data.generator;

import java.util.List;
import java.util.Map;

import com.data.exporter.NflDataExporter;
import com.data.model.nfl.GameSnapShot;
import com.data.reader.JsonReader;

public class NflDataGenerator {

	public static void main(String[] args) {
		JsonReader jsonReader = new JsonReader();
		jsonReader.readAll();

		NflDataExporter reporter = new NflDataExporter(jsonReader.getJsonToListGamechip(), jsonReader.getFileNames());
		reporter.generateReport();
	}

}
