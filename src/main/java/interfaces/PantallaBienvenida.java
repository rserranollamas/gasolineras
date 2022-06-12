package interfaces;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class PantallaBienvenida extends JPanel {
	private Ventana ventana;

	public PantallaBienvenida(Ventana v) {
		this.ventana = v;
		setOpaque(false);
		setLayout(null);

		JLabel labelUsuario = new JLabel(
				ventana.usuarioLogado.getNombre().toUpperCase() + " BIENVENID@");
	//	labelUsuario.setBounds(67, 74, 264, 28);
		labelUsuario.setBounds(76, 80, 340, 36);
		labelUsuario.setForeground(Color.WHITE);
	//	labelUsuario.setFont(new Font("Bauhaus 93", Font.BOLD, 22));
		labelUsuario.setFont(new Font("Bauhaus 93", Font.PLAIN, 28));
	//	labelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelUsuario);
		
		JLabel labelGasolinerasApp = new JLabel("GASOLINERAS APP");
		labelGasolinerasApp.setBounds(426, 83, 202, 28);
		labelGasolinerasApp.setForeground(Color.WHITE);
		labelGasolinerasApp.setFont(new Font("Bauhaus 93", Font.BOLD, 22));
		labelGasolinerasApp.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelGasolinerasApp);
		
	}

}