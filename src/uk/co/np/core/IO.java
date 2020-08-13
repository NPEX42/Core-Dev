package uk.co.np.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class IO {
	public static String LoadString(String path) {
		try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
			StringBuffer buffer = new StringBuffer();
			String line;
			while((line = reader.readLine()) != null) {
				buffer.append(line);
				buffer.append("\n");
			}
			return buffer.toString();
		} catch (IOException e) {
			return null;
		}
	}
	
	public static String[] LoadStrings(String path) {
		String source = LoadString(path);
		if(source == null) return null;
		return source.split("\n");
	}
}
