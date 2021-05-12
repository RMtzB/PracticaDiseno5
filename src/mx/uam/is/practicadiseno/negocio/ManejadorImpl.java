package mx.uam.is.practicadiseno.negocio;

import java.util.ArrayList;
import java.util.List;

import mx.uam.is.practicadiseno.Observador;
import mx.uam.is.practicadiseno.datos.MapeadorDatos;
import mx.uam.is.practicadiseno.vista.Ventana;

public class ManejadorImpl implements Manejador {
	private MapeadorDatos mapeadorDatosImpl;
	private List<Observador> suscriptores;
	
	/**
	 * Constructor conecta el mapeadorDatos
	 *
	 */
	public ManejadorImpl(MapeadorDatos mapeadorDatosImpl) {
		this.mapeadorDatosImpl = mapeadorDatosImpl;
		suscriptores = new ArrayList<>();
	}

	/**
	 * Metodo llamado cuando se cierra la ventana
	 *
	 */
	public void finaliza(Ventana o) {
		if(0 < suscriptores.size()) {
			o.dispose();
		} else {
			System.exit(0);
		}
	}

	@Override
	public String[] dameDatos() {
		return mapeadorDatosImpl.dameDatos();
	}

	@Override
	public boolean agrega(String dato) {
		if(mapeadorDatosImpl.agrega(dato)) {
			notifica();
			
			return true;
		}
		
		return false;
	}

	@Override
	public boolean borra(String dato) {
		if(mapeadorDatosImpl.borra(dato)) {
			notifica();
			
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean agregaObservador(Observador o) {
		// agregar un observador a la lista de observadores
		return suscriptores.add(o);
	}

	@Override
	public boolean quitaObservador(Observador o) {
		// quitar un observador de la lista de observadores
		return suscriptores.remove(o);
	}

	private void notifica() {
		// llamar actualiza() sobre todos los observadores
		for(int i = 0; i < suscriptores.size(); i++) {
			suscriptores.get(i).actualiza();
		}
	}

}
