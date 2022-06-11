package dialogosemergentes;

import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import clases.PosicionDAO;
import clases.UsuarioDAO;
import interfaces.Ventana;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmergenteEditarPosicion extends JDialog {
	private Ventana ventana;
	private UsuarioDAO usuario;
	private PosicionDAO posicionAEditar;
	private JTextField campoLatitud;
	private JTextField campoLongitud;
	private JTextField campoRadioKm;
	private JButton botonLatitud;
	private JButton botonLongitud;
	private JButton botonRadioKm;

	public EmergenteEditarPosicion(Ventana v, UsuarioDAO u, PosicionDAO p) {
		this.ventana = v;
		this.usuario = u;
		this.posicionAEditar = p;
		this.setSize(500, 300);
		getContentPane().setLayout(null);

		JLabel labelCabecera = new JLabel("MODIFICAR UBICACIÓN");
		labelCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		labelCabecera.setFont(new Font("Bauhaus 93", Font.PLAIN, 36));
		labelCabecera.setBounds(10, 11, 401, 39);
		getContentPane().add(labelCabecera);

		JLabel labelInfo = new JLabel("Puedes modificar la ubicación si lo deseas");
		labelInfo.setBounds(39, 51, 359, 14);
		getContentPane().add(labelInfo);

		JLabel labelLatitud = new JLabel("Latitud");
		labelLatitud.setHorizontalAlignment(SwingConstants.LEFT);
		labelLatitud.setBounds(39, 80, 56, 14);
		getContentPane().add(labelLatitud);

		botonLatitud = new JButton("Modificar Latitud");
		botonLatitud.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					posicionAEditar.setLatitud(Float.parseFloat(campoLatitud.getText()));
					JOptionPane.showMessageDialog(ventana, "Latitud modificada con éxito", "Información",
							JOptionPane.INFORMATION_MESSAGE);
					botonLatitud.setEnabled(false);
				} catch (NumberFormatException | SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});

		botonLatitud.setEnabled(false);
		botonLatitud.setBounds(264, 76, 134, 23);
		getContentPane().add(botonLatitud);

		campoLatitud = new JTextField(Float.toString(posicionAEditar.getLatitud()));
		campoLatitud.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarLatitud();
			}
		});

		campoLatitud.setColumns(10);
		campoLatitud.setBounds(149, 77, 99, 20);
		getContentPane().add(campoLatitud);

		JLabel labelLongitud = new JLabel("Longitud");
		labelLongitud.setHorizontalAlignment(SwingConstants.LEFT);
		labelLongitud.setBounds(39, 111, 60, 14);
		getContentPane().add(labelLongitud);

		campoLongitud = new JTextField(Float.toString(posicionAEditar.getLongitud()));
		campoLongitud.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarLongitud();
			}
		});
		campoLongitud.setColumns(10);
		campoLongitud.setBounds(149, 108, 99, 20);
		getContentPane().add(campoLongitud);

		botonLongitud = new JButton("Modificar Longitud");
		botonLongitud.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					posicionAEditar.setLongitud(Float.parseFloat(campoLongitud.getText()));
					JOptionPane.showMessageDialog(ventana, "Longitud modificada con éxito", "Información",
							JOptionPane.INFORMATION_MESSAGE);
					botonLongitud.setEnabled(false);
				} catch (NumberFormatException | SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		botonLongitud.setEnabled(false);
		botonLongitud.setBounds(264, 110, 134, 23);
		getContentPane().add(botonLongitud);

		JLabel labelRadioKm = new JLabel("Radio (en Kms)");
		labelRadioKm.setBounds(39, 142, 110, 14);
		getContentPane().add(labelRadioKm);

		campoRadioKm = new JTextField(Short.toString(posicionAEditar.getRadioKm()));
		campoRadioKm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarRadioKm();
			}
		});
		campoRadioKm.setColumns(10);
		campoRadioKm.setBounds(149, 139, 99, 20);
		getContentPane().add(campoRadioKm);

		botonRadioKm = new JButton("Modificar Radio");
		botonRadioKm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					posicionAEditar.setRadioKm(Short.parseShort(campoRadioKm.getText()));
					JOptionPane.showMessageDialog(ventana, "Radio modificado con éxito", "Información",
							JOptionPane.INFORMATION_MESSAGE);
					botonRadioKm.setEnabled(false);
				} catch (NumberFormatException | SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		botonRadioKm.setEnabled(false);
		botonRadioKm.setBounds(264, 138, 134, 23);
		getContentPane().add(botonRadioKm);
	}

	public void habilitarLatitud() {
		if (campoLatitud.getText().isEmpty()) {
			botonLatitud.setEnabled(false);
		} else {
			botonLatitud.setEnabled(true);
		}
	}

	public void habilitarLongitud() {
		if (campoLongitud.getText().isEmpty()) {
			botonLongitud.setEnabled(false);
		} else {
			botonLongitud.setEnabled(true);
		}
	}

	public void habilitarRadioKm() {
		if (campoRadioKm.getText().isEmpty()) {
			botonRadioKm.setEnabled(false);
		} else {
			botonRadioKm.setEnabled(true);
		}
	}

}
