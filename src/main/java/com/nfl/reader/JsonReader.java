package com.nfl.reader;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nfl.model.GameSnapShot;
import com.nfl.model.NflData;
import com.nfl.model.Scores;
import com.nfl.utils.FileUtils;
import com.nfl.utils.Global;

public class JsonReader {
	private Map<String, List<GameSnapShot>> jsonToListGamechip;
	private List<String> fileNames;

	public void readAll() {
		loadDataFromPath(Global.baseDir + "/src/main/resources/data");
	}

	private void loadDataFromPath(String path) {
		jsonToListGamechip = new HashMap<String, List<GameSnapShot>>();
		fileNames = new ArrayList<String>();

		List<File> files = FileUtils.getFilesInFolder(path);

		for (File file : files) {
			System.out.println("Loading " + file.getName());
			try {

				ObjectMapper mapper = new ObjectMapper();

				// JSON from file to Object
				NflData nflData = mapper.readValue(file, NflData.class);
				fileNames.add(file.getName());

				jsonToListGamechip.put(file.getName(), nflData.getScores().getGameSnapShot());

			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException("Load data error" + ex.getMessage());
			}
		}
	}

	public Map<String, List<GameSnapShot>> getJsonToListGamechip() {
		if (jsonToListGamechip == null) {
			jsonToListGamechip = new HashMap<String, List<GameSnapShot>>();
		}
		return jsonToListGamechip;
	}

	public List<String> getFileNames() {

		if (fileNames == null) {
			fileNames = new ArrayList<String>();
		}
		return fileNames;
	}

}
