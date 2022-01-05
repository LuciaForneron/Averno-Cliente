package com.michidex.averno.io;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.michidex.averno.red.Cliente;
import com.michidex.averno.red.HiloCliente;
import com.michidex.averno.utiles.Render;

public class Entradas implements InputProcessor{

	private boolean arriba, abajo, enter,enter2,f,fIzq,fDer,g,fDos,michidex;
	private boolean mTip,iTip,cTip,hTip,dTip,eTip,xTip;

	public boolean isCTip() {
		return cTip;
	}public boolean isDTip() {
		return dTip;
	}public boolean isETip() {
		return eTip;
	}public boolean isHTip() {
		return hTip;
	}public boolean isITip() {
		return iTip;
	}public boolean isMTip() {
		return mTip;
	}public boolean isXTip() {
		return xTip;
	}
	public boolean isMichidex() {
		return michidex;
	}
	public void setFDos(boolean fDos) {
		this.fDos = fDos;
	}
	public boolean isF() {
		return f;
	}
	public boolean isFDos() {
		return fDos;
	}
	public boolean isEnter() {
		return enter;
	}
	
	public boolean isAbajo() {
		return abajo;
	}
	
	public boolean isArriba() {
		return arriba;
	}
	public boolean isFDer() {
		return fDer;
	}
	public boolean isFIzq() {
		return fIzq;
	}public boolean isG() {
		return g;
	}public boolean isEnter2() {
		return enter2;
	}
	

	public boolean keyDown(int keycode) {
		
		
		if(keycode == Keys.DOWN) {
			abajo = true;
		} else if(keycode == Keys.UP) {
			arriba = true;
		}else if(keycode == Keys.ENTER) {
			enter2 = true;
			enter = true;
		}else if(keycode == Keys.F) {
			f = true;
			fDos=true;
		}else if(keycode == Keys.LEFT) {
			fIzq = true;
		}else if(keycode == Keys.RIGHT) {
			fDer = true;
		}else if(keycode == Keys.G) {
			g = true;
		}else if(keycode == Keys.M) {
			mTip= true;
		}else if(keycode == Keys.I) {
			iTip = true;
		}else if(keycode == Keys.C) {
			cTip = true;
		}else if(keycode == Keys.H) {
			hTip = true;
		}else if(keycode == Keys.D) {
			dTip= true;
		}else if(keycode == Keys.E) {
			eTip = true;
		}else if(keycode == Keys.X) {
			xTip = true;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(keycode == Keys.DOWN) {
			abajo = false;
		}
		if(keycode == Keys.UP) {
			arriba = false;
		}
		if(keycode == Keys.ENTER) {
			enter = false;
		}if(keycode == Keys.F) {
//			if(Render.averno.getCliente().getHc()!=null) {
//				Render.averno.getCliente().enviarMensaje("NoF"+"!"+Render.averno.getCliente().getId());
//			}
			f = false;
		}if(keycode == Keys.LEFT) {
			if(Render.averno.getCliente().getHc()!=null) {
				Render.averno.getCliente().enviarMensaje("NoApreteIzquierda"+"!"+Render.averno.getCliente().getId());
			}
			fIzq = false;
		}if(keycode == Keys.RIGHT) {
			if(Render.averno.getCliente().getHc()!=null) {
				Render.averno.getCliente().enviarMensaje("NoApreteDerecha"+"!"+Render.averno.getCliente().getId());
			}	
			fDer = false;
		}if(keycode == Keys.G) {
//			if(Render.averno.getCliente().getHc()!=null) {
//				Render.averno.getCliente().enviarMensaje("NoG"+"!"+Render.averno.getCliente().getId());
//			}
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {

		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
