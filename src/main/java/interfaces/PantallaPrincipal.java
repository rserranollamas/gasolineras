package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import clases.PosicionDAO;
import enums.NombrePantalla;
import excepciones.PosicionNoExisteException;

import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class PantallaPrincipal extends JPanel {
	private Ventana ventana;
	protected JPanel contenedor;
	protected JButton botonLogin;
	protected JButton botonMiPerfil;
	protected JButton botonUbicacion;
	protected JButton botonLocalidades;

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
		gbl_panelEste.rowHeights = new int[] { 23, 23, 0, 0, 23, 0, 0, 0 };
		gbl_panelEste.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panelEste.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelEste.setLayout(gbl_panelEste);

		botonLogin = new JButton("INICIAR SESIÓN");
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		botonMiPerfil.setEnabled(false);
		botonMiPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla(NombrePantalla.MIPERFIL,
						"PERFIL DE " + ventana.usuarioLogado.getNombre().toUpperCase());
			}
		});
		botonMiPerfil.setVerticalAlignment(SwingConstants.TOP);
		GridBagConstraints gbc_botonMiPerfil = new GridBagConstraints();
		gbc_botonMiPerfil.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonMiPerfil.insets = new Insets(0, 0, 5, 0);
		gbc_botonMiPerfil.gridx = 0;
		gbc_botonMiPerfil.gridy = 1;
		panelEste.add(botonMiPerfil, gbc_botonMiPerfil);

		botonUbicacion = new JButton("UBICACIÓN");
		botonUbicacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ventana.posicionUsuario = new PosicionDAO(ventana.usuarioLogado);
					System.out.println(ventana.usuarioLogado.getDni());
					ventana.irAPantalla(NombrePantalla.UBICACION, "Puedes modificar la ubicación si lo deseas");
					ventana.pantallaUbicacion.campoLatitud
							.setText(Float.toString(ventana.posicionUsuario.getLatitud()));
					ventana.pantallaUbicacion.campoLongitud
							.setText(Float.toString(ventana.posicionUsuario.getLongitud()));
					ventana.pantallaUbicacion.campoRadioKm
							.setText(Short.toString(ventana.posicionUsuario.getRadioKm()));
				} catch (SQLException | PosicionNoExisteException e1) {
					ventana.irAPantalla(NombrePantalla.UBICACION,
							"Introduce tu ubicaci�n para poder realizar la b�squeda");
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		botonUbicacion.setEnabled(false);
		GridBagConstraints gbc_botonUbicacion = new GridBagConstraints();
		gbc_botonUbicacion.insets = new Insets(0, 0, 5, 0);
		gbc_botonUbicacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonUbicacion.gridx = 0;
		gbc_botonUbicacion.gridy = 2;
		panelEste.add(botonUbicacion, gbc_botonUbicacion);

		JButton botonBuscar = new JButton("BUSCAR");
		botonBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla(NombrePantalla.GASOLINERAS, "Listado de Gasolineras");
			}
		});

		JButton botonCombustible = new JButton("COMBUSTIBLE");
		botonCombustible.setEnabled(false);
		botonCombustible.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla(NombrePantalla.COMBUSTIBLE,
						ventana.usuarioLogado.getNombre().toUpperCase() + ", SELECCIONA EL COMBUSTIBLE ");
			}
		});

		botonLocalidades = new JButton("LOCALIDADES");
		botonLocalidades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla(NombrePantalla.LOCALIDADES,
						ventana.usuarioLogado.getNombre().toUpperCase() + ", SELECCIONA LOCALIDADES A A�ADIR");
			}
		});
		botonLocalidades.setEnabled(false);
		GridBagConstraints gbc_botonLocalidades = new GridBagConstraints();
		gbc_botonLocalidades.insets = new Insets(0, 0, 5, 0);
		gbc_botonLocalidades.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonLocalidades.gridx = 0;
		gbc_botonLocalidades.gridy = 3;
		panelEste.add(botonLocalidades, gbc_botonLocalidades);
		GridBagConstraints gbc_botonCombustible = new GridBagConstraints();
		gbc_botonCombustible.insets = new Insets(0, 0, 5, 0);
		gbc_botonCombustible.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonCombustible.gridx = 0;
		gbc_botonCombustible.gridy = 4;
		panelEste.add(botonCombustible, gbc_botonCombustible);
		botonBuscar.setEnabled(false);
		GridBagConstraints gbc_botonBuscar = new GridBagConstraints();
		gbc_botonBuscar.insets = new Insets(0, 0, 5, 0);
		gbc_botonBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonBuscar.gridx = 0;
		gbc_botonBuscar.gridy = 5;
		panelEste.add(botonBuscar, gbc_botonBuscar);

	}
}
