package clases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

import com.google.gson.Gson;

import utils.HttpGet;

public class UsuarioDAO {
	private String nombre;
	private String email;
	private String password;
	private ArrayList<String> localidadesBusqueda;
	private ArrayList<PosicionDAO> posicionesBusqueda;
	private TreeSet<ListaEESSPrecio> gasolineras;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean añadirLocalidad(String s) {
		if (localidadesBusqueda.contains(s)) {
			return false;
		}
		this.localidadesBusqueda.add(s);
		return true;
	}

	public boolean quitarLocalidad(String s) {
		if (!localidadesBusqueda.contains(s)) {
			return false;
		}
		this.localidadesBusqueda.remove(s);
		return true;
	}

	public boolean añadirPosicion(PosicionDAO p) {
		if (posicionesBusqueda.contains(p)) {
			return false;
		}
		this.posicionesBusqueda.add(p);
		return true;
	}

	public boolean quitarPosicion(PosicionDAO p) {
		if (!posicionesBusqueda.contains(p)) {
			return false;
		}
		this.posicionesBusqueda.remove(p);
		return true;
	}

	public TreeSet<ListaEESSPrecio> listarMisGasolineras() {

		try {
			// Obtenemos los datos de la web del Ministerio y los guardamos en un String
			String json = (HttpGet.httpGet(
					"https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/"));
			// Creamos un objeto Gson
			Gson gson = new Gson();
			// Convertimos el json en objeto (clase Gasolineras.class)
			Gasolineras datos = gson.fromJson(json, Gasolineras.class);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return gasolineras;

	}

	@Override
	public String toString() {
		return "UsuarioDAO [nombre=" + nombre + ", email=" + email + ", password=" + password + ", localidadesBusqueda="
				+ localidadesBusqueda + ", posicionesBusqueda=" + posicionesBusqueda + "]";
	}

}
