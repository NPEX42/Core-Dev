package uk.co.np.core;

import com.sun.jna.Library;
import com.sun.jna.Native;

class DriverManager {
	public static Library LoadDriver(String driverName,Class<? extends Library> lib) {
			return (Library) Native.load(driverName,lib);
	}
}
