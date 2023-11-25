package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class PanelMenuApRealizada extends JPanel {

	private JComboBox<String> apuesta;
	private Image backImage;
	
	public PanelMenuApRealizada() {
		setLayout(new GridBagLayout()); // Usar un layout de cuadrícula para centrar los componentes verticalmente

		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(80, 80, 80, 80);
		apuesta = new JComboBox<String>();
		setVisible(true);
		apuesta.setSize(1500, 75);
		apuesta.setName("Filtrado");
		apuesta.addItem("Apostador");
		apuesta.addItem("Sede");


		add(apuesta);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(apuesta, gbc);

		backImage = new ImageIcon("./imgs/vConsultas.png").getImage();
		revalidate();
		repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (backImage != null) {
			g.drawImage(backImage, 0, 0, getWidth(), getHeight(), this);
		}
	}

	public JComboBox<String> getApuesta() {
		return apuesta;
	}

	public void setApuesta(JComboBox<String> apuesta) {
		this.apuesta = apuesta;
	}

	public Image getBackImage() {
		return backImage;
	}

	public void setBackImage(Image backImage) {
		this.backImage = backImage;
	}

	

}
