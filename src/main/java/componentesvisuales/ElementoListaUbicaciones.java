package componentesvisuales;

import javax.swing.JPanel;

import clases.PosicionDAO;
import clases.UsuarioDAO;
import dialogosemergentes.EmergenteEditarPosicion;
import interfaces.Ventana;
import java.awt.GridBagLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ElementoListaUbicaciones extends JPanel {
	private Ventana ventana;
	private UsuarioDAO usuario;
	private PosicionDAO posicion;

	public ElementoListaUbicaciones(Ventana v, UsuarioDAO u, final PosicionDAO p) {
		this.ventana = v;
		this.usuario = u;
		this.posicion = p;
		setBackground(new Color(26,84,130));
		setBorder(new LineBorder(new Color(100, 230, 124), 2));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 113, 0, 0, 0, 0, 65, 40, 79, 32, 83, 0, 0, 0, 0, -12, 0 };
		gridBagLayout.rowHeights = new int[] { 18, 9, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0,
				1.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JButton botonBusqueda = new JButton("Añadir a la búsqueda");
		botonBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuario.añadirPosicion(p)) {
					JOptionPane.showMessageDialog(ventana, "Se ha añadido la ubicación búsqueda", "Información",
							JOptionPane.INFORMATION_MESSAGE);
					setBackground(new Color(100,230,124));
				} else {
					JOptionPane.showMessageDialog(ventana, "Esta ubicación ya estaba añadida", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		JButton botonEliminarBusqueda = new JButton("Eliminar Búsqueda");
		botonEliminarBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (usuario.quitarPosicion(p)) {
					JOptionPane.showMessageDialog(ventana, "Se ha eliminado la ubicación búsqueda", "Información",
							JOptionPane.INFORMATION_MESSAGE);
					setBackground(new Color(26,84,130));

				} else {
					JOptionPane.showMessageDialog(ventana, "Esta ubicación no estaba en la búsqueda", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});


		GridBagConstraints gbc_botonBusqueda = new GridBagConstraints();
		gbc_botonBusqueda.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonBusqueda.insets = new Insets(0, 0, 5, 5);
		gbc_botonBusqueda.gridx = 0;
		gbc_botonBusqueda.gridy = 0;
		add(botonBusqueda, gbc_botonBusqueda);

		JLabel labelLatitud = new JLabel("Latitud");
		labelLatitud.setForeground(Color.WHITE);
		labelLatitud.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_labelLatitud = new GridBagConstraints();
		gbc_labelLatitud.insets = new Insets(0, 0, 5, 5);
		gbc_labelLatitud.gridx = 5;
		gbc_labelLatitud.gridy = 0;
		add(labelLatitud, gbc_labelLatitud);

		JLabel labelLongitud = new JLabel("Longitud");
		labelLongitud.setForeground(Color.WHITE);
		labelLongitud.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelLongitud.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelLongitud = new GridBagConstraints();
		gbc_labelLongitud.insets = new Insets(0, 0, 5, 5);
		gbc_labelLongitud.gridx = 7;
		gbc_labelLongitud.gridy = 0;
		add(labelLongitud, gbc_labelLongitud);

		JLabel labelRadioKm = new JLabel("Radio (Kms)");
		labelRadioKm.setForeground(Color.WHITE);
		labelRadioKm.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_labelRadioKm = new GridBagConstraints();
		gbc_labelRadioKm.insets = new Insets(0, 0, 5, 5);
		gbc_labelRadioKm.gridx = 9;
		gbc_labelRadioKm.gridy = 0;
		add(labelRadioKm, gbc_labelRadioKm);

		JButton botonEditar = new JButton("Editar");
		botonEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmergenteEditarPosicion editarPosicion = new EmergenteEditarPosicion(ventana, usuario, posicion);
				editarPosicion.setVisible(true);
			}
		});
		GridBagConstraints gbc_botonEditar = new GridBagConstraints();
		gbc_botonEditar.insets = new Insets(0, 0, 5, 0);
		gbc_botonEditar.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonEditar.gridx = 14;
		gbc_botonEditar.gridy = 0;
		add(botonEditar, gbc_botonEditar);
		GridBagConstraints gbc_botonEliminarBusqueda = new GridBagConstraints();
		gbc_botonEliminarBusqueda.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonEliminarBusqueda.insets = new Insets(0, 0, 0, 5);
		gbc_botonEliminarBusqueda.gridx = 0;
		gbc_botonEliminarBusqueda.gridy = 1;
		add(botonEliminarBusqueda, gbc_botonEliminarBusqueda);

		JLabel labelLatitudUsuario = new JLabel(Float.toString(posicion.getLatitud()));
		labelLatitudUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelLatitudUsuario.setForeground(Color.WHITE);
		GridBagConstraints gbc_labelLatitudUsuario = new GridBagConstraints();
		gbc_labelLatitudUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_labelLatitudUsuario.gridx = 5;
		gbc_labelLatitudUsuario.gridy = 1;
		add(labelLatitudUsuario, gbc_labelLatitudUsuario);

		JLabel labelLongitudUsuario = new JLabel(Float.toString(posicion.getLongitud()));
		labelLongitudUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelLongitudUsuario.setForeground(Color.WHITE);
		GridBagConstraints gbc_labelLongitudUsuario = new GridBagConstraints();
		gbc_labelLongitudUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_labelLongitudUsuario.gridx = 7;
		gbc_labelLongitudUsuario.gridy = 1;
		add(labelLongitudUsuario, gbc_labelLongitudUsuario);

		JLabel labelRadioKmUsuario = new JLabel(Short.toString(posicion.getRadioKm()));
		labelRadioKmUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		labelRadioKmUsuario.setForeground(Color.WHITE);
		GridBagConstraints gbc_labelRadioKmUsuario = new GridBagConstraints();
		gbc_labelRadioKmUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_labelRadioKmUsuario.gridx = 9;
		gbc_labelRadioKmUsuario.gridy = 1;
		add(labelRadioKmUsuario, gbc_labelRadioKmUsuario);

		JButton botonBorrar = new JButton("Borrar");
		botonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				usuario.quitarPosicion(p);
				p.eliminar();
			}
		});
		GridBagConstraints gbc_botonBorrar = new GridBagConstraints();
		gbc_botonBorrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonBorrar.gridx = 14;
		gbc_botonBorrar.gridy = 1;
		add(botonBorrar, gbc_botonBorrar);

	}
}
