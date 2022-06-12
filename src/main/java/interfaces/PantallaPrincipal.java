package interfaces;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import clases.UsuarioDAO;
import enums.NombrePantalla;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class PantallaPrincipal extends JPanel {
	private Ventana ventana;
	protected JPanel contenedor;
	protected JButton botonLogin;
	protected JButton botonMiPerfil;
	protected JButton botonUbicacion;
	protected JButton botonLocalidades;
	protected JButton botonLogout;
	protected JButton botonCombustible;
	private JButton botonSalir;

	public PantallaPrincipal(Ventana v) {
		setBackground(Color.RED);
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		
		PanelFondoImagen imagenFondo = new PanelFondoImagen("./imagenes/EstacionServicio2.jpg");
		add(imagenFondo);
		imagenFondo.setOpaque(false);
		imagenFondo.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorte = new JPanel();
		imagenFondo.add(panelNorte, BorderLayout.NORTH);
		panelNorte.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelNorte.setOpaque(false);

		contenedor = new JPanel();
		imagenFondo.add(contenedor, BorderLayout.CENTER);
		contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.X_AXIS));
		contenedor.setOpaque(false);


		botonLogin = new JButton("INICIAR SESIÓN");
		botonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.irAPantalla(NombrePantalla.INICIO);
			}
		});
		GridBagConstraints gbc_botonLogin = new GridBagConstraints();
		panelNorte.add(botonLogin, gbc_botonLogin);

		botonLogout = new JButton("CERRAR SESIÓN");
		botonLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.usuarioLogado = new UsuarioDAO();
				botonLogout.setVisible(false);
				botonLogin.setVisible(true);
				botonMiPerfil.setEnabled(false);
				botonUbicacion.setEnabled(false);
				botonLocalidades.setEnabled(false);
				botonCombustible.setEnabled(false);
				ventana.irAPantalla(NombrePantalla.INICIO);
			}
		});
		botonLogout.setVisible(false);
		GridBagConstraints gbc_botonCerrarSesion = new GridBagConstraints();
		gbc_botonCerrarSesion.insets = new Insets(0, 0, 5, 0);
		gbc_botonCerrarSesion.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonCerrarSesion.gridx = 0;
		gbc_botonCerrarSesion.gridy = 0;
		panelNorte.add(botonLogout, gbc_botonCerrarSesion);

		botonMiPerfil = new JButton("MI PERFIL");
		botonMiPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.irAPantalla(NombrePantalla.MIPERFIL);
			}
		});
		botonMiPerfil.setEnabled(false);
		botonMiPerfil.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_botonMiPerfil = new GridBagConstraints();
		gbc_botonMiPerfil.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonMiPerfil.insets = new Insets(0, 0, 5, 0);
		gbc_botonMiPerfil.gridx = 0;
		gbc_botonMiPerfil.gridy = 1;
		panelNorte.add(botonMiPerfil, gbc_botonMiPerfil);

		botonUbicacion = new JButton("UBICACIÓN");
		botonUbicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.irAPantalla(NombrePantalla.UBICACION);
			}
		});
		botonUbicacion.setEnabled(false);
		GridBagConstraints gbc_botonUbicacion = new GridBagConstraints();
		gbc_botonUbicacion.insets = new Insets(0, 0, 5, 0);
		gbc_botonUbicacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonUbicacion.gridx = 0;
		gbc_botonUbicacion.gridy = 2;
		panelNorte.add(botonUbicacion, gbc_botonUbicacion);

		botonLocalidades = new JButton("LOCALIDADES");
		botonLocalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.irAPantalla(NombrePantalla.LOCALIDADES);
			}
		});
		botonLocalidades.setEnabled(false);
		GridBagConstraints gbc_botonLocalidades = new GridBagConstraints();
		gbc_botonLocalidades.insets = new Insets(0, 0, 5, 0);
		gbc_botonLocalidades.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonLocalidades.gridx = 0;
		gbc_botonLocalidades.gridy = 3;
		panelNorte.add(botonLocalidades, gbc_botonLocalidades);

		botonCombustible = new JButton("COMBUSTIBLE");
		botonCombustible.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.irAPantalla(NombrePantalla.COMBUSTIBLE);
			}
		});
		botonCombustible.setEnabled(false);
		GridBagConstraints gbc_botonCombustible = new GridBagConstraints();
		gbc_botonCombustible.insets = new Insets(0, 0, 5, 0);
		gbc_botonCombustible.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonCombustible.gridx = 0;
		gbc_botonCombustible.gridy = 4;
		panelNorte.add(botonCombustible, gbc_botonCombustible);
		
		botonSalir = new JButton("SALIR");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panelNorte.add(botonSalir);

	}

}
