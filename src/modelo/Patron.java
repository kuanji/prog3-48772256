package modelo;

import java.util.Collection;

import modelo.excepciones.ExcepcionArgumentosIncorrectos;
import modelo.excepciones.ExcepcionPosicionFueraTablero;

/**
 * Clase Patron: En esta clase guardamos un patron para despues poder introducirlo en el tablero donde se ejecutara el juego de la vida.
 * 
 * @author Juan Carlos Lopez Gutierrez    48772256C
 * @version 1.0.0
 */
public class Patron {

	/**
	 * Variable donde guardamos el nombre del patron.
	 */
	private String nombre;
	
	/**
	 * Variable tablero donde almacenamos el patron.
	 */
	Tablero tablero;
	
	/**
	 * Constructor: asigna los valores a sus respectivas variables privadas.
	 * 
	 * @param nombre nombre del patron
	 * @param tablero tablero donde almacenaremos el patron
	 */
	public Patron(String nombre, Tablero tablero) {
	    if(nombre == null)
	        throw new ExcepcionArgumentosIncorrectos("No tiene nombre.");
	    if(tablero == null)
            throw new ExcepcionArgumentosIncorrectos("Tablero no apunta a ningún sitio.");
		this.nombre = nombre;
		this.tablero = tablero;
	}
	
	/**
	 * Getter.
	 * 
	 * @return nombre del patron.
	 */
	public String getNombre() {return this.nombre;}
	
	/**
	 * Busca el estado de una celda en el hashMap de la variable tablero.
	 * 
	 * @param coordenada coordenada de la celda que queremos buscar.
	 * @return estado de la celda en esa posicion.
	 * @throws ExcepcionPosicionFueraTablero 
	 */
	public EstadoCelda getCelda(Coordenada coordenada) throws ExcepcionPosicionFueraTablero {
	    if(coordenada == null)
            throw new ExcepcionArgumentosIncorrectos("Coordenada no apunta a ningun sitio.");
	        return tablero.getCelda(coordenada);
	}
	
	/**
	 * Getter.
	 * 
	 * @return devuelve una Collection con todas las coordenadas que componen el patron.
	 */
	public Collection<Coordenada> getPosiciones(){return tablero.getPosiciones();}

	/**
	 * Redefinimos la funcion toString para que nos devuelva un string con la informacion del patron.
	 * 
	 * @return devuelve la informacion del patron.
	 */
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nombre);
		sb.append("\n");
		sb.append(tablero.toString());
		return sb.toString();
	}
}
