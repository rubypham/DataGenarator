/**
 * 
 * DIRECTV PROPRIETARY
 * Copyright� 2015 DIRECTV, INC.
 * UNPUBLISHED WORK
 * ALL RIGHTS RESERVED
 * 
 * This software is the confidential and proprietary information of
 * DIRECTV, Inc. ("Proprietary Information").  Any use, reproduction, 
 * distribution or disclosure of the software or Proprietary Information, 
 * in whole or in part, must comply with the terms of the license 
 * agreement, nondisclosure agreement or contract entered into with 
 * DIRECTV providing access to this software.
 */
package com.nfl.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);

	public static List<String> readFile(File fin) throws IOException {
		List<String> resultList = new ArrayList<String>();
		BufferedReader br = null;
		String line = null;
		try {
			FileInputStream fis = new FileInputStream(fin);
			// Construct BufferedReader from InputStreamReader
			br = new BufferedReader(new InputStreamReader(fis));
			while ((line = br.readLine()) != null) {
				resultList.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			br.close();
		}
		return resultList;
	}

	public static void writeFile(File fout, List<String> contents) throws IOException {
		FileOutputStream fos = new FileOutputStream(fout);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

		for (String string : contents) {
			bw.write(string);
			bw.newLine();
		}

		bw.close();
	}

	public static Set<String> getFilesInFolder(final File folder) {
		Set<String> fileNames = new HashSet<String>();

		if (folder != null) {
			LOGGER.debug("Scanning test suites in folder: " + folder.getPath());
			for (final File fileEntry : folder.listFiles()) {
				if (fileEntry.isDirectory()) {
					getFilesInFolder(fileEntry);
				} else {
					fileNames.add(fileEntry.getName());
					LOGGER.debug("Found test suite file: " + fileEntry.getName());
				}
			}
		}

		return fileNames;
	}

	public static List<File> getFilesInFolder(final String path) {
		List<File> files = new ArrayList<File>();
		File folder = new File(path);

		if (folder != null && folder.isDirectory()) {
			LOGGER.debug("Scanning test data in folder: " + folder.getPath());
			for (final File fileEntry : folder.listFiles()) {
				files.add(fileEntry);
			}
		}

		return files;
	}

}
