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
import java.awt.Font;
import javax.swing.SwingConstants;

public class PantallaLogin extends JPanel {
	private Ventana ventana;
	private String dni;
	private JPasswordField campoPassword;

	public PantallaLogin(Ventana v, String mensaje) {
		this.ventana = v;
		this.dni = mensaje;
		setLayout(null);

		JLabel labelCabecera = new JLabel("INICIAR SESION");
		labelCabecera.setBounds(111, 21, 216, 44);
		labelCabecera.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		add(labelCabecera);

		JLabel labelInfo = new JLabel("Por favor, introduce una contraseña para iniciar sesión.");
		labelInfo.setBounds(44, 76, 453, 14);
		labelInfo.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelInfo);

		JLabel labelPassword = new JLabel("Contraseña");
		labelPassword.setBounds(70, 114, 56, 14);
		add(labelPassword);

		campoPassword = new JPasswordField();
		campoPassword.setBounds(136, 111, 235, 20);
		add(campoPassword);

		JButton botonLogin = new JButton("Login");
		botonLogin.setBounds(94, 156, 270, 23);
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String password = new String(campoPassword.getPassword());
				try {
					ventana.usuarioLogado = new UsuarioDAO(dni, password);
					JOptionPane.showMessageDialog(ventana, "Bienvenid@ " + ventana.usuarioLogado.getNombre(),
							"Se ha iniciado la sesión con éxito", JOptionPane.INFORMATION_MESSAGE);

					PantallaPrincipal principal = new PantallaPrincipal(ventana);
					ventana.irAPantalla(NombrePantalla.BIENVENIDA,"HOLA "+ventana.usuarioLogado.getNombre().toUpperCase());

				} catch (SQLException | PassIncorrectoException | UsuarioNoExisteException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}

		});
		add(botonLogin);
	}

}
