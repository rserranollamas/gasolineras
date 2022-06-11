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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaPrincipal extends JPanel {
	private Ventana ventana;
	protected JPanel contenedor;
	protected JButton botonLogin;
	protected JButton botonMiPerfil;
	protected JButton botonUbicacion;
	protected JButton botonLocalidades;
	protected JButton botonBuscar;
	protected JButton botonCombustible;

	public PantallaPrincipal(Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));

		contenedor = new JPanel();
		add(contenedor, BorderLayout.CENTER);
		contenedor.setLayout(new BoxLayout(contenedor, BoxLayout.X_AXIS));

		JPanel panelEste = new JPanel();
		add(panelEste, BorderLayout.WEST);
		GridBagLayout gbl_panelEste = new GridBagLayout();
		gbl_panelEste.columnWidths = new int[] { 113, 0 };
		gbl_panelEste.rowHeights = new int[] { 23, 23, 0, 0, 23, 0, 0, 0 };
		gbl_panelEste.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panelEste.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelEste.setLayout(gbl_panelEste);

		botonLogin = new JButton("INICIAR SESIÓN");
		botonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.irAPantalla(NombrePantalla.INICIO, "INICIAR SESIÓN O REGISTRARSE");
				botonLogin.setText("INICIAR SESIÓN");
			}
		});
		GridBagConstraints gbc_botonLogin = new GridBagConstraints();
		gbc_botonLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonLogin.insets = new Insets(0, 0, 5, 0);
		gbc_botonLogin.gridx = 0;
		gbc_botonLogin.gridy = 0;
		panelEste.add(botonLogin, gbc_botonLogin);

		botonMiPerfil = new JButton("MI PERFIL");
		botonMiPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.irAPantalla(NombrePantalla.MIPERFIL,
						"PERFIL DE " + ventana.usuarioLogado.getNombre().toUpperCase());
			}
		});
		botonMiPerfil.setEnabled(false);
		botonMiPerfil.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_botonMiPerfil = new GridBagConstraints();
		gbc_botonMiPerfil.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonMiPerfil.insets = new Insets(0, 0, 5, 0);
		gbc_botonMiPerfil.gridx = 0;
		gbc_botonMiPerfil.gridy = 1;
		panelEste.add(botonMiPerfil, gbc_botonMiPerfil);

		botonUbicacion = new JButton("UBICACIÓN");
		botonUbicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.irAPantalla(NombrePantalla.UBICACION, "Listado de ubicaciones");
			}
		});
		botonUbicacion.setEnabled(false);
		GridBagConstraints gbc_botonUbicacion = new GridBagConstraints();
		gbc_botonUbicacion.insets = new Insets(0, 0, 5, 0);
		gbc_botonUbicacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonUbicacion.gridx = 0;
		gbc_botonUbicacion.gridy = 2;
		panelEste.add(botonUbicacion, gbc_botonUbicacion);

		botonLocalidades = new JButton("LOCALIDADES");
		botonLocalidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.irAPantalla(NombrePantalla.LOCALIDADES,
						ventana.usuarioLogado.getNombre().toUpperCase() + ", SELECCIONA LOCALIDADES A AÑADIR");
			}
		});
		botonLocalidades.setEnabled(false);
		GridBagConstraints gbc_botonLocalidades = new GridBagConstraints();
		gbc_botonLocalidades.insets = new Insets(0, 0, 5, 0);
		gbc_botonLocalidades.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonLocalidades.gridx = 0;
		gbc_botonLocalidades.gridy = 3;
		panelEste.add(botonLocalidades, gbc_botonLocalidades);

		botonCombustible = new JButton("COMBUSTIBLE");
		botonCombustible.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.irAPantalla(NombrePantalla.COMBUSTIBLE,
						ventana.usuarioLogado.getNombre().toUpperCase() + ", SELECCIONA EL COMBUSTIBLE ");
			}
		});
		botonCombustible.setEnabled(false);
		GridBagConstraints gbc_botonCombustible = new GridBagConstraints();
		gbc_botonCombustible.insets = new Insets(0, 0, 5, 0);
		gbc_botonCombustible.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonCombustible.gridx = 0;
		gbc_botonCombustible.gridy = 4;
		panelEste.add(botonCombustible, gbc_botonCombustible);

		botonBuscar = new JButton("BUSCAR");
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.irAPantalla(NombrePantalla.GASOLINERAS, "Listado de Gasolineras");
			}
		});
		botonBuscar.setEnabled(false);
		GridBagConstraints gbc_botonBuscar = new GridBagConstraints();
		gbc_botonBuscar.insets = new Insets(0, 0, 5, 0);
		gbc_botonBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonBuscar.gridx = 0;
		gbc_botonBuscar.gridy = 5;
		panelEste.add(botonBuscar, gbc_botonBuscar);

	}
}
