package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import clases.UsuarioDAO;
import enums.NombrePantalla;
import excepciones.PassIncorrectoException;
import excepciones.UsuarioNoExisteException;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.sql.SQLException;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PantallaLogin extends JPanel {
	private Ventana ventana;
	private JPasswordField campoPassword;

	public PantallaLogin(Ventana v) {
		this.ventana = v;
		this.setOpaque(false);
		setLayout(null);

		JLabel labelUsuario = new JLabel("HOLA " + ventana.usuarioLogado.getNombre());
		labelUsuario.setForeground(Color.WHITE);
		labelUsuario.setFont(new Font("Bauhaus 93", Font.BOLD, 25));
		labelUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		labelUsuario.setBounds(70, 80, 252, 28);
		add(labelUsuario);

		JLabel labelInfo = new JLabel("Por favor, introduce una contraseña para iniciar sesión.");
		labelInfo.setForeground(Color.WHITE);
		labelInfo.setBounds(49, 11, 328, 14);
		labelInfo.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelInfo);

		JLabel labelPassword = new JLabel("Contraseña");
		labelPassword.setForeground(Color.WHITE);
		labelPassword.setBounds(49, 36, 93, 14);
		add(labelPassword);

		campoPassword = new JPasswordField();
		campoPassword.setBounds(131, 33, 160, 20);
		add(campoPassword);

		JButton botonLogin = new JButton("Login");
		botonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = new String(campoPassword.getPassword());
				try {
					ventana.usuarioLogado = new UsuarioDAO(ventana.usuarioLogado.getDni(), password);
					JOptionPane.showMessageDialog(ventana, "Bienvenid@ " + ventana.usuarioLogado.getNombre(),
							"Se ha iniciado la sesión con éxito", JOptionPane.INFORMATION_MESSAGE);

					ventana.irAPantalla(NombrePantalla.BIENVENIDA);
					ventana.pantallaPrincipal.botonMiPerfil.setEnabled(true);
					ventana.pantallaPrincipal.botonUbicacion.setEnabled(true);
					ventana.pantallaPrincipal.botonLocalidades.setEnabled(true);
					ventana.pantallaPrincipal.botonCombustible.setEnabled(true);
					ventana.pantallaPrincipal.botonLogout.setVisible(true);
					ventana.pantallaPrincipal.botonLogin.setVisible(false);

				} catch (SQLException | PassIncorrectoException | UsuarioNoExisteException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		botonLogin.setBounds(317, 32, 136, 23);
		add(botonLogin);

	}

}