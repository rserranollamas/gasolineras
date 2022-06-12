package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

import excepciones.PosicionNoExisteException;
import utils.ConexionBD;

public class PosicionDAO {
	/* representa la latitud de la posición del usuario */
	protected float latitud;
	/* representa la longitud de la posición del usuario */
	protected float longitud;
	/* representa el radio de búsqueda en Kms */
	protected short radioKm;
	/* representa al usuario que tiene la posición */
	protected UsuarioDAO usuario;

	/**
	 * Constructor de posición vacío
	 * 
	 */
	protected PosicionDAO() {

	}

	/**
	 * Constructor de posición con todas las variables internas inserta en la base
	 * de datos los parámetros recibidos
	 * 
	 * 
	 * @param latitud  latitud de la posición del usuario
	 * @param longitud longitud de la posición del usuario
	 * @param radioKm  radio de búsqueda en kilómetros
	 * @param usuario  usuario del que se obtiene la posicion
	 * @throws SQLException
	 */

	public PosicionDAO(float latitud, float longitud, short radioKm, UsuarioDAO usuario) throws SQLException {
		Statement smt = ConexionBD.conectar();
		if (smt.executeUpdate("INSERT INTO posicion VALUES(" + latitud + "," + longitud + "," + radioKm + ",'"
				+ usuario.getDni() + "')") > 0) {
			this.latitud = latitud;
			this.longitud = longitud;
			this.radioKm = radioKm;
			this.usuario = usuario;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("Error al insertar la posicion en la BBDD");
		}
		ConexionBD.desconectar();
	}

	/**
	 * Constructor de posición que consulta la posición del usuario a partir de su
	 * PK
	 * 
	 * @param latitud  latitud de la posición del usuario
	 * @param longitud longitud de la posición del usuario
	 * @param usuario  usuario del que se obtiene la posicion
	 * @throws SQLException
	 * @throws PosicionNoExisteException
	 */

	public PosicionDAO(float latitud, float longitud, UsuarioDAO usuario)
			throws SQLException, PosicionNoExisteException {
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("SELECT * FROM posicion WHERE latitud=" + latitud + " AND longitud="
				+ longitud + " AND usuario='" + usuario.getDni() + "'");

		if (cursor.next()) {
			this.latitud = latitud;
			this.longitud = longitud;
			this.radioKm = cursor.getShort("radioKm");
			this.usuario = usuario;

		} else {
			ConexionBD.desconectar();
			throw new PosicionNoExisteException("No existe la posición indicada");
		}
		ConexionBD.desconectar();
	}

	/**
	 * getter de Latitud
	 * 
	 * @return devuelve la latitud de la posición del usuario
	 */
	public float getLatitud() {
		return latitud;
	}

	/**
	 * setter de Latitud
	 * 
	 * @param establece la latitud de la posición del usuario
	 * @throws SQLException
	 */
	public void setLatitud(float latitud) throws SQLException {
		Statement smt = ConexionBD.conectar();

		if (smt.executeUpdate("UPDATE posicion SET latitud=" + latitud + " WHERE latitud=" + this.latitud
				+ " AND longitud=" + this.longitud + " AND usuario='" + this.usuario.getDni() + "'") > 0) {
			this.latitud = latitud;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido modificar la latitud");
		}
		ConexionBD.desconectar();
	}

	/**
	 * getter de Longitud
	 * 
	 * @return devuelve la longitud de la posición del usuario
	 */
	public float getLongitud() {
		return longitud;
	}

	/**
	 * setter de Longitud
	 * 
	 * @param longitud establece la longitud de la posición del usuario
	 * @throws SQLException
	 */
	public void setLongitud(float longitud) throws SQLException {
		Statement smt = ConexionBD.conectar();

		if (smt.executeUpdate("UPDATE posicion SET longitud=" + longitud + " WHERE latitud=" + this.latitud
				+ " AND longitud=" + this.longitud + " AND usuario='" + this.usuario.getDni() + "'") > 0) {
			this.longitud = longitud;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido modificar la longitud");
		}
		ConexionBD.desconectar();
	}

	/**
	 * getter de RadioKm
	 * 
	 * @return devuelve el radio de búsqueda en Kms que se ha almacenado para la
	 *         posición del usuario
	 */
	public short getRadioKm() {
		return radioKm;
	}

	/**
	 * setter de RadioKm
	 * 
	 * @param radioKm recibe el radio de búsqueda en kilómetros y lo actualiza en la
	 *                base de datos
	 * @throws SQLException
	 */
	public void setRadioKm(short radioKm) throws SQLException {
		Statement smt = ConexionBD.conectar();

		if (smt.executeUpdate("UPDATE posicion SET radioKm=" + radioKm + " WHERE latitud=" + this.latitud
				+ " AND longitud=" + this.longitud + " AND usuario='" + this.usuario.getDni() + "'") > 0) {
			this.radioKm = radioKm;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido modificar el radio de búsqueda");
		}
		ConexionBD.desconectar();

	}

	/**
	 * getter de Usuario
	 * 
	 * @return devuelve el usuario al que está asociada la posición
	 */
	public UsuarioDAO getUsuario() {
		return usuario;
	}

	/**
	 * Método que elimina la posición del usuario a partir de su PK
	 * 
	 */
	public void eliminar() {
		Statement smt = ConexionBD.conectar();
		try {
			smt.executeUpdate("DELETE FROM posicion WHERE latitud=" + this.latitud + " AND longitud=" + this.longitud
					+ " AND usuario='" + usuario.getDni() + "'");
			this.latitud = 0;
			this.longitud = 0;
			this.radioKm = 0;
			this.usuario = null;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ConexionBD.desconectar();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (obj.getClass() != getClass()) {
			return false;
		}

		PosicionDAO p = (PosicionDAO) obj;
		return Objects.equals(latitud, p.latitud) && p.longitud == longitud && p.usuario == usuario;

	}

	@Override
	public int hashCode() {
		return Objects.hash(latitud, longitud, usuario);
	}

	/**
	 * toString de la clase PosicionDAO, muestra formateada toda la información de
	 * la posición
	 * 
	 * @return String con toda la información de la posición
	 */
	@Override
	public String toString() {
		return "PosicionDAO [latitud=" + latitud + ", longitud=" + longitud + ", radioKm=" + radioKm + "]";
	}

}