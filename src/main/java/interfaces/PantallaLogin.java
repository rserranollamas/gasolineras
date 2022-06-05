package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import clases.UsuarioDAO;
import enums.NombrePantalla;
import excepciones.PassIncorrectoException;
import excepciones.UsuarioNoExisteException;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class PantallaLogin extends JPanel {
	private Ventana ventana;
	private JTextField campoDni;
	private JPasswordField campoPassword;

	public PantallaLogin(Ventana v) {
		this.ventana = v;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 92, 0, 0, 80, 0, 231, 87, 118, 91, 0, 0, 450, 0 };
		gridBagLayout.rowHeights = new int[] { 112, 33, 32, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0,
				0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel labelDni = new JLabel("DNI");
		GridBagConstraints gbc_labelDni = new GridBagConstraints();
		gbc_labelDni.anchor = GridBagConstraints.WEST;
		gbc_labelDni.insets = new Insets(0, 0, 5, 5);
		gbc_labelDni.gridx = 6;
		gbc_labelDni.gridy = 1;
		add(labelDni, gbc_labelDni);

		campoDni = new JTextField();
		GridBagConstraints gbc_campoDni = new GridBagConstraints();
		gbc_campoDni.gridwidth = 4;
		gbc_campoDni.insets = new Insets(0, 0, 5, 5);
		gbc_campoDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoDni.gridx = 8;
		gbc_campoDni.gridy = 1;
		add(campoDni, gbc_campoDni);
		campoDni.setColumns(10);

		JLabel labelPassword = new JLabel("Contraseña");
		GridBagConstraints gbc_labelPassword = new GridBagConstraints();
		gbc_labelPassword.anchor = GridBagConstraints.WEST;
		gbc_labelPassword.insets = new Insets(0, 0, 5, 5);
		gbc_labelPassword.gridx = 6;
		gbc_labelPassword.gridy = 2;
		add(labelPassword, gbc_labelPassword);

		campoPassword = new JPasswordField();
		GridBagConstraints gbc_campoPassword = new GridBagConstraints();
		gbc_campoPassword.gridwidth = 4;
		gbc_campoPassword.insets = new Insets(0, 0, 5, 5);
		gbc_campoPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_campoPassword.gridx = 8;
		gbc_campoPassword.gridy = 2;
		add(campoPassword, gbc_campoPassword);

		JButton botonLogin = new JButton("Login");
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String dni = campoDni.getText();
				String password = new String(campoPassword.getPassword());
				try {
					ventana.usuarioLogado = new UsuarioDAO(dni, password);
					JOptionPane.showMessageDialog(ventana, "Bienvenid@ " + ventana.usuarioLogado.getNombre(),
							"Se ha iniciado la sesión con éxito", JOptionPane.INFORMATION_MESSAGE);
					// ventana.irAPantalla(NombrePantalla.INICIO);
				} catch (SQLException | PassIncorrectoException | UsuarioNoExisteException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_botonLogin = new GridBagConstraints();
		gbc_botonLogin.insets = new Insets(0, 0, 0, 5);
		gbc_botonLogin.gridx = 10;
		gbc_botonLogin.gridy = 7;
		add(botonLogin, gbc_botonLogin);

		JButton botonVolver = new JButton("Volver");
		botonVolver.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla(NombrePantalla.INICIO);
			}
		});
		GridBagConstraints gbc_botonVolver = new GridBagConstraints();
		gbc_botonVolver.insets = new Insets(0, 0, 0, 5);
		gbc_botonVolver.gridx = 11;
		gbc_botonVolver.gridy = 7;
		add(botonVolver, gbc_botonVolver);
	}

}
