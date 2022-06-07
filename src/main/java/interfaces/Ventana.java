package interfaces;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.UsuarioDAO;
import enums.NombrePantalla;

public class Ventana extends JFrame {
	/** Representa la pantalla actual por la que estoy navegando **/
	private PantallaPrincipal pantallaPrincipal;
	protected UsuarioDAO usuarioLogado;

	public Ventana() {
		this.setSize(700, 400);
		this.setLocationRelativeTo(null);
		this.setTitle("Gasolineras");
		this.pantallaPrincipal = new PantallaPrincipal(this);

		this.setContentPane(this.pantallaPrincipal);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void irAPantalla(NombrePantalla nombreVentana, String mensaje) {
		this.pantallaPrincipal.contenedor.setLocation(0, 0);
		this.pantallaPrincipal.contenedor.removeAll();
		switch (nombreVentana) {
		case PRINCIPAL:
			break;
		case INICIO:
			this.pantallaPrincipal.contenedor.add(new PantallaInicio(this, mensaje), BorderLayout.CENTER);
			break;
		case REGISTRO:
			this.pantallaPrincipal.contenedor.add(new PantallaRegistro(this, mensaje), BorderLayout.CENTER);
			break;
		case LOGIN:
			this.pantallaPrincipal.contenedor.add(new PantallaLogin(this, mensaje), BorderLayout.CENTER);
			break;
		}
		this.pantallaPrincipal.contenedor.repaint();
		this.pantallaPrincipal.contenedor.revalidate();
	}
}