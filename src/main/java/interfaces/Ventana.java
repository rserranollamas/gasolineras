package interfaces;

import java.awt.BorderLayout;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;

import clases.PosicionDAO;
import clases.UsuarioDAO;
import enums.NombrePantalla;

public class Ventana extends JFrame {
	/** Representa la pantalla actual por la que estoy navegando **/
	protected PantallaPrincipal pantallaPrincipal;
	protected UsuarioDAO usuarioLogado;
	protected PosicionDAO posicionUsuario;

	public Ventana() {
		this.setSize(700, 400);
		this.setUndecorated(true);
	//	setShape(new RoundRectangle2D.Double(0,0,this.getBounds().width,this.getBounds().height,50,50));
		getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(100,230,124)));
		this.setLocationRelativeTo(null);
		this.setTitle("Gasolineras");
		this.pantallaPrincipal = new PantallaPrincipal(this);
		this.setContentPane(this.pantallaPrincipal);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void irAPantalla(NombrePantalla nombreVentana) {
		this.pantallaPrincipal.contenedor.removeAll();
		switch (nombreVentana) {
		case PRINCIPAL:
			break;
		case INICIO:
			this.pantallaPrincipal.contenedor.add(new PantallaInicio(this), BorderLayout.CENTER);
			break;
		case REGISTRO:
			this.pantallaPrincipal.contenedor.add(new PantallaRegistro(this), BorderLayout.CENTER);
			break;
		case LOGIN:
			this.pantallaPrincipal.contenedor.add(new PantallaLogin(this), BorderLayout.CENTER);
			break;
		case BIENVENIDA:
			this.pantallaPrincipal.contenedor.add(new PantallaBienvenida(this), BorderLayout.CENTER);
			break;
		case COMBUSTIBLE:
			this.pantallaPrincipal.contenedor.add(new PantallaCombustible(this), BorderLayout.CENTER);
			break;
		case MIPERFIL:
			this.pantallaPrincipal.contenedor.add(new PantallaMiPerfil(this), BorderLayout.CENTER);
			break;
		case UBICACION:
			this.pantallaPrincipal.contenedor.add(new PantallaUbicacion(this), BorderLayout.CENTER);
			break;
		case LOCALIDADES:
			this.pantallaPrincipal.contenedor.add(new PantallaLocalidades(this), BorderLayout.CENTER);
			break;
		}
		this.pantallaPrincipal.contenedor.setOpaque(false);
		this.pantallaPrincipal.contenedor.repaint();
		this.pantallaPrincipal.contenedor.revalidate();
	}
}