package interfaces;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import clases.PosicionDAO;
import excepciones.PosicionNoExisteException;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Font;

public class PantallaUbicacion extends JPanel {
	private Ventana ventana;
	protected JTextField campoLatitud;
	protected JTextField campoLongitud;
	protected JTextField campoRadioKm;
	private JButton botonLatitud;
	private JButton botonLongitud;
	private JButton botonRadioKm;
	private JButton botonActualizar;

	public PantallaUbicacion(Ventana v, String mensaje) {
		this.ventana = v;
		setLayout(null);

		JLabel labelCabecera = new JLabel("MI UBICACI\u00D3N");
		labelCabecera.setFont(new Font("Bauhaus 93", Font.PLAIN, 36));
		labelCabecera.setBounds(107, 11, 291, 39);
		add(labelCabecera);

		JLabel labelInfo = new JLabel(mensaje);
		labelInfo.setBounds(39, 51, 359, 14);
		add(labelInfo);

		JLabel labelLatitud = new JLabel("Latitud");
		labelLatitud.setHorizontalAlignment(SwingConstants.LEFT);
		labelLatitud.setBounds(39, 80, 56, 14);
		add(labelLatitud);

		botonLatitud = new JButton("Modificar Latitud");
		botonLatitud.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ventana.posicionUsuario.setLatitud(Float.parseFloat(campoLatitud.getText()));
					JOptionPane.showMessageDialog(ventana, "Latitud modificada con éxito", "Información",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		botonLatitud.setEnabled(false);
		botonLatitud.setBounds(346, 76, 160, 23);
		add(botonLatitud);

		campoLatitud = new JTextField();
		campoLatitud.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				habilitarLatitud();
			}
		});
		campoLatitud.setColumns(10);
		campoLatitud.setBounds(149, 77, 191, 20);
		add(campoLatitud);

		JLabel labelLongitud = new JLabel("Longitud");
		labelLongitud.setHorizontalAlignment(SwingConstants.LEFT);
		labelLongitud.setBounds(39, 111, 60, 14);
		add(labelLongitud);

		campoLongitud = new JTextField();
		campoLongitud.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarLongitud();
			}
		});
		campoLongitud.setColumns(10);
		campoLongitud.setBounds(149, 108, 191, 20);
		add(campoLongitud);

		botonLongitud = new JButton("Modificar Longitud");
		botonLongitud.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ventana.posicionUsuario.setLongitud(Float.parseFloat(campoLongitud.getText()));
					JOptionPane.showMessageDialog(ventana, "Longitud modificada con éxito", "Información",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		botonLongitud.setEnabled(false);
		botonLongitud.setBounds(346, 107, 160, 23);
		add(botonLongitud);

		JLabel labelRadioKm = new JLabel("Radio (en Kms)");
		labelRadioKm.setBounds(39, 142, 110, 14);
		add(labelRadioKm);

		campoRadioKm = new JTextField();
		campoRadioKm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarRadioKm();
			}
		});
		campoRadioKm.setColumns(10);
		campoRadioKm.setBounds(149, 139, 191, 20);
		add(campoRadioKm);

		botonRadioKm = new JButton("Modificar Radio");
		botonRadioKm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ventana.posicionUsuario.setRadioKm(Short.parseShort(campoRadioKm.getText()));
					JOptionPane.showMessageDialog(ventana, "Radio modificado con éxito", "Información",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		botonRadioKm.setEnabled(false);
		botonRadioKm.setBounds(346, 138, 160, 23);
		add(botonRadioKm);

		botonActualizar = new JButton("A\u00F1adir Ubicaci\u00F3n");
		botonActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (ventana.usuarioLogado.añadirPosicion(ventana.posicionUsuario)) {
					System.out.println("Posición añadida correctamente");
				} else {
					System.out.println("La posición ya estaba almacenada");
				}

			}
		});
		botonActualizar.setEnabled(false);
		botonActualizar.setBounds(164, 183, 121, 23);
		add(botonActualizar);
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
