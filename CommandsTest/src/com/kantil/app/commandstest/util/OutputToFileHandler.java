package com.kantil.app.commandstest.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.content.Context;
import android.os.Environment;

import com.kantil.app.commandstest.R;
import com.kantil.app.commandstest.command.CommandsEnum;

public class OutputToFileHandler {
	public static final String FILEDIR = Environment
			.getExternalStorageDirectory() + "/CT/";
	public static final String TABLEFILE = FILEDIR + "table";

	public static void cleanFile(Context context) {
		new File(FILEDIR).mkdirs();
		File tableFile = new File(TABLEFILE);
		if (!tableFile.exists()) {
			tableFile.delete();
		}
		try {
			tableFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			// BufferedWriter for performance, true to set append to file flag
			BufferedWriter buf = new BufferedWriter(new FileWriter(tableFile,
					true));
			buf.append(context.getString(R.string.description) + " - "
					+ context.getString(R.string.code) + " - "
					+ context.getString(R.string.databytes) + " - "
					+ context.getString(R.string.min) + " - "
					+ context.getString(R.string.max) + " - "
					+ context.getString(R.string.unit) + " - "
					+ context.getString(R.string.formula) + " - "
					+ context.getString(R.string.result));
			buf.newLine();
			buf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void insertRow(CommandsEnum c, String result) {
		new File(FILEDIR).mkdirs();
		File logFile = new File(TABLEFILE);
		try {
			// BufferedWriter for performance, true to set append to file flag
			BufferedWriter buf = new BufferedWriter(new FileWriter(logFile,
					true));
			buf.append(c.getDescription() + " - " + c.getCode() + " - "
					+ c.getDataBytes() + " - " + c.getMin() + " - "
					+ c.getMax() + " - " + c.getUnit() + " - " + c.getFormula()
					+ " - " + result);
			buf.newLine();
			buf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
