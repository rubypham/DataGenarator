package com.data.generator;

import com.data.exporter.ISTQBDataExporter;
import com.data.reader.ISTQBQuestionBankReader;

public class ISTQBDataGenerator {
	public static void main(String[] args) {
		ISTQBQuestionBankReader istqbDataReader = new ISTQBQuestionBankReader();
		istqbDataReader.readAll();

		ISTQBDataExporter exporter = new ISTQBDataExporter(istqbDataReader.getQuestionBank());
		exporter.writeQuestionBank();
	}
}
