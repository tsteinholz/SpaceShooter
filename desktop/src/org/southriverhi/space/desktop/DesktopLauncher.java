package org.southriverhi.space.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.southriverhi.space.SpaceShooter;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "South River Space Shooter";
		new LwjglApplication(new SpaceShooter(), config);
	}
}
