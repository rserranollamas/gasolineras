package dialogosemergentes;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import clases.PosicionDAO;
import clases.UsuarioDAO;
import interfaces.Ventana;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Font;

public class EmergenteCrearPosicion extends JDialog {
	private Ventana ventana;
	private UsuarioDAO usuario;
	private JTextField campoLatitud;
	private JTextField campoLongitud;
	private JTextField campoRadioKm;
	private JButton botonCrear;

	public EmergenteCrearPosicion(Ventana v, UsuarioDAO u) {
		this.ventana = v;
		this.usuario = u;
		this.setSize(500, 300);
		getContentPane().setLayout(null);

		JLabel labelCabecera = new JLabel("NUEVA UBICACIÓN");
		labelCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		labelCabecera.setFont(new Font("Bauhaus 93", Font.PLAIN, 36));
		labelCabecera.setBounds(10, 21, 414, 39);
		getContentPane().add(labelCabecera);

		JLabel labelLatitud = new JLabel("Latitud");
		labelLatitud.setHorizontalAlignment(SwingConstants.LEFT);
		labelLatitud.setBounds(74, 80, 56, 14);
		getContentPane().add(labelLatitud);

		campoLatitud = new JTextField();
		campoLatitud.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				habilitarCrear();
			}
		});
		campoLatitud.setColumns(10);
		campoLatitud.setBounds(186, 77, 99, 20);
		getContentPane().add(campoLatitud);

		JLabel labelLongitud = new JLabel("Longitud");
		labelLongitud.setHorizontalAlignment(SwingConstants.LEFT);
		labelLongitud.setBounds(74, 111, 60, 14);
		getContentPane().add(labelLongitud);

		campoLongitud = new JTextField();
		campoLongitud.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarCrear();
			}
		});
		campoLongitud.setColumns(10);
		campoLongitud.setBounds(186, 108, 99, 20);
		getContentPane().add(campoLongitud);

		JLabel labelRadioKm = new JLabel("Radio (en Kms)");
		labelRadioKm.setBounds(74, 142, 110, 14);
		getContentPane().add(labelRadioKm);

		campoRadioKm = new JTextField();
		campoRadioKm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarCrear();
			}
		});
		campoRadioKm.setColumns(10);
		campoRadioKm.setBounds(186, 139, 99, 20);
		getContentPane().add(campoRadioKm);

		botonCrear = new JButton("A\u00F1adir Ubicaci\u00F3n");
		botonCrear.setEnabled(false);
		botonCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new PosicionDAO(Float.parseFloat(campoLatitud.getText()), Float.parseFloat(campoLongitud.getText()),
							Short.parseShort(campoRadioKm.getText()), usuario);
					JOptionPane.showMessageDialog(ventana, "Ubicación creada con éxito", "Información",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (NumberFormatException | SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		botonCrear.setBounds(164, 183, 121, 23);
		getContentPane().add(botonCrear);
	}

	public void habilitarCrear() {
		if (campoLatitud.getText().isEmpty() || campoLongitud.getText().isEmpty() || campoRadioKm.getText().isEmpty()) {
			botonCrear.setEnabled(false);
		} else {
			botonCrear.setEnabled(true);
		}
	}
}