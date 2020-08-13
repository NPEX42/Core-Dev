package uk.co.np.core;

class Memory {
	
	public static long GetMemoryBytesFree() {
		return OS.runtime.freeMemory();
	}
	
	public static long GetMemoryBytesAvail() {
		return OS.runtime.maxMemory();
	}
	
	public static long GetMemoryBytesTotal() {
		return OS.runtime.totalMemory();
	}
	
	public static long GetMemoryKBytesFree() {
		return GetMemoryBytesFree() / 1024;
	}
	
	public static int GetMemoryMBytesFree() {
		return (int) (GetMemoryKBytesFree() / 1024);
	}
	
	public static int GetMemoryGBytesFree() {
		return GetMemoryMBytesFree() / 1024;
	}
}
