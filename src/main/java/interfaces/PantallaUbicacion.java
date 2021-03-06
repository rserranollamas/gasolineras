package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import clases.PosicionDAO;
import componentesvisuales.ElementoListaUbicaciones;
import dialogosemergentes.EmergenteCrearPosicion;

import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaUbicacion extends JPanel {
	private Ventana ventana;

	public PantallaUbicacion(Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		setOpaque(false);

		JLabel labelTitulo = new JLabel("MIS UBICACIONES");
		labelTitulo.setForeground(Color.WHITE);
		labelTitulo.setFont(new Font("Bauhaus 93", Font.PLAIN, 25));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelTitulo, BorderLayout.NORTH);

		JButton botonCrearPosicion = new JButton("NUEVA UBICACIÓN");
		botonCrearPosicion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmergenteCrearPosicion crearPosicion = new EmergenteCrearPosicion(ventana, ventana.usuarioLogado);
				crearPosicion.setVisible(true);
			}
		});
		add(botonCrearPosicion, BorderLayout.SOUTH);

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
	//	scrollPane.setOpaque(false);

		JPanel listadoUbicaciones = new JPanel();
		listadoUbicaciones.setBackground(new Color(26,84,130));
		scrollPane.setViewportView(listadoUbicaciones);
		listadoUbicaciones.setLayout(new BoxLayout(listadoUbicaciones, BoxLayout.Y_AXIS));
	//	listadoUbicaciones.setOpaque(false);

		ArrayList<PosicionDAO> todasPosiciones = ventana.usuarioLogado.getPosiciones();
		for (byte i = 0; i < todasPosiciones.size(); i++) {
			ElementoListaUbicaciones ubicacion = new ElementoListaUbicaciones(ventana, ventana.usuarioLogado,
					todasPosiciones.get(i));
			listadoUbicaciones.add(ubicacion);
			if (ventana.usuarioLogado.posicionesBusqueda.contains(todasPosiciones.get(i))) {
				ubicacion.setBackground(new Color(26,84,130));
			}
		}

	}

}
