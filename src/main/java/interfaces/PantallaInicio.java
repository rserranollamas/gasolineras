package interfaces;

import javax.swing.JPanel;
import javax.swing.JTextField;

import clases.UsuarioDAO;
import enums.NombrePantalla;
import excepciones.UsuarioNoExisteException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaInicio extends JPanel {
	private Ventana ventana;
	private JTextField campoDni;
	private JButton botonContinuar;

	public PantallaInicio(Ventana v, String mensaje) {
		this.ventana = v;
		setLayout(null);

		JLabel labelCabecera = new JLabel(mensaje);
		labelCabecera.setBounds(120, 26, 264, 44);
		labelCabecera.setFont(new Font("Bauhaus 93", Font.BOLD, 30));
		add(labelCabecera);

		JLabel labelInfo = new JLabel("Vamos a comprobar si formas parte de Gasolineras APP");
		labelInfo.setBounds(82, 81, 341, 14);
		add(labelInfo);

		JLabel labelDni = new JLabel("DNI");
		labelDni.setBounds(103, 109, 31, 14);
		add(labelDni);

		campoDni = new JTextField();
		campoDni.setBounds(140, 106, 159, 20);
		campoDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarContinuar();
			}
		});
		add(campoDni);
		campoDni.setColumns(10);

		botonContinuar = new JButton("CONTINUAR");
		botonContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dni = campoDni.getText();
				if (!dni.isBlank()) {
					try {
						ventana.usuarioLogado = new UsuarioDAO(dni);
						JOptionPane.showMessageDialog(ventana,
								ventana.usuarioLogado.getNombre() + " bienvenid@ a Gasolineras APP", "HOLA DE NUEVO",
								JOptionPane.INFORMATION_MESSAGE);
						ventana.irAPantalla(NombrePantalla.LOGIN, dni);
						
					} catch (SQLException | UsuarioNoExisteException e1) {
						JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
						ventana.irAPantalla(NombrePantalla.REGISTRO, dni);
					}
				}
			}
		});
		botonContinuar.setBounds(150, 137, 126, 33);
		botonContinuar.setEnabled(false);
		add(botonContinuar);
		
	}

	public void habilitarContinuar() {
		if (campoDni.getText().isBlank()) {
			botonContinuar.setEnabled(false);
		} else {
			botonContinuar.setEnabled(true);
		}
	}
}
