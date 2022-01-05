package com.michidex.averno.pantallas;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.michidex.averno.elementos.Acotacion;
import com.michidex.averno.elementos.Escena;
import com.michidex.averno.elementos.Imagen;
import com.michidex.averno.elementos.Texto;
import com.michidex.averno.escenas.AcotacionesSalaUnoDos;
import com.michidex.averno.io.Entradas;
import com.michidex.averno.personajes.Enzo;
import com.michidex.averno.personajes.Marisa;
import com.michidex.averno.personajes.Monstruo;
import com.michidex.averno.personajes.Personaje;
import com.michidex.averno.utiles.Config;
import com.michidex.averno.utiles.Global;
import com.michidex.averno.utiles.Recursos;
import com.michidex.averno.utiles.Render;

public class SalaUnoDos implements Screen {

	Entradas entradas = new Entradas();
	SpriteBatch b;
	Imagen fondo;
	private boolean flag,flag2,fin=false,completado,adentro=false,bandera,adentro2,bandera2;
	private float opc,tiempo,time,tempo;
	private Texto salir;
	private Monstruo m;
	private Escena[] acotaciones = new Acotacion[AcotacionesSalaUnoDos.values().length];
	private String[] rutas = new String[] {"Objetos/Puerta.png","Objetos/cuadro sala dos.png","Objetos/placa cuadro.png","Objetos/caja.png","Objetos/Caja de letras.png","Objetos/Armario.png ","Imagenes/imagen caja.png","Imagenes/Imagen placa.png","Imagenes/Imagen caja de letras.png","Imagenes/Imagen caja de letras error.png","Imagenes/Imagen caja de letras exito.png"};
	private Imagen[] objetos = new Imagen[rutas.length];
	private String[] rMichidex = new String[] {"Imagenes/m.png","Imagenes/mi.png","Imagenes/mic.png","Imagenes/mich.png","Imagenes/michi.png","Imagenes/michid.png","Imagenes/michide.png","Imagenes/michidex.png"};
	private Imagen[] objMichidex = new Imagen[rMichidex.length];
	
	@Override
	public void show() {
		b = Render.batch;
		Gdx.input.setInputProcessor(entradas);
		fondo = new Imagen(Recursos.SALAUNODOS);
		fondo.setPosicion((Config.ANCHO/2)-(fondo.getAncho()/2), 0);
		for (int i = 0; i < objetos.length; i++) {
			objetos[i] = new Imagen(rutas[i]);
		}
		for (int i = 0; i < objMichidex.length; i++) {
			objMichidex[i] = new Imagen(rMichidex[i]);
		}
		m = new Monstruo();
		objetos[0].setPosicion(400f,Recursos.ALTURAP);
		objetos[1].setPosicion(140f, 168f);
		objetos[2].setPosicion(206f, 150f);
		objetos[3].setPosicion(766f, 120f);
		objetos[4].setPosicion(1166f, 199f);
		objetos[5].setPosicion(1324, 12);
		objetos[6].setPosicion(100, 0);
		objetos[7].setPosicion(100, 0);
		objetos[8].setPosicion(100, 0);
		objetos[9].setPosicion(100, 0);
		objetos[10].setPosicion(100, 0);
		objMichidex[0].setPosicion(100, 0);
		objMichidex[1].setPosicion(100, 0);
		objMichidex[2].setPosicion(100, 0);
		objMichidex[3].setPosicion(100, 0);
		objMichidex[4].setPosicion(100, 0);
		objMichidex[5].setPosicion(100, 0);
		objMichidex[6].setPosicion(100, 0);
		objMichidex[7].setPosicion(100, 0);
		for (int i = 0; i < acotaciones.length; i++) {
			acotaciones[i] = new Acotacion(AcotacionesSalaUnoDos.values()[i].getDialogo(),AcotacionesSalaUnoDos.values()[i].isPersonaje());
		}
		
	}

