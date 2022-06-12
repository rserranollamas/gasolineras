package interfaces;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelFondoImagen extends JPanel {
	private Image imagenFondo;
	private String rutaImagen;

	public PanelFondoImagen(String ruta) {
		this.rutaImagen = ruta;
	}

	@Override
	public void paint(Graphics g) {
		try {
			imagenFondo = new ImageIcon(ImageIO.read(new File(rutaImagen))).getImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (imagenFondo != null) {
			g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
			setOpaque(false);
		} else {
			setOpaque(true);
		}
		super.paint(g);
	}
}