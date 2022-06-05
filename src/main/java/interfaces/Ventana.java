package interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.UsuarioDAO;
import enums.NombrePantalla;

public class Ventana extends JFrame {
	/** Representa la pantalla actual por la que estoy navegando **/
	private JPanel pantallaActual;
	protected UsuarioDAO usuarioLogado;
	
	public Ventana() {
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("Gasolineras");
		this.pantallaActual=new PantallaInicio(this);
		this.setContentPane(this.pantallaActual);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void irAPantalla(NombrePantalla nombreVentana) {
		this.pantallaActual.setVisible(false);
		this.pantallaActual = null;
		switch (nombreVentana) {
		case INICIO:
			this.pantallaActual=new PantallaInicio(this);
			break;
		case REGISTRO:
			this.pantallaActual=new PantallaRegistro(this);
			break;
		case LOGIN:
			this.pantallaActual=new PantallaLogin(this);
			break;
		}
		this.pantallaActual.setVisible(true);
		this.setContentPane(this.pantallaActual);
	}
}