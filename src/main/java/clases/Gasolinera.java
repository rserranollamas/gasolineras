package clases;

import com.google.gson.annotations.SerializedName;

public class Gasolinera implements Comparable<Gasolinera> {
	@SerializedName("C.P.")
	/* representa el código postal */
	private short codigoPostal;
	@SerializedName("Dirección")
	/* representa la dirección */
	private String direccion;
	@SerializedName("Horario")
	/* representa el horario */
	private String horario;
	@SerializedName("Latitud")
	/* representa la latitud */
	private String latitud;
	@SerializedName("Localidad")
	/* representa la localidad */
	private String localidad;
	@SerializedName("Longitud (WGS84)")
	/* representa la longitud */
	private String longitud;
	@SerializedName("Margen")
	/* representa el margen */
	private char margen;
	@SerializedName("Municipio")
	/* representa el municipio */
	private String municipio;
	@SerializedName("Precio Biodiesel")
	/* representa el precio del biodiesel */
	private String bioDiesel;
	@SerializedName("Precio Bioetanol")
	/* representa el precio del bioetanol */
	private String bioEtanol;
	@SerializedName("Precio Gas Natural Comprimido")
	/* representa el precio del gnc */
	private String gnc;
	@SerializedName("Precio Gas Natural Licuado")
	/* representa el precio del gnl */
	private String gnl;
	@SerializedName("Precio Gases licuados del petróleo")
	/* representa el precio del glp */
	private String glp;
	@SerializedName("Precio Gasoleo A")
	/* represena el precio del gasoleo a */
	private String gasoleoA;
	@SerializedName("Precio Gasoleo B")
	/* representa el precio del gasoleo b */
	private String gasoleoB;
	@SerializedName("Precio Gasoleo Premium")
	/* representa el precio del gasoleo premium */
	private String gasoleoPremium;
	@SerializedName("Precio Gasolina 95 E10")
	/* representa el precio de la gasolina 95 e10 */
	private String gasolina95E10;
	@SerializedName("Precio Gasolina 95 E5")
	/* representa el precio de la gasolina 95 e5 */
	private String gasolina95E5;
	@SerializedName("Precio Gasolina 95 E5 Premium")
	/* representa el precio de la gasolina 95 premium */
	private String gasolina95E5Premium;
	@SerializedName("Precio Gasolina 98 E10")
	/* representa el precio de la gasolina 98 e10 */
	private String gasolina98E10;
	@SerializedName("Precio Gasolina 98 E5")
	/* representa el precio de la gasolina 98 e5 */
	private String gasolina98E5;
	@SerializedName("Precio Hidrogeno")
	/* representa el precio del hidrógeno */
	private String hidrogeno;
	@SerializedName("Provincia")
	/* representa la provincia */
	private String provincia;
	@SerializedName("Remisión")
	/* representa la remisión */
	private String remision;
	@SerializedName("Rótulo")
	/* representa el rótulo */
	private String rotulo;
	@SerializedName("Tipo Venta")
	/* representa el tipo de venta */
	private char tipoVenta;
	@SerializedName("% BioEtanol")
	/* representa el % de bioetanol */
	private String porcBioEtanol;
	@SerializedName("% Éster metílico")
	/* representa el % de éster metílico */
	private String porcEsterMetilico;
	@SerializedName("IDEESS")
	/* representa el identificador de la estación de servicio */
	private short idEstacionServicio;
	@SerializedName("IDMunicipio")
	/* representa el identificador del municipio */
	private short idMunicipio;
	@SerializedName("IDProvincia")
	/* representa el identificador de la provincia */
	private byte idProvincia;
	@SerializedName("IDCCAA")
	/* representa el identificador de la comunidad */
	private String idComunidad;

