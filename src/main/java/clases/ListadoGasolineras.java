package clases;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class ListadoGasolineras {
	@SerializedName("Fecha")
	/* representa la fecha del json */
	private String fecha;
	@SerializedName("ListaEESSPrecio")
	/* representa las gasolineras */
	private ArrayList<Gasolinera> listaEstaciones;
	@SerializedName("Nota")
	/* representa la información del fichero */
	private String nota;
	@SerializedName("ResultadoConsulta")
	/* representa el resultado de la consulta */
	private String resultado;

	/**
	 * Getter de fecha
	 * 
	 * @return devuelve la fecha del json
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Getter de lista de estaciones
	 * 
	 * @return devuelve todas las estaciones de servicio
	 */
	public ArrayList<Gasolinera> getListaEstaciones() {
		return listaEstaciones;
	}

	/**
	 * Getter nota
	 * 
	 * @return devuelve la informacion del json
	 */
	public String getNota() {
		return nota;
	}

	/**
	 * Getter resultado
	 * 
	 * @return devuelve el resultado de la consulta
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * toString de la clase ListadoGasolineras, muestra formateada toda la
	 * información de la misma
	 * 
	 * @return String con toda la información del json y estaciones de servicio
	 */
	@Override
	public String toString() {
		return "Gasolineras [fecha=" + fecha + ", listaEstaciones=" + listaEstaciones + ", nota=" + nota
				+ ", resultado=" + resultado + "]";
	}

}
