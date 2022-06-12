package interfaces;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import clases.UsuarioDAO;
import enums.NombrePantalla;

import javax.swing.JPasswordField;
import java.awt.Font;
import java.sql.SQLException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PantallaRegistro extends JPanel {
	private Ventana ventana;
	private JTextField campoDni;
	private JTextField campoNombre;
	private JTextField campoEmail;
	private JPasswordField campoPassword;
	private JPasswordField campoPassword2;
	private JButton botonRegistrar;

	public PantallaRegistro(Ventana v) {
		this.ventana = v;
		setLayout(null);
		setOpaque(false);

		JLabel labelRegistro = new JLabel("REGISTRO");
		labelRegistro.setForeground(Color.WHITE);
		labelRegistro.setBounds(80, 82, 136, 35);
		labelRegistro.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		add(labelRegistro);

		JLabel labelDni = new JLabel("DNI");
		labelDni.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelDni.setForeground(Color.WHITE);
		labelDni.setBounds(80, 129, 56, 14);
		labelDni.setHorizontalAlignment(SwingConstants.LEFT);
		add(labelDni);

		campoDni = new JTextField();
		campoDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarRegistro();
			}
		});
		campoDni.setBounds(226, 128, 159, 20);
		add(campoDni);
		campoDni.setColumns(10);

		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setForeground(Color.WHITE);
		labelNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelNombre.setBounds(80, 160, 60, 14);
		labelNombre.setHorizontalAlignment(SwingConstants.LEFT);
		add(labelNombre);

		campoNombre = new JTextField();
		campoNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarRegistro();
			}
		});
		campoNombre.setBounds(226, 159, 159, 20);
		add(campoNombre);
		campoNombre.setColumns(10);

		JLabel labelEmail = new JLabel("Email");
		labelEmail.setForeground(Color.WHITE);
		labelEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelEmail.setBounds(80, 191, 60, 14);
		add(labelEmail);

		campoEmail = new JTextField();
		campoEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarRegistro();
			}
		});
		campoEmail.setBounds(226, 190, 159, 20);
		add(campoEmail);
		campoEmail.setColumns(10);

		JLabel labelPassword = new JLabel("Contraseña");
		labelPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelPassword.setForeground(Color.WHITE);
		labelPassword.setBounds(80, 222, 110, 14);
		add(labelPassword);

		campoPassword = new JPasswordField();
		campoPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarRegistro();
			}
		});
		campoPassword.setBounds(226, 221, 159, 20);
		add(campoPassword);

		JLabel labelPassword2 = new JLabel("Repita Contraseña");
		labelPassword2.setForeground(Color.WHITE);
		labelPassword2.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelPassword2.setBounds(80, 253, 136, 14);
		add(labelPassword2);

		campoPassword2 = new JPasswordField();
		campoPassword2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarRegistro();
			}
		});
		campoPassword2.setBounds(226, 252, 159, 20);
		add(campoPassword2);

		botonRegistrar = new JButton("Registrar");
		botonRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
						ventana.irAPantalla(NombrePantalla.LOGIN);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		botonRegistrar.setEnabled(false);
		botonRegistrar.setBounds(226, 283, 159, 23);
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