	/**
	 * Constructor vacío de Gasolinera
	 * 
	 */
	public Gasolinera() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor de gasolinera con todas las variables internas
	 * 
	 * @param codigoPostal        código postal de la gasolinera
	 * @param direccion           dirección de la gasolinera
	 * @param horario             horario de la gasolinera
	 * @param latitud             latitud de la gasolinera
	 * @param localidad           localidad de la gasolinera
	 * @param longitud            longitud de la gasolinera
	 * @param margen              margen de la gasolinera
	 * @param municipio           municipio de la gasolinera
	 * @param bioDiesel           precio del biodiesel
	 * @param bioEtanol           precio del bioetanol
	 * @param gnc                 precio del gnc
	 * @param gnl                 precio del gnl
	 * @param glp                 precio del glp
	 * @param gasoleoA            precio del gasoleo a
	 * @param gasoleoB            precio del gasoleo b
	 * @param gasoleoPremium      precio del gasoleo premium
	 * @param gasolina95e10       precio de la gasolina 95 e10
	 * @param gasolina95e5        precio de la gasolina 95 e5
	 * @param gasolina95e5Premium precio de la gasolina 95 premium
	 * @param gasolina98e10       precio de la gasolina 98 e10
	 * @param gasolina98e5        precio de la gasolina 98 e5
	 * @param hidrogeno           precio del hidrógeno
	 * @param provincia           provincia de la gasolinera
	 * @param remision            remision de la gasolinera
	 * @param rotulo              rótulo de la gasolinera
	 * @param tipoVenta           tipo de venta de la gasolinera
	 * @param porcBioEtanol       porcentaje de bioetanol
	 * @param porcEsterMetilico   porcentaje de ester metilico
	 * @param idEstacionServicio  identificador de la estacion de servicio
	 * @param idMunicipio         identificador del municipio
	 * @param idProvincia         identificador de la provincia
	 * @param idComunidad         identificador de la comunidad
	 */
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

	/**
	 * Getter del código postal
	 * 
	 * @return el código postal de la gasolinera
	 */
	public short getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * Getter de dirección
	 * 
	 * @return dirección de la gasolinera
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Getter de horario
	 * 
	 * @return horario de la gasolinera
	 */
	public String getHorario() {
		return horario;
	}

	/**
	 * Getter de latitud
	 * 
	 * @return latitud de la gasolinera
	 */
	public float getLatitud() {
		float latitudFloat = Float.parseFloat(latitud.replace(",", "."));
		return latitudFloat;
	}

	/**
	 * Getter de localidad
	 * 
	 * @return localidad de la gasolinera
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * Getter de longitud
	 * 
	 * @return longitud de la gasolinera
	 */
	public float getLongitud() {
		float longitudFloat = Float.parseFloat(longitud.replace(",", "."));
		return longitudFloat;
	}

	/**
	 * Getter de margen
	 * 
	 * @return margen de la gasolinera
	 */
	public char getMargen() {
		return margen;
	}

	/**
	 * Getter de municipio
	 * 
	 * @return municipio de la gasolinera
	 */
	public String getMunicipio() {
		return municipio;
	}

	/**
	 * Getter de biodiesel
	 * 
	 * @return precio del biodiesel
	 */
	public String getBioDiesel() {
		return bioDiesel;
	}

	/**
	 * Getter de bioetanol
	 * 
	 * @return precio del bioetanol
	 */
	public String getBioEtanol() {
		return bioEtanol;
	}

	/**
	 * Getter de gnc
	 * 
	 * @return precio del gnc
	 */
	public String getGnc() {
		return gnc;
	}

	/**
	 * Getter de gnl
	 * 
	 * @return precio del gnl
	 */
	public String getGnl() {
		return gnl;
	}

	/**
	 * Getter de glp
	 * 
	 * @return precio del glp
	 */
	public String getGlp() {
		return glp;
	}

	/**
	 * Getter de gasoleoa
	 * 
	 * @return precio del gasoleo a
	 */
	public String getGasoleoA() {
		return gasoleoA;
	}

