package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PantallaBienvenida extends JPanel {
	private Ventana ventana;

	public PantallaBienvenida(Ventana v, String mensaje) {
		this.ventana = v;
		setLayout(new BorderLayout(0, 0));
		
		JLabel labelUsuario = new JLabel(mensaje);
		labelUsuario.setFont(new Font("Tahoma", Font.BOLD, 27));
		labelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelUsuario, BorderLayout.NORTH);
		
		JLabel labelBienvenida = new JLabel("BIENVENID@ A GASOLINERAS APP");
		labelBienvenida.setVerticalAlignment(SwingConstants.TOP);
		labelBienvenida.setFont(new Font("Tahoma", Font.BOLD, 24));
		labelBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelBienvenida, BorderLayout.CENTER);
			
	}

}