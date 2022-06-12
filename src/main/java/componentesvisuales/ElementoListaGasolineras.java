package componentesvisuales;

import javax.swing.JPanel;

import clases.Gasolinera;
import interfaces.Ventana;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ElementoListaGasolineras extends JPanel {
	private Ventana ventana;
	private Gasolinera gasolinera;

	public ElementoListaGasolineras(Ventana v, Gasolinera g, String precio) {
		setBackground(new Color(205,234,250));
		setBorder(new LineBorder(new Color(100, 230, 124)));
		setOpaque(false);
		this.ventana = v;
		this.gasolinera = g;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 70, 165, 60, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 20, 15, 15, 15, 10, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel labelRotulo = new JLabel(gasolinera.getRotulo());
		labelRotulo.setForeground(Color.WHITE);
		labelRotulo.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelRotulo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelRotulo = new GridBagConstraints();
		gbc_labelRotulo.anchor = GridBagConstraints.WEST;
		gbc_labelRotulo.insets = new Insets(0, 0, 5, 5);
		gbc_labelRotulo.gridx = 2;
		gbc_labelRotulo.gridy = 1;
		add(labelRotulo, gbc_labelRotulo);

		JLabel iconoGasolinera = new JLabel("");
		iconoGasolinera.setIcon(new ImageIcon("./iconos/surtidor64px.png"));
		iconoGasolinera.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_iconoGasolinera = new GridBagConstraints();
		gbc_iconoGasolinera.gridwidth = 2;
		gbc_iconoGasolinera.fill = GridBagConstraints.VERTICAL;
		gbc_iconoGasolinera.insets = new Insets(0, 0, 5, 5);
		gbc_iconoGasolinera.gridheight = 4;
		gbc_iconoGasolinera.gridx = 0;
		gbc_iconoGasolinera.gridy = 1;
		add(iconoGasolinera, gbc_iconoGasolinera);

		JLabel labelDireccion = new JLabel(gasolinera.getDireccion());
		labelDireccion.setForeground(Color.WHITE);
		labelDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelDireccion = new GridBagConstraints();
		gbc_labelDireccion.anchor = GridBagConstraints.WEST;
		gbc_labelDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_labelDireccion.gridx = 2;
		gbc_labelDireccion.gridy = 2;
		add(labelDireccion, gbc_labelDireccion);

		JLabel labelLocalidad = new JLabel(gasolinera.getLocalidad() + ", " + gasolinera.getCodigoPostal());
		labelLocalidad.setForeground(Color.WHITE);
		labelLocalidad.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelLocalidad = new GridBagConstraints();
		gbc_labelLocalidad.anchor = GridBagConstraints.WEST;
		gbc_labelLocalidad.insets = new Insets(0, 0, 5, 5);
		gbc_labelLocalidad.gridx = 2;
		gbc_labelLocalidad.gridy = 3;
		add(labelLocalidad, gbc_labelLocalidad);

		JLabel labelPrecio = new JLabel(precio + " €");
		labelPrecio.setForeground(Color.WHITE);
		labelPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_labelPrecio = new GridBagConstraints();
		gbc_labelPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_labelPrecio.anchor = GridBagConstraints.EAST;
		gbc_labelPrecio.gridheight = 2;
		gbc_labelPrecio.gridx = 3;
		gbc_labelPrecio.gridy = 2;
		add(labelPrecio, gbc_labelPrecio);

		JLabel labelProvincia = new JLabel(gasolinera.getProvincia());
		labelProvincia.setForeground(Color.WHITE);
		labelProvincia.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelProvincia = new GridBagConstraints();
		gbc_labelProvincia.anchor = GridBagConstraints.WEST;
		gbc_labelProvincia.insets = new Insets(0, 0, 5, 5);
		gbc_labelProvincia.gridx = 2;
		gbc_labelProvincia.gridy = 4;
		add(labelProvincia, gbc_labelProvincia);

	}

}
