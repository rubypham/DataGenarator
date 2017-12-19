package com.nfl.reader;

import java.util.ArrayList;
import java.util.List;

import com.istqb.model.Question;
import com.istqb.model.QuestionBank;
import com.istqb.model.Questions;
import com.istqb.model.Session;
import com.nfl.utils.Global;

public class ISTQBQuestionBankReader {
	private QuestionBank questionBank;

	private static final String QUESTION_SHEET = "gamechip";

	private static final int COL_Session = 0;
	private static final int COL_Level = 1;
	private static final int COL_Stem_part = 2;
	private static final int COL_A = 3;
	private static final int COL_B = 4;
	private static final int COL_C = 5;
	private static final int COL_D = 6;
	private static final int COL_E = 7;
	private static final int COL_Answer = 8;
	private static final int COL_Explaination = 9;

	private int iRow;
	private int iCol;

	public void readAll() {
		loadDataFromPath(Global.baseDir + "/src/main/resources/data/istqb");
	}

	private void loadDataFromPath(String string) {
		questionBank = new QuestionBank();
		List<Session> sessions = new ArrayList<>();
		sessions.add(readSession());
		questionBank.setSession(sessions);

	}

	private Session readSession() {
		Session session = new Session();
		session.setKey(readCell(iRow, iCol));
		session.setArray(readQuestions());

		return session;
	}

	private Questions readQuestions() {
		Questions questions = new Questions();
		List<Question> listQuestions = new ArrayList<>();
		listQuestions.add(readQuestion());

		questions.setDict(listQuestions);
		return questions;
	}

	private Question readQuestion() {
		Question question = new Question();
		// question.
		return question;
	}

	private String readCell(int iRow2, int iCol2) {
		// TODO Auto-generated method stub
		return null;
	}

}
