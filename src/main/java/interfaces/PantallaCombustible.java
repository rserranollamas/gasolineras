package interfaces;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;

import clases.Gasolinera;
import componentesvisuales.ElementoListaGasolineras;
import dialogosemergentes.EmergenteLeerFichero;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import enums.TipoCombustible;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.TreeSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Color;

public class PantallaCombustible extends JPanel {
	private Ventana ventana;
	private JPanel listadoGasolineras;
	private Image imagenFondo;
	private String resultado = "";

	public PantallaCombustible(Ventana v) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		setOpaque(false);

		JPanel panelCabecera = new JPanel();
		add(panelCabecera, BorderLayout.NORTH);
		panelCabecera.setOpaque(false);

		final JComboBox seleccionCombustible = new JComboBox();
		panelCabecera.add(seleccionCombustible);
		seleccionCombustible.setModel(new DefaultComboBoxModel(TipoCombustible.values()));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		listadoGasolineras = new JPanel();
		listadoGasolineras.setBackground(new Color(26, 84, 130));
		scrollPane.setViewportView(listadoGasolineras);
		listadoGasolineras.setLayout(new BoxLayout(listadoGasolineras, BoxLayout.Y_AXIS));

		JButton botonBuscar = new JButton("Buscar");
		panelCabecera.add(botonBuscar);

		JButton botonGrabar = new JButton("Guardar");
		botonGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File archivo = new File("./archivos/gasolineras.txt");
					if (archivo.exists()) {
						archivo.delete();
					}
					FileWriter escritor = new FileWriter("./archivos/gasolineras.txt", true);
					escritor.write(resultado);
					escritor.flush();
					escritor.close();
					JOptionPane.showMessageDialog(ventana, "Se ha grabado el fichero correctamente", "Información",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		panelCabecera.add(botonGrabar);

		JButton botonLeer = new JButton("Leer");
		botonLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmergenteLeerFichero leerFichero = new EmergenteLeerFichero(ventana);
				leerFichero.setVisible(true);
			}
		});
		panelCabecera.add(botonLeer);
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listadoGasolineras.removeAll();
				if (!ventana.usuarioLogado.comprobarLocalidad() && !ventana.usuarioLogado.comprobarPosicion()) {
					JOptionPane.showMessageDialog(ventana, "Debe seleccionar una localidad o ubicación", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
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
				resultado += gasolinera.toString() + "\n";
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
