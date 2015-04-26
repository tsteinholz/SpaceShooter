package org.southriverhi.space.Addons;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class AddonUtil {
	/**
	 * Scans a JAR file for .class-files and returns a {@link java.util.List} containing the full name of found classes (in the following form: packageName.className)
	 * 
	 * @param file
	 *            JAR-file which should be searched for .class-files
	 * @return Returns all found class-files with their full-name as a List of Strings
	 * @throws java.io.IOException
	 *             If during processing of the Jar-file an error occurred
	 * @throws IllegalArgumentException
	 *             If either the provided file is null, does not exist or is no Jar file
	 */
	public static List<String> scanJarFileForClasses(File file) throws IOException, IllegalArgumentException {
		if (file == null || !file.exists())
			throw new IllegalArgumentException("Invalid jar-file to scan provided");
		if (file.getName().endsWith(".jar")) {
			List<String> foundClasses = new ArrayList<String>();
			try (JarFile jarFile = new JarFile(file)) {
				Enumeration<JarEntry> entries = jarFile.entries();
				while (entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (entry.getName().endsWith(".class")) {
						String name = entry.getName();
						name = name.substring(0, name.lastIndexOf(".class"));
						if (name.indexOf("/") != -1)
							name = name.replaceAll("/", ".");
						if (name.indexOf("\\") != -1)
							name = name.replaceAll("\\", ".");
						foundClasses.add(name);
					}
				}
			}
			return foundClasses;
		}
		throw new IllegalArgumentException("No jar-file provided");
	}

	/**
	 * <p>
	 * Looks inside a jar file and looks for implementing classes of the provided interface.
	 * </p>
	 * 
	 * @param <T>
	 * 
	 * @param file
	 *            The Jar-File containing the classes to scan for implementation of the given interface
	 * @param iface
	 *            The interface classes have to implement
	 * @param loader
	 *            The class loader the implementing classes got loaded with
	 * @return A {@link java.util.List} of implementing classes for the provided interface inside jar files of the <em>ClassFinder</em>s class path
	 * 
	 * @throws Exception
	 *             If during processing of the Jar-file an error occurred
	 */
	public static <T extends Annotation> List<Class<?>> findImplementingClassesInJarFile(File file, Class<T> iface, ClassLoader loader) throws Exception {
		List<Class<?>> implementingClasses = new ArrayList<>();
		// scan the jar file for all included classes
		for (String classFile : scanJarFileForClasses(file)) {
			System.out.println("2: " + classFile);
			Class<?> clazz;
			try {
				// now try to load the class
				if (loader == null) {
					clazz = Class.forName(classFile);
					System.err.println("3: " + clazz);
				} else {
					clazz = Class.forName(classFile, true, loader);
					System.out.println("4: " + clazz);
				}
				// clazz.newInstance();

				// if(clazz.)
				int notFound = 0;
				try {
					System.out.println(Arrays.toString(clazz.getMethods()));
				} catch (Exception e) {
					System.err.println("NOOOOOOOO");
				}
				// for (Method me : clazz.getMethods()) {
				// if (me.getName().equalsIgnoreCase("load") && me.getParameterTypes()[0] == PluginLoadEvent.class) {
				// notFound++;
				// }
				// if (me.getName().equalsIgnoreCase("unload") && me.getParameterTypes()[0] == PluginUnloadEvent.class) {
				// notFound++;
				// }
				// if (me.getName().equalsIgnoreCase("start") && me.getParameterTypes()[0] == PluginStartEvent.class) {
				// notFound++;
				// }
				// if (me.getName().equalsIgnoreCase("stop") && me.getParameterTypes()[0] == PluginStopEvent.class) {
				// notFound++;
				// }
				// if (me.getName().equalsIgnoreCase("run") && me.getParameterTypes()[0] == PluginRunEvent.class) {
				// notFound++;
				// }
				// }

				System.out.println("VAR: " + Arrays.toString(clazz.getFields()));
				for (Field f : clazz.getFields()) {
					// System.err.println(f.getName());
					if (f.getName().equalsIgnoreCase("pluginInstance") && f.getType() == clazz && notFound > 4) {
						implementingClasses.add(clazz);
					}
				}

				// System.out.println("HMMM " + Arrays.toString(clazz.getAnnotations()));
				// System.out.println("Heeee " + clazz.isAnnotationPresent(InventoryPlugin.class));
				// System.out.println(iface.isAssignableFrom(clazz));
				// System.out.println(Arrays.toString(clazz.getMethods()));
				// // if(clazz.getAnnotation(iface) != null){
				// if(clazz.isAnnotationPresent(iface)){
				// System.out.println("LOLOLOLOLOLOLOLOL");
				// }
				// System.out.println(clazz.getAnnotations().length + " HIII " + Arrays.toString(clazz.getAnnotations()));
				// // }
				// // and check if the class implements the provided interface
				// if (iface.isAssignableFrom(clazz) && !clazz.equals(iface)) {
				// }
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return implementingClasses;
	}

	public static void executeImplementationsOfAInJarFile(File downloadedJarFile) throws MalformedURLException {
		if (downloadedJarFile == null || !downloadedJarFile.exists())
			throw new IllegalArgumentException("Invalid jar file provided");

		URL downloadURL = downloadedJarFile.toURI().toURL();
		URL[] downloadURLs = new URL[] { downloadURL };
		URLClassLoader loader = URLClassLoader.newInstance(downloadURLs, AddonUtil.class.getClass().getClassLoader());
		try {
			List<Class<?>> implementingClasses = findImplementingClassesInJarFile(downloadedJarFile, null, loader);
			System.out.println(implementingClasses);
			for (Class<?> clazz : implementingClasses) {
				// assume there is a public default constructor available
				Object instance = clazz.newInstance();
				Method method = clazz.getDeclaredMethod("start", String.class);
				Object result = method.invoke(instance, new String("Test from method!"));
				System.out.println("HI");
				System.out.println(result);
				System.out.println("BYE");
				// T instance = clazz.newInstance();
				// ... do whatever you like here
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
