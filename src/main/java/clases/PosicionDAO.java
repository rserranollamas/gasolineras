package clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import excepciones.PosicionNoExisteException;
import utils.ConexionBD;

public class PosicionDAO {
	private float latitud;
	private float longitud;
	private short radioKm;
	private UsuarioDAO usuario;

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

	public PosicionDAO(UsuarioDAO usuario) throws SQLException, PosicionNoExisteException {
		Statement smt = ConexionBD.conectar();
		ResultSet cursor = smt.executeQuery("SELECT * FROM posicion WHERE usuario='" + usuario.getDni() + "'");
		if (cursor.next()) {
			this.latitud = cursor.getFloat("latitud");
			this.longitud = cursor.getFloat("longitud");
			this.radioKm = cursor.getShort("radioKm");
			this.usuario = usuario;
		} else {
			ConexionBD.desconectar();
			throw new PosicionNoExisteException(usuario.getNombre() + " no tienes almacenada ninguna ubicación");
		}
		ConexionBD.desconectar();
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) throws SQLException {
		Statement smt = ConexionBD.conectar();

		if (smt.executeUpdate(
				"UPDATE posicion SET latitud=" + latitud + " WHERE usuario='" + this.usuario.getDni() + "'") > 0) {
			this.latitud = latitud;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido modificar la latitud");
		}
		ConexionBD.desconectar();
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) throws SQLException {
		Statement smt = ConexionBD.conectar();

		if (smt.executeUpdate(
				"UPDATE posicion SET longitud=" + longitud + " WHERE usuario='" + this.usuario.getDni() + "'") > 0) {
			this.longitud = longitud;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido modificar la longitud");
		}
		ConexionBD.desconectar();
	}

	public short getRadioKm() {
		return radioKm;
	}

	public void setRadioKm(short radioKm) throws SQLException {
		Statement smt = ConexionBD.conectar();

		if (smt.executeUpdate(
				"UPDATE posicion SET radioKm=" + radioKm + " WHERE usuario='" + this.usuario.getDni() + "'") > 0) {
			this.radioKm = radioKm;
		} else {
			ConexionBD.desconectar();
			throw new SQLException("No se ha podido modificar el radio de búsqueda");
		}
		ConexionBD.desconectar();

	}

	public UsuarioDAO getUsuario() {
		return usuario;
	}

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
	public String toString() {
		return "PosicionDAO [latitud=" + latitud + ", longitud=" + longitud + ", radioKm=" + radioKm + "]";
	}

}