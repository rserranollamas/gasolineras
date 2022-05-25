package clases;

import com.google.gson.annotations.SerializedName;

public class ListaEESSPrecio {
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

	public short getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(short codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getLatitud() {
		return latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getLongitud() {
		return longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	public char getMargen() {
		return margen;
	}

	public void setMargen(char margen) {
		this.margen = margen;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getBioDiesel() {
		return bioDiesel;
	}

	public void setBioDiesel(String bioDiesel) {
		this.bioDiesel = bioDiesel;
	}

	public String getBioEtanol() {
		return bioEtanol;
	}

	public void setBioEtanol(String bioEtanol) {
		this.bioEtanol = bioEtanol;
	}

	public String getGnc() {
		return gnc;
	}

	public void setGnc(String gnc) {
		this.gnc = gnc;
	}

	public String getGnl() {
		return gnl;
	}

	public void setGnl(String gnl) {
		this.gnl = gnl;
	}

	public String getGlp() {
		return glp;
	}

	public void setGlp(String glp) {
		this.glp = glp;
	}

	public String getGasoleoA() {
		return gasoleoA;
	}

	public void setGasoleoA(String gasoleoA) {
		this.gasoleoA = gasoleoA;
	}

	public String getGasoleoB() {
		return gasoleoB;
	}

	public void setGasoleoB(String gasoleoB) {
		this.gasoleoB = gasoleoB;
	}

	public String getGasoleoPremium() {
		return gasoleoPremium;
	}

	public void setGasoleoPremium(String gasoleoPremium) {
		this.gasoleoPremium = gasoleoPremium;
	}

	public String getGasolina95E10() {
		return gasolina95E10;
	}

	public void setGasolina95E10(String gasolina95e10) {
		gasolina95E10 = gasolina95e10;
	}

	public String getGasolina95E5() {
		return gasolina95E5;
	}

	public void setGasolina95E5(String gasolina95e5) {
		gasolina95E5 = gasolina95e5;
	}

	public String getGasolina95E5Premium() {
		return gasolina95E5Premium;
	}

	public void setGasolina95E5Premium(String gasolina95e5Premium) {
		gasolina95E5Premium = gasolina95e5Premium;
	}

	public String getGasolina98E10() {
		return gasolina98E10;
	}

	public void setGasolina98E10(String gasolina98e10) {
		gasolina98E10 = gasolina98e10;
	}

	public String getGasolina98E5() {
		return gasolina98E5;
	}

	public void setGasolina98E5(String gasolina98e5) {
		gasolina98E5 = gasolina98e5;
	}

	public String getHidrogeno() {
		return hidrogeno;
	}

	public void setHidrogeno(String hidrogeno) {
		this.hidrogeno = hidrogeno;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getRemision() {
		return remision;
	}

	public void setRemision(String remision) {
		this.remision = remision;
	}

	public String getRotulo() {
		return rotulo;
	}

	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}

	public char getTipoVenta() {
		return tipoVenta;
	}

	public void setTipoVenta(char tipoVenta) {
		this.tipoVenta = tipoVenta;
	}

	public String getPorcBioEtanol() {
		return porcBioEtanol;
	}

	public void setPorcBioEtanol(String porcBioEtanol) {
		this.porcBioEtanol = porcBioEtanol;
	}

	public String getPorcEsterMetilico() {
		return porcEsterMetilico;
	}

	public void setPorcEsterMetilico(String porcEsterMetilico) {
		this.porcEsterMetilico = porcEsterMetilico;
	}

	public short getIdEstacionServicio() {
		return idEstacionServicio;
	}

	public void setIdEstacionServicio(short idEstacionServicio) {
		this.idEstacionServicio = idEstacionServicio;
	}

	public short getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(short idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public byte getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(byte idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getIdComunidad() {
		return idComunidad;
	}

	public void setIdComunidad(String idComunidad) {
		this.idComunidad = idComunidad;
	}

	@Override
	public String toString() {
		return "ListaEESSPrecio [codigoPostal=" + codigoPostal + ", direccion=" + direccion + ", horario=" + horario
				+ ", latitud=" + latitud + ", localidad=" + localidad + ", longitud=" + longitud + ", margen=" + margen
				+ ", municipio=" + municipio + ", bioDiesel=" + bioDiesel + ", bioEtanol=" + bioEtanol + ", gnc=" + gnc
				+ ", gnl=" + gnl + ", glp=" + glp + ", gasoleoA=" + gasoleoA + ", gasoleoB=" + gasoleoB
				+ ", gasoleoPremium=" + gasoleoPremium + ", gasolina95E10=" + gasolina95E10 + ", gasolina95E5="
				+ gasolina95E5 + ", gasolina95E5Premium=" + gasolina95E5Premium + ", gasolina98E10=" + gasolina98E10
				+ ", gasolina98E5=" + gasolina98E5 + ", hidrogeno=" + hidrogeno + ", provincia=" + provincia
				+ ", remision=" + remision + ", rotulo=" + rotulo + ", tipoVenta=" + tipoVenta + ", porcBioEtanol="
				+ porcBioEtanol + ", porcEsterMetilico=" + porcEsterMetilico + ", idEstacionServicio="
				+ idEstacionServicio + ", idMunicipio=" + idMunicipio + ", idProvincia=" + idProvincia
				+ ", idComunidad=" + idComunidad + "]";
	}

}
