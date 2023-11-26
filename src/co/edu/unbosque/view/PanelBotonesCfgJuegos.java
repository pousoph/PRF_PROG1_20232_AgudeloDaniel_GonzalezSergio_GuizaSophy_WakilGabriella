package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 * Panel que contiene dos botones para la configuración de juegos.
 * 
 * @author AgudeloDaniel, GuizaSophy, GonzalezSergio, WakilGabriella 25-11-2023
 */

public class PanelBotonesCfgJuegos extends JPanel {

	private JButton btn1, btn2;

	/**
	 * Constructor que inicializa y configura los botones de configuración y salir.
	 */

	public PanelBotonesCfgJuegos() {
		// TODO Auto-generated constructor stub
		btn1 = new JButton("Configuracion");
		btn1.setActionCommand("CONFIGURAR JUEGOS");
		btn1.setBackground(new Color(134, 124, 157));
		ImageIcon temporal1 = new ImageIcon("./imgs/button_accConfigurar.png");
		Image imtemporal1 = temporal1.getImage();
		int anchoConfigurar = 180;
		int altoConfigurar = 66;
		Image imagenRed = imtemporal1.getScaledInstance(anchoConfigurar, altoConfigurar, Image.SCALE_SMOOTH);
		btn1.setIcon(new ImageIcon(imagenRed));
		btn1.setPreferredSize(new Dimension(180, 66));
		add(btn1);

		btn2 = new JButton("Configuracion");
		btn2.setActionCommand("SALIR CONFIGURACIONJUEGO");
		btn2.setBackground(new Color(134, 124, 157));
		ImageIcon temporal2 = new ImageIcon("./imgs/button_salir.png");
		Image imtemporal2 = temporal2.getImage();
		int anchoConfiguracion = 180;
		int altoConfiguracion = 66;
		Image imagenRed2 = imtemporal2.getScaledInstance(anchoConfiguracion, altoConfiguracion, Image.SCALE_SMOOTH);
		btn2.setIcon(new ImageIcon(imagenRed2));
		btn2.setPreferredSize(new Dimension(180, 66));
		add(btn2);
	}

	/**
	 * Obtiene el botón de configuración.
	 *
	 * @return Botón de configuración.
	 */

	public JButton getBtn1() {
		return btn1;
	}

	/**
	 * Establece el botón de configuración.
	 *
	 * @param btn1 Botón de configuración a establecer.
	 */

	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}

	/**
	 * Obtiene el botón de salir.
	 *
	 * @return Botón de salir.
	 */

	public JButton getBtn2() {
		return btn2;
	}

	/**
	 * Establece el botón de salir.
	 *
	 * @param btn2 Botón de salir a establecer.
	 */

	public void setBtn2(JButton btn2) {
		this.btn2 = btn2;
	}

}