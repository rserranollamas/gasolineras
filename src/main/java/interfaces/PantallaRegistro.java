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

public class PantallaRegistro extends JPanel {
	private Ventana ventana;
	private JTextField campoDni;
	private JTextField campoNombre;
	private JTextField campoEmail;
	private JPasswordField campoPassword;
	private JPasswordField campoPassword2;

	public PantallaRegistro(Ventana v, String mensaje) {
		this.ventana = v;
		setLayout(null);

		JLabel labelRegistro = new JLabel("REGISTRO");
		labelRegistro.setBounds(193, 47, 136, 44);
		labelRegistro.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		add(labelRegistro);

		JLabel labelDni = new JLabel("DNI");
		labelDni.setBounds(90, 105, 56, 14);
		labelDni.setHorizontalAlignment(SwingConstants.LEFT);
		add(labelDni);

		campoDni = new JTextField(mensaje);
		campoDni.setBounds(170, 102, 159, 20);
		add(campoDni);
		campoDni.setColumns(10);

		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(90, 136, 60, 14);
		labelNombre.setHorizontalAlignment(SwingConstants.LEFT);
		add(labelNombre);

		campoNombre = new JTextField();
		campoNombre.setBounds(170, 133, 159, 20);
		add(campoNombre);
		campoNombre.setColumns(10);

		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(90, 167, 60, 14);
		add(labelEmail);

		campoEmail = new JTextField();
		campoEmail.setBounds(170, 164, 159, 20);
		add(campoEmail);
		campoEmail.setColumns(10);

		JLabel labelPassword = new JLabel("Contraseña");
		labelPassword.setBounds(90, 198, 77, 14);
		add(labelPassword);

		campoPassword = new JPasswordField();
		campoPassword.setBounds(170, 195, 159, 20);
		add(campoPassword);

		JLabel labelPassword2 = new JLabel("Contraseña 2");
		labelPassword2.setBounds(90, 229, 83, 14);
		add(labelPassword2);

		campoPassword2 = new JPasswordField();
		campoPassword2.setBounds(170, 226, 159, 20);
		add(campoPassword2);

		JButton botonRegistrar = new JButton("Registrar");
		final String dni = campoDni.getText();
		final String nombreUsuario = campoNombre.getText();
		final String email = campoEmail.getText();
		final String password = new String(campoPassword.getPassword());
		final String password2 = new String(campoPassword2.getPassword());
		if(!dni.isEmpty()&&!nombreUsuario.isEmpty()&&!email.isEmpty()&&!password.isEmpty()&&!password2.isEmpty()) {
			botonRegistrar.setEnabled(true);
			botonRegistrar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
					if (!password.equals(password2)) {
						JOptionPane.showMessageDialog(ventana, "Las contraseñas no coinciden", "Error",
								JOptionPane.ERROR_MESSAGE);
					}else {
						try {
							new UsuarioDAO(dni, nombreUsuario, email, password);
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
			
		} else {
			botonRegistrar.setEnabled(false);
		}

		botonRegistrar.setBounds(202, 257, 94, 23);
		add(botonRegistrar);
	}

}
