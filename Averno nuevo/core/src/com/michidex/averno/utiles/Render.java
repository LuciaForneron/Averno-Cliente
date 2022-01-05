package com.michidex.averno.utiles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.michidex.averno.Averno;
import com.michidex.averno.personajes.Personaje;

public class Render {

	public static SpriteBatch batch;
	public static Averno averno;
	public static void limpiarPantalla(float r, float g, float b) {
		Gdx.gl.glClearColor(r, g, b, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
}
