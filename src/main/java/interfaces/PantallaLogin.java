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

public class PantallaLogin extends JPanel {
	private Ventana ventana;
	private String dni;
	private JPasswordField campoPassword;

	public PantallaLogin(Ventana v, String mensaje) {
		this.ventana = v;
		this.dni = mensaje;
		setLayout(null);

		JLabel labelCabecera = new JLabel("INICIAR SESI\u00D3N");
		labelCabecera.setBounds(167, 11, 216, 44);
		labelCabecera.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		add(labelCabecera);

		JLabel labelUsuario = new JLabel("HOLA " + ventana.usuarioLogado.getNombre());
		labelUsuario.setFont(new Font("Bauhaus 93", Font.BOLD, 20));
		labelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		labelUsuario.setBounds(37, 66, 453, 28);
		add(labelUsuario);

		JLabel labelInfo = new JLabel("Por favor, introduce una contraseña para iniciar sesión.");
		labelInfo.setBounds(48, 97, 453, 14);
		labelInfo.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelInfo);

		JLabel labelPassword = new JLabel("Contraseña");
		labelPassword.setBounds(76, 122, 93, 14);
		add(labelPassword);

		campoPassword = new JPasswordField();
		campoPassword.setBounds(167, 119, 235, 20);
		add(campoPassword);

		JButton botonLogin = new JButton("Login");
		botonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = new String(campoPassword.getPassword());
				try {
					ventana.usuarioLogado = new UsuarioDAO(dni, password);
					JOptionPane.showMessageDialog(ventana, "Bienvenid@ " + ventana.usuarioLogado.getNombre(),
							"Se ha iniciado la sesión con éxito", JOptionPane.INFORMATION_MESSAGE);

					ventana.irAPantalla(NombrePantalla.BIENVENIDA,
							"HOLA " + ventana.usuarioLogado.getNombre().toUpperCase());
					ventana.pantallaPrincipal.botonMiPerfil.setEnabled(true);
					ventana.pantallaPrincipal.botonUbicacion.setEnabled(true);
					ventana.pantallaPrincipal.botonLocalidades.setEnabled(true);
					ventana.pantallaPrincipal.botonBuscar.setEnabled(true);

				} catch (SQLException | PassIncorrectoException | UsuarioNoExisteException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		botonLogin.setBounds(167, 176, 223, 23);
		add(botonLogin);

	}

}