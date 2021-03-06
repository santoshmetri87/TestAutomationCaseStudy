package com.serenity.demo.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertyFileHelper {

	public static Properties prop = new Properties();
	public static InputStream input = null;
	public static OutputStream out = null;

	public static Properties loadPropertyFile(String filepath) {
		try {
			input = new FileInputStream(filepath);
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.getMessage();
				}
			}

		}

		return prop;
	}

}
