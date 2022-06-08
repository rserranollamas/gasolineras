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
import java.awt.GridLayout;

public class ElementoListaGasolineras extends JPanel {
	private Ventana ventana;
	private Gasolinera gasolinera;

	public ElementoListaGasolineras(Ventana v, Gasolinera g) {
		setBorder(new LineBorder(Color.RED, 3));
		this.ventana = v;
		this.gasolinera = g;
		setLayout(new GridLayout(0, 3, 0, 0));

		JLabel iconoGasolinera = new JLabel("New label");
		add(iconoGasolinera);

		JLabel labelRotulo = new JLabel(gasolinera.getRotulo());
		labelRotulo.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelRotulo);

		JLabel labelPrecio95 = new JLabel(gasolinera.getGasolina95E5() + " €");
		labelPrecio95.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelPrecio95.setHorizontalAlignment(SwingConstants.RIGHT);
		add(labelPrecio95);

		JLabel lblNewLabel = new JLabel("New label");
		add(lblNewLabel);

		JLabel labelDireccion = new JLabel(gasolinera.getDireccion());
		labelDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelDireccion);

	}

}
