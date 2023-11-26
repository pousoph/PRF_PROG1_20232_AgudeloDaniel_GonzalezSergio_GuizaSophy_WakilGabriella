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

/**
 * 
 * Panel de configuración para una casa de apuestas que permite ingresar
 * información como el nombre, número de sedes y presupuesto total.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class PanelConfiguracionCasAp extends JPanel {

	private JLabel lblNombreCasaApuestas, lblNumeroSedes, lblPresupuestoTotal;
	private JTextField txtNombreCasaApuestas, txtNumeroSedes, txtPresupuestoTotal;
	private Image backgroundImage;

	/**
	 * Constructor que inicializa el panel de configuración de la casa de apuestas.
	 */

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

	/**
	 * Sobrescribe el método paintComponent para dibujar la imagen de fondo.
	 *
	 * @param g El objeto Graphics utilizado para dibujar.
	 */

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (backgroundImage != null) {
			g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
		}
	}

	/**
	 * Obtiene la etiqueta que indica el nombre de la casa de apuestas.
	 *
	 * @return La etiqueta del nombre de la casa de apuestas.
	 */

	public JLabel getLblNombreCasaApuestas() {
		return lblNombreCasaApuestas;
	}

	/**
	 * Establece la etiqueta que indica el nombre de la casa de apuestas.
	 *
	 * @param lblNombreCasaApuestas La etiqueta del nombre de la casa de apuestas.
	 */

	public void setLblNombreCasaApuestas(JLabel lblNombreCasaApuestas) {
		this.lblNombreCasaApuestas = lblNombreCasaApuestas;
	}

	/**
	 * Obtiene la etiqueta que indica el número de sedes de la casa de apuestas.
	 *
	 * @return La etiqueta del número de sedes.
	 */

	public JLabel getLblNumeroSedes() {
		return lblNumeroSedes;
	}

	/**
	 * Establece la etiqueta que indica el número de sedes de la casa de apuestas.
	 *
	 * @param lblNumeroSedes La etiqueta del número de sedes.
	 */

	public void setLblNumeroSedes(JLabel lblNumeroSedes) {
		this.lblNumeroSedes = lblNumeroSedes;
	}

	/**
	 * Obtiene la etiqueta que indica el presupuesto total de la casa de apuestas.
	 *
	 * @return La etiqueta del presupuesto total.
	 */

	public JLabel getLblPresupuestoTotal() {
		return lblPresupuestoTotal;
	}

	/**
	 * Establece la etiqueta que indica el presupuesto total de la casa de apuestas.
	 *
	 * @param lblPresupuestoTotal La etiqueta del presupuesto total.
	 */

	public void setLblPresupuestoTotal(JLabel lblPresupuestoTotal) {
		this.lblPresupuestoTotal = lblPresupuestoTotal;
	}

	/**
	 * Obtiene el campo de texto para ingresar el nombre de la casa de apuestas.
	 *
	 * @return El campo de texto del nombre de la casa de apuestas.
	 */

	public JTextField getTxtNombreCasaApuestas() {
		return txtNombreCasaApuestas;
	}

	/**
	 * Establece el campo de texto para ingresar el nombre de la casa de apuestas.
	 *
	 * @param txtNombreCasaApuestas El campo de texto del nombre de la casa de
	 *                              apuestas.
	 */

	public void setTxtNombreCasaApuestas(JTextField txtNombreCasaApuestas) {
		this.txtNombreCasaApuestas = txtNombreCasaApuestas;
	}

	/**
	 * Obtiene el campo de texto para ingresar el número de sedes de la casa de
	 * apuestas.
	 *
	 * @return El campo de texto del número de sedes.
	 */

	public JTextField getTxtNumeroSedes() {
		return txtNumeroSedes;
	}

	/**
	 * Establece el campo de texto para ingresar el número de sedes de la casa de
	 * apuestas.
	 *
	 * @param txtNumeroSedes El campo de texto del número de sedes.
	 */

	public void setTxtNumeroSedes(JTextField txtNumeroSedes) {
		this.txtNumeroSedes = txtNumeroSedes;
	}

	/**
	 * Obtiene el campo de texto para ingresar el presupuesto total de la casa de
	 * apuestas.
	 *
	 * @return El campo de texto del presupuesto total.
	 */

	public JTextField getTxtPresupuestoTotal() {
		return txtPresupuestoTotal;
	}

	/**
	 * Establece el campo de texto para ingresar el presupuesto total de la casa de
	 * apuestas.
	 *
	 * @param txtPresupuestoTotal El campo de texto del presupuesto total.
	 */

	public void setTxtPresupuestoTotal(JTextField txtPresupuestoTotal) {
		this.txtPresupuestoTotal = txtPresupuestoTotal;
	}

	/**
	 * Obtiene la imagen de fondo del panel.
	 *
	 * @return La imagen de fondo.
	 */

	public Image getBackgroundImage() {
		return backgroundImage;
	}

	/**
	 * Establece la imagen de fondo del panel.
	 *
	 * @param backgroundImage La imagen de fondo.
	 */

	public void setBackgroundImage(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

}