package uk.co.np.core;

import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

class JARLoader extends URLClassLoader {
	public JARLoader() {
		super(new URL[1]);
	}
	public Object LoadClass(String classPath, String name) {
		try {
			addURL(new URL(classPath));
			Class<?> clazz = this.loadClass(name);
			return (Object) clazz.newInstance();
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}
	public void addURL(URL url) {
		super.addURL(url);
	}
	
	private Constructor<?> LoadConstructor(Class<?> clazz, Class<?>... argTypes) {
		try {
			return clazz.getDeclaredConstructor(argTypes);
		} catch (NoSuchMethodException | SecurityException e) {
			System.err.println(e);
			return null;
		}
	}
}
