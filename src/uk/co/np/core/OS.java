package uk.co.np.core;

import java.io.File;
import java.io.IOException;

class OS {
	public static final Runtime runtime = Runtime.getRuntime();
	public static final boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows"); 
	public static int Run(String command) {
		Process process = null;
		if(isWindows) {
			try {
				process = runtime.exec("cmd.exe "+command);
			} catch (IOException e) {
				return -1;
			}
		} else {
			try {
				process = runtime.exec("sh "+command);
			} catch (IOException e) {
				return -1;
			}
		}
		
		try {
			return process.waitFor();
		} catch (InterruptedException e) {
			return -2;
		}
	}
	
	public static int BuildAndRunCommand(Object... args) {
		String command = "";
		for(Object o : args) {
			command += o;
		}
		
		return Run(command);
	}
 	 
	public static String GetEnvString(String key) {
		return System.getenv(key);
	}
	
	public static File GetEnvDir(String key) {
		return new File(GetEnvString(key));
	}
	
	public static int GetEnvInt(String key) {
		return Integer.parseInt(GetEnvString(key));
	}
	
	public static String GetWorkingPath() {
		return GetEnvString("user.dir");
	}
}
