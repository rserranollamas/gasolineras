package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import enums.NombrePantalla;

import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaPrincipal extends JPanel {
	private Ventana ventana;
	protected JPanel contenedor;

	public PantallaPrincipal(Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));

		contenedor = new JPanel();
		contenedor.setSize(700, 700);
		add(contenedor, BorderLayout.CENTER);
		contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.X_AXIS));

		JPanel panelEste = new JPanel();
		add(panelEste, BorderLayout.WEST);
		GridBagLayout gbl_panelEste = new GridBagLayout();
		gbl_panelEste.columnWidths = new int[] { 113, 0 };
		gbl_panelEste.rowHeights = new int[] { 23, 23, 23, 0, 0, 0 };
		gbl_panelEste.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panelEste.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelEste.setLayout(gbl_panelEste);

		JButton botonLogin = new JButton("INICIAR SESIÓN");
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla(NombrePantalla.INICIO, "INICIAR SESIÓN O REGISTRARSE");
			}
		});
		GridBagConstraints gbc_botonLogin = new GridBagConstraints();
		gbc_botonLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonLogin.insets = new Insets(0, 0, 5, 0);
		gbc_botonLogin.gridx = 0;
		gbc_botonLogin.gridy = 0;
		panelEste.add(botonLogin, gbc_botonLogin);

		JButton botonMiPerfil = new JButton("MI PERFIL");
		botonMiPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		botonMiPerfil.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_botonMiPerfil = new GridBagConstraints();
		gbc_botonMiPerfil.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonMiPerfil.insets = new Insets(0, 0, 5, 0);
		gbc_botonMiPerfil.gridx = 0;
		gbc_botonMiPerfil.gridy = 1;
		panelEste.add(botonMiPerfil, gbc_botonMiPerfil);

		JButton botonBuscar = new JButton("BUSCAR");
		GridBagConstraints gbc_botonBuscar = new GridBagConstraints();
		gbc_botonBuscar.insets = new Insets(0, 0, 5, 0);
		gbc_botonBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonBuscar.gridx = 0;
		gbc_botonBuscar.gridy = 2;
		panelEste.add(botonBuscar, gbc_botonBuscar);

		JButton botonUbicacion = new JButton("UBICACIÓN");
		GridBagConstraints gbc_botonUbicacion = new GridBagConstraints();
		gbc_botonUbicacion.insets = new Insets(0, 0, 5, 0);
		gbc_botonUbicacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonUbicacion.gridx = 0;
		gbc_botonUbicacion.gridy = 3;
		panelEste.add(botonUbicacion, gbc_botonUbicacion);

		JButton botonCombustible = new JButton("COMBUSTIBLE");
		GridBagConstraints gbc_botonCombustible = new GridBagConstraints();
		gbc_botonCombustible.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonCombustible.gridx = 0;
		gbc_botonCombustible.gridy = 4;
		panelEste.add(botonCombustible, gbc_botonCombustible);

	}
}
