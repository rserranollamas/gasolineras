package interfaces;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import utils.ConexionBD;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class PantallaLocalidades extends JPanel {
	private Ventana ventana;
	private JList list;
	private ArrayList<String> todas;

	public PantallaLocalidades(Ventana v) {
		this.ventana = v;
		setOpaque(false);
		setLayout(null);

		JLabel labelCabecera = new JLabel("LOCALIDADES");
		labelCabecera.setForeground(Color.WHITE);
		labelCabecera.setFont(new Font("Bauhaus 93", Font.PLAIN, 30));
		labelCabecera.setBounds(76, 80, 192, 36);
		add(labelCabecera);

		JButton botonAñadirBusqueda = new JButton("Añadir Búsqueda");
		botonAñadirBusqueda.setBounds(66, 116, 147, 23);
		botonAñadirBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ventana.usuarioLogado.añadirLocalidad((String) list.getSelectedValue())) {
					JOptionPane.showMessageDialog(ventana, "Se ha añadido la localidad en la búsqueda", "Información",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(ventana, "Esta localidad ya estaba añadida a la búsqueda", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		add(botonAñadirBusqueda);

		JButton botonEliminarBusqueda = new JButton("Eliminar Búsqueda");
		botonEliminarBusqueda.setBounds(66, 150, 147, 23);
		botonEliminarBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ventana.usuarioLogado.quitarLocalidad((String) list.getSelectedValue())) {
					JOptionPane.showMessageDialog(ventana, "Localidad eliminada de la búsqueda", "Información",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(ventana, "Esta localidad no estaba en la búsqueda", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton botonAñadir = new JButton("Nueva Localidad");
		botonAñadir.setBounds(367, 116, 139, 23);
		botonAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String localidad = JOptionPane.showInputDialog(ventana, "Escribe la localidad que deseas añadir",
						"Añadir localidad", JOptionPane.INFORMATION_MESSAGE);
				if (localidad.isBlank()) {
					JOptionPane.showMessageDialog(ventana, "La localidad no puede estar vacía", "Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Statement smt = ConexionBD.conectar();
					try {
						if (smt.executeUpdate("INSERT INTO localidad VALUES('" + localidad.toUpperCase() + "','"
								+ ventana.usuarioLogado.getDni() + "')") > 0) {
							JOptionPane.showMessageDialog(ventana, "Localidad añadida a la BBDD correctamente",
									"Información", JOptionPane.INFORMATION_MESSAGE);
							actualizarComboBox();
						} else {
							// Si no se ha podido insertar, lanzo un error: No se ha podido insertar.
							ConexionBD.desconectar();
							throw new SQLException("No se ha podido insertar la localidad en la BBDD");
						}
					} catch (HeadlessException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ConexionBD.desconectar();
				}
			}
		});
		add(botonAñadir);
		add(botonEliminarBusqueda);

		JButton botonEliminar = new JButton("Eliminar Localidad");
		botonEliminar.setBounds(367, 150, 139, 23);
		botonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seleccionada = (String) list.getSelectedValue();
				ventana.usuarioLogado.quitarLocalidad(seleccionada);
				Statement smt = ConexionBD.conectar();
				try {
					if (smt.executeUpdate("DELETE FROM localidad WHERE nombre='" + seleccionada + "' AND usuario='"
							+ ventana.usuarioLogado.getDni() + "'") > 0) {
						todas.remove(seleccionada);
						list.repaint();
						JOptionPane.showMessageDialog(ventana, "Se ha borrado la localidad de la BBDD", "Información",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(ventana, "Esta localidad no existe en la BBDD", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				ConexionBD.desconectar();
			}
		});
		add(botonEliminar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(213, 116, 156, 106);
		add(scrollPane);

		list = new JList();
		actualizarComboBox();
		scrollPane.setViewportView(list);

	}

	public void actualizarComboBox() {
		todas = ventana.usuarioLogado.getLocalidades();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};

			public int getSize() {
				return todas.size();
			}

			public Object getElementAt(int index) {
				return todas.get(index);
			}
		});

	}

}
