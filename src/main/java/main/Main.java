package main;

import java.util.Iterator;
import java.util.TreeSet;

import clases.Gasolinera;
import clases.PosicionDAO;
import clases.UsuarioDAO;
import interfaces.Ventana;

public class Main {

	public static void main(String[] args) {
		Ventana ventana=new Ventana();
		UsuarioDAO usuario=new UsuarioDAO("Rodrigo","rserranollamas@gmail.com","holahola");
		usuario.añadirLocalidad("RINCON DE LA VICTORIA");
		PosicionDAO posicion=new PosicionDAO((float)36.71474,(float)-4.27577,(short)50);
		usuario.añadirPosicion(posicion);
		
	//	usuario.añadirLocalidad("RINCON DE LA VICTORIA");
		
	//	usuario.listarMisGasolineras();
		System.out.println(usuario.listarMisGasolineras().size());
	//	TreeSet<Gasolinera> misGasolineras = new TreeSet<Gasolinera>();
	//	misGasolineras=usuario.listarMisGasolineras();		
		
		Iterator it=usuario.listarMisGasolineras().iterator();
		System.out.println("-------------------------------------------------------------------------");
		
		while(it.hasNext()) {
			Gasolinera gasolinera=(Gasolinera)it.next();
		//	System.out.println(gasolinera.getDireccion()+" | LOCALIDAD: "+gasolinera.getLocalidad()+" | GASOLINA 95: "+gasolinera.getGasolina95E5());
			if(gasolinera.getGlp()!=" ") {
				System.out.println(gasolinera.getRotulo()+" - Precio GLP: "+gasolinera.getGlp());
			}
			
		}
	
	/*
		for (Gasolinera gasolinera : usuario.listarMisGasolineras()) {
			System.out.println(gasolinera);
		}
	*/
	}

}
