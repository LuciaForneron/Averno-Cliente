package com.michidex.averno.red;

public class Cliente {
	
	private HiloCliente hc;
	private int id;
	
	public void enviarMensaje(String msg) {
		this.hc.enviarMensaje(msg);
	}
	public void crearHilo() {
		hc = new HiloCliente();
		hc.start();
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}public HiloCliente getHc() {
		return hc;
	}
}