package uk.co.np.data;

import java.lang.reflect.Field;

public class ObjectSerializer {
	public static final int MAX_RECURSE_DEPTH = 16;
	public static ConfigMap Save(String prefix, Object obj,ConfigMap map, int depth) {
		Field[] fields = obj.getClass().getFields();
		//System.out.println("Depth: "+depth);
		try {
			for(Field field : fields) {
				Object type = field.getType();
				//System.out.println("Field '"+field.getName()+"' Type: "+type);
				//System.out.println(type instanceof Integer);
				if(type.equals(byte.class)) {
					map.SetByte(prefix+field.getName(), field.getByte(obj));
					//System.out.println("Processed Field '"+field.getName()+"' as a byte");
				}
				
				else if(type.equals(short.class)) {
					map.SetShort(prefix+field.getName(), field.getShort(obj));
					//System.out.println("Processed Field '"+field.getName()+"' as a short");
				}
				
				else if(type.equals(int.class)) {
					map.SetInt(prefix+field.getName(), field.getInt(obj));
					//System.out.println("Processed Field '"+field.getName()+"' as a int");
				}
				
				else if(type.equals(long.class)) {
					map.SetLong(prefix+field.getName(), field.getLong(obj));
					//System.out.println("Processed Field '"+field.getName()+"' as a long");
				}
				
				else if(type.equals(float.class)) {
					map.SetFloat(prefix+field.getName(), field.getFloat(obj));
					//System.out.println("Processed Field '"+field.getName()+"' as a float");
				}
				
				else if(type.equals(double.class)) {
					map.SetDouble(prefix+field.getName(), field.getDouble(obj));
					//System.out.println("Processed Field '"+field.getName()+"' as a double");
				}
				
				else if(type.equals(String.class)) {
					map.SetString(prefix+field.getName(), (String) field.get(obj));
					//System.out.println("Processed Field '"+field.getName()+"' as a float");
				}
				
				else if(depth < MAX_RECURSE_DEPTH) {
					Save(prefix+field.getName()+":",field.get(obj), map, depth + 1);
					//System.out.println("Processed Field '"+field.getName()+"' as a Object");
				}
			}
		} catch(Exception ex) {
			return map;
		}
		return map;
	} 
	
	public static ConfigMap Save(Object obj) {
		return Save("",obj, new ConfigMap(), 0);
	}
	
	public static Object Load(Object obj, ConfigMap map, String prefix, int depth) {
		try {
			Field[] fields = obj.getClass().getFields();
			for(Field field : fields) {
				Class<?> type = field.getType();
				String name = prefix + field.getName();
				if(type.equals(byte.class)) {
					field.setByte(obj, map.GetByte(name));
				}
				
				else if(type.equals(short.class)) {
					field.setShort(obj, map.GetShort(name));
				}
				
				else if(type.equals(int.class)) {
					field.setInt(obj, map.GetInt(name));
				}
				
				else if(type.equals(long.class)) {
					field.setLong(obj, map.GetLong(name));
				}
				
				else if(type.equals(float.class)) {
					field.setFloat(obj, map.GetFloat(name));
				}
				
				else if(type.equals(double.class)) {
					field.setDouble(obj, map.GetDouble(name));
				}
				
				else if(type.equals(String.class)) {
					field.set(obj, map.GetString(name));
				} else if(depth < MAX_RECURSE_DEPTH) {
					Load(type, map, name+":", depth + 1);
				}
			}
		} catch(Exception ex) {
			return null;
		}
		return obj;
	}
	
	public static void Load(Class<?> clazz, ConfigMap map, String prefix, int depth) {
		try {
			Load(clazz.newInstance(), map, prefix, depth);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
} 
