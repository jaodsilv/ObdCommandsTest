package com.kantil.app.commandstest.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import android.os.Environment;
import android.text.format.Time;
import android.util.Log;

public class Logger {

	public static final String WARNING = "W";
	public static final String VERBOSE = "V";
	public static final String ERROR = "E";
	public static final String INFO = "I";
	public static final String DEBUG = "D";

	public static final String LOGFILEDIR = Environment
			.getExternalStorageDirectory() + "/CT/";
	public static final String LOGFILE = LOGFILEDIR + "logfile." + Time.getCurrentTimezone();

	public static void w(String tag, String text) {
		log(WARNING, tag, text);
		Log.w(tag, text);
	}

	public static void v(String tag, String text) {
		log(VERBOSE, tag, text);
		Log.v(tag, text);
	}

	public static void e(String tag, String text) {
		log(ERROR, tag, text);
		Log.e(tag, text);
	}

	public static void i(String tag, String text) {
		log(INFO, tag, text);
		Log.i(tag, text);
	}

	public static void d(String tag, String text) {
		log(DEBUG, tag, text);
		Log.d(tag, text);
	}

	private static void log(String level, String tag, String text) {
		text = (new Date(System.currentTimeMillis())).toString() + " " + level
				+ ": " + tag + ": " + text;
		new File(LOGFILEDIR).mkdirs();
		File logFile = new File(LOGFILE);
		if (!logFile.exists()) {
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			// BufferedWriter for performance, true to set append to file flag
			BufferedWriter buf = new BufferedWriter(new FileWriter(logFile,
					true));
			buf.append(text);
			buf.newLine();
			buf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
