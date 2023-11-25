package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class PanelListadoxSede extends JPanel {

	private JComboBox<String> sede;
	private Image backImage;

	public PanelListadoxSede() {
		setLayout(new GridBagLayout());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(80, 80, 80, 80);
		sede = new JComboBox<String>();
		setVisible(true);
		sede.setSize(1500, 75);
		sede.setName("Filtrado");
		sede.addItem("Sede");

		add(sede);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(sede, gbc);

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

	public JComboBox<String> getSede() {
		return sede;
	}

	public void setSede(JComboBox<String> sede) {
		this.sede = sede;
	}

	public Image getBackImage() {
		return backImage;
	}

	public void setBackImage(Image backImage) {
		this.backImage = backImage;
	}

}
