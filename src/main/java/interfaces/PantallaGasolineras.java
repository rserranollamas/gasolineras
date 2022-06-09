package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.TreeSet;

import javax.swing.SwingConstants;

import clases.Gasolinera;
import componentesvisuales.ElementoListaGasolineras;

import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

public class PantallaGasolineras extends JPanel {
	private Ventana ventana;

	public PantallaGasolineras(Ventana v, String mensaje) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));

		JLabel labelTitulo = new JLabel("LISTA DE GASOLINERAS");
		labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
		add(labelTitulo, BorderLayout.NORTH);

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		JPanel listadoGasolineras = new JPanel();
		scrollPane.setViewportView(listadoGasolineras);
		listadoGasolineras.setLayout(new BoxLayout(listadoGasolineras, BoxLayout.Y_AXIS));

		try {
			TreeSet<Gasolinera>  gasolineras = ventana.usuarioLogado.listarMisGasolineras();
			Iterator it = gasolineras.iterator();
			while (it.hasNext()) {
				Gasolinera gasolinera = (Gasolinera) it.next();
				System.out.println(gasolinera);
				listadoGasolineras.add(new ElementoListaGasolineras(ventana, gasolinera));
			}
		} catch (KeyManagementException | NoSuchAlgorithmException | IOException e) {
			JOptionPane.showMessageDialog(ventana, "Error al conectar:\n" +e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

}
