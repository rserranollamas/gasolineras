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
import java.sql.SQLException;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

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

	public PantallaMiPerfil(Ventana v) {
		setForeground(Color.WHITE);
		this.ventana = v;
		setLayout(null);
		setOpaque(false);
		
		JLabel labelCabecera = new JLabel("MI PERFIL");
		labelCabecera.setForeground(Color.WHITE);
		labelCabecera.setFont(new Font("Bauhaus 93", Font.PLAIN, 36));
		labelCabecera.setBounds(180, 11, 160, 54);
		add(labelCabecera);
		
		JLabel labelDni = new JLabel("DNI");
		labelDni.setForeground(Color.WHITE);
		labelDni.setHorizontalAlignment(SwingConstants.LEFT);
		labelDni.setBounds(60, 80, 56, 14);
		add(labelDni);

		botonDni = new JButton("Modificar DNI");
		botonDni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ventana.usuarioLogado.setDni(campoDni.getText());
					JOptionPane.showMessageDialog(ventana, "DNI modificado con éxito", "Información",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		botonDni.setEnabled(false);
		botonDni.setBounds(366, 76, 160, 23);
		add(botonDni);

		campoDni = new JTextField(ventana.usuarioLogado.getDni());
		campoDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				habilitarDni();
			}
		});
		campoDni.setColumns(10);
		campoDni.setBounds(170, 77, 191, 20);
		add(campoDni);

		JLabel labelNombre = new JLabel("Nombre");
		labelNombre.setForeground(Color.WHITE);
		labelNombre.setHorizontalAlignment(SwingConstants.LEFT);
		labelNombre.setBounds(60, 111, 60, 14);
		add(labelNombre);

		campoNombre = new JTextField(ventana.usuarioLogado.getNombre());
		campoNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarNombre();
			}
		});
		campoNombre.setColumns(10);
		campoNombre.setBounds(170, 108, 191, 20);
		add(campoNombre);

		botonNombre = new JButton("Modificar Nombre");
		botonNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		botonNombre.setBounds(366, 107, 160, 23);
		add(botonNombre);

		JLabel labelEmail = new JLabel("Email");
		labelEmail.setForeground(Color.WHITE);
		labelEmail.setBounds(60, 142, 60, 14);
		add(labelEmail);

		campoEmail = new JTextField(ventana.usuarioLogado.getEmail());
		campoEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarEmail();
			}
		});
		campoEmail.setColumns(10);
		campoEmail.setBounds(170, 139, 191, 20);
		add(campoEmail);

		botonEmail = new JButton("Modificar Email");
		botonEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ventana.usuarioLogado.setEmail(campoEmail.getText());
					JOptionPane.showMessageDialog(ventana, "Email modificado con éxito", "Información",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		botonEmail.setEnabled(false);
		botonEmail.setBounds(366, 138, 160, 23);
		add(botonEmail);

		JLabel labelPassword = new JLabel("Contrase\u00F1a");
		labelPassword.setForeground(Color.WHITE);
		labelPassword.setBounds(60, 173, 77, 14);
		add(labelPassword);

		campoPassword = new JPasswordField();
		campoPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarPassword();
			}
		});
		campoPassword.setBounds(170, 170, 191, 20);
		add(campoPassword);

		JLabel labelPassword2 = new JLabel("Repita Contrase\u00F1a");
		labelPassword2.setForeground(Color.WHITE);
		labelPassword2.setBounds(60, 204, 110, 14);
		add(labelPassword2);

		campoPassword2 = new JPasswordField();
		campoPassword2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarPassword();
			}
		});
		campoPassword2.setBounds(170, 201, 191, 20);
		add(campoPassword2);

		botonPassword = new JButton("Modificar contrase\u00F1a");
		botonPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = new String(campoPassword.getPassword());
				String password2 = new String(campoPassword2.getPassword());

				if (!password.equals(password2)) {
					JOptionPane.showMessageDialog(ventana, "Las contraseñas no coinciden", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						ventana.usuarioLogado.setPassword(password);
						JOptionPane.showMessageDialog(ventana, "Contraseña modificada con éxito", "Información",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		botonPassword.setEnabled(false);
		botonPassword.setBounds(366, 184, 160, 23);
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
