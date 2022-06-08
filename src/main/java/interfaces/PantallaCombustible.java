package interfaces;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;
import java.awt.Insets;

public class PantallaCombustible extends JPanel {
	private Ventana ventana;

	public PantallaCombustible(Ventana v, String mensaje) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		
		JLabel labelCabecera = new JLabel(mensaje);
		labelCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		labelCabecera.setFont(new Font("Tahoma", Font.BOLD, 24));
		add(labelCabecera, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JRadioButton combustibleGasolina95 = new JRadioButton("Gasolina 95");
		combustibleGasolina95.setBounds(102, 31, 170, 23);
		panel.add(combustibleGasolina95);
		
		JRadioButton combustibleGasoleoB = new JRadioButton("Gas\u00F3leo B");
		combustibleGasoleoB.setBounds(290, 31, 150, 23);
		panel.add(combustibleGasoleoB);
		
		JRadioButton combustibleGasolina95Premium = new JRadioButton("Gasolina 95 Premium");
		combustibleGasolina95Premium.setBounds(102, 59, 170, 23);
		panel.add(combustibleGasolina95Premium);
		
		JRadioButton combustibleBiodiesel = new JRadioButton("Biodi\u00E9sel");
		combustibleBiodiesel.setBounds(290, 59, 150, 23);
		panel.add(combustibleBiodiesel);
		
		JRadioButton combustibleGasolina98 = new JRadioButton("Gasolina 98");
		combustibleGasolina98.setBounds(102, 87, 170, 23);
		panel.add(combustibleGasolina98);
		
		JRadioButton combustibleBioetanol = new JRadioButton("Bioetanol");
		combustibleBioetanol.setBounds(290, 87, 150, 23);
		panel.add(combustibleBioetanol);
		
		JRadioButton combustibleDiesel = new JRadioButton("Di\u00E9sel");
		combustibleDiesel.setBounds(102, 115, 170, 23);
		panel.add(combustibleDiesel);
		
		JRadioButton combustibleGlp = new JRadioButton("GLP");
		combustibleGlp.setBounds(290, 115, 150, 23);
		panel.add(combustibleGlp);
		
		JRadioButton combustibleDieselPremium = new JRadioButton("Di\u00E9sel Premium");
		combustibleDieselPremium.setBounds(102, 143, 170, 23);
		panel.add(combustibleDieselPremium);
		
		JRadioButton combustibleGnc = new JRadioButton("GNC");
		combustibleGnc.setBounds(290, 143, 150, 23);
		panel.add(combustibleGnc);
		
		// Agrupamos los botones de combustible
		ButtonGroup grupoCombustible=new ButtonGroup();
		grupoCombustible.add(combustibleGnc);
		grupoCombustible.add(combustibleDieselPremium);
		grupoCombustible.add(combustibleGlp);
		grupoCombustible.add(combustibleDiesel);
		grupoCombustible.add(combustibleBioetanol);
		grupoCombustible.add(combustibleGasolina98);
		grupoCombustible.add(combustibleBiodiesel);
		grupoCombustible.add(combustibleGasolina95Premium);
		grupoCombustible.add(combustibleGasoleoB);
		grupoCombustible.add(combustibleGasolina95);

	}

}
