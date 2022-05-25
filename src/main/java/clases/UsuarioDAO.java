package clases;

import java.util.ArrayList;

public class UsuarioDAO {
	private String nombre;
	private String email;
	private String password;
	private ArrayList<String> localidadesBusqueda;
	private ArrayList<PosicionDAO> posicionesBusqueda;

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

	@Override
	public String toString() {
		return "UsuarioDAO [nombre=" + nombre + ", email=" + email + ", password=" + password + ", localidadesBusqueda="
				+ localidadesBusqueda + ", posicionesBusqueda=" + posicionesBusqueda + "]";
	}

}
