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

public class PanelValorTotalApxApos extends JPanel {

	private JComboBox<String> apostador;
	private Image backImage;

	public PanelValorTotalApxApos() {
		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(80, 80, 80, 80);
		apostador = new JComboBox<String>();
		setVisible(true);
		apostador.setSize(1500, 75);
		apostador.setName("Filtrado");
		apostador.addItem("Apostador");
		apostador.addItem("Sede");
		apostador.addItem("Tipo Juego");

		add(apostador);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(apostador, gbc);

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
	
	public JComboBox<String> getApostador() {
		return apostador;
	}

	public void setApostador(JComboBox<String> apostador) {
		this.apostador = apostador;
	}

	public Image getBackImage() {
		return backImage;
	}

	public void setBackImage(Image backImage) {
		this.backImage = backImage;
	}

}
