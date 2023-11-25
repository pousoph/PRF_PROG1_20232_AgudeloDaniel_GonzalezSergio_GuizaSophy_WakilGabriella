package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotonesMenuP extends JPanel {

	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

	public PanelBotonesMenuP() {
		int anchoVentana = 800;
		int numeroColumnas = 5;
		int espacioEntreBotones = 3;
		int alturaVentana = 600;
		int numeroFilas = 3;
		int espacioEntreBotones1 = 10;

		setLayout(new GridLayout(numeroFilas, numeroColumnas, espacioEntreBotones, espacioEntreBotones1));

		btn1 = crearBoton("Apostador", "APOSTADORES", "./imgs/button_apostadores.png", 266, 200);
		btn2 = crearBoton("Sede", "SEDE", "./imgs/button_sede.png", 266, 200);
		btn3 = crearBoton("Configuracion", "CONFIGURACION", "./imgs/button_configuracion.png", 266, 200);
		btn4 = crearBoton("Loteria", "LOTERIA", "./imgs/button_loteria.png", 266, 200);
		btn5 = crearBoton("SuperAstro", "SUPERASTRO", "./imgs/button_superastro.png", 266, 200);
		btn6 = crearBoton("Baloto", "BALOTO", "./imgs/button_baloto.png", 266, 200);
		btn7 = crearBoton("Chance", "CHANCE", "./imgs/button_chance.png", 266, 200);
		btn8 = crearBoton("Betplay", "BETPLAY", "./imgs/button_betplay.png", 266, 200);
		btn9 = crearBoton("Consultas", "CONSULTAS", "./imgs/button_consultas.png", 266, 200);

		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		add(btn6);
		add(btn7);
		add(btn8);
		add(btn9);
	}

	private JButton crearBoton(String texto, String comando, String rutaImagen, int ancho, int altura) {
		JButton boton = new JButton(texto);
		boton.setActionCommand(comando);
		ImageIcon temporal = new ImageIcon(rutaImagen);
		Image imtemporal = temporal.getImage();
		Image imagenRed = imtemporal.getScaledInstance(ancho, altura, Image.SCALE_SMOOTH);
		boton.setIcon(new ImageIcon(imagenRed));
		boton.setPreferredSize(new Dimension(ancho, altura));
		boton.setBackground(Color.WHITE);
		boton.setHorizontalAlignment(JButton.CENTER);
		boton.setVerticalAlignment(JButton.CENTER);
		return boton;
	}

	public JButton getBtn1() {
		return btn1;
	}

	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}

	public JButton getBtn2() {
		return btn2;
	}

	public void setBtn2(JButton btn2) {
		this.btn2 = btn2;
	}

	public JButton getBtn3() {
		return btn3;
	}

	public void setBtn3(JButton btn3) {
		this.btn3 = btn3;
	}

	public JButton getBtn4() {
		return btn4;
	}

	public void setBtn4(JButton btn4) {
		this.btn4 = btn4;
	}

	public JButton getBtn5() {
		return btn5;
	}

	public void setBtn5(JButton btn5) {
		this.btn5 = btn5;
	}

	public JButton getBtn6() {
		return btn6;
	}

	public void setBtn6(JButton btn6) {
		this.btn6 = btn6;
	}

	public JButton getBtn7() {
		return btn7;
	}

	public void setBtn7(JButton btn7) {
		this.btn7 = btn7;
	}

	public JButton getBtn8() {
		return btn8;
	}

	public void setBtn8(JButton btn8) {
		this.btn8 = btn8;
	}

	public JButton getBtn9() {
		return btn9;
	}

	public void setBtn9(JButton btn9) {
		this.btn9 = btn9;
	}

}
