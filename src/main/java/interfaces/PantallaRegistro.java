package interfaces;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import clases.UsuarioDAO;
import enums.NombrePantalla;

import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PantallaRegistro extends JPanel {
	private Ventana ventana;
	private JTextField campoDni;
	private JTextField campoNombre;
	private JTextField campoEmail;
	private JPasswordField campoPassword;
	private JPasswordField campoPassword2;
	private JButton botonRegistrar;

	public PantallaRegistro(Ventana v, String mensaje) {
		this.ventana = v;
		setLayout(null);

		JLabel labelRegistro = new JLabel("REGISTRO");
		labelRegistro.setBounds(193, 47, 136, 44);
		labelRegistro.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		add(labelRegistro);

		JLabel labelDni = new JLabel("DNI");
		labelDni.setBounds(80, 105, 56, 14);
		labelDni.setHorizontalAlignment(SwingConstants.LEFT);
		add(labelDni);

		campoDni = new JTextField(mensaje);
		campoDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarRegistro();
			}
		});
		campoDni.setBounds(190, 102, 159, 20);
		add(campoDni);
		campoDni.setColumns(10);

		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(80, 136, 60, 14);
		labelNombre.setHorizontalAlignment(SwingConstants.LEFT);
		add(labelNombre);

		campoNombre = new JTextField();
		campoNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarRegistro();
			}
		});
		campoNombre.setBounds(190, 133, 159, 20);
		add(campoNombre);
		campoNombre.setColumns(10);

		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(80, 167, 60, 14);
		add(labelEmail);

		campoEmail = new JTextField();
		campoEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarRegistro();
			}
		});
		campoEmail.setBounds(190, 164, 159, 20);
		add(campoEmail);
		campoEmail.setColumns(10);

		JLabel labelPassword = new JLabel("Contraseña");
		labelPassword.setBounds(80, 198, 77, 14);
		add(labelPassword);

		campoPassword = new JPasswordField();
		campoPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarRegistro();
			}
		});
		campoPassword.setBounds(190, 195, 159, 20);
		add(campoPassword);

		JLabel labelPassword2 = new JLabel("Repita Contraseña");
		labelPassword2.setBounds(80, 229, 110, 14);
		add(labelPassword2);

		campoPassword2 = new JPasswordField();
		campoPassword2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarRegistro();
			}
		});
		campoPassword2.setBounds(190, 226, 159, 20);
		add(campoPassword2);

		botonRegistrar = new JButton("Registrar");
		botonRegistrar.setEnabled(false);

		botonRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String dni = campoDni.getText();
				String nombreUsuario = campoNombre.getText();
				String email = campoEmail.getText();
				String password = new String(campoPassword.getPassword());
				String password2 = new String(campoPassword2.getPassword());

				if (!password.equals(password2)) {
					JOptionPane.showMessageDialog(ventana, "Las contraseñas no coinciden", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						ventana.usuarioLogado = new UsuarioDAO(dni, nombreUsuario, email, password);
						JOptionPane.showMessageDialog(ventana, "Usuari@ registrad@ con éxito", "Registro completado",
								JOptionPane.PLAIN_MESSAGE);
						ventana.irAPantalla(NombrePantalla.LOGIN, dni);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});

		botonRegistrar.setBounds(202, 257, 94, 23);
		add(botonRegistrar);
	}

	public void habilitarRegistro() {
		String nombreUsuario = campoNombre.getText();
		String email = campoEmail.getText();
		String password = new String(campoPassword.getPassword());
		String password2 = new String(campoPassword2.getPassword());

		if (nombreUsuario.isBlank() || email.isBlank() || password.isBlank() || password2.isBlank()) {
			botonRegistrar.setEnabled(false);
		} else {
			botonRegistrar.setEnabled(true);
		}

	}
}
