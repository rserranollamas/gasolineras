package interfaces;

import javax.swing.JPanel;

import enums.NombrePantalla;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaInicio extends JPanel {
	private Ventana ventana;

	public PantallaInicio(Ventana v) {
		this.ventana = v;
		setLayout(null);

		JButton botonLogin = new JButton("Login");
		botonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla(NombrePantalla.LOGIN);
			}
		});
		botonLogin.setBounds(330, 403, 120, 46);
		botonLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(botonLogin);

		JButton botonRegistro = new JButton("Registro");
		botonRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.irAPantalla(NombrePantalla.REGISTRO);
			}
		});
		botonRegistro.setBounds(128, 403, 120, 46);
		add(botonRegistro);

	}

}
