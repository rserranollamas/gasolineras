package interfaces;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;

import clases.Gasolinera;
import componentesvisuales.ElementoListaGasolineras;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import enums.TipoCombustible;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class PantallaCombustible extends JPanel {
	private Ventana ventana;
	private JPanel listadoGasolineras;

	public PantallaCombustible(Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));

		JPanel panelCabecera = new JPanel();
		add(panelCabecera, BorderLayout.NORTH);

		final JComboBox seleccionCombustible = new JComboBox();
		panelCabecera.add(seleccionCombustible);
		seleccionCombustible.setModel(new DefaultComboBoxModel(TipoCombustible.values()));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		listadoGasolineras = new JPanel();
		scrollPane.setViewportView(listadoGasolineras);
		listadoGasolineras.setLayout(new BoxLayout(listadoGasolineras, BoxLayout.Y_AXIS));

		JButton botonBuscar = new JButton("Buscar");
		panelCabecera.add(botonBuscar);
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listadoGasolineras.removeAll();
				switch ((TipoCombustible) seleccionCombustible.getSelectedItem()) {
				case GASOLINA_95:
					mostrarGasolineras(TipoCombustible.GASOLINA_95);
					break;
				case GASOLINA_95_PREMIUM:
					mostrarGasolineras(TipoCombustible.GASOLINA_95_PREMIUM);
					break;
				case GASOLINA_98:
					mostrarGasolineras(TipoCombustible.GASOLINA_98);
					break;
				case DIESEL:
					mostrarGasolineras(TipoCombustible.DIESEL);
					break;
				case DIESEL_PREMIUM:
					mostrarGasolineras(TipoCombustible.DIESEL_PREMIUM);
					break;
				case GASOLEO_B:
					mostrarGasolineras(TipoCombustible.GASOLEO_B);
					break;
				case BIODIESEL:
					mostrarGasolineras(TipoCombustible.BIODIESEL);
					;
					break;
				case BIOETANOL:
					mostrarGasolineras(TipoCombustible.BIOETANOL);
					break;
				case GLP:
					mostrarGasolineras(TipoCombustible.GLP);
					break;
				case GNC:
					mostrarGasolineras(TipoCombustible.GNC);
					break;
				}
				listadoGasolineras.repaint();
				listadoGasolineras.revalidate();
			}
		});

	}

	public void mostrarGasolineras(TipoCombustible combustibleSeleccionado) {
		try {
			String precio = null;
			TreeSet<Gasolinera> gasolineras = ventana.usuarioLogado.listarMisGasolineras();
			Iterator it = gasolineras.iterator();
			while (it.hasNext()) {
				Gasolinera gasolinera = (Gasolinera) it.next();
				switch (combustibleSeleccionado) {
				case GASOLINA_95:
					precio = gasolinera.getGasolina95E5();
					break;
				case GASOLINA_95_PREMIUM:
					precio = gasolinera.getGasolina95E5Premium();
					break;
				case GASOLINA_98:
					precio = gasolinera.getGasolina98E5();
					break;
				case DIESEL:
					precio = gasolinera.getGasoleoA();
					break;
				case DIESEL_PREMIUM:
					precio = gasolinera.getGasoleoPremium();
					break;
				case GASOLEO_B:
					precio = gasolinera.getGasoleoB();
					break;
				case BIODIESEL:
					precio = gasolinera.getBioDiesel();
					break;
				case BIOETANOL:
					precio = gasolinera.getBioDiesel();
					break;
				case GLP:
					precio = gasolinera.getGlp();
					break;
				case GNC:
					precio = gasolinera.getGnc();
					break;
				default:
					break;
				}
				if (!precio.isEmpty()) {
					listadoGasolineras.add(new ElementoListaGasolineras(ventana, gasolinera, precio));
				}
			}
		} catch (KeyManagementException | NoSuchAlgorithmException | IOException e) {
			JOptionPane.showMessageDialog(ventana, "Error al conectar:\n" + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}
}
