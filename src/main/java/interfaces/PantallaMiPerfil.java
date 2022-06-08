package interfaces;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Font;

public class PantallaMiPerfil extends JPanel {
	private Ventana ventana;
	private JTextField campoDni;
	private JTextField campoNombre;
	private JTextField campoEmail;
	private JPasswordField campoPassword;
	private JPasswordField campoPassword2;
	private JButton botonDni;
	private JButton botonNombre;
	private JButton botonEmail;
	private JButton botonPassword;

	public PantallaMiPerfil(Ventana v, String mensaje) {
		this.ventana = v;
		setLayout(null);
		
		JLabel labelCabecera = new JLabel("MI PERFIL");
		labelCabecera.setFont(new Font("Bauhaus 93", Font.PLAIN, 36));
		labelCabecera.setBounds(159, 11, 281, 54);
		add(labelCabecera);
		
		JLabel labelDni = new JLabel("DNI");
		labelDni.setHorizontalAlignment(SwingConstants.LEFT);
		labelDni.setBounds(39, 80, 56, 14);
		add(labelDni);

		botonDni = new JButton("Modificar DNI");
		botonDni.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ventana.usuarioLogado.setDni(campoDni.getText());
					JOptionPane.showMessageDialog(ventana, "DNI modificado con �xito", "Informaci�n",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		botonDni.setEnabled(false);
		botonDni.setBounds(346, 76, 160, 23);
		add(botonDni);

		campoDni = new JTextField(ventana.usuarioLogado.getDni());
		campoDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				habilitarDni();
			}
		});
		campoDni.setColumns(10);
		campoDni.setBounds(149, 77, 191, 20);
		add(campoDni);

		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setHorizontalAlignment(SwingConstants.LEFT);
		labelNombre.setBounds(39, 111, 60, 14);
		add(labelNombre);

		campoNombre = new JTextField(ventana.usuarioLogado.getNombre());
		campoNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarNombre();
			}
		});
		campoNombre.setColumns(10);
		campoNombre.setBounds(149, 108, 191, 20);
		add(campoNombre);

		botonNombre = new JButton("Modificar Nombre");
		botonNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ventana.usuarioLogado.setNombre(campoNombre.getText());
					JOptionPane.showMessageDialog(ventana, "Nombre modificado con �xito", "Informaci�n",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});
		botonNombre.setEnabled(false);
		botonNombre.setBounds(346, 107, 160, 23);
		add(botonNombre);

		JLabel labelEmail = new JLabel("Email");
		labelEmail.setBounds(39, 142, 60, 14);
		add(labelEmail);

		campoEmail = new JTextField(ventana.usuarioLogado.getEmail());
		campoEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarEmail();
			}
		});
		campoEmail.setColumns(10);
		campoEmail.setBounds(149, 139, 191, 20);
		add(campoEmail);

		botonEmail = new JButton("Modificar Email");
		botonEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ventana.usuarioLogado.setEmail(campoEmail.getText());
					JOptionPane.showMessageDialog(ventana, "Email modificado con �xito", "Informaci�n",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		botonEmail.setEnabled(false);
		botonEmail.setBounds(346, 138, 160, 23);
		add(botonEmail);

		JLabel labelPassword = new JLabel("Contrase\u00F1a");
		labelPassword.setBounds(39, 173, 77, 14);
		add(labelPassword);

		campoPassword = new JPasswordField();
		campoPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarPassword();
			}
		});
		campoPassword.setBounds(149, 170, 191, 20);
		add(campoPassword);

		JLabel labelPassword2 = new JLabel("Repita Contrase\u00F1a");
		labelPassword2.setBounds(39, 204, 110, 14);
		add(labelPassword2);

		campoPassword2 = new JPasswordField();
		campoPassword2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarPassword();
			}
		});
		campoPassword2.setBounds(149, 201, 191, 20);
		add(campoPassword2);

		botonPassword = new JButton("Modificar contrase\u00F1a");
		botonPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		botonPassword.setEnabled(false);
		botonPassword.setBounds(346, 184, 160, 23);
		add(botonPassword);
		
	}

	public void habilitarDni() {
		if (campoDni.getText().isEmpty()) {
			botonDni.setEnabled(false);
		} else {
			botonDni.setEnabled(true);
		}
	}

	public void habilitarNombre() {
		if (campoNombre.getText().isEmpty()) {
			botonNombre.setEnabled(false);
		} else {
			botonNombre.setEnabled(true);
		}
	}

	public void habilitarEmail() {
		if (campoEmail.getText().isEmpty()) {
			botonEmail.setEnabled(false);
		} else {
			botonEmail.setEnabled(true);
		}
	}

	public void habilitarPassword() {
		String password = new String(campoPassword.getPassword());
		String password2 = new String(campoPassword2.getPassword());
		if (password.isEmpty() || password2.isEmpty()) {
			botonPassword.setEnabled(false);
		} else {
			botonPassword.setEnabled(true);
		}
	}
}