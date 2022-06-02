package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame {
	/** Representa la pantalla actual por la que estoy navegando **/
	private JPanel ventanaActual;

	public Ventana() {
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("Gasolineras");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);

		this.setVisible(true);
	}

	public void irAVentana(String nombreVentana) {
		this.ventanaActual.setVisible(false);
		this.ventanaActual = null;
		switch (nombreVentana) {
		case "login":
		//	this.ventanaActual=new VentanaLogin(this);
			break;
		case "registro":
		//	this.ventanaActual=new VentanaRegistro(this);
			break;
		}
		
		this.ventanaActual.setVisible(true);
		this.setContentPane(this.ventanaActual);
	}
}
