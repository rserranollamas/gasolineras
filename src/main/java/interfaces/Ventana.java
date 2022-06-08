package interfaces;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import clases.PosicionDAO;
import clases.UsuarioDAO;
import enums.NombrePantalla;

public class Ventana extends JFrame {
	/** Representa la pantalla actual por la que estoy navegando **/
	protected PantallaPrincipal pantallaPrincipal;
	protected PantallaUbicacion pantallaUbicacion;
	protected UsuarioDAO usuarioLogado;
	protected PosicionDAO posicionUsuario;

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
		case BIENVENIDA:
			this.pantallaPrincipal.contenedor.add(new PantallaBienvenida(this, mensaje), BorderLayout.CENTER);
			break;
		case COMBUSTIBLE:
			this.pantallaPrincipal.contenedor.add(new PantallaCombustible(this, mensaje), BorderLayout.CENTER);
			break;
		case MIPERFIL:
			this.pantallaPrincipal.contenedor.add(new PantallaMiPerfil(this, mensaje), BorderLayout.CENTER);
			break;
		case UBICACION:
			this.pantallaUbicacion = new PantallaUbicacion(this, mensaje);
			this.pantallaPrincipal.contenedor.add(this.pantallaUbicacion, BorderLayout.CENTER);
			break;
		case LOCALIDADES:
			this.pantallaPrincipal.contenedor.add(new PantallaLocalidades(this, mensaje), BorderLayout.CENTER);
			break;
		case GASOLINERAS:
			this.pantallaPrincipal.contenedor.add(new PantallaGasolineras(this,mensaje),BorderLayout.CENTER);
			break;
		}
		this.pantallaPrincipal.contenedor.repaint();
		this.pantallaPrincipal.contenedor.revalidate();
	}
}