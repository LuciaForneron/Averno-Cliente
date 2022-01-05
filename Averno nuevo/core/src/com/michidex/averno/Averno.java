package com.michidex.averno;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.michidex.averno.pantallas.PantallaElegir;
import com.michidex.averno.pantallas.PantallaInicio;
import com.michidex.averno.pantallas.SalaDos;
import com.michidex.averno.pantallas.SalaUno;
import com.michidex.averno.pantallas.SalaUnoDos;
import com.michidex.averno.red.Cliente;
import com.michidex.averno.utiles.Assets;
import com.michidex.averno.utiles.Render;

public class Averno extends Game {
	private Cliente cliente;
	private boolean elegir,uno,unoDos,dos;
	private PantallaElegir ele;
	private SalaUno s1;
	private SalaUnoDos s12;
	private SalaDos s2;
	@Override
	public void create () {
		Assets.load();
		Assets.manager.finishLoading();
		Render.averno = this;
		Render.batch = new SpriteBatch();
		this.setScreen(new PantallaInicio());
		cliente = new Cliente();
	}

	@Override
	public void render () {
		super.render();
		if(elegir) {
			elegir();
		}if(uno) {
			salaUno();
		}if(unoDos) {
			salaUnoDos();
		}if(dos) {
			salaDos();
		}
	}
	
	@Override
	public void dispose () {
		cliente.getHc().enviarMensaje("Cerro"+"!"+cliente.getId());
		cliente=null;
		Render.batch.dispose();
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void elegir() {
		screen.dispose();
		this.setScreen(ele = new PantallaElegir());
		elegir=false;
		super.render();
	}
	public void salaUno() {
		screen.dispose();
		this.setScreen(s1 = new SalaUno());
		uno=false;
		super.render();
	}
	public void salaUnoDos() {
		screen.dispose();
		this.setScreen(s12 = new SalaUnoDos());
		unoDos=false;
		super.render();
	}
	public void salaDos() {
		screen.dispose();
		this.setScreen(s2 = new SalaDos());
		dos=false;
		super.render();
	}
	public void setDos(boolean dos) {
		this.dos = dos;
	}public void setUno(boolean uno) {
		this.uno = uno;
	}public void setUnoDos(boolean unoDos) {
		this.unoDos = unoDos;
	}public void setElegir(boolean elegir) {
		this.elegir = elegir;
	}
}