	/**
	 * Getter de gasoleob
	 * 
	 * @return precio del gasoleo b
	 */
	public String getGasoleoB() {
		return gasoleoB;
	}

	/**
	 * Getter del gasoleo premium
	 * 
	 * @return precio del gasoleo premium
	 */
	public String getGasoleoPremium() {
		return gasoleoPremium;
	}

	/**
	 * Getter de la gasolina 95 e10
	 * 
	 * @return precio de la gasolina 95 e10
	 */
	public String getGasolina95E10() {
		return gasolina95E10;
	}

	/**
	 * Getter de la gasolina 95 e5
	 * 
	 * @return precio de la gasolina 95 e5
	 */
	public String getGasolina95E5() {
		return gasolina95E5;
	}

	/**
	 * Getter de la gasolina 95 premium
	 * 
	 * @return precio de la gasolina 95 premium
	 */
	public String getGasolina95E5Premium() {
		return gasolina95E5Premium;
	}

	/**
	 * Getter de la gasolina 98 e10
	 * 
	 * @return precio de la gasolina 98 e10
	 */
	public String getGasolina98E10() {
		return gasolina98E10;
	}

	/**
	 * Getter de la gasolina 98 e5
	 * 
	 * @return precio de la gasolina 98 e5
	 */
	public String getGasolina98E5() {
		return gasolina98E5;
	}

	/**
	 * Getter del hidrógeno
	 * 
	 * @return precio del hidrógeno
	 */
	public String getHidrogeno() {
		return hidrogeno;
	}

	/**
	 * Getter de provincia
	 * 
	 * @return provincia de la gasolinera
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * Getter de remisión
	 * 
	 * @return remisión de la gasolinera
	 */
	public String getRemision() {
		return remision;
	}

	/**
	 * Getter de rótulo
	 * 
	 * @return rótulo de la gasolinera
	 */
	public String getRotulo() {
		return rotulo;
	}

	/**
	 * Getter de tipo de venta
	 * 
	 * @return tipo de venta de la gasolinera
	 */
	public char getTipoVenta() {
		return tipoVenta;
	}

	/**
	 * Getter de porcentaje de bioetanol
	 * 
	 * @return porcentaje de bioetanol
	 */
	public String getPorcBioEtanol() {
		return porcBioEtanol;
	}

	/**
	 * Getter de porcentaje ester metílico
	 * 
	 * @return porcentaje ester metílico
	 */
	public String getPorcEsterMetilico() {
		return porcEsterMetilico;
	}

	/**
	 * Getter de identificador de estación de servicio
	 * 
	 * @return identificador de la estación de servicio
	 */
	public short getIdEstacionServicio() {
		return idEstacionServicio;
	}

	/**
	 * Getter de identificador de municipio
	 * 
	 * @return identificador del municipio de la gasolinera
	 */
	public short getIdMunicipio() {
		return idMunicipio;
	}

	/**
	 * Getter de identificador de provincia
	 * 
	 * @return identificador de la provincia de la gasolinera
	 */
	public byte getIdProvincia() {
		return idProvincia;
	}

	/**
	 * Getter de identificador de comunidad
	 * 
	 * @return identificador de la comunidad autónoma de la gasolinera
	 */
	public String getIdComunidad() {
		return idComunidad;
	}

	/**
	 * toString de la clase Gasolinera, muestra formateada toda la información de la
	 * mismo
	 * 
	 * @return String con toda la información de la gasolinera
	 */
	@Override
	public String toString() {
		return rotulo + " " + direccion + " " + codigoPostal + " " + localidad + " (" + provincia + ")";
	}

	public int compareTo(Gasolinera o) {
		if (this.gasolina95E5.compareTo(o.gasolina95E5) == 0) {
			return this.rotulo.compareTo(o.rotulo);
		}
		return this.gasolina95E5.compareTo(o.gasolina95E5);
	}

}
