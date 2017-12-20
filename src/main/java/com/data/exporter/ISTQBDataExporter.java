package com.data.exporter;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.data.model.istqb.QuestionBank;
import com.data.utils.Global;

public class ISTQBDataExporter {
	private QuestionBank questionBank;
	private String outFileName;

	public ISTQBDataExporter(QuestionBank questionBank) {
		super();
		this.questionBank = questionBank;
	}
	
	public void start() {
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy-hhmmss");
		outFileName = new StringBuffer().append(Global.baseDir).append("/output/ISTQBData-")
				.append(df.format(new Date().getTime())).append(".xml").toString();

	}

	public void writeQuestionBank() {
		start();
		System.out.println("Start Exporting data.");
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(QuestionBank.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMarshaller.marshal(questionBank, new File(outFileName));
			jaxbMarshaller.marshal(questionBank, System.out);
			
			System.out.println("Export data sucessfully.");
		} catch (Exception e) {
			System.out.println("Export data failed.");
		}

	}
}
