package com.michidex.averno.escenas;

import com.michidex.averno.utiles.Config;

public enum AcotacionesSalaUnoDos{
	CUADRO("Hay algo escrito aca."),CAJABOTONES("Mmm...Una caja con letras.\n Tendre  que escribir algo?"),CAJA("Esta cerrada, debe de haber \n una llave por ahi."),ARMARIO("Hay una bocha de cosas aca..."),ARMARIO2("Que lindo respirar aire fresco uff.");
	
	private String dialogo;
	private boolean personaje;
	
	AcotacionesSalaUnoDos(String dialogo){
		this.dialogo=dialogo;
		this.personaje=Config.personaje;
	}
	public String getDialogo() {
		return dialogo;
	}
	public boolean isPersonaje() {
		return personaje;
	}
}
