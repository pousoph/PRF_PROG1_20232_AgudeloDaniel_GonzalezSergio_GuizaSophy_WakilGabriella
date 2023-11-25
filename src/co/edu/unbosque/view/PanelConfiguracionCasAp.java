package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelConfiguracionCasAp extends JPanel {

	private JLabel lblNombreCasaApuestas, lblNumeroSedes, lblPresupuestoTotal;
	private JTextField txtNombreCasaApuestas, txtNumeroSedes, txtPresupuestoTotal;
	private Image backgroundImage;

	public PanelConfiguracionCasAp() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);

		lblNombreCasaApuestas = new JLabel("Casa de Apuestas: ");
		lblNombreCasaApuestas.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNombreCasaApuestas.setForeground(Color.white);
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(lblNombreCasaApuestas, gbc);

		txtNombreCasaApuestas = new JTextField(24);
		gbc.gridx = 1;
		gbc.gridy = 0;
		add(txtNombreCasaApuestas, gbc);

		lblNumeroSedes = new JLabel("Número de Sedes: ");
		lblNumeroSedes.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNumeroSedes.setForeground(Color.white);
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(lblNumeroSedes, gbc);

		txtNumeroSedes = new JTextField(24);
		gbc.gridx = 1;
		gbc.gridy = 1;
		add(txtNumeroSedes, gbc);

		lblPresupuestoTotal = new JLabel("Presupuesto Total: ");
		lblPresupuestoTotal.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPresupuestoTotal.setForeground(Color.white);
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(lblPresupuestoTotal, gbc);

		txtPresupuestoTotal = new JTextField(24);
		gbc.gridx = 1;
		gbc.gridy = 2;
		add(txtPresupuestoTotal, gbc);

		backgroundImage = new ImageIcon("./imgs/inicioSesion.png").getImage();

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (backgroundImage != null) {
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
		}
	}

	public JLabel getLblNombreCasaApuestas() {
		return lblNombreCasaApuestas;
	}

	public void setLblNombreCasaApuestas(JLabel lblNombreCasaApuestas) {
		this.lblNombreCasaApuestas = lblNombreCasaApuestas;
	}

	public JLabel getLblNumeroSedes() {
		return lblNumeroSedes;
	}

	public void setLblNumeroSedes(JLabel lblNumeroSedes) {
		this.lblNumeroSedes = lblNumeroSedes;
	}

	public JLabel getLblPresupuestoTotal() {
		return lblPresupuestoTotal;
	}

	public void setLblPresupuestoTotal(JLabel lblPresupuestoTotal) {
		this.lblPresupuestoTotal = lblPresupuestoTotal;
	}

	public JTextField getTxtNombreCasaApuestas() {
		return txtNombreCasaApuestas;
	}

	public void setTxtNombreCasaApuestas(JTextField txtNombreCasaApuestas) {
		this.txtNombreCasaApuestas = txtNombreCasaApuestas;
	}

	public JTextField getTxtNumeroSedes() {
		return txtNumeroSedes;
	}

	public void setTxtNumeroSedes(JTextField txtNumeroSedes) {
		this.txtNumeroSedes = txtNumeroSedes;
	}

	public JTextField getTxtPresupuestoTotal() {
		return txtPresupuestoTotal;
	}

	public void setTxtPresupuestoTotal(JTextField txtPresupuestoTotal) {
		this.txtPresupuestoTotal = txtPresupuestoTotal;
	}

	public Image getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

}
