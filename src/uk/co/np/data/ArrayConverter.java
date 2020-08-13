package uk.co.np.data;

import java.util.Arrays;

class ArrayConverter {
	public static String ToRawString(int[] data, boolean stripOuterChars) {
		String output = Arrays.toString(data);
		if(stripOuterChars) output = output.substring(1, output.length() - 1);
		String finalOutput = "";
		for(int i = 0; i < output.split(",").length; i++) {
			String item = output.split(",")[i];
			if(i > 0) {
				finalOutput += (item + ",").substring(1);
			} else {
				finalOutput += (item + ",");
			}
		}
		return finalOutput.substring(0,finalOutput.length() - 1);
	}
	
	public static String ToRawString(float[] data, boolean stripOuterChars) {
		String output = Arrays.toString(data);
		if(stripOuterChars) output = output.substring(1, output.length() - 1);
		String finalOutput = "";
		for(int i = 0; i < output.split(",").length; i++) {
			String item = output.split(",")[i];
			if(i > 0) {
				finalOutput += (item + ",").substring(1);
			} else {
				finalOutput += (item + ",");
			}
		}
		return finalOutput.substring(0,finalOutput.length() - 1);
	}
	
	public static String ToRawString(byte[] data, boolean stripOuterChars) {
		String output = Arrays.toString(data);
		if(stripOuterChars) output = output.substring(1, output.length() - 1);
		String finalOutput = "";
		for(int i = 0; i < output.split(",").length; i++) {
			String item = output.split(",")[i];
			if(i > 0) {
				finalOutput += (item + ",").substring(1);
			} else {
				finalOutput += (item + ",");
			}
		}
		return finalOutput.substring(0,finalOutput.length() - 1);
	}
	
	public static String ToRawString(short[] data, boolean stripOuterChars) {
		String output = Arrays.toString(data);
		if(stripOuterChars) output = output.substring(1, output.length() - 1);
		String finalOutput = "";
		for(int i = 0; i < output.split(",").length; i++) {
			String item = output.split(",")[i];
			if(i > 0) {
				finalOutput += (item + ",").substring(1);
			} else {
				finalOutput += (item + ",");
			}
		}
		return finalOutput.substring(0,finalOutput.length() - 1);
	}
	
	public static String ToRawString(long[] data, boolean stripOuterChars) {
		String output = Arrays.toString(data);
		if(stripOuterChars) output = output.substring(1, output.length() - 1);
		String finalOutput = "";
		for(int i = 0; i < output.split(",").length; i++) {
			String item = output.split(",")[i];
			if(i > 0) {
				finalOutput += (item + ",").substring(1);
			} else {
				finalOutput += (item + ",");
			}
		}
		return finalOutput.substring(0,finalOutput.length() - 1);
	}
	
	public static String ToRawString(double[] data, boolean stripOuterChars) {
		String output = Arrays.toString(data);
		if(stripOuterChars) output = output.substring(1, output.length() - 1);
		String finalOutput = "";
		for(int i = 0; i < output.split(",").length; i++) {
			String item = output.split(",")[i];
			if(i > 0) {
				finalOutput += (item + ",").substring(1);
			} else {
				finalOutput += (item + ",");
			}
		}
		return finalOutput.substring(0,finalOutput.length() - 1);
	}
	
	public static int[] ToIntArray(String str) {
		String[] items = str.split(",");
		int[] outputArray = new int[items.length];
		
		for(int i = 0; i < items.length; i++) {
			outputArray[i] = Integer.parseInt(items[i]);
		}
		
		return outputArray;
	} 
	
	public static byte[] ToByteArray(String str) {
		String[] items = str.split(",");
		byte[] outputArray = new byte[items.length];
		
		for(int i = 0; i < items.length; i++) {
			outputArray[i] = Byte.parseByte(items[i]);
		}
		
		return outputArray;
	} 
	
	public static short[] ToShortArray(String str) {
		String[] items = str.split(",");
		short[] outputArray = new short[items.length];
		
		for(int i = 0; i < items.length; i++) {
			outputArray[i] =  Short.parseShort(items[i]);
		}
		
		return outputArray;
	} 
	
	public static long[] ToLongArray(String str) {
		String[] items = str.split(",");
		long[] outputArray = new long[items.length];
		
		for(int i = 0; i < items.length; i++) {
			outputArray[i] = Long.parseLong(items[i]);
		}
		
		return outputArray;
	} 
	
	public static float[] ToFloatArray(String str) {
		String[] items = str.split(",");
		float[] outputArray = new float[items.length];
		
		for(int i = 0; i < items.length; i++) {
			outputArray[i] = Integer.parseInt(items[i]);
		}
		
		return outputArray;
	} 
	
	public static double[] ToDoubleArray(String str) {
		String[] items = str.split(",");
		double[] outputArray = new double[items.length];
		
		for(int i = 0; i < items.length; i++) {
			outputArray[i] = Double.parseDouble(items[i]);
		}
		
		return outputArray;
	}
}
