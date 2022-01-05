package com.michidex.averno.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.michidex.averno.elementos.Acotacion;
import com.michidex.averno.elementos.Escena;
import com.michidex.averno.elementos.Imagen;
import com.michidex.averno.escenas.AcotacionesSalaUno;
import com.michidex.averno.io.Entradas;
import com.michidex.averno.objetos.Objetos;
import com.michidex.averno.personajes.Enzo;
import com.michidex.averno.personajes.Marisa;
import com.michidex.averno.utiles.Config;
import com.michidex.averno.utiles.Escenas;
import com.michidex.averno.utiles.Global;
import com.michidex.averno.utiles.Recursos;
import com.michidex.averno.utiles.Render;

public class SalaUno implements Screen{
	private Entradas entradas = new Entradas();
	private SpriteBatch b;
	private Imagen fondo;
	private Escena escena;
	private int opc = 0;
	private boolean flag=false;
	private Escena[] acotaciones = new Acotacion[AcotacionesSalaUno.values().length];
	private String[] rutasObj = new String[] {"Objetos/Boton de luz.png","Objetos/Florero mesa.png","Objetos/Puerta.png","Objetos/Escritorio computadora.png","Objetos/Puerta.png","Objetos/Ascensor.png","Imagenes/Proximamente.png"};
	private Imagen[] objetos = new Imagen[rutasObj.length];
	
	
	
	@Override
	public void show() {
		
		b = Render.batch;
		Gdx.input.setInputProcessor(entradas);
		fondo = new Imagen(Recursos.SALAUNO);
		fondo.setPosicion((Config.ANCHO/2)-(fondo.getAncho()/2), 0);
		for (int i = 0; i < objetos.length; i++) {
			objetos[i] = new Imagen(rutasObj[i]);
		}
		objetos[0].setPosicion(377f, 178f);
		objetos[1].setPosicion(446f, Recursos.ALTURAP);
		objetos[2].setPosicion(566f, Recursos.ALTURAP);
		objetos[3].setPosicion(1202f, Recursos.ALTURAP);
		objetos[4].setPosicion(886, Recursos.ALTURAP);
		objetos[5].setPosicion(146, Recursos.ALTURAP);
		objetos[6].setPosicion(100, 0);
		
		escena = new Escena(Escenas.escena1,Escenas.escena1P);
		for (int i = 0; i < AcotacionesSalaUno.values().length; i++) {
			acotaciones[i] = new Acotacion(AcotacionesSalaUno.values()[i].getDialogo(),AcotacionesSalaUno.values()[i].isPersonaje());
		}
		for (int i = 0; i < Objetos.values().length; i++) {
			Recursos.inventario1.add(Objetos.values()[i]);
		}
		for (int i = 0; i < Objetos.values().length; i++) {
			Recursos.inventario2.add(Objetos.values()[i]);
		}
		if(Config.personaje) {
			Global.p = new Enzo();
			Global.p2 = new Marisa();
		}else{
			Global.p = new Marisa();
			Global.p2 = new Enzo();
		}
		
	}

	@Override
	public void render(float delta) {
		Render.limpiarPantalla(0,0,0);
		b.begin();
			dibujarObjetos(delta); 
			if(!Recursos.escenaTerminada) {
				escena.mostrarDialogo(entradas.isF());
			}
			if(Global.asc) {
				objetos[6].dibujar();
			}
//			else if(!unaVez){
//				
//				dibujarObjetos(delta);
//				opc=0;
//				unaVez=true;
//			}
		
			if(Global.acotacion1) {
				if(Global.nro == 0) {
					dibujarAcotacion(0,delta);
				}
				if(Global.nro == 1) {
					dibujarAcotacion(1,delta);
				}
				if(Global.nro == 2) {
					dibujarAcotacion(2,delta);
				}
			}
			if(Global.acotacion2){
				if(Global.nro == 0) {
					dibujarAcotacion(0,delta);
				}
				if(Global.nro == 1) {
					dibujarAcotacion(1,delta);
				}
				if(Global.nro == 2) {
					dibujarAcotacion(2,delta);
				}
			
			// Aca tengo el punto x y le sumo el ancho para saber el area donde se encuentra el objeto (Colision muy trucha)
			//Posicion x personaje menor o igual x del objeto+ancho del objeto(area) && posicion personaje mayor o igual al punto x del objeto
//			

			}
		b.end();
	}

	public void dibujarObjetos(float delta) {
		fondo.dibujar();
		for (int i = 0; i < objetos.length-1; i++) {
			objetos[i].dibujar();
		}
		Global.p.caminar(entradas);
		procesarCaminar();
		
	}
	

	public void dibujarAcotacion(int i,float delta) {
		if(Gdx.input.isKeyJustPressed(Keys.F)||flag) {
			flag = true;
			
			do {
			acotaciones[i].mostrarDialogo(flag);
			opc++;
			}while(opc<1000);
		}if(Gdx.input.isKeyJustPressed(Keys.G)) {
			flag=false;
			dibujarObjetos(delta);
		}
	}
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	public void procesarCaminar() {
		
		if(Global.d1==true) {
			Global.p.getAnimaciones()[2].dibujarAnimacion(Global.posicionX1, Recursos.ALTURAP);
		} 
		if(Global.d2==true) {
			Global.p2.getAnimaciones()[2].dibujarAnimacion(Global.posicionX2, Recursos.ALTURAP);
			
		}
		if(Global.i1==true) {
			Global.p.getAnimaciones()[3].dibujarAnimacion(Global.posicionX1, Recursos.ALTURAP);
		} 
		if(Global.i2==true) {
			Global.p2.getAnimaciones()[3].dibujarAnimacion(Global.posicionX2, Recursos.ALTURAP);
			
		}
		if(Global.d1==false&&Global.i1==false) {
			if(Global.direccion1) {
				Global.p.getAnimaciones()[0].dibujarAnimacion(Global.posicionX1,  Recursos.ALTURAP);
			}else {
				Global.p.getAnimaciones()[1].dibujarAnimacion(Global.posicionX1,  Recursos.ALTURAP);
			}
		}
		if(Global.d2==false&&Global.i2==false) {
			if(Global.direccion2) {
				Global.p2.getAnimaciones()[0].dibujarAnimacion(Global.posicionX2,  Recursos.ALTURAP);
			}else {
				Global.p2.getAnimaciones()[1].dibujarAnimacion(Global.posicionX2,  Recursos.ALTURAP);
			}
			
		}
	}
}
