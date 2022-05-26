package clases;

import com.google.gson.annotations.SerializedName;

public class Gasolinera implements Comparable<Gasolinera> {
	@SerializedName("C.P.")
	private short codigoPostal;
	@SerializedName("Dirección")
	private String direccion;
	@SerializedName("Horario")
	private String horario;
	@SerializedName("Latitud")
	private String latitud;
	@SerializedName("Localidad")
	private String localidad;
	@SerializedName("Longitud (WGS84)")
	private String longitud;
	@SerializedName("Margen")
	private char margen;
	@SerializedName("Municipio")
	private String municipio;
	@SerializedName("Precio Biodiesel")
	private String bioDiesel;
	@SerializedName("Precio Bioetanol")
	private String bioEtanol;
	@SerializedName("Precio Gas Natural Comprimido")
	private String gnc;
	@SerializedName("Precio Gas Natural Licuado")
	private String gnl;
	@SerializedName("Precio Gases licuados del petróleo")
	private String glp;
	@SerializedName("Precio Gasoleo A")
	private String gasoleoA;
	@SerializedName("Precio Gasoleo B")
	private String gasoleoB;
	@SerializedName("Precio Gasoleo Premium")
	private String gasoleoPremium;
	@SerializedName("Precio Gasolina 95 E10")
	private String gasolina95E10;
	@SerializedName("Precio Gasolina 95 E5")
	private String gasolina95E5;
	@SerializedName("Precio Gasolina 95 E5 Premium")
	private String gasolina95E5Premium;
	@SerializedName("Precio Gasolina 98 E10")
	private String gasolina98E10;
	@SerializedName("Precio Gasolina 98 E5")
	private String gasolina98E5;
	@SerializedName("Precio Hidrogeno")
	private String hidrogeno;
	@SerializedName("Provincia")
	private String provincia;
	@SerializedName("Remisión")
	private String remision;
	@SerializedName("Rótulo")
	private String rotulo;
	@SerializedName("Tipo Venta")
	private char tipoVenta;
	@SerializedName("% BioEtanol")
	private String porcBioEtanol;
	@SerializedName("% Éster metílico")
	private String porcEsterMetilico;
	@SerializedName("IDEESS")
	private short idEstacionServicio;
	@SerializedName("IDMunicipio")
	private short idMunicipio;
	@SerializedName("IDProvincia")
	private byte idProvincia;
	@SerializedName("IDCCAA")
	private String idComunidad;

	public Gasolinera() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gasolinera(short codigoPostal, String direccion, String horario, String latitud, String localidad,
			String longitud, char margen, String municipio, String bioDiesel, String bioEtanol, String gnc, String gnl,
			String glp, String gasoleoA, String gasoleoB, String gasoleoPremium, String gasolina95e10,
			String gasolina95e5, String gasolina95e5Premium, String gasolina98e10, String gasolina98e5,
			String hidrogeno, String provincia, String remision, String rotulo, char tipoVenta, String porcBioEtanol,
			String porcEsterMetilico, short idEstacionServicio, short idMunicipio, byte idProvincia,
			String idComunidad) {
		super();
		this.codigoPostal = codigoPostal;
		this.direccion = direccion;
		this.horario = horario;
		this.latitud = latitud;
		this.localidad = localidad;
		this.longitud = longitud;
		this.margen = margen;
		this.municipio = municipio;
		this.bioDiesel = bioDiesel;
		this.bioEtanol = bioEtanol;
		this.gnc = gnc;
		this.gnl = gnl;
		this.glp = glp;
		this.gasoleoA = gasoleoA;
		this.gasoleoB = gasoleoB;
		this.gasoleoPremium = gasoleoPremium;
		gasolina95E10 = gasolina95e10;
		gasolina95E5 = gasolina95e5;
		gasolina95E5Premium = gasolina95e5Premium;
		gasolina98E10 = gasolina98e10;
		gasolina98E5 = gasolina98e5;
		this.hidrogeno = hidrogeno;
		this.provincia = provincia;
		this.remision = remision;
		this.rotulo = rotulo;
		this.tipoVenta = tipoVenta;
		this.porcBioEtanol = porcBioEtanol;
		this.porcEsterMetilico = porcEsterMetilico;
		this.idEstacionServicio = idEstacionServicio;
		this.idMunicipio = idMunicipio;
		this.idProvincia = idProvincia;
		this.idComunidad = idComunidad;
	}

