package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HttpGet {
	public static String httpGet(String urlStr) throws IOException, KeyManagementException, NoSuchAlgorithmException {
		/* Start of the fix */
		/*
		 * TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
		 * public java.security.cert.X509Certificate[] getAcceptedIssuers() { return
		 * null; } public void checkClientTrusted(X509Certificate[] certs, String
		 * authType) { } public void checkServerTrusted(X509Certificate[] certs, String
		 * authType) { }
		 * 
		 * } };
		 * 
		 * SSLContext sc = SSLContext.getInstance("SSL"); sc.init(null, trustAllCerts,
		 * new java.security.SecureRandom());
		 * HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		 * 
		 * // Create all-trusting host name verifier HostnameVerifier allHostsValid =
		 * new HostnameVerifier() { public boolean verify(String hostname, SSLSession
		 * session) { return true; } }; // Install the all-trusting host verifier
		 * HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid); /* End of the
		 * fix
		 */

		// Creamos un objeto de tipo URL
		URL url = new URL(urlStr);
		// Abrimos la conexión e indicamos que será de tipo GET HttpURLConnection
		HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
		conexion.setRequestMethod("GET");
		conexion.setRequestProperty("Accept", "application/json");
		// Si la conexión devuelve una respuesta diferente a 200, devolvemos una
		// excepción con el código de respuesta
		if (conexion.getResponseCode() != 200) {
			throw new IOException(conexion.getResponseMessage());
		} else {
			// Creamos el buffer para leer BufferedReader
			BufferedReader lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			StringBuilder resultado = new StringBuilder();
			String linea = lector.readLine();
			// Mientras el BufferedReader se pueda leer, va añadiendo contenido a resultado
			while (linea != null) {
				resultado.append(linea);
				linea = lector.readLine();
			}
			// Cerramos el BufferedReader y la conexión
			lector.close();
			conexion.disconnect();
			// Devolvemos el resultado como cadena, no como StringBuilder
			return resultado.toString();
		}

	}
}
