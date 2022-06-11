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
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.ventana = v;
		this.usuario = u;
		this.posicion = p;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 50, 0, 55, 0, 69, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 26, 16, 15, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel labelLatitud = new JLabel("Latitud");
		labelLatitud.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_labelLatitud = new GridBagConstraints();
		gbc_labelLatitud.insets = new Insets(0, 0, 5, 5);
		gbc_labelLatitud.gridx = 2;
		gbc_labelLatitud.gridy = 0;
		add(labelLatitud, gbc_labelLatitud);

		JLabel labelLongitud = new JLabel("Longitud");
		labelLongitud.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelLongitud.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelLongitud = new GridBagConstraints();
		gbc_labelLongitud.insets = new Insets(0, 0, 5, 5);
		gbc_labelLongitud.gridx = 4;
		gbc_labelLongitud.gridy = 0;
		add(labelLongitud, gbc_labelLongitud);

		JLabel labelRadioKm = new JLabel("Radio (Kms)");
		labelRadioKm.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_labelRadioKm = new GridBagConstraints();
		gbc_labelRadioKm.insets = new Insets(0, 0, 5, 5);
		gbc_labelRadioKm.gridx = 6;
		gbc_labelRadioKm.gridy = 0;
		add(labelRadioKm, gbc_labelRadioKm);

		JButton botonBusqueda = new JButton("Añadir a la búsqueda");
		botonBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (usuario.añadirPosicion(p)) {
					JOptionPane.showMessageDialog(ventana, "Se ha añadido la ubicación búsqueda", "Información",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(ventana, "Esta ubicación ya estaba añadida", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		GridBagConstraints gbc_botonBusqueda = new GridBagConstraints();
		gbc_botonBusqueda.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonBusqueda.gridwidth = 2;
		gbc_botonBusqueda.insets = new Insets(0, 0, 5, 0);
		gbc_botonBusqueda.gridx = 10;
		gbc_botonBusqueda.gridy = 0;
		add(botonBusqueda, gbc_botonBusqueda);

		JButton botonBorrar = new JButton("Borrar");
		botonBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				usuario.quitarPosicion(p);
				p.eliminar();
			}
		});

		JLabel labelLatitudUsuario = new JLabel(Float.toString(posicion.getLatitud()));
		GridBagConstraints gbc_labelLatitudUsuario = new GridBagConstraints();
		gbc_labelLatitudUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_labelLatitudUsuario.gridx = 2;
		gbc_labelLatitudUsuario.gridy = 1;
		add(labelLatitudUsuario, gbc_labelLatitudUsuario);

		JLabel labelLongitudUsuario = new JLabel(Float.toString(posicion.getLongitud()));
		GridBagConstraints gbc_labelLongitudUsuario = new GridBagConstraints();
		gbc_labelLongitudUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_labelLongitudUsuario.gridx = 4;
		gbc_labelLongitudUsuario.gridy = 1;
		add(labelLongitudUsuario, gbc_labelLongitudUsuario);

		JLabel labelRadioKmUsuario = new JLabel(Short.toString(posicion.getRadioKm()));
		GridBagConstraints gbc_labelRadioKmUsuario = new GridBagConstraints();
		gbc_labelRadioKmUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_labelRadioKmUsuario.gridx = 6;
		gbc_labelRadioKmUsuario.gridy = 1;
		add(labelRadioKmUsuario, gbc_labelRadioKmUsuario);
		GridBagConstraints gbc_botonBorrar = new GridBagConstraints();
		gbc_botonBorrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonBorrar.insets = new Insets(0, 0, 5, 0);
		gbc_botonBorrar.gridx = 11;
		gbc_botonBorrar.gridy = 1;
		add(botonBorrar, gbc_botonBorrar);

		JButton botonEditar = new JButton("Editar");
		botonEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmergenteEditarPosicion editarPosicion = new EmergenteEditarPosicion(ventana, usuario, posicion);
				editarPosicion.setVisible(true);
			}
		});
		GridBagConstraints gbc_botonEditar = new GridBagConstraints();
		gbc_botonEditar.fill = GridBagConstraints.HORIZONTAL;
		gbc_botonEditar.gridx = 11;
		gbc_botonEditar.gridy = 2;
		add(botonEditar, gbc_botonEditar);

	}
}
