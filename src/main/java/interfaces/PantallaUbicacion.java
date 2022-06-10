package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import clases.PosicionDAO;
import componentesvisuales.ElementoListaUbicaciones;
import dialogosemergentes.EmergenteCrearPosicion;
import dialogosemergentes.EmergenteEditarPosicion;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PantallaUbicacion extends JPanel {
	private Ventana ventana;

	public PantallaUbicacion(Ventana v, String mensaje) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));

		JLabel labelTitulo = new JLabel("MIS UBICACIONES");
		labelTitulo.setFont(new Font("Bauhaus 93", Font.PLAIN, 25));
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelTitulo, BorderLayout.NORTH);

		JButton botonCrearPosicion = new JButton("Nueva Posición");
		botonCrearPosicion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmergenteCrearPosicion crearPosicion = new EmergenteCrearPosicion(ventana, ventana.usuarioLogado);
				crearPosicion.setVisible(true);
			}
		});
		add(botonCrearPosicion, BorderLayout.SOUTH);

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		JPanel listadoUbicaciones = new JPanel();
		scrollPane.setViewportView(listadoUbicaciones);
		listadoUbicaciones.setLayout(new BoxLayout(listadoUbicaciones, BoxLayout.Y_AXIS));

		ArrayList<PosicionDAO> todasPosiciones = ventana.usuarioLogado.getTodas();
		for (byte i = 0; i < todasPosiciones.size(); i++) {
			listadoUbicaciones.add(new ElementoListaUbicaciones(ventana, ventana.usuarioLogado, todasPosiciones.get(i)));
		}

	}

}
