package com.michidex.averno.personajes;

import com.michidex.averno.elementos.Animacion;
import com.michidex.averno.utiles.Global;
import com.michidex.averno.utiles.Recursos;

public class Monstruo extends Personaje{
	
	private boolean ataque;
	private float tiempo;
	private boolean bandera;
	public Monstruo() {
		super("Monstruo", Recursos.ANIMACIONESMONS,Recursos.ANIMACIONESMONS.length);
		
	}
	public void caminarMons(boolean estado) {
		//Si es el ataque tengo que sumarle 153 porque el sprite del ataque es muy ancho y causa problemas, lo mismo con los otros
		// si la posicion en si p.x es mayor a m.x camina a la derecha ó p.x mayor a la mA.x+153 y ataque true
		if(estado) {
			if(!Global.mDes) {
				if(Global.mLP) {
					this.animaciones[3].dibujarAnimacion(Global.posicionXM, Recursos.ALTURAP);
				}if(Global.mNoP) {
					this.animaciones[2].dibujarAnimacion(Global.posicionXM, Recursos.ALTURAP);
				}
			}else {
				Global.bandera=true;
			}
		}else {
			if(Global.mD) {
				this.animaciones[2].dibujarAnimacion(Global.posicionXM, Recursos.ALTURAP);
			}else if(Global.mI) {
				this.animaciones[3].dibujarAnimacion(Global.posicionXM, Recursos.ALTURAP);
			}if(Global.mAt) {
				this.animaciones[4].dibujarAnimacion(Global.posicionXM,Recursos.ALTURAP);
				
			}
		}
	}
	public boolean isBandera() {
		return bandera;
	}
}

