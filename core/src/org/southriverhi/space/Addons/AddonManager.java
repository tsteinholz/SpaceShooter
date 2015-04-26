package org.southriverhi.space.Addons;

import static net.elektrofuchse.im1.src.MainClass.DIR_STORE;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class AddonManager {

	private static final String PLUGIN_PATH = DIR_STORE + "/plugins";
	private ArrayList<SpaceShooterPlugin> plugins = new ArrayList<SpaceShooterPlugin>();
	private HashMap<SpaceShooterPlugin, AddonInfo> pluginInfo = new HashMap<SpaceShooterPlugin, AddonInfo>();

	public ArrayList<SpaceShooterPlugin> loadPlugins(String... listOPlugin) {
		// if (DEBUG) {
		// for (Map.Entry<String, String> entry : System.getenv().entrySet()) {
		// System.out.println(entry.getKey() + " :: " + entry.getValue());
		// }
		// System.out.println();
		// }
		try {
			File filePath = new File(PLUGIN_PATH);
			if (!filePath.exists())
				filePath.mkdirs();
			File files[] = filePath.listFiles();

			for (File file : files) {
				if (file.isFile()) {
					if (file.getName().contains(" ")) {
						file.renameTo(new File(file.getParentFile().getAbsolutePath() + "\\" + file.getName().replace(' ', '-')));
						return loadPlugins();
					}
					ZipFile zf = new ZipFile(file);
					Enumeration<? extends ZipEntry> entries = zf.entries();
					while (entries.hasMoreElements()) {
						ZipEntry ze = entries.nextElement();
						System.out.println(ze.getName());

						if (ze.getName().equalsIgnoreCase("plugin.yml")) {

							DataInputStream in = new DataInputStream(zf.getInputStream(ze));
							BufferedReader br = new BufferedReader(new InputStreamReader(in));

							// ArrayList<String> info = new ArrayList<String>();
							HashMap<String, String> info = new HashMap<String, String>();
							String line;
							int err = 0;
							while ((line = br.readLine()) != null) {

								try {
									info.put(line.split(":")[0].trim(), line.split(":")[1].trim().replace(' ', '_'));
								} catch (Exception e) {
									System.out.println("PluginFailedToLoad: " + file.getAbsolutePath());
									err = 1;
									break;
								}
							}
							if (err != 0) {
								break;
							}
							String name = info.get("name");
							String type = info.get("type");
							String version = info.get("version");
							String classpath = info.get("classpath");
							String description = info.get("description");
							String reqversion = info.get("reqVersion");
							String reviseddate = info.get("revisedDate");
							String authors = info.get("authors");
							AddonInfo pi = new AddonInfo(name, version, type, classpath, description, reqversion, reviseddate, authors);

							br.close();
							in.close();
							System.out.println();
							URI uri = URI.create("file:/" + PLUGIN_PATH + "/" + file.getName());
							URL url = uri.toURL();
							URL[] urls = new URL[] { url };

							@SuppressWarnings("resource")
							ClassLoader loader = new URLClassLoader(urls);
							Class<?> cls = loader.loadClass(pi.getClasspath());
							SpaceShooterPlugin temp = (SpaceShooterPlugin) cls.newInstance();
							plugins.add(temp);
							pluginInfo.put(temp, pi);
							temp = null;
							loader = null;
							break;
						}
						ze = null;
					}
					zf.close();
					entries = null;
				} else {
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return plugins;
	}
}
