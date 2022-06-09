package main;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

import com.google.gson.Gson;

import clases.UsuarioDAO;
import excepciones.PassIncorrectoException;
import excepciones.UsuarioNoExisteException;
import interfaces.Ventana;
import utils.HttpGet;

public class Main {

	public static void main(String[] args) {
		

		try {
			JFrame.setDefaultLookAndFeelDecorated(true);
			JDialog.setDefaultLookAndFeelDecorated(true);
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			// UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		Ventana ventana = new Ventana();
		
	/*
		try {
			UsuarioDAO usuario = new UsuarioDAO("75897420L");
			System.out.println(usuario.getEmail());
		} catch (SQLException | UsuarioNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			UsuarioDAO usuario2=new UsuarioDAO("75897420L","holahola");
		} catch (SQLException | PassIncorrectoException | UsuarioNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/
	}

}
