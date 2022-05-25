package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGet {
	public static String httpGet(String urlStr) throws IOException {
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
		}
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
