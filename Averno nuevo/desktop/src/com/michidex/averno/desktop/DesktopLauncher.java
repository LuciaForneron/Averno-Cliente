package com.michidex.averno.desktop;


import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.michidex.averno.Averno;
import com.michidex.averno.utiles.Config;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height=Config.ALTO;
		config.width=Config.ANCHO;
		new LwjglApplication(new Averno(), config);
	}
}

