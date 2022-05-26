package clases;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.TreeSet;

import com.google.gson.Gson;

import utils.HttpGet;

public class UsuarioDAO {
	private String nombre;
	private String email;
	private String password;
	private HashSet<String> localidadesBusqueda;
	private HashSet<PosicionDAO> posicionesBusqueda;

	public UsuarioDAO() {
		this.localidadesBusqueda = new HashSet<String>();
	}

	public UsuarioDAO(String nombre, String email, String password) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.password = password;
	}

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
		if (this.localidadesBusqueda.contains(s)) {
			return false;
		}
		this.localidadesBusqueda.add(s);
		return true;
	}

	public boolean quitarLocalidad(String s) {
		if (!this.localidadesBusqueda.contains(s)) {
			return false;
		}
		this.localidadesBusqueda.remove(s);
		return true;
	}

	public boolean añadirPosicion(PosicionDAO p) {
		if (this.posicionesBusqueda.contains(p)) {
			return false;
		}
		this.posicionesBusqueda.add(p);
		return true;
	}

	public boolean quitarPosicion(PosicionDAO p) {
		if (!this.posicionesBusqueda.contains(p)) {
			return false;
		}
		this.posicionesBusqueda.remove(p);
		return true;
	}

	public TreeSet<Gasolinera> listarMisGasolineras() {
		TreeSet<Gasolinera> gasolineras = new TreeSet<Gasolinera>();
		try {
			// Obtenemos los datos de la web del Ministerio y los almacenamos en un String
			String json = (HttpGet.httpGet(
					"https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/"));
			// Creamos un objeto Gson
			Gson gson = new Gson();
			// Convertimos el json en objeto (clase Gasolineras.class)
			ListadoGasolineras datosGasolineras = gson.fromJson(json, ListadoGasolineras.class);
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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