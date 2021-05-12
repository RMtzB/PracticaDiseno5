package mx.uam.is.practicadiseno;

import mx.uam.is.practicadiseno.negocio.Manejador;
import mx.uam.is.practicadiseno.vista.Ventana;

public class ManejadorProxy implements Manejador {
	private Manejador manejador;
	
	public ManejadorProxy(Manejador manejador) {
		this.manejador = manejador;
	}
	
	@Override
	public String[] dameDatos() {
		System.out.println("Se invoco el metodo dameDatos()");
		return manejador.dameDatos();
	}

	@Override
	public boolean agrega(String dato) {
		System.out.println("Se invoco el metodo agrega(String dato)");
		return manejador.agrega(dato);
	}

	@Override
	public boolean borra(String dato) {
		System.out.println("Se invoco el metodo borra(String dato)");
		return manejador.borra(dato);
	}

	@Override
	public void finaliza(Ventana o) {
		System.out.println("Se invoco el metodo finaliza(Ventana o)");
		manejador.finaliza(o);
	}

	@Override
	public boolean agregaObservador(Observador o) {
		System.out.println("Se invoco el metodo agregarObservador(Observador o)");
		return manejador.agregaObservador(o);
	}

	@Override
	public boolean quitaObservador(Observador o) {
		System.out.println("Se invoco el metodo quitaObservador(Observador o)");
		return manejador.quitaObservador(o);
	}
}
