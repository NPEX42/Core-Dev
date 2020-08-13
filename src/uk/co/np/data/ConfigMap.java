package uk.co.np.data;

import java.util.Arrays;
import java.util.List;

public class ConfigMap {
	private HashMap<String, String> map = new HashMap<>();
	public static final String seperator = ":"; 
	public ConfigMap() {
		map = new HashMap<String, String>();
	}
	
	public ConfigMap(String... configSource) {
		this(Arrays.asList(configSource));
	}
	
	public ConfigMap(List<String> configSource) {
		for(String line : configSource) {
			String[] sections = line.split(seperator);
			if(sections.length >= 2) {
				map.Put(sections[0], sections[1]);
			}
		}
	}
	
	public void SetString(String key, String value) {
		map.Put(key,value);
	}
	
	public void SetInt(String key, int value) {
		SetString(key,""+value);
	}
	
	public void SetByte(String key, byte value) {
		SetString(key,""+value);
	}
	
	public void SetShort(String key, short value) {
		SetString(key,""+value);
	}
	
	public void SetLong(String key, long value) {
		SetString(key,""+value);
	}
	
	public void SetFloat(String key, float value) {
		SetString(key, ""+value);
	}
	
	public void SetDouble(String key, double value) {
		SetString(key, ""+value);
	}
	
	public void SetInts(String key, int[] values) {
		SetString(key, ArrayConverter.ToRawString(values, true));
	}
	
	public void SetFloats(String key, float[] values) {
		SetString(key, ArrayConverter.ToRawString(values, true));
	}
	
	public void SetBytes(String key, byte[] values) {
		SetString(key, ArrayConverter.ToRawString(values, true));
	}
	
	public void SetShorts(String key, short[] values) {
		SetString(key, ArrayConverter.ToRawString(values, true));
	}
	
	public void SetLong(String key, long[] values) {
		SetString(key, ArrayConverter.ToRawString(values, true));
	}	
	
	public void SetDouble(String key, double[] values) {
		SetString(key, ArrayConverter.ToRawString(values, true));
	}
	
	public String GetString(String key) {
		return map.GetOrDefault(key, "0");
	}
	
	public byte GetByte(String key) {
		return Byte.parseByte(GetString(key));
	}
	
	public short GetShort(String key) {
		return Short.parseShort(GetString(key));
	}
	
	public int GetInt(String key) {
		return Integer.parseInt(GetString(key));
	}
	
	public long GetLong(String key) {
		return Long.parseLong(GetString(key));
	}
	
	public float GetFloat(String key) {
		return Float.parseFloat(GetString(key));
	}
	
	public double GetDouble(String key) {
		return Double.parseDouble(GetString(key));
	}
	
	public int[] GetInts(String key) {
		return ArrayConverter.ToIntArray(GetString(key));
	}
	
	public byte[] GetBytes(String key) {
		return ArrayConverter.ToByteArray(GetString(key));
	}
	
	public short[] GetShorts(String key) {
		return ArrayConverter.ToShortArray(GetString(key));
	}
	
	public long[] GetLongs(String key) {
		return ArrayConverter.ToLongArray(GetString(key));
	}
	
	public float[] GetFloats(String key) {
		return ArrayConverter.ToFloatArray(GetString(key));
	}
	
	public double[] GetDoubles(String key) {
		return ArrayConverter.ToDoubleArray(GetString(key));
	}
	
	public String toString() {return map.toString(); }
     
}
