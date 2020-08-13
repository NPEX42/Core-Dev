package uk.co.np.data;
@SuppressWarnings("unchecked")
public class HashMap<K, V> {
	public static final int TABLE_SIZE = 65536;
	private Object[] table = new Object[TABLE_SIZE];
	
	private int ToIndex(Object obj) {
		return obj.hashCode() % TABLE_SIZE;
	}
	
	public V Get(K key) {
		return (V) table[ToIndex(key)];
	}
	
	public V GetOrDefault(K key, V def) {
		if(Get(key) == null) return def;
		return Get(key);
	}
	
	public void Put(K key, V value) {
		table[ToIndex(key)] = value;
	}
}
