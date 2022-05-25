package clases;

import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

public class Gasolineras {
	@SerializedName("Fecha")
	private String fecha;
	@SerializedName("ListaEESSPrecio")
	private ArrayList<ListaEESSPrecio> listaEstaciones;
	@SerializedName("Nota")
	private String nota;
	@SerializedName("ResultadoConsulta")
	private String resultado;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public ArrayList<ListaEESSPrecio> getListaEstaciones() {
		return listaEstaciones;
	}

	public void setListaEstaciones(ArrayList<ListaEESSPrecio> listaEstaciones) {
		this.listaEstaciones = listaEstaciones;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "Gasolineras [fecha=" + fecha + ", listaEstaciones=" + listaEstaciones + ", nota=" + nota
				+ ", resultado=" + resultado + "]";
	}

}
