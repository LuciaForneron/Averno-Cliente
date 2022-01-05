package com.michidex.averno.dialogos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Align;
import com.michidex.averno.elementos.Imagen;
import com.michidex.averno.elementos.Texto;
import com.michidex.averno.utiles.Config;
import com.michidex.averno.utiles.Recursos;

public abstract class CuadroDialogo {
	
	private Imagen cuadro;
	private Texto dialogo;
	
	public CuadroDialogo(String rutaCuadro, String dialogo) {
		
		cuadro = new Imagen(rutaCuadro);
		this.dialogo = new Texto(Recursos.FUENTEMENU,20,new Color((186/ 255f),(144/ 255f),(101/ 255f),1),true,dialogo);
	}
	
	public void dibujar() {
		cuadro.setPosicion(Config.DIALOGOX, Config.DIALOGOY);
		dialogo.setPosicion(697, 125);
		cuadro.dibujar();
		dialogo.dibujar();
		
	}
}
