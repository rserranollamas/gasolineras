package clases;

public class PosicionDAO {
	private float latitud;
	private float longitud;
	private short radioKm;

	public PosicionDAO(float latitud, float longitud, short radioKm) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
		this.radioKm = radioKm;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public short getRadioKm() {
		return radioKm;
	}

	public void setRadioKm(short radioKm) {
		this.radioKm = radioKm;
	}

	@Override
	public String toString() {
		return "PosicionDAO [latitud=" + latitud + ", longitud=" + longitud + ", radioKm=" + radioKm + "]";
	}

}