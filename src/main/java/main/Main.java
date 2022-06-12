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
			JFrame.setDefaultLookAndFeelDecorated(false);
			JDialog.setDefaultLookAndFeelDecorated(true);
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		Ventana ventana = new Ventana();
	}

}
