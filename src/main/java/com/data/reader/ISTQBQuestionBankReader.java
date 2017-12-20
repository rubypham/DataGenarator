package com.data.reader;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.data.common.Utils;
import com.data.model.istqb.Options;
import com.data.model.istqb.Paragraph;
import com.data.model.istqb.Question;
import com.data.model.istqb.QuestionBank;
import com.data.model.istqb.Questions;
import com.data.model.istqb.Session;
import com.data.utils.Global;

public class ISTQBQuestionBankReader {
	private QuestionBank questionBank;

	private Map<String, List<Question>> sessionToListQuestion;
	private String sessionId;
	private List<Question> questionList;
	private Question question;

	private static final String QUESTION_SHEET = "Questions";

	private static final int COL_SESSION = 0;
	private static final int COL_ID = 1;
	private static final int COL_LEVEL = 2;
	private static final int COL_STEM_PART = 3;
	private static final int COL_A = 4;
	private static final int COL_B = 5;
	private static final int COL_C = 6;
	private static final int COL_D = 7;
	private static final int COL_E = 8;
	private static final int COL_RIGHT = 9;
	private static final int COL_EXPLAINATION = 10;

	private Row row;

	public void readAll() {
		loadDataFromPath(Global.baseDir + "/src/main/resources/data/istqb");
	}

	public QuestionBank getQuestionBank() {
		questionBank = new QuestionBank();

		Set<Entry<String, List<Question>>> entrySet = sessionToListQuestion.entrySet();
		Session session;
		Questions questions;

		List<Session> sessions = new ArrayList<>();
		for (Entry<String, List<Question>> entry : entrySet) {
			session = new Session();
			session.setKey(entry.getKey());
			questions = new Questions();
			questions.setDict(entry.getValue());
			session.setArray(questions);
			sessions.add(session);
		}

		questionBank.setSession(sessions);

		return questionBank;

	}

	private void loadDataFromPath(String pathname) {
		File folder = new File(pathname);
		if (folder == null || !folder.isDirectory()) {
			return;
		}

		File[] files = folder.listFiles();

		sessionToListQuestion = new HashMap<String, List<Question>>();

		for (File file : files) {
			try {

				FileInputStream inputStream = new FileInputStream(file);

				Workbook workbook = new XSSFWorkbook(inputStream);
				Sheet questionSheet = workbook.getSheet(QUESTION_SHEET);
				int totalRow = questionSheet.getLastRowNum();
				for (int i = 0; i < totalRow; i++) {
					row = questionSheet.getRow(i);
					readQuestion();
					putQuestion();
				}

				workbook.close();
				inputStream.close();
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

	private void putQuestion() {
		questionList = sessionToListQuestion.get(sessionId);
		if (questionList == null) {
			questionList = new ArrayList<Question>();
		}

		questionList.add(question);
		sessionToListQuestion.put(sessionId, questionList);

	}

	private String readCell(int col) {
		Cell cell = row.getCell(col);
		String result = "";

		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			result = cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			result = "" + cell.getBooleanCellValue();
			break;
		case Cell.CELL_TYPE_NUMERIC:
			result = "" + cell.getNumericCellValue();
			break;
		}
		return result;
	}

	private void readQuestion() {
		question = new Question();

		sessionId = readCell(COL_SESSION);
		question.setSessionId(sessionId);

		question.setId( createQuestionId(sessionId+ readCell(COL_ID)));

		question.setLevel(Utils.toInt(readCell(COL_LEVEL)));

		question.setRoot(createStringParagraph(COL_STEM_PART));

		question.setOptions(createoptions());

		question.setRight(createIntParagraph(COL_RIGHT));

		question.setExplanation(createStringParagraph(COL_EXPLAINATION));

	}


	private String createQuestionId(String value) {
		return value.replace(".", "");
	}

	private Options createoptions() {
		Options options = new Options();

		options.setOptionA(createStringParagraph(COL_A));
		options.setOptionB(createStringParagraph(COL_B));
		options.setOptionC(createStringParagraph(COL_C));
		options.setOptionD(createStringParagraph(COL_D));
		options.setOptionE(createStringParagraph(COL_E));

		return options;
	}

	private Paragraph createStringParagraph(int col) {
		Paragraph paragraph = new Paragraph();

		List<String> listText = new ArrayList<String>();
		listText.add(readCell(col));
		paragraph.setString(listText);

		return paragraph;
	}

	private Paragraph createIntParagraph(int col) {
		Paragraph paragraph = new Paragraph();

		List<Integer> listInt = new ArrayList<Integer>();
		listInt.add(Utils.optionToInt(readCell(col)));

		paragraph.setInteger(listInt);

		return paragraph;
	}

}
