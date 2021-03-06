package dialogosemergentes;

import java.awt.Font;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import interfaces.Ventana;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class EmergenteLeerFichero extends JDialog {
	private Ventana ventana;
	private JButton botonLeer;
	private JTextPane textPane;
	private JScrollPane scrollPane;

	public EmergenteLeerFichero(Ventana v) {
		this.ventana = v;
		this.setSize(770, 300);
		getContentPane().setLayout(null);

		JLabel labelCabecera = new JLabel("OBTENER RESULTADO");
		labelCabecera.setHorizontalAlignment(SwingConstants.CENTER);
		labelCabecera.setFont(new Font("Bauhaus 93", Font.PLAIN, 36));
		labelCabecera.setBounds(174, 0, 398, 60);
		getContentPane().add(labelCabecera);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 734, 116);
		getContentPane().add(scrollPane);

		textPane = new JTextPane();
		textPane.setBounds(33, 51, 697, 123);
		scrollPane.setViewportView(textPane);

		botonLeer = new JButton("Leer");
		botonLeer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedReader lector = new BufferedReader(new FileReader("./archivos/gasolineras.txt"));
					String linea = lector.readLine();
					String texto = "";
					textPane.setText("");
					while (linea != null) {
						textPane.setText(textPane.getText() + linea + "\n");
						linea = lector.readLine();
					}
					lector.close();
					JOptionPane.showMessageDialog(ventana, "Se ha leído el fichero correctamente", "Información",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(ventana, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		botonLeer.setBounds(269, 185, 132, 36);
		getContentPane().add(botonLeer);

	}
}
