package interfaces;

import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.UsuarioDAO;
import enums.NombrePantalla;
import excepciones.UsuarioNoExisteException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PantallaInicio extends JPanel {
	private Ventana ventana;
	private JTextField campoDni;

	public PantallaInicio(Ventana v, String mensaje) {
		this.ventana = v;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 57, 0, 0, 231, 87, 118, 91, 0, 0, 450, 0 };
		gridBagLayout.rowHeights = new int[] { 112, 0, 0, 0, 33, 32, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel labelCabecera = new JLabel(mensaje);
		labelCabecera.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		GridBagConstraints gbc_labelCabecera = new GridBagConstraints();
		gbc_labelCabecera.gridwidth = 8;
		gbc_labelCabecera.insets = new Insets(0, 0, 5, 5);
		gbc_labelCabecera.gridx = 6;
		gbc_labelCabecera.gridy = 0;
		add(labelCabecera, gbc_labelCabecera);

		JLabel labelInfo = new JLabel("Vamos a comprobar si formas parte de Gasolineras APP");
		GridBagConstraints gbc_labelInfo = new GridBagConstraints();
		gbc_labelInfo.gridwidth = 2;
		gbc_labelInfo.insets = new Insets(0, 0, 5, 5);
		gbc_labelInfo.gridx = 10;
		gbc_labelInfo.gridy = 1;
		add(labelInfo, gbc_labelInfo);

		JLabel labelDni = new JLabel("DNI");
		GridBagConstraints gbc_labelDni = new GridBagConstraints();
		gbc_labelDni.anchor = GridBagConstraints.WEST;
		gbc_labelDni.insets = new Insets(0, 0, 5, 5);
		gbc_labelDni.gridx = 10;
		gbc_labelDni.gridy = 4;
		add(labelDni, gbc_labelDni);

		final JButton botonContinuar = new JButton("CONTINUAR");
		botonContinuar.setEnabled(false);

		GridBagConstraints gbc_botonContinuar = new GridBagConstraints();
		gbc_botonContinuar.insets = new Insets(0, 0, 5, 5);
		gbc_botonContinuar.gridx = 11;
		gbc_botonContinuar.gridy = 6;
		add(botonContinuar, gbc_botonContinuar);

		campoDni = new JTextField();
		campoDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (campoDni.getText().isBlank()) {
					botonContinuar.setEnabled(false);

				}
				botonContinuar.setEnabled(true);
			}
		});
		GridBagConstraints gbc_campoDni = new GridBagConstraints();
		gbc_campoDni.anchor = GridBagConstraints.WEST;
		gbc_campoDni.insets = new Insets(0, 0, 5, 5);
		gbc_campoDni.gridx = 11;
		gbc_campoDni.gridy = 4;
		add(campoDni, gbc_campoDni);
		campoDni.setColumns(10);

		botonContinuar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String dni = campoDni.getText();
				if (!dni.isBlank()) {
					try {
						UsuarioDAO usuarioLogado = new UsuarioDAO(dni);
						JOptionPane.showMessageDialog(ventana,
								usuarioLogado.getNombre() + " bienvenid@ a Gasolineras APP", "HOLA DE NUEVO",
								JOptionPane.INFORMATION_MESSAGE);
						ventana.irAPantalla(NombrePantalla.LOGIN, dni);
					} catch (SQLException | UsuarioNoExisteException e1) {
						JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
						ventana.irAPantalla(NombrePantalla.REGISTRO, dni);
					}

				}

			}
		});

	}
}
