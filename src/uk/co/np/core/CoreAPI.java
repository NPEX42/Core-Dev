package uk.co.np.core;

import java.io.File;

import com.sun.jna.Library;
import com.sun.jna.platform.linux.LibC;

public class CoreAPI {
	private static JARLoader loader = new JARLoader();
	
	public static Library LoadDriver(String driverName, Class<? extends Library> lib) {
		return DriverManager.LoadDriver(driverName, lib);
	} 
	
	public static String LoadString(String path) {
		return IO.LoadString(path);
	}
	
	public static String[] LoadStrings(String path) {
		return IO.LoadStrings(path);
	}
	
	public static Object LoadObject(String classPath, String name) {
		return loader.LoadClass(classPath, name);
	}
	
	public static int GetMemoryFreeKB() {
		return (int) Memory.GetMemoryKBytesFree();
	}
	
	public static int GetMemoryFreeMB() {
		return Memory.GetMemoryMBytesFree();
	}
	
	public static int GetMemoryFreeGB() {
		return (int) Memory.GetMemoryGBytesFree();
	}
	
	public static boolean SendMessage(String msg, String ip, int port) {
		return NET.SendString(msg, ip, port);
	}
	
	public static String GetNextMessage() {
		return NET.GetNextMessage();
	}
	
	public static boolean HasNextMessage() {
		return NET.HasNextMessage();
	}
	
	public static boolean StartListening(int port) {
		return NET.StartListening(port) != null;
	}
	
	public static String GetEnvironmentString(String key) {
		return OS.GetEnvString(key);
	}
	
	public static int GetEnvironmentint(String key) {
		return OS.GetEnvInt(key);
	}
	
	public static File GetEnvironmentDirectory(String key) {
		return OS.GetEnvDir(key);
	}
	
	public static String GetCurrentWorkingPath() {
		return OS.GetWorkingPath();
	}
} 
