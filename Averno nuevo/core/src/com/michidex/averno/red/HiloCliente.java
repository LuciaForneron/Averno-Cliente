package com.michidex.averno.red;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.michidex.averno.utiles.Config;
import com.michidex.averno.utiles.Global;
import com.michidex.averno.utiles.Recursos;
import com.michidex.averno.utiles.Render;

public class HiloCliente extends Thread{

	private DatagramSocket conexion;
	private InetAddress ipServer;
	private int puerto = 2008;
	private boolean fin;
	
	public HiloCliente() {
		try {
			ipServer = InetAddress.getByName("LUCIA");
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			conexion = new DatagramSocket();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			enviarMensaje("Conexion");
	}
	
	public void enviarMensaje(String msg) {
		byte[] data = msg.getBytes();
		DatagramPacket dp = new DatagramPacket(data,data.length,ipServer,puerto);
		try {
			if(conexion.isClosed()) {
				conexion.connect(ipServer, puerto);
			}
			conexion.send(dp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void run(){
		do {
			byte[] data = new byte[1024];
			DatagramPacket dp = new DatagramPacket(data,data.length);
			try {
				conexion.receive(dp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			procesarMensaje(dp);
		}while(!fin);
	}
	private void procesarMensaje(DatagramPacket dp) {
		String msg = (new String(dp.getData())).trim();
		
		String mensaje[] = msg.split("!");
		if(mensaje[0].equals("Ok")) {
			ipServer = dp.getAddress();
			Render.averno.getCliente().setId(Integer.valueOf(mensaje[1]));
		} 
		if(msg.equals("Empieza")) {
			Config.empieza=true;
		} 
//		if(mensaje[0].equals("Cerro")) {
//			Config.empieza=false;
//			Render.averno.setElegir(true);
//			fin=true;
//		}
		if(mensaje[0].equals("P")) {
			if(mensaje[1].equals("Enzo")) {
				Config.personaje=true;
			}
			if(mensaje[1].equals("Marisa")){
				Config.personaje=false;
			}
			Render.averno.setUno(true);
		}
	    if(mensaje[0].equals("CP")) {
			if(Integer.valueOf(mensaje[1])==Render.averno.getCliente().getId()) {
				Global.d1=false;
				Global.i1=false;
				Global.direccion1=(Boolean.valueOf(mensaje[2]));
			}
			if(Integer.valueOf(mensaje[1])!=Render.averno.getCliente().getId()) {
				Global.d2=false;
				Global.i2=false;
				Global.direccion2=(Boolean.valueOf(mensaje[2]));
			}
	    }
		if(mensaje[0].equals("CD")) {
			if(Integer.valueOf(mensaje[1])==Render.averno.getCliente().getId()) {
				Global.d1=true;
				Global.posicionX1=(Float.valueOf(mensaje[2]));
			}if(Integer.valueOf(mensaje[1])!=Render.averno.getCliente().getId()) {
				Global.d2=true;
				Global.posicionX2=(Float.valueOf(mensaje[2]));
			}
		}
		if(mensaje[0].equals("CI")) {
			if(Integer.valueOf(mensaje[1])==Render.averno.getCliente().getId()) {
				Global.i1=true;
				Global.posicionX1=(Float.valueOf(mensaje[2]));
			}if(Integer.valueOf(mensaje[1])!=Render.averno.getCliente().getId()) {
				Global.i2=true;
				Global.posicionX2=(Float.valueOf(mensaje[2]));
			}
		}
		if(mensaje[0].equals("F")) {
			if(Integer.valueOf(mensaje[1])==0&&Integer.valueOf(mensaje[1])==Render.averno.getCliente().getId()) {
				Global.clienteF = true;
			}if(Integer.valueOf(mensaje[1])==1&&Integer.valueOf(mensaje[1])==Render.averno.getCliente().getId()) {
				Global.cliente2F = true;
			}
		}
		if(mensaje[0].equals("G")) {
			if(Integer.valueOf(mensaje[1])==0&&Integer.valueOf(mensaje[1])==Render.averno.getCliente().getId()) {
				Global.clienteG = true;
			}if(Integer.valueOf(mensaje[1])==1&&Integer.valueOf(mensaje[1])==Render.averno.getCliente().getId()) {
				Global.cliente2G = true;
			}
		}
		if(mensaje[0].equals("NoF")) {
			if(Integer.valueOf(mensaje[1])==0&&Integer.valueOf(mensaje[1])==Render.averno.getCliente().getId()) {
				Global.clienteF = false;
			}if(Integer.valueOf(mensaje[1])==1&&Integer.valueOf(mensaje[1])==Render.averno.getCliente().getId()) {
				Global.cliente2F = false;
			}
		}
		if(mensaje[0].equals("NoG")) {
			if(Integer.valueOf(mensaje[1])==0&&Integer.valueOf(mensaje[1])==Render.averno.getCliente().getId()) {
				Global.clienteG = false;
			}if(Integer.valueOf(mensaje[1])==1&&Integer.valueOf(mensaje[1])==Render.averno.getCliente().getId()) {
				Global.cliente2G = false;
			}
		}
		if(mensaje[0].equals("Sala")) {
			if(mensaje[1].equals("UnoDos")) {
					Render.averno.setUnoDos(true);
			}
			if(mensaje[1].equals("Uno")) {
					Render.averno.setUno(true);
			}
		}
		if(mensaje[0].equals("Llave")) {
			if(Integer.valueOf(mensaje[1])==0&&Integer.valueOf(mensaje[1])==Render.averno.getCliente().getId()) {
				Recursos.inventario1.get(0).setEstado(true);
			}
			if(Integer.valueOf(mensaje[1])==1&&Integer.valueOf(mensaje[1])==Render.averno.getCliente().getId()) {
				Recursos.inventario2.get(0).setEstado(true);
			}
		} 
		
//System.out.println("El mensaje: "+msg+" *");
		
		if(mensaje[0].equals("Placa")) {
			if(Integer.valueOf(mensaje[1])==0&&Integer.valueOf(mensaje[1])==Render.averno.getCliente().getId()) {
				Global.placa1 = true;
			}
			if(Integer.valueOf(mensaje[1])==1&&Integer.valueOf(mensaje[1])==Render.averno.getCliente().getId()) {
				Global.placa2 = true;
			}
		}
		if(mensaje[0].equals("Destornillador")) {
			if(Integer.valueOf(mensaje[1])==0&&Integer.valueOf(mensaje[1])==Render.averno.getCliente().getId()) {
				Global.des1 = true;
			}
			if(Integer.valueOf(mensaje[1])==1&&Integer.valueOf(mensaje[1])==Render.averno.getCliente().getId()) {
				Global.des2 = true;
			}
		}
		if(mensaje[0].equals("CajaBotones")) {
			if(Integer.valueOf(mensaje[1])==0&&Integer.valueOf(mensaje[1])==Render.averno.getCliente().getId()) {
				Global.cajaB1 = true;
			}
			if(Integer.valueOf(mensaje[1])==1&&Integer.valueOf(mensaje[1])==Render.averno.getCliente().getId()) {
				Global.cajaB2 = true;
			}
		}
		if(mensaje[0].equals("Adentro")) {
			Global.adentro=true;
		}
		if(mensaje[0].equals("AfueraObjeto")) {
			if(Integer.valueOf(mensaje[1])==0&&Integer.valueOf(mensaje[1])==Render.averno.getCliente().getId()) {
				Global.afuera1=true;
			}
			if(Integer.valueOf(mensaje[1])==1&&Integer.valueOf(mensaje[1])==Render.averno.getCliente().getId()) {
				Global.afuera2=true;
			}
		}
		if(mensaje[0].equals("AdentroF")) {
				Global.adentro=false;
		}
		if(mensaje[0].equals("BanderaT")) {
			Global.bandera=false;
		}
		if(mensaje[0].equals("FalseAfueraObjeto")) {
			if(Integer.valueOf(mensaje[1])==0&&Integer.valueOf(mensaje[1])==Render.averno.getCliente().getId()) {
				Global.afuera1=false;
			}
			if(Integer.valueOf(mensaje[1])==1&&Integer.valueOf(mensaje[1])==Render.averno.getCliente().getId()) {
				Global.afuera2=false;
			}
		}
		if(mensaje[0].equals("Error")) {
			Global.error = true;
		}
		if(mensaje[0].equals("M")){
			Global.clienteM = true;
			
		}
		if(mensaje[0].equals("I")){
			Global.clienteI= true;
			
		}
		if(mensaje[0].equals("C")){
			Global.clienteC = true;
			
		}
		if(mensaje[0].equals("H")){
			Global.clienteH = true;
			
		}
		if(mensaje[0].equals("D")){
			Global.clienteD = true;
			
		}
		if(mensaje[0].equals("E")){
			Global.clienteE = true;
			
		}
		if(mensaje[0].equals("X")){
			Global.clienteX = true;
			
		}
		
		//mensajes monstruo
		
//		System.out.println("EL MENSAJE ES: "+msg+"*");
		if(mensaje[0].equals("Mons")) {
			if(mensaje[1].equals("Der")) {
				Global.mD=true;
				Global.posicionXM=(Float.valueOf(mensaje[2]));
			}
			if(mensaje[1].equals("Izq")) {
				Global.mI=true;
				Global.posicionXM=(Float.valueOf(mensaje[2]));
			}
			if(mensaje[1].equals("Ataque")) {
				Global.mAt=true;
				Global.posicionXM=(Float.valueOf(mensaje[2]));
			}
			if(mensaje[1].equals("Desaparece")) {
				Global.mDes=true;
				Global.mP=true;
			}
			if(mensaje[1].equals("AdentroDer")) {
				Global.mLP=true;
				Global.posicionXM=(Float.valueOf(mensaje[2]));
			}
			if(mensaje[1].equals("AdentroIzq")) {
				Global.mNoP=true;
				Global.posicionXM=(Float.valueOf(mensaje[2]));
			}
			
		}
		
		//ACOTACIONES
		
		if(mensaje[0].equals("Acotacion")) {
			if(Integer.valueOf(mensaje[2])==0) {
				Global.acotacion1 = true;
				if(mensaje[1].equals("0")) {
					Global.nro=0;
				}
				if(mensaje[1].equals("1")) {
					Global.nro=1;
				}
				if(mensaje[1].equals("2")) {
					Global.nro=2;
				}
			}if(Integer.valueOf(mensaje[2])==1) {
				Global.acotacion2 = true;
				if(mensaje[1].equals("0")) {
					Global.nro=0;
				}
				if(mensaje[1].equals("1")) {
					Global.nro=1;
				}
				if(mensaje[1].equals("2")) {
					Global.nro=2;
				}
			}
		}
			
			//SALIDA

			if(mensaje[0].equals("Ascensor")) {
				
				Global.asc = true;
				
			}
			
		}
		
	}

