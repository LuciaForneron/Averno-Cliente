package com.michidex.averno.personajes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.michidex.averno.elementos.Animacion;
import com.michidex.averno.io.Entradas;
import com.michidex.averno.utiles.Render;

public abstract class Personaje{
	

	protected String nombre;
	protected Animacion[] animaciones;
	protected boolean direccion;
	protected float posicionX =101f;
	
	public Personaje(String nombre,String[]rutaA,int tamaño) {
		animaciones =  new Animacion[tamaño];
		this.nombre=nombre;
		crearAnimaciones(rutaA);
		
	}
	
//	public void dibujar() {
//		sprite.draw(Render.batch);
//	}
	public void crearAnimaciones(String[] rutaA) {
		for (int i = 0; i < animaciones.length; i++) {
			animaciones[i] = new Animacion(rutaA[i]);
		}
	}
	public void caminar(Entradas entradas) {
		if(entradas.isFDer()){
			Render.averno.getCliente().enviarMensaje("ApreteDerecha"+"!"+Render.averno.getCliente().getId());
		}
		if(entradas.isFIzq()){
			Render.averno.getCliente().enviarMensaje("ApreteIzquierda"+"!"+Render.averno.getCliente().getId());
		}
		if(Gdx.input.isKeyJustPressed(Keys.G)) {
			Render.averno.getCliente().enviarMensaje("G"+"!"+Render.averno.getCliente().getId());
			Render.averno.getCliente().enviarMensaje("NoF"+"!"+Render.averno.getCliente().getId());
		}
		if(Gdx.input.isKeyJustPressed(Keys.F)) {
			Render.averno.getCliente().enviarMensaje("F"+"!"+Render.averno.getCliente().getId());
			Render.averno.getCliente().enviarMensaje("NoG"+"!"+Render.averno.getCliente().getId());
		}
		
		if(entradas.isMTip()) {
			Render.averno.getCliente().enviarMensaje("M"+"!"+Render.averno.getCliente().getId());
		}
		if(entradas.isITip()) {
			Render.averno.getCliente().enviarMensaje("I"+"!"+Render.averno.getCliente().getId());
		}
		if(entradas.isCTip()) {
			Render.averno.getCliente().enviarMensaje("C"+"!"+Render.averno.getCliente().getId());
		}
		if(entradas.isHTip()) {
			Render.averno.getCliente().enviarMensaje("H"+"!"+Render.averno.getCliente().getId());
		}
		if(entradas.isDTip()) {
			Render.averno.getCliente().enviarMensaje("D"+"!"+Render.averno.getCliente().getId());
		}
		if(entradas.isETip()) {
			Render.averno.getCliente().enviarMensaje("E"+"!"+Render.averno.getCliente().getId());
		}
		if(entradas.isXTip()) {
			Render.averno.getCliente().enviarMensaje("X"+"!"+Render.averno.getCliente().getId());
		}
		if(entradas.isEnter2()) {
			Render.averno.getCliente().enviarMensaje("Enter"+"!"+Render.averno.getCliente().getId());
		}
		
	}
	
	
	public Animacion[] getAnimaciones() {
		return animaciones;
	}
	public float getPosicionX() {
		return posicionX;
	}
	public void setPosicionX(float posicionX) {
		this.posicionX = posicionX;
	}
	
	
	
}
