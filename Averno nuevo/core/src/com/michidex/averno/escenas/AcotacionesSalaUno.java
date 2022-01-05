package com.michidex.averno.escenas;

import com.michidex.averno.utiles.Config;
import com.michidex.averno.utiles.Render;

public enum AcotacionesSalaUno {

	BOTON("No funciona"),FLORERO("Hay algo dentro...Una llave"),ESCRITORIO("Esta apagada");
	
	private String dialogo;
	private boolean personaje;
	
	AcotacionesSalaUno(String dialogo) {
		this.dialogo=dialogo;
			this.personaje = Config.personaje;
	}
	public String getDialogo() {
		return dialogo;
	}
	public boolean isPersonaje() {
		return personaje;
	}
}
