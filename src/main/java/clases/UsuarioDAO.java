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

	public ArrayList<String> getLocalidadesBusqueda() {
		return localidadesBusqueda;
	}

	public void setLocalidadesBusqueda(ArrayList<String> localidadesBusqueda) {
		this.localidadesBusqueda = localidadesBusqueda;
	}

	public ArrayList<PosicionDAO> getPosicionesBusqueda() {
		return posicionesBusqueda;
	}

	public void setPosicionesBusqueda(ArrayList<PosicionDAO> posicionesBusqueda) {
		this.posicionesBusqueda = posicionesBusqueda;
	}

	@Override
	public String toString() {
		return "UsuarioDAO [nombre=" + nombre + ", email=" + email + ", password=" + password + ", localidadesBusqueda="
				+ localidadesBusqueda + ", posicionesBusqueda=" + posicionesBusqueda + "]";
	}

}
