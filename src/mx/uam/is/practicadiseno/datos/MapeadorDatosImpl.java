package mx.uam.is.practicadiseno.datos;

import java.util.ArrayList;
import java.util.List;

public class MapeadorDatosImpl implements MapeadorDatos {
	// La estructura que contiene los datos
	private List<String> datos = new ArrayList<String>();

	public MapeadorDatosImpl() {
		datos.add("Entrada 1");
		datos.add("Entrada 2");
		datos.add("Entrada 3");
	}

	/**
	 * Agrega un dato mientras no este vacio y no este ya en la lista
	 *
	 * @param dato el dato a agregar
	 * @return true si se agrego exitosamente false sino
	 */
	@Override
	public boolean agrega(String dato) {
		if (!dato.equals("") && !datos.contains(dato)) {
			datos.add(dato);

			return true;
		}

		return false;
	}

	/**
	 * Borra un dato de la list
	 *
	 * @param dato el dato a borrar
	 * @return true si se borro exitosamente, false sino
	 */
	@Override
	public boolean borra(String dato) {
		return datos.remove(dato);
	}

	/**
	 * Recupera los datos
	 *
	 * @return la lista de datos
	 */
	@Override
	public String[] dameDatos() {
		// Convierte la lista a un arreglo de cadenas y lo regresa
		String arregloDatos[] = new String[datos.size()];
		datos.toArray(arregloDatos);

		return arregloDatos;
	}

	/**
	 * Checa si un dato esta presente
	 *
	 * @param dato
	 * @return
	 */
	@Override
	public boolean contiene(String dato) {
		return datos.contains(dato);
	}

}