	public short getCodigoPostal() {
		return codigoPostal;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getHorario() {
		return horario;
	}

	public float getLatitud() {
		float latitudFloat = Float.parseFloat(latitud.replace(",", "."));
		return latitudFloat;
	}

	public String getLocalidad() {
		return localidad;
	}

	public float getLongitud() {
		float longitudFloat = Float.parseFloat(longitud.replace(",", "."));
		return longitudFloat;
	}

	public char getMargen() {
		return margen;
	}

	public String getMunicipio() {
		return municipio;
	}

	public String getBioDiesel() {
		return bioDiesel;
	}

	public String getBioEtanol() {
		return bioEtanol;
	}

	public String getGnc() {
		return gnc;
	}

	public String getGnl() {
		return gnl;
	}

	public String getGlp() {
		return glp;
	}

	public String getGasoleoA() {
		return gasoleoA;
	}

	public String getGasoleoB() {
		return gasoleoB;
	}

	public String getGasoleoPremium() {
		return gasoleoPremium;
	}

	public String getGasolina95E10() {
		return gasolina95E10;
	}

	public String getGasolina95E5() {
		return gasolina95E5;
	}

	public String getGasolina95E5Premium() {
		return gasolina95E5Premium;
	}

	public String getGasolina98E10() {
		return gasolina98E10;
	}

	public String getGasolina98E5() {
		return gasolina98E5;
	}

	public String getHidrogeno() {
		return hidrogeno;
	}

	public String getProvincia() {
		return provincia;
	}

	public String getRemision() {
		return remision;
	}

	public String getRotulo() {
		return rotulo;
	}

	public char getTipoVenta() {
		return tipoVenta;
	}

	public String getPorcBioEtanol() {
		return porcBioEtanol;
	}

	public String getPorcEsterMetilico() {
		return porcEsterMetilico;
	}

	public short getIdEstacionServicio() {
		return idEstacionServicio;
	}

	public short getIdMunicipio() {
		return idMunicipio;
	}

	public byte getIdProvincia() {
		return idProvincia;
	}

	public String getIdComunidad() {
		return idComunidad;
	}

	@Override
	public String toString() {
		return "codigoPostal=" + codigoPostal + ", direccion=" + direccion + ", horario=" + horario + ", latitud="
				+ latitud + ", localidad=" + localidad + ", longitud=" + longitud + ", margen=" + margen
				+ ", municipio=" + municipio + ", bioDiesel=" + bioDiesel + ", bioEtanol=" + bioEtanol + ", gnc=" + gnc
				+ ", gnl=" + gnl + ", glp=" + glp + ", gasoleoA=" + gasoleoA + ", gasoleoB=" + gasoleoB
				+ ", gasoleoPremium=" + gasoleoPremium + ", gasolina95E10=" + gasolina95E10 + ", gasolina95E5="
				+ gasolina95E5 + ", gasolina95E5Premium=" + gasolina95E5Premium + ", gasolina98E10=" + gasolina98E10
				+ ", gasolina98E5=" + gasolina98E5 + ", hidrogeno=" + hidrogeno + ", provincia=" + provincia
				+ ", remision=" + remision + ", rotulo=" + rotulo + ", tipoVenta=" + tipoVenta + ", porcBioEtanol="
				+ porcBioEtanol + ", porcEsterMetilico=" + porcEsterMetilico + ", idEstacionServicio="
				+ idEstacionServicio + ", idMunicipio=" + idMunicipio + ", idProvincia=" + idProvincia
				+ ", idComunidad=" + idComunidad;
	}

	public int compareTo(Gasolinera o) {
		return this.gasolina95E5.compareTo(o.gasolina95E5);
	}

}
