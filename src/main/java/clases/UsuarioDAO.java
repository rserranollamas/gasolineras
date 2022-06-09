package clases;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

import com.google.gson.Gson;

import excepciones.PassIncorrectoException;
import excepciones.UsuarioNoExisteException;
import utils.ConexionBD;
import utils.HttpGet;

public class UsuarioDAO {
	private String dni;
	private String nombre;
	private String email;
	private String password;
	private HashSet<String> localidadesBusqueda;
	private HashSet<PosicionDAO> posicionesBusqueda;

	public UsuarioDAO() {
	}

	/**
	 * Este constructor hará que persista en BBDD el usuario que estoy creando
	 * 
	 * @param dni      dni del usuario
	 * @param nombre   nombre del usuario
	 * @param email    email del usuario
	 * @param password password del usuario
	 * @throws SQLException
	 */
	public UsuarioDAO(String dni, String nombre, String email, String password) throws SQLException {

		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate(
				"INSERT INTO usuario VALUES('" + dni + "','" + nombre + "','" + email + "','" + password + "')") > 0) {
			// Solo si todo ha ido bien insertando, se modifican las variables internas
			this.dni = dni;
			this.nombre = nombre;
			this.email = email;
			this.password = password;
			this.localidadesBusqueda = new HashSet<String>();
			this.posicionesBusqueda = new HashSet<PosicionDAO>();
		} else {
			// Si no se ha podido insertar, lanzo un error: No se ha podido insertar.
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido insertar al usuario en la BBDD");
		}
		ConexionBD.desconectar();

	}

	/**
	 * Este constructor va a consultar en la BBDD al usuario a partir de su DNI y
	 * password
	 * 
	 * @param dni      dni del usuario
	 * @param password password del usuario
	 * @throws SQLException
	 * @throws PassIncorrectoException
	 * @throws UsuarioNoExisteException
	 */

	public UsuarioDAO(String dni, String password)
			throws SQLException, PassIncorrectoException, UsuarioNoExisteException {
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("SELECT * FROM usuario WHERE dni='" + dni + "'");
		if (cursor.next()) {
			this.password = cursor.getString("password");
			if (!this.password.equals(password)) {
				ConexionBD.desconectar();
				throw new PassIncorrectoException("El password es incorrecto");
			}
			this.dni = cursor.getString("dni");
			this.nombre = cursor.getString("nombre");
			this.email = cursor.getString("email");
			this.localidadesBusqueda = new HashSet<String>();
			this.posicionesBusqueda = new HashSet<PosicionDAO>();

		} else {
			ConexionBD.desconectar();
			throw new UsuarioNoExisteException("No existe ningun usuario con el DNI indicado");

		}
		ConexionBD.desconectar();
	}

	/**
	 * Este constructor va a consultar en la BBDD al usuario a partir de su DNI
	 * 
	 * @param dni dni del usuario
	 * @throws SQLException
	 * @throws UsuarioNoExisteException
	 */

	public UsuarioDAO(String dni) throws SQLException, UsuarioNoExisteException {
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("SELECT * FROM usuario WHERE dni='" + dni + "'");
		if (cursor.next()) {
			this.dni = cursor.getString("dni");
			this.nombre = cursor.getString("nombre");
		} else {
			ConexionBD.desconectar();
			throw new UsuarioNoExisteException("No existe ningun usuario con el DNI indicado");
		}
	}

	/**
	 * Getter de DNI
	 * 
	 * @return devuelve el valor del DNI en String
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Setter de DNI
	 * 
	 * @param dni
	 * @throws SQLException
	 */
	public void setDni(String dni) throws SQLException {
		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate("UPDATE usuario SET dni='" + dni + "' WHERE dni='" + this.dni + "'") > 0) {
			this.dni = dni;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido modificar el DNI");
		}
		ConexionBD.desconectar();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws SQLException {
		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate("UPDATE usuario SET nombre='" + nombre + "' WHERE dni='" + this.dni + "'") > 0) {
			this.nombre = nombre;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido modificar el nombre");
		}
		ConexionBD.desconectar();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws SQLException {
		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate("UPDATE usuario SET email='" + email + "' WHERE dni='" + this.dni + "'") > 0) {
			this.email = email;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido modificar el email");
		}
		ConexionBD.desconectar();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws SQLException {
		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate("UPDATE usuario SET password='" + password + "' WHERE dni='" + this.dni + "'") > 0) {
			this.password = password;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido modificar el password");
		}
		ConexionBD.desconectar();
	}

	/**
	 * 
	 * @param s
	 * @return
	 * @throws SQLException
	 */
	public boolean añadirLocalidad(String s) throws SQLException {
		if (this.localidadesBusqueda.contains(s)) {
			return false;
		}

		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate("INSERT INTO localidad VALUES('" + s + "','" + this.getDni() + "')") > 0) {
			// Solo si todo ha ido bien insertando, añado la localidad al HashSet
			// localidadesBusqueda
			this.localidadesBusqueda.add(s);
		} else {
			// Si no se ha podido insertar, lanzo un error: No se ha podido insertar.
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido insertar la localidad en la BBDD");
		}
		ConexionBD.desconectar();

		return true;
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public boolean quitarLocalidad(String s) {
		if (!this.localidadesBusqueda.contains(s)) {
			return false;
		}
		this.localidadesBusqueda.remove(s);
		Statement smt = ConexionBD.conectar();
		try {
			smt.executeUpdate("DELETE FROM localidad WHERE nombre=" + s + " AND usuario='" + this.dni + "'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexionBD.desconectar();

		return true;
	}

	/**
	 * 
	 * @param p
	 * @return
	 */

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
		// Se elimina la posicion del HashSet posicionesBusqueda
		this.posicionesBusqueda.remove(p);
		// Se elimina la posicion de la BBDD
		p.eliminar();
		return true;
	}

	/**
	 * 
	 * @return devuelve el TreeSet con las gasolineras
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */

	public TreeSet<Gasolinera> listarMisGasolineras()
			throws KeyManagementException, NoSuchAlgorithmException, IOException {
		TreeSet<Gasolinera> gasolineras = new TreeSet<Gasolinera>();

		// Obtenemos los datos de la web del Ministerio y los almacenamos en un String
		String json = (HttpGet.httpGet(
				"https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/"));
		// Creamos un objeto Gson
		Gson gson = new Gson();
		// Convertimos el json en objeto (clase Gasolineras.class)
		ListadoGasolineras datosGasolineras = gson.fromJson(json, ListadoGasolineras.class);
		for (short i = 0; i < datosGasolineras.getListaEstaciones().size(); i++) {
			Gasolinera gasolinera = datosGasolineras.getListaEstaciones().get(i);
			if (this.localidadesBusqueda.contains(datosGasolineras.getListaEstaciones().get(i).getLocalidad())) {
				gasolineras.add(gasolinera);
			}

			Iterator it = this.posicionesBusqueda.iterator();

			while (it.hasNext()) {
				PosicionDAO posicionUsuario = (PosicionDAO) it.next();
				float latitudUsuario = (float) Math.toRadians(posicionUsuario.getLatitud());
				float longitudUsuario = (float) Math.toRadians(posicionUsuario.getLongitud());
				float latitudGasolinera = (float) Math
						.toRadians(datosGasolineras.getListaEstaciones().get(i).getLatitud());
				float longitudGasolinera = (float) Math
						.toRadians(datosGasolineras.getListaEstaciones().get(i).getLongitud());

				float radioTierra = (float) 6378.1; // Kilómetros

				float distancia = (float) (radioTierra
						* Math.acos(Math.sin(latitudUsuario) * Math.sin(latitudGasolinera) + Math.cos(latitudUsuario)
								* Math.cos(latitudGasolinera) * Math.cos(longitudUsuario - longitudGasolinera)));

				if (distancia < posicionUsuario.getRadioKm()) {
					gasolineras.add(gasolinera);
				}

			}

		}

		return gasolineras;
	}

	@Override
	public String toString() {
		return "UsuarioDAO [nombre=" + nombre + ", email=" + email + ", password=" + password + ", localidadesBusqueda="
				+ localidadesBusqueda + ", posicionesBusqueda=" + posicionesBusqueda + "]";
	}

}