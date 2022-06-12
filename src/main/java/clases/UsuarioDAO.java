package clases;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

import com.google.gson.Gson;

import excepciones.PassIncorrectoException;
import excepciones.UsuarioNoExisteException;
import utils.ConexionBD;
import utils.HttpGet;

public class UsuarioDAO {
	/* representa el dni del usuario */
	private String dni;
	/* representa el nombre del usuario */
	private String nombre;
	/* representa el email del usuario */
	private String email;
	/* representa el password del usuario */
	private String password;
	/* HashSet que almacenará las localidades dónde se desea buscar gasolineras */
	private HashSet<String> localidadesBusqueda;
	/* HashSet que almacenará las posiciones dónde se desde buscar gasolineras */
	public HashSet<PosicionDAO> posicionesBusqueda;

	/**
	 * Constructor vacío de usuario
	 */
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
	 * Setter de DNI, modifica el dni del usuario
	 * 
	 * @param dni especifica el nuevo dni del usuario
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

	/**
	 * Getter de nombre, devuelve el nombre del usuario
	 * 
	 * @return nombre del usuario
	 */

	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter de nombre, modifica el nombre del usuario
	 * 
	 * @param nombre nuevo nombre del usuario
	 * @throws SQLException
	 */

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

	/**
	 * Getter email, devuelve el email del usuario
	 * 
	 * @return email del usuario
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter email, modifica el email del usuario
	 * 
	 * @param email nuevo email del usuario
	 * @throws SQLException
	 */
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

	/**
	 * Getter de password, devuelve el password del usuario
	 * 
	 * @return password del usuario
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter de password, modifica el password del usuario
	 * 
	 * @param password nuevo password del usuario
	 * @throws SQLException
	 */
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
	 * Método que recibe un String localidad y la añade al HashSet
	 * localidadesBusqueda, devuelve un booleano indicando si ha conseguido añadirla
	 * o no.
	 * 
	 * @param s localidad
	 * @return booleano que indica si ha conseguido añadir la localidad o no.
	 */
	public boolean añadirLocalidad(String s) {
		if (this.localidadesBusqueda.contains(s)) {
			return false;
		}
		this.localidadesBusqueda.add(s);
		return true;
	}

	/**
	 * Método que recibe un String localidad y la elimina del HashSet
	 * localidadesBusqueda, devuelve un booleano indicando si ha conseguido
	 * eliminarla o no.
	 * 
	 * @param s localidad
	 * @return booleano que indica si ha conseguido eliminar la localidad o no.
	 */
	public boolean quitarLocalidad(String s) {
		if (!this.localidadesBusqueda.contains(s)) {
			return false;
		}
		this.localidadesBusqueda.remove(s);
		return true;
	}

	/**
	 * Método que comprueba si la localidad se encuentra en el HashSet
	 * localidadesBusqueda y devuelve un booleano
	 * 
	 * @return booleano que indica si la localidad se encuentra en
	 *         localidadesBusqueda
	 */
	public boolean comprobarLocalidad() {
		if (this.localidadesBusqueda.isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * Método que recibe una posición y la añade al HashSet posicionesBusqueda,
	 * devuelve un booleano indicando si ha conseguido añadirla o no.
	 * 
	 * @param p posición del usuario
	 * @return booleano que indica si ha conseguido añadir la posición o no.
	 */
	public boolean añadirPosicion(PosicionDAO p) {
		if (this.posicionesBusqueda.contains(p)) {
			return false;
		}
		this.posicionesBusqueda.add(p);
		return true;
	}

	/**
	 * Método que recibe una posición y la elimina del HashSet posicionesBusqueda,
	 * devuelve un booleano indicando si ha conseguido eliminarla o no.
	 * 
	 * @param p posición del usuario
	 * @return booleano que indica si ha conseguido eliminar la posición o no.
	 */
	public boolean quitarPosicion(PosicionDAO p) {
		if (!this.posicionesBusqueda.contains(p)) {
			return false;
		}
		// Se elimina la posicion del HashSet posicionesBusqueda
		this.posicionesBusqueda.remove(p);
		return true;
	}

	/**
	 * Método que comprueba si la posición se encuentra en el HashSet
	 * posicionesBusqueda y devuelve un booleano
	 * 
	 * @return booleano que indica si la posición se encuentra en posicionesBusqueda
	 */
	public boolean comprobarPosicion() {
		if (this.posicionesBusqueda.isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * Método que realiza la consulta con la API REST del ministerio y obtiene las
	 * gasolineras a partir de la posición del usuario y de las localidades que haya
	 * introducido en los HashSet localidadesBusqueda y posicionesBusqueda
	 * 
	 * @return devuelve el TreeSet con las gasolineras encontradas a partir de la
	 *         posición y/o localidades
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

	/**
	 * Método que devuelve en un ArrayList todas las posiciones de un usuario
	 * almacenadas en la base de datos
	 * 
	 * @return ArrayList con todas las posiciones del usuario obtenidas de la BD
	 */
	public ArrayList<PosicionDAO> getPosiciones() {
		ArrayList<PosicionDAO> ret = new ArrayList<PosicionDAO>();

		Statement smt = ConexionBD.conectar();

		try {
			ResultSet cursor = smt.executeQuery("SELECT * FROM posicion WHERE usuario='" + this.dni + "'");
			while (cursor.next()) {
				PosicionDAO p = new PosicionDAO();
				p.latitud = cursor.getFloat("latitud");
				p.longitud = cursor.getFloat("longitud");
				p.radioKm = cursor.getShort("radioKm");
				p.usuario = this;
				ret.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexionBD.desconectar();

		return ret;
	}

	/**
	 * Método que devuelve en un ArrayList todas las localidades que un usuario ha
	 * almacenado en la base de datos
	 * 
	 * @return ArrayList con todas las localidades del usuario obtenidas de la BD
	 */
	public ArrayList<String> getLocalidades() {
		ArrayList<String> ret = new ArrayList<String>();
		Statement smt = ConexionBD.conectar();

		try {
			ResultSet cursor = smt.executeQuery("SELECT * FROM localidad WHERE usuario='" + this.dni + "'");
			while (cursor.next()) {
				ret.add(cursor.getString("nombre"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexionBD.desconectar();

		return ret;
	}

	/**
	 * toString de la clase UsuarioDAO, muestra formateada toda la información del
	 * mismo
	 * 
	 * @return String con toda la información del usuario
	 */
	@Override
	public String toString() {
		return "UsuarioDAO [nombre=" + nombre + ", email=" + email + ", password=" + password + ", localidadesBusqueda="
				+ localidadesBusqueda + ", posicionesBusqueda=" + posicionesBusqueda + "]";
	}

}