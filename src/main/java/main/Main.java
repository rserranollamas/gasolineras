package main;

import java.io.IOException;

import com.google.gson.Gson;

import clases.Gasolineras;
import utils.HttpGet;

public class Main {

	public static void main(String[] args) {

		try {
			// Obtenemos los datos de la web del Ministerio y los guardamos en un String
			String json = (HttpGet.httpGet(
					"https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/"));
			// Creamos un objeto Gson
			Gson gson = new Gson();
			// Convertimos el json en objeto (clase DatosJson.class)
			Gasolineras datos = gson.fromJson(json, Gasolineras.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
