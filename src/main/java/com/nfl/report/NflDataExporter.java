package com.nfl.report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.nfl.model.GameSnapShot;
import com.nfl.utils.Global;

public class NflDataExporter {

	private static final String REPORT_TEMPLATE = "template.xlsx";

	private static final String GAME_CHIP = "gamechip";
	// private static final String SHEET_STYLE = "Style";

	private static final int GAME_CHIP_ROW_START = 0;
	private static final int GAME_CHIP_COL_START = 1;

	private XSSFSheet sheetReader;
	private XSSFWorkbook wbReader;
	private XSSFRow row;
	private XSSFCell cell;

	private int iRow;
	private int iCol;

	private Map<String, List<GameSnapShot>> jsonFileToGamechipsMap;
	private List<String> fileNames;
	
	private List<GameSnapShot> gamechips;
	private GameSnapShot gamechip;
	private String temp = "";
	private File img;

	private CellStyle cellStyleNormal;
	private CellStyle cellStyleGreen;

	public static String reportFile;

	public NflDataExporter(Map<String, List<GameSnapShot>> jsonFileToGamechipsMap, List<String> fileNames) {
		this.jsonFileToGamechipsMap = jsonFileToGamechipsMap;
		this.fileNames = fileNames;
	}

	public void start() {
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy-hhmmss");
		reportFile = new StringBuffer().append(Global.baseDir).append("/output/DataGenerate-")
				.append(df.format(new Date().getTime())).append(".xlsx").toString();

	}

	public void generateReport() {
		start();

		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(REPORT_TEMPLATE);

		try {
			wbReader = new XSSFWorkbook(inputStream);

			initCellStyle();

			createGamechipSheet();

			OutputStream outputStream = new FileOutputStream(new File(reportFile));

			wbReader.write(outputStream);

			if (outputStream != null) {
				outputStream.close();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (

		Exception e) {
			e.printStackTrace();
		}
	}

	private void initCellStyle() {
		sheetReader = wbReader.getSheet(GAME_CHIP);

		cellStyleGreen = sheetReader.getRow(0).getCell(0).getCellStyle();
		cellStyleNormal = sheetReader.getRow(1).getCell(0).getCellStyle();


	}

	private void createGamechipSheet() throws Exception {
//		sheetReader = wbReader.getSheet(GAME_CHIP);

		/* TEST RESULT DETAILS */
		iRow = GAME_CHIP_ROW_START;
		iCol = GAME_CHIP_COL_START;

		for (String fileName:fileNames) {
			setCellValueForCol(fileName);

			this.gamechips =jsonFileToGamechipsMap.get(fileName);
			writeGamechips();
			iRow = 0;
			iCol++;
		}
	}

	private void writeGamechips() {
		for (GameSnapShot gamechip : gamechips) {
			this.gamechip = gamechip;
			writeGamechip();
			setCellValueForCol("");
			this.cell.setCellStyle(cellStyleGreen);
		}

	}

	private void writeGamechip() {

		setCellValueForCol(this.gamechip.getGameId());

		setCellValueForCol(this.gamechip.getHomeTeamClubCode());

		setCellValueForCol(this.gamechip.getHomeTeamScore());

		setCellValueForCol(this.gamechip.getAwayTeamScore());

		setCellValueForCol(this.gamechip.getAwayTeamClubCode());

		setCellValueForCol(this.gamechip.getClock());

		setCellValueForCol(this.gamechip.getPhase());

		setCellValueForCol(this.gamechip.getPossession());

		setCellValueForCol(this.gamechip.getKickoffDate().get_GMT());

		setCellValueForCol(this.gamechip.getYardLine());

	}

	private void setCellValueForRow(String value, String hyperLink) {
		setCellValue(this.iRow, this.iCol, value, hyperLink);
		this.iCol++;

	}

	private void setCellValueForRow(String value) {
		setCellValue(this.iRow, this.iCol, value);
		this.iCol++;

	}

	private void setCellValueForCol(int value) {
		setCellValueForCol(new Integer(value).toString());
	}

	private void setCellValueForCol(String value) {
		setCellValue(this.iRow, this.iCol, value);
		this.iRow++;
	}

	private void setCellValueForCol(String value, String hyperLink) {
		setCellValue(this.iRow, this.iCol, value, hyperLink);
		this.iRow++;
	}

	private void setCellValue(int iRow, int iCol, String value) {
		setCellValue(iRow, iCol, value, null);
	}

	private void setCellValue(int iRow, int iCol, String value, String hyperLink) {
		row = sheetReader.getRow(iRow);
		if (row == null) {
			row = sheetReader.createRow(iRow);
		}
		if ((cell = row.getCell(iCol)) == null) {
			cell = row.createCell(iCol);
		}
		cell.setCellValue(value);
		cell.setCellStyle(cellStyleNormal);
		if (hyperLink != null) {
			XSSFCellStyle style = cell.getCellStyle();
			XSSFFont font = wbReader.createFont();
			font.setUnderline((byte) 1);
			style.setFont((Font) font);
			XSSFCreationHelper createHelper = wbReader.getCreationHelper();
			Hyperlink link = createHelper.createHyperlink(HyperlinkType.FILE);
			link.setAddress(hyperLink.replace("\\", "/").replace(" ", "%20").replace("+", "%2B"));
			cell.setHyperlink(link);
			cell.setCellStyle((CellStyle) style);
		}
	}
}