	@Override
	public void render(float delta) {
		Render.limpiarPantalla(0, 0, 0);
		b.begin();
		 	dibujarObjetos();
		 	if(completado&&!Global.bandera) {
		 		m.caminarMons(Global.adentro);
		 	}
		 
		 		
		 		if(Global.clienteF) {
		 			if(Global.placa1) {
		 				objetos[7].dibujar();
		 				acotaciones[0].mostrarDialogo(Config.personaje);
		 			}
		 			if(Global.des1&&Recursos.inventario1.get(0).isEstado()){
		 				objetos[6].dibujar();
		 				acotaciones[2].mostrarDialogo(Config.personaje);
		 				
		 			}
		 			if(Global.cajaB1&&!completado){
		 				objetos[8].dibujar();
		 				acotaciones[1].mostrarDialogo(Config.personaje);
		 				procesarLetras();
		 				
		 			}
		 			
		 			if(Global.afuera1) {
		 				Global.placa1 = false;
		 				Global.des1 = false;
		 				Global.cajaB1 = false;
		 				Global.adentro=false;
		 			}
		 		}
		 		if(Global.cliente2F) {
		 			if(Global.placa2) {
		 				objetos[7].dibujar();
		 				acotaciones[0].mostrarDialogo(Config.personaje);
//		 				Global.cajaB2 = false;
//		 				Global.aden2 = false;
//		 				Global.des2 = false;

		 			}
		 			if(Global.des2&&Recursos.inventario1.get(0).isEstado()){
		 				objetos[6].dibujar();
		 				acotaciones[2].mostrarDialogo(Config.personaje);
//		 				Global.cajaB2 = false;
//		 				Global.aden2 = false;
//		 				Global.placa2 = false;
		 			}
		 			if(Global.cajaB2&&!completado){
		 				objetos[8].dibujar();
		 				acotaciones[1].mostrarDialogo(Config.personaje);
		 				procesarLetras();
		 			
//		 				Global.aden1 = false;
//		 				Global.placa1 = false;
//		 				Global.des1 = false;
		 				
		 			}
		 			if(Global.afuera2) {
		 				Global.placa2 = false;
		 				Global.des2 = false;
		 				Global.cajaB2 = false;
		 				Global.adentro=false;
		 			}
		 		}
		 	
		 		if(Global.adentro) {
		 			acotaciones[3].mostrarDialogo(Config.personaje);
	 				Global.afuera1=false;
	 				Global.afuera2=false;
	 			}
		 		
		 	if(Global.clienteG||Global.cliente2G) {
		 		
		 		if(Global.adentro) {
		 			acotaciones[4].mostrarDialogo(Config.personaje);
					Global.bandera=true;
					Global.adentro=false;
					Global.afuera1=true;
	 				Global.afuera2=true;
					}
		 	}
		 	
		 	
			b.end();
	}

	public void dibujarObjetos() {
		fondo.dibujar();
		for (int i = 0; i < 4; i++) {
			objetos[i].dibujar();
		}
		Global.p.caminar(entradas);
		if(!Global.adentro) {
		procesarCaminar();
		}
//		if(!adentro2){
//		Global.p2.caminar(entradas);
//		procesarCaminar();
//		}
		
//		procesarCaminar();
		}
	public void dibujarAcotacion(int i) {
		if(entradas.isFDos()) {
			acotaciones[i].mostrarDialogo(flag);
		}if(entradas.isG()) {
			entradas.setFDos(false);
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
		b.dispose();

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
	public void procesarLetras(){
			if(Global.clienteM) {	//M
					objMichidex[0].dibujar();
					
					if(Global.clienteI){    
						objMichidex[1].dibujar();
						
						if(Global.clienteC) {     
							objMichidex[2].dibujar();
							
							if(Global.clienteH) {		
								objMichidex[3].dibujar();
								
								if(Global.clienteI) {
									objMichidex[4].dibujar();  
									
									if(Global.clienteD) {		
										objMichidex[5].dibujar();
										
										if(Global.clienteE) {		
											objMichidex[6].dibujar();
											if(Global.clienteX) {
												objMichidex[7].dibujar();
												objetos[10].dibujar();
												completado=true;
											}if(entradas.isEnter2()) {
												objetos[9].dibujar();
											}
										}if(Global.error) {
											objetos[9].dibujar();
										}
									}if(Global.error) {
										objetos[9].dibujar();
									}
								}if(Global.error) {
									objetos[9].dibujar();
								}
							}if(Global.error) {
								objetos[9].dibujar();
							}
						}if(Global.error) {
							objetos[9].dibujar();
						}
					}if(Global.error) {	
						objetos[9].dibujar();
					}
				}if(Global.error) {	
					objetos[9].dibujar();
				}
		}
	
	}
