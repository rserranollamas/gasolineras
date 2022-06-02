package clases;

public class PosicionDAO {
	private float longitud;
	private float latitud;
	private short radioKm;

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public short getRadioKm() {
		return radioKm;
	}

	public void setRadioKm(short radioKm) {
		this.radioKm = radioKm;
	}

	@Override
	public String toString() {
		return "PosicionDAO [longitud=" + longitud + ", latitud=" + latitud + ", radioKm=" + radioKm + "]";
	}

}
