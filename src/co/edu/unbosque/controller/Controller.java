package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import co.edu.unbosque.model.ApostadorDTO;
import co.edu.unbosque.model.BalotoDTO;
import co.edu.unbosque.model.BetplayDTO;
import co.edu.unbosque.model.ChanceDTO;
import co.edu.unbosque.model.ConfiguracionDTO;
import co.edu.unbosque.model.LoteriaDTO;
import co.edu.unbosque.model.SuperAstroDTO;
import co.edu.unbosque.model.UsuarioDTO;
import co.edu.unbosque.model.persistence.ApostadorDAO;
import co.edu.unbosque.model.persistence.ApuestaDAO;
import co.edu.unbosque.model.persistence.BalotoDAO;
import co.edu.unbosque.model.persistence.BetplayDAO;
import co.edu.unbosque.model.persistence.ChanceDAO;
import co.edu.unbosque.model.persistence.ConfiguracionDAO;
import co.edu.unbosque.model.persistence.JuegoDAO;
import co.edu.unbosque.model.persistence.LoteriaDAO;
import co.edu.unbosque.model.persistence.SedeDAO;
import co.edu.unbosque.model.persistence.SuperAstroDAO;
import co.edu.unbosque.model.persistence.UsuarioDAO;
import co.edu.unbosque.util.CedulaNotValidException;
import co.edu.unbosque.util.NombreNotValidException;
import co.edu.unbosque.util.NumeroNegativoException;
import co.edu.unbosque.util.PresupuestoExcedidoException;
import co.edu.unbosque.util.UsuarioNoEncontradoException;
import co.edu.unbosque.view.Console;
import co.edu.unbosque.view.MainWindow;
import co.edu.unbosque.view.MenuPrincipal;
import co.edu.unbosque.view.PanelAgApBaloto;
import co.edu.unbosque.view.TablaApBaloto;
import co.edu.unbosque.view.TablaApBetplay;
import co.edu.unbosque.view.TablaApLoteria;
import co.edu.unbosque.view.TablaApostadores;
import co.edu.unbosque.view.TablaApuestaChance;
import co.edu.unbosque.view.TablaApuestaSuperAstro;
import co.edu.unbosque.view.VentanaActApostador;
import co.edu.unbosque.view.VentanaActBaloto;
import co.edu.unbosque.view.VentanaActBetplay;
import co.edu.unbosque.view.VentanaActChance;
import co.edu.unbosque.view.VentanaActLoteria;
import co.edu.unbosque.view.VentanaActSuperAstro;
import co.edu.unbosque.view.VentanaAgApBaloto;
import co.edu.unbosque.view.VentanaAgApBetplay;
import co.edu.unbosque.view.VentanaAgApostador;
import co.edu.unbosque.view.VentanaAgChance;
import co.edu.unbosque.view.VentanaAgLoteria;
import co.edu.unbosque.view.VentanaAgSede;
import co.edu.unbosque.view.VentanaAgSuperAstro;
import co.edu.unbosque.view.VentanaCfgJuegos;
import co.edu.unbosque.view.VentanaConfigCasaApuestas;
import co.edu.unbosque.view.VentanaConfiguracion;
import co.edu.unbosque.view.VentanaDepApostador;
import co.edu.unbosque.view.VentanaInicioSesion;
import co.edu.unbosque.view.VentanaListadoxSede;
import co.edu.unbosque.view.VentanaMenuApRealizada;
import co.edu.unbosque.view.VentanaMenuApostador;
import co.edu.unbosque.view.VentanaMenuBaloto;
import co.edu.unbosque.view.VentanaMenuBetplay;
import co.edu.unbosque.view.VentanaMenuChance;
import co.edu.unbosque.view.VentanaMenuConsulta;
import co.edu.unbosque.view.VentanaMenuLoteria;
import co.edu.unbosque.view.VentanaMenuSede;
import co.edu.unbosque.view.VentanaMenuSuperAstro;
import co.edu.unbosque.view.VentanaValorTotalAoxCliente;
import co.edu.unbosque.view.VentanaModSede;
import co.edu.unbosque.view.VentanaRegistroU;

public class Controller implements ActionListener {

	private Console con;
	private ApostadorDAO apDao;
	private BalotoDAO balDao;
	private BetplayDAO betDao;
	private ChanceDAO chanDao;
	private JuegoDAO juegoDao;
	private LoteriaDAO ltDao;
	private SedeDAO sedeDao;
	private SuperAstroDAO sAstroDao;
	private UsuarioDAO usDao;
	private ConfiguracionDAO cfDao;
	private ApuestaDAO apuDao;

	private String buscarIndex;
	private int opc;
	private int opc2;

	private MainWindow mw;
	private VentanaInicioSesion vInicioSesion;
	private VentanaRegistroU vRegistro;
	private MenuPrincipal vMenuPrincipal;
	private VentanaConfiguracion vConfiguracion;
	private VentanaConfigCasaApuestas vCfgCasa;
	private VentanaCfgJuegos vCfgJuegos;
	private VentanaMenuSede vMenSede;
	private VentanaAgSede vAgSede;
	private VentanaModSede vModSede;
	private VentanaMenuApostador vMenuApostador;
	private VentanaAgApostador vAgApostador;
	private VentanaActApostador vActApostador;
	private VentanaDepApostador vDepApostador;
	private VentanaMenuBaloto vMenBaloto;
	private VentanaAgApBaloto vAgBaloto;
	private PanelAgApBaloto pnAgBaloto;
	private VentanaActBaloto vActBaloto;
	private VentanaMenuChance vMenChance;
	private VentanaAgChance vAgChance;
	private VentanaActChance vActChance;
	private VentanaMenuLoteria vMenLoteria;
	private VentanaAgLoteria vAgLoteria;
	private VentanaActLoteria vActLoteria;
	private VentanaMenuSuperAstro vMenSuperAstro;
	private VentanaAgSuperAstro vAgSuperAstro;
	private VentanaActSuperAstro vActSuperAstro;
	private VentanaMenuBetplay vMenBetplay;
	private VentanaAgApBetplay vAgBetplay;
	private VentanaActBetplay vActBetplay;
	private VentanaMenuConsulta vMenuConsulta;
	private VentanaListadoxSede vListadoxSede;
	private VentanaMenuApRealizada vMenApRealizada;
	private VentanaValorTotalAoxCliente vTotalApxCliente;

	public Controller() {
		// TODO Auto-generated constructor stub
		con = new Console();
		apDao = new ApostadorDAO();
		balDao = new BalotoDAO();
		betDao = new BetplayDAO();
		chanDao = new ChanceDAO();
		juegoDao = new JuegoDAO();
		ltDao = new LoteriaDAO();
		sedeDao = new SedeDAO();
		sAstroDao = new SuperAstroDAO();
		usDao = new UsuarioDAO();
		usDao.loadFromFile();
		cfDao = new ConfiguracionDAO();
		apuDao = new ApuestaDAO();

		buscarIndex = null;
		opc = -2;
		opc2 = -1;
		String sedeSeleccionada = "";

		mw = new MainWindow();
		vInicioSesion = new VentanaInicioSesion();
		vRegistro = new VentanaRegistroU();
		vMenuPrincipal = new MenuPrincipal();
		vConfiguracion = new VentanaConfiguracion();
		vCfgCasa = new VentanaConfigCasaApuestas();
		vCfgJuegos = new VentanaCfgJuegos();
		vMenSede = new VentanaMenuSede();
		vAgSede = new VentanaAgSede();
		vModSede = new VentanaModSede();
		vMenuApostador = new VentanaMenuApostador();
		vAgApostador = new VentanaAgApostador();
		vActApostador = new VentanaActApostador();
		vDepApostador = new VentanaDepApostador();
		vMenBaloto = new VentanaMenuBaloto();
		vAgBaloto = new VentanaAgApBaloto();
		pnAgBaloto = new PanelAgApBaloto();
		vActBaloto = new VentanaActBaloto();
		vMenChance = new VentanaMenuChance();
		vAgChance = new VentanaAgChance();
		vActChance = new VentanaActChance();
		vMenLoteria = new VentanaMenuLoteria();
		vAgLoteria = new VentanaAgLoteria();
		vActLoteria = new VentanaActLoteria();
		vMenSuperAstro = new VentanaMenuSuperAstro();
		vAgSuperAstro = new VentanaAgSuperAstro();
		vActSuperAstro = new VentanaActSuperAstro();
		vMenBetplay = new VentanaMenuBetplay();
		vAgBetplay = new VentanaAgApBetplay();
		vActBetplay = new VentanaActBetplay();
		vMenuConsulta = new VentanaMenuConsulta();
		vListadoxSede = new VentanaListadoxSede();
		vMenApRealizada = new VentanaMenuApRealizada();
		vTotalApxCliente = new VentanaValorTotalAoxCliente();

		Asignar();
	}

	public void Asignar() {

		mw.getP2().getBtn().addActionListener((ActionListener) this);

		vInicioSesion.getP3().getBtn2().addActionListener((ActionListener) this);
		vInicioSesion.getP3().getBtn3().addActionListener((ActionListener) this);

		vRegistro.getP4().getBtn4().addActionListener((ActionListener) this);
		vRegistro.getP4().getBtn5().addActionListener((ActionListener) this);

		vMenuPrincipal.getP5().getBtn1().addActionListener((ActionListener) this);
		vMenuPrincipal.getP5().getBtn2().addActionListener((ActionListener) this);
		vMenuPrincipal.getP5().getBtn3().addActionListener((ActionListener) this);
		vMenuPrincipal.getP5().getBtn4().addActionListener((ActionListener) this);
		vMenuPrincipal.getP5().getBtn5().addActionListener((ActionListener) this);
		vMenuPrincipal.getP5().getBtn6().addActionListener((ActionListener) this);
		vMenuPrincipal.getP5().getBtn7().addActionListener((ActionListener) this);
		vMenuPrincipal.getP5().getBtn8().addActionListener((ActionListener) this);
		vMenuPrincipal.getP5().getBtn9().addActionListener((ActionListener) this);

		vConfiguracion.getP1().getBtn().addActionListener((ActionListener) this);
		vConfiguracion.getP1().getBtn2().addActionListener((ActionListener) this);
		vConfiguracion.getP1().getBtn3().addActionListener((ActionListener) this);

		vCfgCasa.getP5().getBtn1().addActionListener((ActionListener) this);
		vCfgCasa.getP5().getBtn2().addActionListener((ActionListener) this);

		vCfgJuegos.getP6().getBtn1().addActionListener((ActionListener) this);
		vCfgJuegos.getP6().getBtn2().addActionListener((ActionListener) this);

		vMenSede.getP8().getBtn1().addActionListener((ActionListener) this);
		vMenSede.getP8().getBtn2().addActionListener((ActionListener) this);
		vMenSede.getP8().getBtn3().addActionListener((ActionListener) this);

		vAgSede.getP9().getBtn1().addActionListener((ActionListener) this);
		vAgSede.getP9().getBtn2().addActionListener((ActionListener) this);

		vModSede.getP10().getBtn1().addActionListener((ActionListener) this);
		vModSede.getP10().getBtn2().addActionListener((ActionListener) this);

		vMenuApostador.getP11().getBtn1().addActionListener((ActionListener) this);
		vMenuApostador.getP11().getBtn2().addActionListener((ActionListener) this);
		vMenuApostador.getP11().getBtn3().addActionListener((ActionListener) this);
		vMenuApostador.getP11().getBtn4().addActionListener((ActionListener) this);
		vMenuApostador.getP11().getBtn5().addActionListener((ActionListener) this);
		vMenuApostador.getP11().getBtn6().addActionListener((ActionListener) this);

		vAgApostador.getP12().getBtn1().addActionListener((ActionListener) this);
		vAgApostador.getP12().getBtn2().addActionListener((ActionListener) this);

		vActApostador.getP13().getBtn1().addActionListener((ActionListener) this);
		vActApostador.getP13().getBtn2().addActionListener((ActionListener) this);

		vDepApostador.getP14().getBtn1().addActionListener((ActionListener) this);
		vDepApostador.getP14().getBtn2().addActionListener((ActionListener) this);

		vMenBaloto.getP15().getBtn1().addActionListener((ActionListener) this);
		vMenBaloto.getP15().getBtn2().addActionListener((ActionListener) this);
		vMenBaloto.getP15().getBtn3().addActionListener((ActionListener) this);
		vMenBaloto.getP15().getBtn4().addActionListener((ActionListener) this);
		vMenBaloto.getP15().getBtn5().addActionListener((ActionListener) this);

		vAgBaloto.getP16().getBtn1().addActionListener((ActionListener) this);
		vAgBaloto.getP16().getBtn2().addActionListener((ActionListener) this);

		vActBaloto.getP17().getBtn1().addActionListener((ActionListener) this);
		vActBaloto.getP17().getBtn2().addActionListener((ActionListener) this);

		vMenChance.getP18().getBtn1().addActionListener((ActionListener) this);
		vMenChance.getP18().getBtn2().addActionListener((ActionListener) this);
		vMenChance.getP18().getBtn3().addActionListener((ActionListener) this);
		vMenChance.getP18().getBtn4().addActionListener((ActionListener) this);
		vMenChance.getP18().getBtn5().addActionListener((ActionListener) this);

		vAgChance.getP19().getBtn1().addActionListener((ActionListener) this);
		vAgChance.getP19().getBtn2().addActionListener((ActionListener) this);

		vActChance.getP20().getBtn1().addActionListener((ActionListener) this);
		vActChance.getP20().getBtn2().addActionListener((ActionListener) this);

		vMenLoteria.getP21().getBtn1().addActionListener((ActionListener) this);
		vMenLoteria.getP21().getBtn2().addActionListener((ActionListener) this);
		vMenLoteria.getP21().getBtn3().addActionListener((ActionListener) this);
		vMenLoteria.getP21().getBtn4().addActionListener((ActionListener) this);
		vMenLoteria.getP21().getBtn5().addActionListener((ActionListener) this);

		vAgLoteria.getP22().getBtn1().addActionListener((ActionListener) this);
		vAgLoteria.getP22().getBtn2().addActionListener((ActionListener) this);

		vActLoteria.getP23().getBtn1().addActionListener((ActionListener) this);
		vActLoteria.getP23().getBtn2().addActionListener((ActionListener) this);

		vMenSuperAstro.getP24().getBtn1().addActionListener((ActionListener) this);
		vMenSuperAstro.getP24().getBtn2().addActionListener((ActionListener) this);
		vMenSuperAstro.getP24().getBtn3().addActionListener((ActionListener) this);
		vMenSuperAstro.getP24().getBtn4().addActionListener((ActionListener) this);
		vMenSuperAstro.getP24().getBtn5().addActionListener((ActionListener) this);

		vAgSuperAstro.getP25().getBtn1().addActionListener((ActionListener) this);
		vAgSuperAstro.getP25().getBtn2().addActionListener((ActionListener) this);

		vActSuperAstro.getP26().getBtn1().addActionListener((ActionListener) this);
		vActSuperAstro.getP26().getBtn2().addActionListener((ActionListener) this);

		vMenBetplay.getP27().getBtn1().addActionListener((ActionListener) this);
		vMenBetplay.getP27().getBtn2().addActionListener((ActionListener) this);
		vMenBetplay.getP27().getBtn3().addActionListener((ActionListener) this);
		vMenBetplay.getP27().getBtn4().addActionListener((ActionListener) this);
		vMenBetplay.getP27().getBtn5().addActionListener((ActionListener) this);

		vAgBetplay.getP28().getBtn1().addActionListener((ActionListener) this);
		vAgBetplay.getP28().getBtn2().addActionListener((ActionListener) this);

		vActBetplay.getP29().getBtn1().addActionListener((ActionListener) this);
		vActBetplay.getP29().getBtn2().addActionListener((ActionListener) this);

		vMenuConsulta.getP30().getBtn1().addActionListener((ActionListener) this);
		vMenuConsulta.getP30().getBtn2().addActionListener((ActionListener) this);
		vMenuConsulta.getP30().getBtn3().addActionListener((ActionListener) this);
		vMenuConsulta.getP30().getBtn4().addActionListener((ActionListener) this);

		vListadoxSede.getP33().getBtn1().addActionListener((ActionListener) this);

		vMenApRealizada.getP31().getBtn1().addActionListener((ActionListener) this);

		vTotalApxCliente.getP32().getBtn1().addActionListener((ActionListener) this);

		pnAgBaloto.getComboBoxSede().addActionListener((ActionListener) this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		con.imprimirConSalto(comando);

		if (comando.equals("USUARIO")) {
			mw.setVisible(false);
			vInicioSesion.add(vInicioSesion.getPnUsuario());
			vInicioSesion.getPnUsuario().setVisible(true);
			vInicioSesion.repaint();
			vInicioSesion.setVisible(true);

		} else if (comando.equals("ACCEDER")) {
			try {
				String nombreUsuario = vInicioSesion.getPnUsuario().getTxtNombreUsuario().getText();
				char[] contrasenaChars = vInicioSesion.getPnUsuario().getTxtContrasena().getPassword();

				if (nombreUsuario.isEmpty() || contrasenaChars.length == 0) {
					JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos.");
				} else {
					String contrasena = new String(contrasenaChars);
					if (usuarioNoEncontrado(nombreUsuario, contrasena)) {
						accesoSiguientePestaña(nombreUsuario, contrasena);

						// Limpiar los campos después de un acceso exitoso
						vInicioSesion.getPnUsuario().getTxtNombreUsuario().setText("");
						vInicioSesion.getPnUsuario().getTxtContrasena().setText("");

						vInicioSesion.setVisible(false);
						vMenuPrincipal.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Usuario no encontrado, intente de nuevo.");
					}
				}
			} catch (UsuarioNoEncontradoException usexc1) {
				JOptionPane.showMessageDialog(null, usexc1.getMessage());
			} catch (Exception e1) {
				// Manejar otras excepciones de manera adecuada
				JOptionPane.showMessageDialog(null, "Ocurrió un error. Por favor, inténtelo de nuevo.");
			}

		} else if (comando.equals("REGISTRAR USUARIO")) {
			vInicioSesion.setVisible(false);
			vRegistro.add(vRegistro.getPnUsuario());
			vRegistro.getPnUsuario().setVisible(true);
			vRegistro.repaint();
			vRegistro.setVisible(true);
		} else if (comando.equals("REGISTRARSE")) {
			String nombreUsuario = vRegistro.getPnUsuario().getTxtNombreUsuario().getText().toString();
			@SuppressWarnings("deprecation")
			String contrasena = vRegistro.getPnUsuario().getTxtContrasena().getText().toString();
			if (nombreUsuario.contentEquals("") || contrasena.contentEquals("")) {
				JOptionPane.showMessageDialog(null, "Por favor ingrese todos los datos.");
			} else {
				usDao.crearUsuario(nombreUsuario, contrasena);
				JOptionPane.showMessageDialog(null, "Usuario credado con exito, Bienvenido!");
				vRegistro.getPnUsuario().getTxtNombreUsuario().setText("");
				vRegistro.getPnUsuario().getTxtContrasena().setText("");
				vRegistro.setVisible(false);
				vRegistro.remove(vRegistro.getPnUsuario());
				vInicioSesion.setVisible(false);
				vMenuPrincipal.setVisible(true);
			}
		} else if (comando.equals("SALIR REGISTRO")) {
			vRegistro.remove(vRegistro.getPnUsuario());
			vRegistro.setVisible(false);
			vInicioSesion.setVisible(true);
		} else if (comando.equals("CONFIGURACION")) {
			vMenuPrincipal.setVisible(false);
			vConfiguracion.add(vConfiguracion.getP1());
			vConfiguracion.getP1().setVisible(true);
			vConfiguracion.repaint();
			vConfiguracion.setVisible(true);
		} else if (comando.equals("CONFG CASA APUESTAS")) {
			vConfiguracion.setVisible(false);
			vConfiguracion.remove(vConfiguracion.getP1());
			vCfgCasa.add(vCfgCasa.getPnCfCasa());
			vCfgCasa.getPnCfCasa().setVisible(true);
			vCfgCasa.repaint();
			vCfgCasa.setVisible(true);
		} else if (comando.equals("CONFIGURAR CASA APUESTAS")) {
			String nombreCasa = vCfgCasa.getPnCfCasa().getTxtNombreCasaApuestas().getText().toString();
			int numeroSedes = Integer.parseInt(vCfgCasa.getPnCfCasa().getTxtNumeroSedes().getText().trim());
			double presupuestoTotal = Double
					.parseDouble(vCfgCasa.getPnCfCasa().getTxtPresupuestoTotal().getText().trim());

			// Create a ConfiguracionDTO object with the gathered data
			ConfiguracionDTO nuevaConfiguracion = new ConfiguracionDTO();
			nuevaConfiguracion.setNombreCasa(nombreCasa);
			nuevaConfiguracion.setNumeroSedes(numeroSedes);
			nuevaConfiguracion.setPresupuestoTotal(presupuestoTotal);

			// Use the ConfiguracionDAO to save the configuration
			cfDao.guardarConfiguracion(nuevaConfiguracion);

			// Mostrar mensaje de éxito y limpiar campos
			JOptionPane.showMessageDialog(null, "¡Configuración establecida con éxito!");
			vCfgCasa.getPnCfCasa().getTxtNombreCasaApuestas().setText("");
			vCfgCasa.getPnCfCasa().getTxtNumeroSedes().setText("");
			vCfgCasa.getPnCfCasa().getTxtPresupuestoTotal().setText("");
			vCfgCasa.setVisible(false);
			vCfgCasa.remove(vCfgCasa.getPnCfCasa());
			vConfiguracion.add(vConfiguracion.getP1());
			vConfiguracion.getP1().setVisible(true);
			vConfiguracion.repaint();
			vConfiguracion.setVisible(true);

		} else if (comando.equals("SALIR CONFIGURACIONCASA")) {
			vCfgCasa.setVisible(false); // Oculta la ventana de configuración de la casa de apuestas
			vConfiguracion.add(vConfiguracion.getP1()); // Añade el panel principal de configuración
			vConfiguracion.getP1().setVisible(true); // Asegura que el panel principal sea visible
			vConfiguracion.repaint();
			vConfiguracion.setVisible(true); // Muestra la ventana de configuración
		} else if (comando.equals("CONFG JUEGOS")) {
			vConfiguracion.setVisible(false);
			vConfiguracion.remove(vConfiguracion.getP1());
			vCfgJuegos.add(vCfgJuegos.getPnCfgJuegos());
			vCfgJuegos.getPnCfgJuegos().setVisible(true);
			vCfgJuegos.repaint();
			vCfgJuegos.setVisible(true);
		} else if (comando.equals("SALIR CONFIGURACIONJUEGO")) {
			vCfgJuegos.setVisible(false);
			vCfgJuegos.remove(vCfgJuegos.getPnCfgJuegos());
			vConfiguracion.add(vConfiguracion.getP1());
			vConfiguracion.getP1().setVisible(true);
			vConfiguracion.repaint();
			vConfiguracion.setVisible(true);
		} else if (comando.equals("CONFIGURAR JUEGOS")) {
			String nombreJuego = vCfgJuegos.getPnCfgJuegos().getNombreJuego().getSelectedItem().toString();
			String tipoJuego = vCfgJuegos.getPnCfgJuegos().getTipoJuego().getSelectedItem().toString();
			double presupuestoJuego = Double
					.parseDouble(vCfgJuegos.getPnCfgJuegos().getTxtPresupuesto().getText().trim());
			int id = -1;
			if (juegoDao.getListaJuegos().size() == 0) {
				id = 1;
			} else {
				ArrayList<Integer> lst = new ArrayList<Integer>();
				for (int i = 0; i < juegoDao.getListaJuegos().size(); i++) {

					lst.add(juegoDao.getListaJuegos().get(i).getIdJuego());
				}
				for (int i = 0; i < juegoDao.getListaJuegos().size(); i++) {
					if (!lst.contains(i + 1)) {
						id = i + 1;
					}
				}
				if (id == -1) {
					id = juegoDao.getListaJuegos().size() + 1;
				}
			}
			try {
				juegoDao.crearJuego(id, nombreJuego, tipoJuego, presupuestoJuego);
			} catch (PresupuestoExcedidoException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "Error de Presupuesto", JOptionPane.ERROR_MESSAGE);
			}
			vCfgJuegos.setVisible(false);
			vCfgJuegos.remove(vCfgJuegos.getPnCfgJuegos());
			vConfiguracion.add(vConfiguracion.getP1());
			vConfiguracion.getP1().setVisible(true);
			vConfiguracion.repaint();
			vConfiguracion.setVisible(true);
		} else if (comando.equals("SALIR CONFG")) {
			vConfiguracion.remove(vConfiguracion.getP1());
			vConfiguracion.getP1().setVisible(false);
			vConfiguracion.setVisible(false);
			vMenuPrincipal.setVisible(true);

		} else if (comando.equals("SEDE")) {
			vMenuPrincipal.setVisible(false);
			vMenSede.add(vMenSede.getP8());
			vMenSede.getP8().setVisible(true);
			vMenSede.repaint();
			vMenSede.setVisible(true);

		} else if (comando.equals("AGREGAR SEDE")) {
			vMenSede.setVisible(false);
			vAgSede.add(vAgSede.getPnAgSede());
			vAgSede.getPnAgSede().setVisible(true);
			vAgSede.repaint();
			vAgSede.setVisible(true);

		} else if (comando.equals("AGREGARSEDE")) {
			String ubicacion = vAgSede.getPnAgSede().getUbicacion().getSelectedItem().toString();
			int numEmpleados = Integer.parseInt(vAgSede.getPnAgSede().getTxtNumEmpleados().getText().toString());
			int id = -1;
			if (sedeDao.getListaSedes().size() == 0) {
				id = 1;
			} else {
				ArrayList<Integer> lst = new ArrayList<Integer>();
				for (int i = 0; i < sedeDao.getListaSedes().size(); i++) {

					lst.add(sedeDao.getListaSedes().get(i).getIdSede());
				}
				for (int i = 0; i < sedeDao.getListaSedes().size(); i++) {
					if (!lst.contains(i + 1)) {
						id = i + 1;
					}
				}
				if (id == -1) {
					id = sedeDao.getListaSedes().size() + 1;
				}
			}

			// Preguntar al usuario si desea continuar
			int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea continuar agregando sedes?", "Confirmación",
					JOptionPane.YES_NO_OPTION);

			if (respuesta == JOptionPane.YES_OPTION) {
				// Mantener la misma ventana con campos borrados
				vAgSede.getPnAgSede().getUbicacion();
				vAgSede.getPnAgSede().getTxtNumEmpleados().setText("");
			} else {
				// Quitar la pestaña y volver a la ventana anterior
				vAgSede.remove(vAgSede.getPnAgSede());
				vAgSede.setVisible(false);
				vMenSede.setVisible(true);
			}

			sedeDao.create(Integer.toString(id), ubicacion, Integer.toString(numEmpleados));
			JOptionPane.showMessageDialog(null, "Sede creado con éxito, conserve bien su id->" + id);
		} else if (comando.equals("SALIR AGSEDE")) {
			vAgSede.setVisible(false);
			vAgSede.remove(vAgSede.getPnAgSede());
			vMenSede.add(vMenSede.getP8());
			vMenSede.getP8().setVisible(true);
			vMenSede.repaint();
			vMenSede.setVisible(true);
		} else if (comando.equals("MODIFICAR SEDE")) {
			String buscar = JOptionPane.showInputDialog(null, "Ingrese el indice que ocupa la sede a modificar.",
					"indice-actualizar");
			if (noLetras(buscar) == false) {
				JOptionPane.showMessageDialog(null, "El indice no puede incluir letras.");
			} else if (sedeDao.searchById(Integer.parseInt(buscar)) == false) {
				JOptionPane.showMessageDialog(null, "No existe ninguna sede con ese index.");
			} else {
				buscarIndex = buscar;
				vModSede.getPnModSede().getTxtNumEmpleados()
						.setText(sedeDao.search(Integer.parseInt(buscarIndex)).getNumEmpleados() + "");

				opc2 = 1;
				vModSede.add(vModSede.getPnModSede());
				vModSede.repaint();
				vMenSede.setVisible(false);
				vModSede.setVisible(true);
			}
		} else if (comando.equals("MODIFICARSEDE")) {
			if (buscarIndex == null) {
				JOptionPane.showMessageDialog(null, "Index no encontrado");
			} else {
				if (opc2 == 1) {
					int index = Integer.parseInt(buscarIndex);
					if (sedeDao.searchById(index)) {
						vModSede.getPnModSede().setVisible(true);
						String ubicacion = vModSede.getPnModSede().getUbicacion().getSelectedItem().toString();
						int numEmpleados = Integer
								.parseInt(vModSede.getPnModSede().getTxtNumEmpleados().getText().toString());

						// Actualizar la sede por índice
						boolean actualizado = sedeDao.updateByIndex(index, ubicacion, Integer.toString(numEmpleados));

						if (actualizado) {
							JOptionPane.showMessageDialog(null, "Sede actualizada con éxito");
							vModSede.getPnModSede().getUbicacion();
							vModSede.getPnModSede().getTxtNumEmpleados().setText("");
							vModSede.remove(vModSede.getPnModSede());
							vModSede.setVisible(false);
							vMenSede.setVisible(true);

						} else {
							JOptionPane.showMessageDialog(null, "Error al actualizar la sede");
						}
					} else {
						JOptionPane.showMessageDialog(null, "No existe ninguna sede con ese índice.");
					}
				}
			}
		} else if (comando.equals("SALIR MODIFICAR SEDE")) {
			vModSede.setVisible(false);
			vModSede.remove(vModSede.getPnModSede());
			vMenSede.add(vMenSede.getP8());
			vMenSede.getP8().setVisible(true);
			vMenSede.repaint();
			vMenSede.setVisible(true);
		} else if (comando.equals("SALIR SEDE")) {
			vMenSede.remove(vMenSede.getP8());
			vMenSede.getP8().setVisible(false);
			vMenSede.setVisible(false);
			vMenuPrincipal.setVisible(true);
		} else if (comando.equals("APOSTADORES")) {
			vMenuPrincipal.remove(vMenuPrincipal.getP5());
			vMenuPrincipal.getP5().setVisible(false);
			vMenuPrincipal.setVisible(false);
			vMenuApostador.add(vMenuApostador.getP11());
			vMenuApostador.getP11().setVisible(true);
			vMenuApostador.repaint();
			vMenuApostador.setVisible(true);
		} else if (comando.equals("AGREGAR APOSTADOR")) {
			vMenuApostador.remove(vMenuApostador.getP11());
			vMenuApostador.getP11().setVisible(false);
			vMenuApostador.setVisible(false);
			vAgApostador.add(vAgApostador.getPnAgApostador());
			vAgApostador.getPnAgApostador().setVisible(true);
			vAgApostador.repaint();
			vAgApostador.setVisible(true);
		} else if (comando.equals("ACTUALIZAR APOSTADOR")) {
			String buscar = JOptionPane.showInputDialog(null, "Ingrese el indice que ocupa el apostador a modificar.",
					"indice-actualizar");
			if (noLetras(buscar) == false) {
				JOptionPane.showMessageDialog(null, "El indice no puede incluir letras.");
			} else if (apDao.searchById(Integer.parseInt(buscar)) == false) {
				JOptionPane.showMessageDialog(null, "No existe ningun apostador con ese index.");
			} else {
				buscarIndex = buscar;
				vActApostador.getPnActApostador().getTxtNombre()
						.setText(apDao.search(Integer.parseInt(buscarIndex)).getName() + "");
				vActApostador.getPnActApostador().getTxtCedula()
						.setText(apDao.search(Integer.parseInt(buscarIndex)).getCedula() + "");
				vActApostador.getPnActApostador().getTxtDireccion()
						.setText(apDao.search(Integer.parseInt(buscarIndex)).getDireccion() + "");
				vActApostador.getPnActApostador().getTxtNumCelular()
						.setText(apDao.search(Integer.parseInt(buscarIndex)).getNumberCell() + "");

				opc2 = 1;
				vMenuApostador.remove(vMenuApostador.getP11());
				vMenuApostador.getP11().setVisible(false);
				vActApostador.add(vActApostador.getPnActApostador());
				vActApostador.getPnActApostador().setVisible(true);
				vAgApostador.repaint();
				vActApostador.setVisible(true);
			}
		} else if (comando.equals("ELIMINAR APOSTADOR")) {
			String buscar = JOptionPane.showInputDialog(null,
					"Ingrese el indice que ocupa el apostador que quiere eliminar en nuestra casa.", "indice-eliminar");
			if (noLetras(buscar) == false) {
				JOptionPane.showMessageDialog(null, "El indice no puede incluir numeros.");
			} else {
				if (apDao.delete(Integer.parseInt(buscar))) {
					JOptionPane.showMessageDialog(null, "Se elimino el apostador con exito.");
				} else {
					JOptionPane.showMessageDialog(null,
							"Recuerde que el indice debe existir y la nomina no puede ser vacia");
				}
			}
		} else if (comando.equals("MOSTRAR APOSTADOR")) {
			ArrayList<ApostadorDTO> apostadores = apDao.getApostadores();
			ArrayList<ApostadorDTO> aux = new ArrayList<ApostadorDTO>();
			for (int i = 0; i < apostadores.size(); i++) {
				if (apostadores.get(i).getClass().getSimpleName().toString().equals("ApostadorDTO")) {
					aux.add(apostadores.get(i));
				}
			}
			TablaApostadores tablaApos = new TablaApostadores(aux);
			JTable tablitaApos = tablaApos.agregarApostadores();
		} else if (comando.equals("FILTRAR APOSTADOR")) {
			vMenuApostador.remove(vMenuApostador.getP11());
			vMenuApostador.getP11().setVisible(false);
			vMenuApostador.setVisible(false);
			vDepApostador.add(vDepApostador.getPnDepApostador());
			vDepApostador.getPnDepApostador().setVisible(true);
			vDepApostador.repaint();
			vDepApostador.setVisible(true);
		} else if (comando.equals("SALIR APOSTADOR")) {
			vMenuApostador.remove(vMenuApostador.getP11());
			vMenuApostador.getP11().setVisible(false);
			vMenuApostador.setVisible(false);
			vMenuPrincipal.add(vMenuPrincipal.getP5());
			vMenuPrincipal.getP5().setVisible(true);
			vMenuPrincipal.setVisible(true);
		} else if (comando.equals("AGREGARAPOSTADOR")) {
			try {
				String nombre = vAgApostador.getPnAgApostador().getTxtNombre().getText().toString();
				checkName(nombre);
				long cedula = Long.parseLong(vAgApostador.getPnAgApostador().getTxtCedula().getText().toString());
				String sede = vAgApostador.getPnAgApostador().getSede().getSelectedItem().toString();
				String direccion = vAgApostador.getPnAgApostador().getTxtDireccion().getText().toString();
				Long numCelular = Long
						.parseLong(vAgApostador.getPnAgApostador().getTxtNumCelular().getText().toString());
				int id = -1;
				if (apDao.getApostadores().size() == 0) {
					id = 1;
				} else {
					ArrayList<Integer> lst = new ArrayList<Integer>();
					for (int i = 0; i < apDao.getApostadores().size(); i++) {

						lst.add(apDao.getApostadores().get(i).getId());
					}
					for (int i = 0; i < apDao.getApostadores().size(); i++) {
						if (!lst.contains(i + 1)) {
							id = i + 1;
						}
					}
					if (id == -1) {
						id = apDao.getApostadores().size() + 1;
					}
				}
				apDao.create(Integer.toString(id), nombre, Long.toString(cedula), sede, direccion,
						Long.toString(numCelular));
				JOptionPane.showMessageDialog(null, "¡Apostador creado con exito, conserve bien su id->" + id);
				vAgApostador.getPnAgApostador().getTxtNombre().setText("");
				vAgApostador.getPnAgApostador().getTxtCedula().setText("");
				vAgApostador.getPnAgApostador().getSede();
				vAgApostador.getPnAgApostador().getTxtDireccion().setText("");
				vAgApostador.getPnAgApostador().getTxtNumCelular().setText("");
				vAgApostador.setVisible(false);
				vAgApostador.remove(vAgApostador.getP12());
				vAgApostador.getP12().setVisible(false);
				vMenuApostador.add(vMenuApostador.getP11());
				vMenuApostador.getP11().setVisible(true);
				vMenuApostador.repaint();
				vMenuApostador.setVisible(true);
			} catch (NombreNotValidException e2) {
				JOptionPane.showMessageDialog(null, e2.getMessage());
			}
		} else if (comando.equals("SALIR AGAPOSTADOR")) {
			vAgApostador.setVisible(false);
			vAgApostador.remove(vAgApostador.getPnAgApostador());
			vMenuApostador.add(vMenuApostador.getP11());
			vMenuApostador.getP11().setVisible(true);
			vMenuApostador.repaint();
			vMenuApostador.setVisible(true);
		} else if (comando.equals("ACTUALIZARAPO")) {
			if (buscarIndex == null) {
				JOptionPane.showMessageDialog(null, "Index no encontrado");
			} else {
				if (opc2 == 1) {
					int index = Integer.parseInt(buscarIndex);
					if (apDao.searchById(index)) {
						vActApostador.getPnActApostador().setVisible(true);
						String nombre = vActApostador.getPnActApostador().getTxtNombre().getText().toString();
						long cedula = Long
								.parseLong(vActApostador.getPnActApostador().getTxtCedula().getText().toString());
						String sede = vActApostador.getPnActApostador().getSede().getSelectedItem().toString();
						String direccion = vActApostador.getPnActApostador().getTxtDireccion().getText().toString();
						long numberCelular = Long
								.parseLong(vActApostador.getPnActApostador().getTxtNumCelular().getText().toString());

						// Actualizar la sede por índice
						boolean actualizado = apDao.updateByIndex(index, nombre, Long.toString(cedula), sede, direccion,
								Long.toString(numberCelular));

						if (actualizado) {
							JOptionPane.showMessageDialog(null, "Apostador actualizada con éxito");
							vActApostador.getPnActApostador().getTxtNombre().setText("");
							vActApostador.getPnActApostador().getTxtCedula().setText("");
							vActApostador.getPnActApostador().getSede();
							vActApostador.getPnActApostador().getTxtDireccion().setText("");
							vActApostador.getPnActApostador().getTxtNumCelular().setText("");
							vActApostador.setVisible(false);
							vActApostador.remove(vActApostador.getP13());
							vActApostador.getP13().setVisible(false);
							vMenuApostador.add(vMenuApostador.getP11());
							vMenuApostador.getP11().setVisible(true);
							vMenuApostador.repaint();
							vMenuApostador.setVisible(true);

						} else {
							JOptionPane.showMessageDialog(null, "Error al actualizar el apostador");
						}
					} else {
						JOptionPane.showMessageDialog(null, "No existe ningun apostador con ese índice.");
					}
				}
			}
		} else if (comando.equals("SALIR ACTUALIZAR APOSTADOR")) {
			vActApostador.setVisible(false);
			vActApostador.remove(vActApostador.getPnActApostador());
			vMenuApostador.add(vMenuApostador.getP11());
			vMenuApostador.getP11().setVisible(true);
			vMenuApostador.repaint();
			vMenuApostador.setVisible(true);
		} else if (comando.equals("FILTRARAPOS")) {
			String search = vDepApostador.getPnDepApostador().getOpcionesfil().getSelectedItem().toString();
			if (search.equals("Nombre")) {
				String nameFilter = JOptionPane.showInputDialog(null,
						"Ingresa el nombre por el cual quieres filtrar la informacion", "nombre");
				try {
					checkName(nameFilter);
				} catch (NombreNotValidException e1) {
					JOptionPane.showMessageDialog(null, "No puede contener numeros.");

				}
				if (apDao.depurar(1, nameFilter) != null) {
					JOptionPane.showMessageDialog(null, apDao.depurar(1, nameFilter));
				} else {
					JOptionPane.showMessageDialog(null, "Informacion no encontrada.");

				}
				vDepApostador.setVisible(false);
				vDepApostador.remove(vDepApostador.getP14());
				vDepApostador.getP14().setVisible(false);
				vMenuApostador.add(vMenuApostador.getP11());
				vMenuApostador.getP11().setVisible(true);
				vMenuApostador.repaint();
				vMenuApostador.setVisible(true);
			} else if (search.equals("Cedula")) {
				String cedulaFilter = JOptionPane.showInputDialog(null,
						"Ingresa la cedula por la cual quieres filtrar la informacion", "cedula");
				Long.parseLong(cedulaFilter);
				if (apDao.depurar(2, cedulaFilter) != null) {
					JOptionPane.showMessageDialog(null, apDao.depurar(2, cedulaFilter));
				} else {
					JOptionPane.showMessageDialog(null, "Informacion no encontrada.");

				}
				vDepApostador.setVisible(false);
				vDepApostador.remove(vDepApostador.getP14());
				vDepApostador.getP14().setVisible(false);
				vMenuApostador.add(vMenuApostador.getP11());
				vMenuApostador.getP11().setVisible(true);
				vMenuApostador.repaint();
				vMenuApostador.setVisible(true);
			} else if (search.equals("Sede")) {
				String sedeFilter = JOptionPane.showInputDialog(null,
						"Ingresa la sede por la cual quieres filtrar la informacion", "sede");
				try {
					checkName(sedeFilter);
				} catch (NombreNotValidException e2) {
					JOptionPane.showMessageDialog(null, "No puede contener numeros.");
				}
				if (apDao.depurar(3, sedeFilter) != null) {
					JOptionPane.showMessageDialog(null, apDao.depurar(3, sedeFilter));
				} else {
					JOptionPane.showMessageDialog(null, "Informacion no encontrada.");

				}
				vDepApostador.setVisible(false);
				vDepApostador.remove(vDepApostador.getP14());
				vDepApostador.getP14().setVisible(false);
				vMenuApostador.add(vMenuApostador.getP11());
				vMenuApostador.getP11().setVisible(true);
				vMenuApostador.repaint();
				vMenuApostador.setVisible(true);
			}
		} else if (comando.equals("BALOTO")) {
			vMenuPrincipal.remove(vMenuPrincipal.getP5());
			vMenBaloto.add(vMenBaloto.getP15());
			vMenBaloto.getP15().setVisible(true);
			vMenBaloto.repaint();
			vMenBaloto.setVisible(true);
		} else if (comando.equals("AGREGAR APBALOTO")) {
			vMenBaloto.setVisible(false);
			vMenBaloto.remove(vMenBaloto.getP15());
			vMenBaloto.getP15().setVisible(false);
			vAgBaloto.getPnAgApBaloto().addSedeChangeListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e4) {
					String sedeSeleccionada = e4.getActionCommand();
					List<Long> cedulas = obtenerCedulasPorSede(sedeSeleccionada);
					vAgBaloto.getPnAgApBaloto().actualizarCedulas(cedulas);
				}
			});
			vAgBaloto.add(vAgBaloto.getPnAgApBaloto());
			vAgBaloto.getPnAgApBaloto().setVisible(true);
			vAgBaloto.repaint();
			vAgBaloto.setVisible(true);
		} else if (comando.equals("AGREGARBALOTO")) {
			LocalDate dia = LocalDate.now();
			String sede = vAgBaloto.getPnAgApBaloto().getSedeSeleccionada();
			Long cedulaApostador = (Long) vAgBaloto.getPnAgApBaloto().getComboBoxCedula().getSelectedItem();

			// Obtener el array de JComboBox<Integer> desde la vista
			JComboBox<Integer>[] comboBoxNumeros = vAgBaloto.getPnAgApBaloto().getComboBoxNumeros();

			// Crear un array de enteros para almacenar los números seleccionados
			List<Integer> numerosSeleccionados = new ArrayList<>();

			// Iterar sobre los JComboBox para obtener los números seleccionados
			for (JComboBox<Integer> comboBox : comboBoxNumeros) {
				numerosSeleccionados.add((Integer) comboBox.getSelectedItem());
			}

			// Convertir la lista a un array de enteros
			int[] numeros = numerosSeleccionados.stream().mapToInt(Integer::intValue).toArray();

			// Crear una cadena de números separados por comas
			String numerosString = Arrays.stream(numeros).mapToObj(String::valueOf).collect(Collectors.joining(","));

			Double valorApuesta = 0.0; // Valor predeterminado

			// Validar y convertir el valor de la apuesta
			String valorApuestaStr = vAgBaloto.getPnAgApBaloto().getTxtValorApuesta().getText().trim();
			if (!valorApuestaStr.isEmpty()) {
				try {
					valorApuesta = Double.parseDouble(valorApuestaStr);
				} catch (NumberFormatException e3) {
					// Mostrar un mensaje de error al usuario
					JOptionPane.showMessageDialog(null,
							"Error en el formato del valor de apuesta. Se establecerá a 0.0");
					valorApuesta = 0.0; // Restablecer el valor predeterminado después del error
				}
			}

			int id = -1;
			if (balDao.getApBalotos().size() == 0) {
				id = 1;
			} else {
				ArrayList<Integer> lst = new ArrayList<Integer>();
				for (int i = 0; i < balDao.getApBalotos().size(); i++) {

					lst.add(balDao.getApBalotos().get(i).getIdBaloto());
				}
				for (int i = 0; i < balDao.getApBalotos().size(); i++) {
					if (!lst.contains(i + 1)) {
						id = i + 1;
					}
				}
				if (id == -1) {
					id = balDao.getApBalotos().size() + 1;
				}
			}

			// Crear la apuesta
			balDao.create(Integer.toString(id), dia.toString(), cedulaApostador.toString(), sede, numerosString,
					valorApuesta.toString());

			vAgBaloto.getPnAgApBaloto().mostrarRecibo(dia, sede, cedulaApostador, numeros, valorApuesta, id);

			// Mostrar mensaje de éxito al usuario
			JOptionPane.showMessageDialog(null, "Apuesta creada con éxito. Conserva muy bien tu ID -> " + id);

			// Limpiar la vista para futuras entradas
			vAgBaloto.getPnAgApBaloto().getTxtValorApuesta().setText("");

			// Cambiar la visibilidad de las vistas
			vAgBaloto.setVisible(false);
			vAgBaloto.remove(vAgBaloto.getP16());
			vAgBaloto.getP16().setVisible(false);
			vMenBaloto.add(vMenBaloto.getP15());
			vMenBaloto.getP15().setVisible(true);
			vMenBaloto.repaint();
			vMenBaloto.setVisible(true);

		} else if (comando.equals("SALIBALOTO")) {
			vAgBaloto.setVisible(false);
			vAgBaloto.remove(vAgBaloto.getPnAgApBaloto());
			vMenBaloto.add(vMenBaloto.getP15());
			vMenBaloto.getP15().setVisible(true);
			vMenBaloto.repaint();
			vMenBaloto.setVisible(true);
		} else if (comando.equals("ACTUALIZAR APBALOTO")) {
			String buscar = JOptionPane.showInputDialog(null, "Ingrese el indice que ocupa la apuesta a modificar.",
					"indice-actualizar");
			if (noLetras(buscar) == false) {
				JOptionPane.showMessageDialog(null, "El indice no puede incluir letras.");
			} else if (balDao.buscarPorId(Integer.parseInt(buscar)) == false) {
				JOptionPane.showMessageDialog(null, "No existe ninguna apuesta con ese index.");
			} else {
				buscarIndex = buscar;
				vActBaloto.getPnActBaloto().getTxtValorApuesta()
						.setText(balDao.search(Integer.parseInt(buscarIndex)).getValorApuesta() + "");
				opc2 = 1;
				vMenBaloto.setVisible(false);
				vMenBaloto.remove(vMenBaloto.getP15());
				vMenBaloto.getP15().setVisible(false);
				vActBaloto.getPnActBaloto().addSedeChangeListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e4) {
						String sedeSeleccionada = e4.getActionCommand();
						List<Long> cedulas = obtenerCedulasPorSede(sedeSeleccionada);
						vActBaloto.getPnActBaloto().actualizarCedulas(cedulas);
					}
				});
				vActBaloto.add(vActBaloto.getPnActBaloto());
				vActBaloto.getPnActBaloto().setVisible(true);
				vActBaloto.repaint();
				vActBaloto.setVisible(true);
			}
			buscarIndex = buscar;
		} else if (comando.equals("ACTUALBALOTO")) {
			if (buscarIndex == null) {
				JOptionPane.showMessageDialog(null, "Index no encontrado");
			} else {
				if (opc2 == 1) {

					int index = Integer.parseInt(buscarIndex);
					if (balDao.searchById(index)) {
						vActBaloto.getPnActBaloto().setVisible(true);
						LocalDate dia = LocalDate.now();
						String sede = vActBaloto.getPnActBaloto().getSedeSeleccionada();
						Long cedulaApostador = (Long) vActBaloto.getPnActBaloto().getComboBoxCedula().getSelectedItem();

						// Obtener el array de JComboBox<Integer> desde la vista
						JComboBox<Integer>[] comboBoxNumeros = vActBaloto.getPnActBaloto().getComboBoxNumeros();

						// Crear un array de enteros para almacenar los números seleccionados
						List<Integer> numerosSeleccionados = new ArrayList<>();

						// Iterar sobre los JComboBox para obtener los números seleccionados
						for (JComboBox<Integer> comboBox : comboBoxNumeros) {
							numerosSeleccionados.add((Integer) comboBox.getSelectedItem());
						}

						// Convertir la lista a un array de enteros
						int[] numeros = numerosSeleccionados.stream().mapToInt(Integer::intValue).toArray();

						// Crear una cadena de números separados por comas
						String numerosString = Arrays.stream(numeros).mapToObj(String::valueOf)
								.collect(Collectors.joining(","));

						Double valorApuesta = 0.0; // Valor predeterminado

						// Validar y convertir el valor de la apuesta
						String valorApuestaStr = vActBaloto.getPnActBaloto().getTxtValorApuesta().getText().trim();
						if (!valorApuestaStr.isEmpty()) {
							try {
								valorApuesta = Double.parseDouble(valorApuestaStr);
							} catch (NumberFormatException e3) {
								// Mostrar un mensaje de error al usuario
								JOptionPane.showMessageDialog(null,
										"Error en el formato del valor de apuesta. Se establecerá a 0.0");
								valorApuesta = 0.0; // Restablecer el valor predeterminado después del error
							}
						}
						// Actualizar la sede por índice
						boolean actualizado = balDao.updateByIndex(index, dia.toString(), cedulaApostador.toString(),
								sede, numerosString, valorApuesta.toString());

						if (actualizado) {
							vActBaloto.getPnActBaloto().mostrarRecibo(dia, sede, cedulaApostador, numeros, valorApuesta,
									index);
							JOptionPane.showMessageDialog(null, "Apuesta Baloto actualizada con éxito");
							vActBaloto.getPnActBaloto().getTxtValorApuesta().setText("");

							// Cambiar la visibilidad de las vistas
							vActBaloto.setVisible(false);
							vActBaloto.remove(vActBaloto.getP17());
							vActBaloto.getP17().setVisible(false);
							vMenBaloto.add(vMenBaloto.getP15());
							vMenBaloto.getP15().setVisible(true);
							vMenBaloto.repaint();
							vMenBaloto.setVisible(true);

						} else {
							JOptionPane.showMessageDialog(null, "Error al actualizar la apuesta");
						}
					} else {
						JOptionPane.showMessageDialog(null, "No existe ninguna apuesta con ese índice.");
					}
				}
			}

		} else if (comando.equals("ELIMINAR APBALOTO")) {
			String buscar = JOptionPane.showInputDialog(null,
					"Ingrese el indice que ocupa la apuesta que quiere eliminar de nuestra sede.", "indice-eliminar");
			if (noLetras(buscar) == false) {
				JOptionPane.showMessageDialog(null, "El indice no puede incluir numeros.");
			} else {
				if (balDao.delete(Integer.parseInt(buscar))) {
					JOptionPane.showMessageDialog(null, "Se elimino la apuesta con exito.");
				} else {
					JOptionPane.showMessageDialog(null,
							"Recuerde que el indice debe existir y la apuesta no puede ser vacia");
				}
			}
		} else if (comando.equals("SALIACTUALBALOTO"))

		{
			vActBaloto.setVisible(false);
			vActBaloto.remove(vActBaloto.getPnActBaloto());
			vMenBaloto.add(vMenBaloto.getP15());
			vMenBaloto.getP15().setVisible(true);
			vMenBaloto.repaint();
			vMenBaloto.setVisible(true);
		} else if (comando.equals("MOSTRAR APBALOTO")) {
			ArrayList<BalotoDTO> apBaloto = balDao.getApBalotos();
			ArrayList<BalotoDTO> aux = new ArrayList<BalotoDTO>();
			for (int i = 0; i < apBaloto.size(); i++) {
				if (apBaloto.get(i).getClass().getSimpleName().toString().equals("BalotoDTO")) {
					aux.add(apBaloto.get(i));
				}
			}
			TablaApBaloto tablaApBal = new TablaApBaloto(aux);
			JTable tablitaApBal = tablaApBal.agregaBaloto();
		} else if (comando.equals("SALIR APBALOTOMENU")) {
			vMenBaloto.remove(vMenBaloto.getP15());
			vMenBaloto.getP15().setVisible(false);
			vMenBaloto.setVisible(false);
			vMenuPrincipal.setVisible(true);

		} else if (comando.equals("CHANCE")) {
			vMenuPrincipal.remove(vMenuPrincipal.getP5());
			vMenChance.add(vMenChance.getP18());
			vMenChance.getP18().setVisible(true);
			vMenChance.repaint();
			vMenChance.setVisible(true);
		} else if (comando.equals("AGREGAR APCHANCE")) {
			vMenChance.setVisible(false);
			vMenChance.remove(vMenChance.getP18());
			vMenChance.getP18().setVisible(false);
			vAgChance.getPnAgChance().addSedeChangeListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e5) {
					String sedeSeleccionada = e5.getActionCommand();
					List<Long> cedulas = obtenerCedulasPorSede(sedeSeleccionada);
					vAgChance.getPnAgChance().actualizarCedulas(cedulas);
				}
			});
			vAgChance.add(vAgChance.getPnAgChance());
			vAgChance.getPnAgChance().setVisible(true);
			vAgChance.repaint();
			vAgChance.setVisible(true);
		} else if (comando.equals("AGREGARAPCHANCE")) {
			LocalDate dia = LocalDate.now();
			String sede = vAgChance.getPnAgChance().getSedeSeleccionada();
			Long cedulaApostador = (Long) vAgChance.getPnAgChance().getComboBoxCedula().getSelectedItem();

			// Obtener el array de JComboBox<Integer> desde la vista
			JComboBox<Integer>[] comboBoxNumeros = vAgChance.getPnAgChance().getComboBoxNumeros();

			// Crear un array de enteros para almacenar los números seleccionados
			List<Integer> numerosSeleccionados = new ArrayList<>();

			// Iterar sobre los JComboBox para obtener los números seleccionados
			for (JComboBox<Integer> comboBox : comboBoxNumeros) {
				numerosSeleccionados.add((Integer) comboBox.getSelectedItem());
			}

			// Convertir la lista a un array de enteros
			int[] numeros = numerosSeleccionados.stream().mapToInt(Integer::intValue).toArray();

			// Crear una cadena de números separados por comas
			String numerosString = Arrays.stream(numeros).mapToObj(String::valueOf).collect(Collectors.joining(","));

			Double valorApuesta = 0.0; // Valor predeterminado

			String nombreLoteria = vAgChance.getPnAgChance().getComboBoxNombreLoteriA().getSelectedItem().toString();
			// Validar y convertir el valor de la apuesta
			String valorApuestaStr = vAgChance.getPnAgChance().getTxtValorApuesta().getText().trim();
			if (!valorApuestaStr.isEmpty()) {
				try {
					valorApuesta = Double.parseDouble(valorApuestaStr);
				} catch (NumberFormatException e3) {
					// Mostrar un mensaje de error al usuario
					JOptionPane.showMessageDialog(null,
							"Error en el formato del valor de apuesta. Se establecerá a 0.0");
					valorApuesta = 0.0; // Restablecer el valor predeterminado después del error
				}
			}

			int id = -1;
			if (chanDao.getApChance().size() == 0) {
				id = 1;
			} else {
				ArrayList<Integer> lst = new ArrayList<Integer>();
				for (int i = 0; i < chanDao.getApChance().size(); i++) {

					lst.add(chanDao.getApChance().get(i).getIdChance());
				}
				for (int i = 0; i < chanDao.getApChance().size(); i++) {
					if (!lst.contains(i + 1)) {
						id = i + 1;
					}
				}
				if (id == -1) {
					id = chanDao.getApChance().size() + 1;
				}
			}

			// Crear la apuesta
			chanDao.create(Integer.toString(id), dia.toString(), cedulaApostador.toString(), sede, nombreLoteria,
					numerosString, valorApuesta.toString());

			vAgChance.getPnAgChance().mostrarRecibo(dia, sede, cedulaApostador, nombreLoteria, numeros, valorApuesta,
					id);

			// Mostrar mensaje de éxito al usuario
			JOptionPane.showMessageDialog(null, "Apuesta creada con éxito. Conserva muy bien tu ID -> " + id);

			// Limpiar la vista para futuras entradas
			vAgChance.getPnAgChance().getTxtValorApuesta().setText("");

			// Cambiar la visibilidad de las vistas
			vAgChance.setVisible(false);
			vAgChance.remove(vAgChance.getP19());
			vAgChance.getP19().setVisible(false);
			vMenChance.add(vMenChance.getP18());
			vMenChance.getP18().setVisible(true);
			vMenChance.repaint();
			vMenChance.setVisible(true);
		} else if (comando.equals("SALIR AGAPCHANCE")) {
			vAgChance.setVisible(false);
			vAgChance.remove(vAgChance.getPnAgChance());
			vMenChance.add(vMenChance.getP18());
			vMenChance.getP18().setVisible(true);
			vMenChance.repaint();
			vMenChance.setVisible(true);
		} else if (comando.equals("ACTUALIZAR APCHANCE")) {
			String buscar = JOptionPane.showInputDialog(null, "Ingrese el indice que ocupa la apuesta a modificar.",
					"indice-actualizar");
			if (noLetras(buscar) == false) {
				JOptionPane.showMessageDialog(null, "El indice no puede incluir letras.");
			} else if (balDao.buscarPorId(Integer.parseInt(buscar)) == false) {
				JOptionPane.showMessageDialog(null, "No existe ninguna apuesta con ese index.");
			} else {
				buscarIndex = buscar;
				vActChance.getPnActChance().getTxtValorApuesta()
						.setText(chanDao.search(Integer.parseInt(buscarIndex)).getValorApuesta() + "");
				opc2 = 1;
				vMenChance.setVisible(false);
				vMenChance.remove(vMenChance.getP18());
				vMenChance.getP18().setVisible(false);
				vActChance.getPnActChance().addSedeChangeListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e4) {
						String sedeSeleccionada = e4.getActionCommand();
						List<Long> cedulas = obtenerCedulasPorSede(sedeSeleccionada);
						vActChance.getPnActChance().actualizarCedulas(cedulas);
					}
				});
				vActChance.add(vActChance.getPnActChance());
				vActChance.getPnActChance().setVisible(true);
				vActChance.repaint();
				vActChance.setVisible(true);
			}
			buscarIndex = buscar;
		} else if (comando.equals("ACTUALAPCHANCE")) {
			if (buscarIndex == null) {
				JOptionPane.showMessageDialog(null, "Index no encontrado");
			} else {
				if (opc2 == 1) {
					int index = Integer.parseInt(buscarIndex);
					if (chanDao.searchById(index)) {
						vActChance.getPnActChance().setVisible(true);
						LocalDate dia = LocalDate.now();
						String sede = vActChance.getPnActChance().getSedeSeleccionada();
						Long cedulaApostador = (Long) vActChance.getPnActChance().getComboBoxCedula().getSelectedItem();
						String nombreLoteria = vActChance.getPnActChance().getComboBoxNombreLoteriA().getSelectedItem()
								.toString();

						// Obtener el array de JComboBox<Integer> desde la vista
						JComboBox<Integer>[] comboBoxNumeros = vActChance.getPnActChance().getComboBoxNumeros();

						// Crear un array de enteros para almacenar los números seleccionados
						List<Integer> numerosSeleccionados = new ArrayList<>();

						// Iterar sobre los JComboBox para obtener los números seleccionados
						for (JComboBox<Integer> comboBox : comboBoxNumeros) {
							numerosSeleccionados.add((Integer) comboBox.getSelectedItem());
						}

						// Convertir la lista a un array de enteros
						int[] numeros = numerosSeleccionados.stream().mapToInt(Integer::intValue).toArray();

						// Crear una cadena de números separados por comas
						String numerosString = Arrays.stream(numeros).mapToObj(String::valueOf)
								.collect(Collectors.joining(","));

						Double valorApuesta = 0.0; // Valor predeterminado

						// Validar y convertir el valor de la apuesta
						String valorApuestaStr = vActChance.getPnActChance().getTxtValorApuesta().getText().trim();
						if (!valorApuestaStr.isEmpty()) {
							try {
								valorApuesta = Double.parseDouble(valorApuestaStr);
							} catch (NumberFormatException e3) {
								// Mostrar un mensaje de error al usuario
								JOptionPane.showMessageDialog(null,
										"Error en el formato del valor de apuesta. Se establecerá a 0.0");
								valorApuesta = 0.0; // Restablecer el valor predeterminado después del error
							}
						}
						// Actualizar la sede por índice
						boolean actualizado = chanDao.updateByIndex(index, dia.toString(), cedulaApostador.toString(),
								sede, nombreLoteria, numerosString, valorApuesta.toString());

						if (actualizado) {
							vActChance.getPnActChance().mostrarRecibo(dia, sede, cedulaApostador, nombreLoteria,
									numeros, valorApuesta, index);
							JOptionPane.showMessageDialog(null, "Apuesta Chance actualizada con éxito!");
							vActBaloto.getPnActBaloto().getTxtValorApuesta().setText("");

							// Cambiar la visibilidad de las vistas
							vActBaloto.setVisible(false);
							vActBaloto.remove(vActBaloto.getP17());
							vActBaloto.getP17().setVisible(false);
							vMenBaloto.add(vMenBaloto.getP15());
							vMenBaloto.getP15().setVisible(true);
							vMenBaloto.repaint();
							vMenBaloto.setVisible(true);

						} else {
							JOptionPane.showMessageDialog(null, "Error al actualizar la apuesta");
						}
					} else {
						JOptionPane.showMessageDialog(null, "No existe ninguna apuesta con ese índice.");
					}
				}
			}
		} else if (comando.equals("SALIR ACTAPCHANCE")) {
			vActChance.setVisible(false);
			vActChance.remove(vAgChance.getPnAgChance());
			vMenChance.add(vMenChance.getP18());
			vMenChance.getP18().setVisible(true);
			vMenChance.repaint();
			vMenChance.setVisible(true);
		} else if (comando.equals("ELIMINAR APBCHANCE")) {
			String buscar = JOptionPane.showInputDialog(null,
					"Ingrese el indice que ocupa la apuesta que quiere eliminar de nuestra sede.", "indice-eliminar");
			if (noLetras(buscar) == false) {
				JOptionPane.showMessageDialog(null, "El indice no puede incluir numeros.");
			} else {
				if (chanDao.delete(Integer.parseInt(buscar))) {
					JOptionPane.showMessageDialog(null, "Se elimino la apuesta con exito.");
				} else {
					JOptionPane.showMessageDialog(null,
							"Recuerde que el indice debe existir y la apuesta no puede ser vacia");
				}
			}
		} else if (comando.equals("MOSTRAR APCHANCE")) {
			ArrayList<ChanceDTO> apChance = chanDao.getApChance();
			ArrayList<ChanceDTO> aux = new ArrayList<ChanceDTO>();
			for (int i = 0; i < apChance.size(); i++) {
				if (apChance.get(i).getClass().getSimpleName().toString().equals("ChanceDTO")) {
					aux.add(apChance.get(i));
				}
			}
			TablaApuestaChance tablaApChan = new TablaApuestaChance(aux);
			JTable tablitaApChan = tablaApChan.agregaChance();
		} else if (comando.equals("SALIR APCHANCE")) {
			vMenChance.remove(vMenChance.getP18());
			vMenChance.getP18().setVisible(false);
			vMenChance.setVisible(false);
			vMenuPrincipal.setVisible(true);
		} else if (comando.equals("LOTERIA")) {
			vMenuPrincipal.remove(vMenuPrincipal.getP5());
			vMenLoteria.add(vMenLoteria.getP21());
			vMenLoteria.getP21().setVisible(true);
			vMenLoteria.repaint();
			vMenLoteria.setVisible(true);
		} else if (comando.equals("AGREGAR APLOTERIA")) {
			vMenLoteria.setVisible(false);
			vMenLoteria.remove(vMenLoteria.getP21());
			vMenLoteria.getP21().setVisible(false);
			vAgLoteria.getPnAgLoteria().addSedeChangeListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e5) {
					String sedeSeleccionada = e5.getActionCommand();
					List<Long> cedulas = obtenerCedulasPorSede(sedeSeleccionada);
					vAgLoteria.getPnAgLoteria().actualizarCedulas(cedulas);
				}
			});
			vAgLoteria.add(vAgLoteria.getPnAgLoteria());
			vAgLoteria.getPnAgLoteria().setVisible(true);
			vAgLoteria.repaint();
			vAgLoteria.setVisible(true);
		} else if (comando.equals("AGREGARAPLOTERIA")) {
			LocalDate dia = LocalDate.now();
			String sede = vAgLoteria.getPnAgLoteria().getSedeSeleccionada();
			Long cedulaApostador = (Long) vAgLoteria.getPnAgLoteria().getComboBoxCedula().getSelectedItem();

			// Obtener el array de JComboBox<Integer> desde la vista
			JComboBox<Integer>[] comboBoxNumeros = vAgLoteria.getPnAgLoteria().getComboBoxNumeros();

			// Crear un array de enteros para almacenar los números seleccionados
			List<Integer> numerosSeleccionados = new ArrayList<>();

			// Iterar sobre los JComboBox para obtener los números seleccionados
			for (JComboBox<Integer> comboBox : comboBoxNumeros) {
				numerosSeleccionados.add((Integer) comboBox.getSelectedItem());
			}
			String nombreLoteria = vAgLoteria.getPnAgLoteria().getComboBoxNombreLoteriA().getSelectedItem().toString();

			// Convertir la lista a un array de enteros
			int[] numeros = numerosSeleccionados.stream().mapToInt(Integer::intValue).toArray();

			// Crear una cadena de números separados por comas
			String numerosString = Arrays.stream(numeros).mapToObj(String::valueOf).collect(Collectors.joining(","));

			int numSerie = Integer.parseInt(vAgLoteria.getPnAgLoteria().getTxtValorApuesta().getText().toString());

			Double valorApuesta = 0.0; // Valor predeterminado

			// Validar y convertir el valor de la apuesta
			String valorApuestaStr = vAgLoteria.getPnAgLoteria().getTxtValorApuesta().getText().trim();
			if (!valorApuestaStr.isEmpty()) {
				try {
					valorApuesta = Double.parseDouble(valorApuestaStr);
				} catch (NumberFormatException e3) {
					// Mostrar un mensaje de error al usuario
					JOptionPane.showMessageDialog(null,
							"Error en el formato del valor de apuesta. Se establecerá a 0.0");
					valorApuesta = 0.0; // Restablecer el valor predeterminado después del error
				}
			}

			int id = -1;
			if (ltDao.getApLoteria().size() == 0) {
				id = 1;
			} else {
				ArrayList<Integer> lst = new ArrayList<Integer>();
				for (int i = 0; i < ltDao.getApLoteria().size(); i++) {

					lst.add(ltDao.getApLoteria().get(i).getIdLoteria());
				}
				for (int i = 0; i < ltDao.getApLoteria().size(); i++) {
					if (!lst.contains(i + 1)) {
						id = i + 1;
					}
				}
				if (id == -1) {
					id = ltDao.getApLoteria().size() + 1;
				}
			}

			// Crear la apuesta
			ltDao.create(Integer.toString(id), dia.toString(), cedulaApostador.toString(), sede, nombreLoteria,
					numerosString, Integer.toString(numSerie), valorApuesta.toString());

			vAgLoteria.getPnAgLoteria().mostrarRecibo(dia, sede, cedulaApostador, numeros, numSerie, valorApuesta, id);

			// Mostrar mensaje de éxito al usuario
			JOptionPane.showMessageDialog(null, "Apuesta creada con éxito. Conserva muy bien tu ID -> " + id);

			// Limpiar la vista para futuras entradas
			vAgLoteria.getPnAgLoteria().getTxtNumeroSerie().setText("");
			vAgLoteria.getPnAgLoteria().getTxtValorApuesta().setText("");

			// Cambiar la visibilidad de las vistas
			vAgLoteria.setVisible(false);
			vAgLoteria.remove(vAgLoteria.getP22());
			vAgLoteria.getP22().setVisible(false);
			vMenLoteria.add(vMenLoteria.getP21());
			vMenLoteria.getP21().setVisible(true);
			vMenLoteria.repaint();
			vMenLoteria.setVisible(true);
		} else if (comando.equals("SALIR AGAPLOTERIA")) {
			vAgLoteria.setVisible(false);
			vAgLoteria.remove(vAgLoteria.getPnAgLoteria());
			vMenLoteria.add(vMenLoteria.getP21());
			vMenLoteria.getP21().setVisible(true);
			vMenLoteria.repaint();
			vMenLoteria.setVisible(true);
		} else if (comando.equals("ACTUALIZAR APLOTERIA")) {
			String buscar = JOptionPane.showInputDialog(null, "Ingrese el indice que ocupa la apuesta a modificar.",
					"indice-actualizar");
			if (noLetras(buscar) == false) {
				JOptionPane.showMessageDialog(null, "El indice no puede incluir letras.");
			} else if (balDao.buscarPorId(Integer.parseInt(buscar)) == false) {
				JOptionPane.showMessageDialog(null, "No existe ninguna apuesta con ese index.");
			} else {
				buscarIndex = buscar;
				vActLoteria.getPnActLoteria().getTxtValorApuesta()
						.setText(ltDao.search(Integer.parseInt(buscarIndex)).getValorApuesta() + "");
				vActLoteria.getPnActLoteria().getTxtValorApuesta()
						.setText(ltDao.search(Integer.parseInt(buscarIndex)).getNumSerie() + "");
				opc2 = 1;
				vMenLoteria.setVisible(false);
				vMenLoteria.remove(vMenLoteria.getP21());
				vMenLoteria.getP21().setVisible(false);
				vActLoteria.getPnActLoteria().addSedeChangeListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e4) {
						String sedeSeleccionada = e4.getActionCommand();
						List<Long> cedulas = obtenerCedulasPorSede(sedeSeleccionada);
						vActLoteria.getPnActLoteria().actualizarCedulas(cedulas);
					}
				});
				vActLoteria.add(vActLoteria.getPnActLoteria());
				vActLoteria.getPnActLoteria().setVisible(true);
				vActLoteria.repaint();
				vActLoteria.setVisible(true);
			}
			buscarIndex = buscar;

		} else if (comando.equals("ACTUALLOTERIA")) {
			if (buscarIndex == null) {
				JOptionPane.showMessageDialog(null, "Index no encontrado");
			} else {
				if (opc2 == 1) {
					int index = Integer.parseInt(buscarIndex);
					if (ltDao.searchById(index)) {
						vActLoteria.getPnActLoteria().setVisible(true);
						LocalDate dia = LocalDate.now();
						String sede = vActLoteria.getPnActLoteria().getSedeSeleccionada();
						Long cedulaApostador = (Long) vActLoteria.getPnActLoteria().getComboBoxCedula()
								.getSelectedItem();
						String nombreLoteria = vActLoteria.getPnActLoteria().getComboBoxNombreLoteriA()
								.getSelectedItem().toString();

						// Obtener el array de JComboBox<Integer> desde la vista
						JComboBox<Integer>[] comboBoxNumeros = vActLoteria.getPnActLoteria().getComboBoxNumeros();

						// Crear un array de enteros para almacenar los números seleccionados
						List<Integer> numerosSeleccionados = new ArrayList<>();

						// Iterar sobre los JComboBox para obtener los números seleccionados
						for (JComboBox<Integer> comboBox : comboBoxNumeros) {
							numerosSeleccionados.add((Integer) comboBox.getSelectedItem());
						}

						// Convertir la lista a un array de enteros
						int[] numeros = numerosSeleccionados.stream().mapToInt(Integer::intValue).toArray();

						// Crear una cadena de números separados por comas
						String numerosString = Arrays.stream(numeros).mapToObj(String::valueOf)
								.collect(Collectors.joining(","));
						int numSerie = Integer
								.parseInt(vActLoteria.getPnActLoteria().getTxtValorApuesta().getText().toString());
						Double valorApuesta = 0.0; // Valor predeterminado

						// Validar y convertir el valor de la apuesta
						String valorApuestaStr = vActLoteria.getPnActLoteria().getTxtValorApuesta().getText().trim();
						if (!valorApuestaStr.isEmpty()) {
							try {
								valorApuesta = Double.parseDouble(valorApuestaStr);
							} catch (NumberFormatException e3) {
								// Mostrar un mensaje de error al usuario
								JOptionPane.showMessageDialog(null,
										"Error en el formato del valor de apuesta. Se establecerá a 0.0");
								valorApuesta = 0.0; // Restablecer el valor predeterminado después del error
							}
						}
						// Actualizar la sede por índice
						boolean actualizado = ltDao.updateByIndex(index, dia.toString(), cedulaApostador.toString(),
								sede, nombreLoteria, numerosString, Integer.toString(numSerie),
								valorApuesta.toString());

						if (actualizado) {
							vAgLoteria.getPnAgLoteria().mostrarRecibo(dia, sede, cedulaApostador, numeros, numSerie,
									valorApuesta, index);
							JOptionPane.showMessageDialog(null, "Apuesta Chance actualizada con éxito!");
							vActLoteria.getPnActLoteria().getTxtValorApuesta().setText("");

							// Cambiar la visibilidad de las vistas
							vActLoteria.setVisible(false);
							vActLoteria.remove(vActLoteria.getP23());
							vActLoteria.getP23().setVisible(false);
							vMenLoteria.add(vMenBaloto.getP15());
							vMenLoteria.getP21().setVisible(true);
							vMenLoteria.repaint();
							vMenLoteria.setVisible(true);

						} else {
							JOptionPane.showMessageDialog(null, "Error al actualizar la apuesta");
						}
					} else {
						JOptionPane.showMessageDialog(null, "No existe ninguna apuesta con ese índice.");
					}
				}
			}
		} else if (comando.equals("SALIR ACTLOTERIA")) {
			vActLoteria.setVisible(false);
			vActLoteria.remove(vAgLoteria.getPnAgLoteria());
			vMenLoteria.add(vMenLoteria.getP21());
			vMenLoteria.getP21().setVisible(true);
			vMenLoteria.repaint();
			vMenLoteria.setVisible(true);
		} else if (comando.equals("ELIMINAR APLOTERIA")) {
			String buscar = JOptionPane.showInputDialog(null,
					"Ingrese el indice que ocupa la apuesta que quiere eliminar de nuestra sede.", "indice-eliminar");
			if (noLetras(buscar) == false) {
				JOptionPane.showMessageDialog(null, "El indice no puede incluir numeros.");
			} else {
				if (ltDao.delete(Integer.parseInt(buscar))) {
					JOptionPane.showMessageDialog(null, "Se elimino la apuesta con exito.");
				} else {
					JOptionPane.showMessageDialog(null,
							"Recuerde que el indice debe existir y la apuesta no puede ser vacia");
				}
			}
		} else if (comando.equals("MOSTRAR APLOTERIA")) {
			ArrayList<LoteriaDTO> apLoteria = ltDao.getApLoteria();
			ArrayList<LoteriaDTO> aux = new ArrayList<LoteriaDTO>();
			for (int i = 0; i < apLoteria.size(); i++) {
				if (apLoteria.get(i).getClass().getSimpleName().toString().equals("LoteriaDTO")) {
					aux.add(apLoteria.get(i));
				}
			}
			TablaApLoteria tablaApLot = new TablaApLoteria(aux);
			JTable tablitaApLot = tablaApLot.agregarLoteria();
		} else if (comando.equals("SALIR APLOTERIA")) {
			vMenLoteria.setVisible(false);
			vMenLoteria.remove(vMenLoteria.getP21());
			vMenuPrincipal.add(vMenuPrincipal.getP5());
			vMenuPrincipal.getP5().setVisible(true);
			vMenuPrincipal.repaint();
			vMenuPrincipal.setVisible(true);
		} else if (comando.equals("SUPERASTRO")) {
			vMenuPrincipal.remove(vMenuPrincipal.getP5());
			vMenSuperAstro.add(vMenSuperAstro.getP24());
			vMenSuperAstro.getP24().setVisible(true);
			vMenSuperAstro.repaint();
			vMenSuperAstro.setVisible(true);
		} else if (comando.equals("AGREGAR APSUPERASTRO")) {
			vMenSuperAstro.setVisible(false);
			vMenSuperAstro.remove(vMenSuperAstro.getP24());
			vMenSuperAstro.getP24().setVisible(false);
			vAgSuperAstro.getPnAgSuperAstro().addSedeChangeListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e5) {
					String sedeSeleccionada = e5.getActionCommand();
					List<Long> cedulas = obtenerCedulasPorSede(sedeSeleccionada);
					vAgSuperAstro.getPnAgSuperAstro().actualizarCedulas(cedulas);
				}
			});
			vAgSuperAstro.add(vAgSuperAstro.getPnAgSuperAstro());
			vAgSuperAstro.getPnAgSuperAstro().setVisible(true);
			vAgSuperAstro.repaint();
			vAgSuperAstro.setVisible(true);
		} else if (comando.equals("AGREGARAPSUPER")) {
			LocalDate dia = LocalDate.now();
			String sede = vAgSuperAstro.getPnAgSuperAstro().getSedeSeleccionada();
			Long cedulaApostador = (Long) vAgSuperAstro.getPnAgSuperAstro().getComboBoxCedula().getSelectedItem();

			// Obtener el array de JComboBox<Integer> desde la vista
			JComboBox<Integer>[] comboBoxNumeros = vAgSuperAstro.getPnAgSuperAstro().getComboBoxNumeros();

			// Crear un array de enteros para almacenar los números seleccionados
			List<Integer> numerosSeleccionados = new ArrayList<>();

			// Iterar sobre los JComboBox para obtener los números seleccionados
			for (JComboBox<Integer> comboBox : comboBoxNumeros) {
				numerosSeleccionados.add((Integer) comboBox.getSelectedItem());
			}

			// Convertir la lista a un array de enteros
			int[] numeros = numerosSeleccionados.stream().mapToInt(Integer::intValue).toArray();

			// Crear una cadena de números separados por comas
			String numerosString = Arrays.stream(numeros).mapToObj(String::valueOf).collect(Collectors.joining(","));

			Double valorApuesta = 0.0; // Valor predeterminado

			String signoZodiacal = vAgSuperAstro.getPnAgSuperAstro().getComboBoxSignoZodiacal().getSelectedItem()
					.toString();
			// Validar y convertir el valor de la apuesta
			String valorApuestaStr = vAgSuperAstro.getPnAgSuperAstro().getTxtValorApuesta().getText().trim();
			if (!valorApuestaStr.isEmpty()) {
				try {
					valorApuesta = Double.parseDouble(valorApuestaStr);
				} catch (NumberFormatException e3) {
					// Mostrar un mensaje de error al usuario
					JOptionPane.showMessageDialog(null,
							"Error en el formato del valor de apuesta. Se establecerá a 0.0");
					valorApuesta = 0.0; // Restablecer el valor predeterminado después del error
				}
			}

			int id = -1;
			if (sAstroDao.getApSuperAstro().size() == 0) {
				id = 1;
			} else {
				ArrayList<Integer> lst = new ArrayList<Integer>();
				for (int i = 0; i < sAstroDao.getApSuperAstro().size(); i++) {

					lst.add(sAstroDao.getApSuperAstro().get(i).getIdSuperAstro());
				}
				for (int i = 0; i < sAstroDao.getApSuperAstro().size(); i++) {
					if (!lst.contains(i + 1)) {
						id = i + 1;
					}
				}
				if (id == -1) {
					id = sAstroDao.getApSuperAstro().size() + 1;
				}
			}

			// Crear la apuesta
			sAstroDao.create(Integer.toString(id), dia.toString(), cedulaApostador.toString(), sede, numerosString,
					signoZodiacal, valorApuesta.toString());

			// Mostrar mensaje de éxito al usuario
			JOptionPane.showMessageDialog(null, "Apuesta creada con éxito. Conserva muy bien tu ID -> " + id);

			vAgSuperAstro.getPnAgSuperAstro().mostrarRecibo(dia, sede, cedulaApostador, numeros, signoZodiacal,
					valorApuesta, id);

			// Limpiar la vista para futuras entradas
			vAgSuperAstro.getPnAgSuperAstro().getTxtValorApuesta().setText("");

			// Cambiar la visibilidad de las vistas
			vAgSuperAstro.setVisible(false);
			vAgSuperAstro.remove(vAgSuperAstro.getP25());
			vAgSuperAstro.getP25().setVisible(false);
			vMenSuperAstro.add(vMenSuperAstro.getP24());
			vMenSuperAstro.getP24().setVisible(true);
			vMenSuperAstro.repaint();
			vMenSuperAstro.setVisible(true);
		} else if (comando.equals("SALIR AGAPCSUPER")) {
			vAgSuperAstro.setVisible(false);
			vAgSuperAstro.remove(vAgSuperAstro.getPnAgSuperAstro());
			vMenSuperAstro.add(vMenSuperAstro.getP24());
			vMenSuperAstro.getP24().setVisible(true);
			vMenSuperAstro.repaint();
			vMenSuperAstro.setVisible(true);
		} else if (comando.equals("ACTUALIZAR APSUPERASTRO")) {
			String buscar = JOptionPane.showInputDialog(null, "Ingrese el indice que ocupa la apuesta a modificar.",
					"indice-actualizar");
			if (noLetras(buscar) == false) {
				JOptionPane.showMessageDialog(null, "El indice no puede incluir letras.");
			} else if (balDao.buscarPorId(Integer.parseInt(buscar)) == false) {
				JOptionPane.showMessageDialog(null, "No existe ninguna apuesta con ese index.");
			} else {
				buscarIndex = buscar;
				vActSuperAstro.getPnActSuperAstro().getTxtValorApuesta()
						.setText(chanDao.search(Integer.parseInt(buscarIndex)).getValorApuesta() + "");
				opc2 = 1;
				vMenSuperAstro.setVisible(false);
				vMenSuperAstro.remove(vMenSuperAstro.getP24());
				vMenSuperAstro.getP24().setVisible(false);
				vActSuperAstro.getPnActSuperAstro().addSedeChangeListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e4) {
						String sedeSeleccionada = e4.getActionCommand();
						List<Long> cedulas = obtenerCedulasPorSede(sedeSeleccionada);
						vActSuperAstro.getPnActSuperAstro().actualizarCedulas(cedulas);
					}
				});
				vActSuperAstro.add(vActSuperAstro.getPnActSuperAstro());
				vActSuperAstro.getPnActSuperAstro().setVisible(true);
				vActSuperAstro.repaint();
				vActSuperAstro.setVisible(true);
			}
			buscarIndex = buscar;
		} else if (comando.equals("ACTUALAPSUPER")) {
			if (buscarIndex == null) {
				JOptionPane.showMessageDialog(null, "Index no encontrado");
			} else {
				if (opc2 == 1) {
					int index = Integer.parseInt(buscarIndex);
					if (sAstroDao.searchById(index)) {
						vActSuperAstro.getPnActSuperAstro().setVisible(true);
						LocalDate dia = LocalDate.now();
						String sede = vActSuperAstro.getPnActSuperAstro().getSedeSeleccionada();
						Long cedulaApostador = (Long) vActSuperAstro.getPnActSuperAstro().getComboBoxCedula()
								.getSelectedItem();
						String signoZodiacal = vActSuperAstro.getPnActSuperAstro().getComboBoxSignoZodiacal()
								.getSelectedItem().toString();

						// Obtener el array de JComboBox<Integer> desde la vista
						JComboBox<Integer>[] comboBoxNumeros = vActSuperAstro.getPnActSuperAstro().getComboBoxNumeros();

						// Crear un array de enteros para almacenar los números seleccionados
						List<Integer> numerosSeleccionados = new ArrayList<>();

						// Iterar sobre los JComboBox para obtener los números seleccionados
						for (JComboBox<Integer> comboBox : comboBoxNumeros) {
							numerosSeleccionados.add((Integer) comboBox.getSelectedItem());
						}

						// Convertir la lista a un array de enteros
						int[] numeros = numerosSeleccionados.stream().mapToInt(Integer::intValue).toArray();

						// Crear una cadena de números separados por comas
						String numerosString = Arrays.stream(numeros).mapToObj(String::valueOf)
								.collect(Collectors.joining(","));

						Double valorApuesta = 0.0; // Valor predeterminado

						// Validar y convertir el valor de la apuesta
						String valorApuestaStr = vActSuperAstro.getPnActSuperAstro().getTxtValorApuesta().getText()
								.trim();
						if (!valorApuestaStr.isEmpty()) {
							try {
								valorApuesta = Double.parseDouble(valorApuestaStr);
							} catch (NumberFormatException e3) {
								// Mostrar un mensaje de error al usuario
								JOptionPane.showMessageDialog(null,
										"Error en el formato del valor de apuesta. Se establecerá a 0.0");
								valorApuesta = 0.0; // Restablecer el valor predeterminado después del error
							}
						}
						// Actualizar la sede por índice
						boolean actualizado = sAstroDao.updateByIndex(index, dia.toString(), cedulaApostador.toString(),
								sede, numerosString, signoZodiacal, valorApuesta.toString());

						if (actualizado) {
							vAgSuperAstro.getPnAgSuperAstro().mostrarRecibo(dia, sede, cedulaApostador, numeros,
									signoZodiacal, valorApuesta, index);
							JOptionPane.showMessageDialog(null, "Apuesta SuperAstro actualizada con éxito!");
							vActSuperAstro.getPnActSuperAstro().getTxtValorApuesta().setText("");

							// Cambiar la visibilidad de las vistas
							vActSuperAstro.setVisible(false);
							vActSuperAstro.remove(vActSuperAstro.getP26());
							vActSuperAstro.getP26().setVisible(false);
							vMenSuperAstro.add(vMenSuperAstro.getP24());
							vMenSuperAstro.getP24().setVisible(true);
							vMenSuperAstro.repaint();
							vMenSuperAstro.setVisible(true);

						} else {
							JOptionPane.showMessageDialog(null, "Error al actualizar la apuesta");
						}
					} else {
						JOptionPane.showMessageDialog(null, "No existe ninguna apuesta con ese índice.");
					}
				}
			}
		} else if (comando.equals("SALIR ACTAPSUPER")) {
			vActSuperAstro.setVisible(false);
			vActSuperAstro.remove(vActSuperAstro.getPnActSuperAstro());
			vMenSuperAstro.add(vMenSuperAstro.getP24());
			vMenSuperAstro.getP24().setVisible(true);
			vMenSuperAstro.repaint();
			vMenSuperAstro.setVisible(true);
		} else if (comando.equals("ELIMINAR APSUPERASTRO")) {
			String buscar = JOptionPane.showInputDialog(null,
					"Ingrese el indice que ocupa la apuesta que quiere eliminar de nuestra sede.", "indice-eliminar");
			if (noLetras(buscar) == false) {
				JOptionPane.showMessageDialog(null, "El indice no puede incluir numeros.");
			} else {
				if (sAstroDao.delete(Integer.parseInt(buscar))) {
					JOptionPane.showMessageDialog(null, "Se elimino la apuesta con exito.");
				} else {
					JOptionPane.showMessageDialog(null,
							"Recuerde que el indice debe existir y la apuesta no puede ser vacia");
				}
			}
		} else if (comando.equals("MOSTRAR APSUPERASTRO")) {
			ArrayList<SuperAstroDTO> apSuperAstro = sAstroDao.getApSuperAstro();
			ArrayList<SuperAstroDTO> aux = new ArrayList<SuperAstroDTO>();
			for (int i = 0; i < apSuperAstro.size(); i++) {
				if (apSuperAstro.get(i).getClass().getSimpleName().toString().equals("SuperAstroDTO")) {
					aux.add(apSuperAstro.get(i));
				}
			}
			TablaApuestaSuperAstro tablaApSuper = new TablaApuestaSuperAstro(aux);
			JTable tablitaApSuper = tablaApSuper.agregarSuperAstro();
		} else if (comando.equals("SALIR APSUPERASTRO")) {
			vMenSuperAstro.remove(vMenSuperAstro.getP24());
			vMenSuperAstro.getP24().setVisible(false);
			vMenSuperAstro.setVisible(false);
			vMenuPrincipal.setVisible(true);
		} else if (comando.equals("BETPLAY")) {
			vMenuPrincipal.remove(vMenuPrincipal.getP5());
			vMenBetplay.add(vMenBetplay.getP27());
			vMenBetplay.getP27().setVisible(true);
			vMenBetplay.repaint();
			vMenBetplay.setVisible(true);
		} else if (comando.equals("AGREGAR APBETPLAY")) {
			vMenBetplay.setVisible(false);
			vMenBetplay.remove(vMenBetplay.getP27());
			vMenBetplay.getP27().setVisible(false);
			vAgBetplay.getPnAgBetplay().addSedeChangeListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e5) {
					String sedeSeleccionada = e5.getActionCommand();
					List<Long> cedulas = obtenerCedulasPorSede(sedeSeleccionada);
					vAgBetplay.getPnAgBetplay().actualizarCedulas(cedulas);
				}
			});
			vAgBetplay.add(vAgBetplay.getPnAgBetplay());
			vAgBetplay.getPnAgBetplay().setVisible(true);
			vAgBetplay.repaint();
			vAgBetplay.setVisible(true);
		} else if (comando.equals("AGREGARAPBETPLAY")) {
			LocalDate dia = LocalDate.now();
			String sede = vAgBetplay.getPnAgBetplay().getSedeSeleccionada();
			Long cedulaApostador = (Long) vAgBetplay.getPnAgBetplay().getComboBoxCedula().getSelectedItem();

			String partido = vAgBetplay.getPnAgBetplay().getComboBoxPartidos().getSelectedItem().toString();
			String resultado = vAgBetplay.getPnAgBetplay().getComboBoxResultado().getSelectedItem().toString();

			Double valorApuesta = 0.0; // Valor predeterminado

			// Validar y convertir el valor de la apuesta
			String valorApuestaStr = vAgBetplay.getPnAgBetplay().getTxtValorApuesta().getText().trim();
			if (!valorApuestaStr.isEmpty()) {
				try {
					valorApuesta = Double.parseDouble(valorApuestaStr);
				} catch (NumberFormatException e3) {
					// Mostrar un mensaje de error al usuario
					JOptionPane.showMessageDialog(null,
							"Error en el formato del valor de apuesta. Se establecerá a 0.0");
					valorApuesta = 0.0; // Restablecer el valor predeterminado después del error
				}
			}

			int id = -1;
			if (betDao.getApBetplay().size() == 0) {
				id = 1;
			} else {
				ArrayList<Integer> lst = new ArrayList<Integer>();
				for (int i = 0; i < betDao.getApBetplay().size(); i++) {

					lst.add(betDao.getApBetplay().get(i).getIdBetplay());
				}
				for (int i = 0; i < betDao.getApBetplay().size(); i++) {
					if (!lst.contains(i + 1)) {
						id = i + 1;
					}
				}
				if (id == -1) {
					id = betDao.getApBetplay().size() + 1;
				}
			}

			// Crear la apuesta
			betDao.create(Integer.toString(id), dia.toString(), cedulaApostador.toString(), sede, partido, resultado,
					valorApuesta.toString());

			vAgBetplay.getPnAgBetplay().mostrarRecibo(dia, sede, cedulaApostador, partido, resultado, valorApuesta, id);

			// Mostrar mensaje de éxito al usuario
			JOptionPane.showMessageDialog(null, "Apuesta creada con éxito. Conserva muy bien tu ID -> " + id);

			// Limpiar la vista para futuras entradas
			vAgBetplay.getPnAgBetplay().getTxtValorApuesta().setText("");

			// Cambiar la visibilidad de las vistas
			vAgBetplay.setVisible(false);
			vAgBetplay.remove(vAgBetplay.getP28());
			vAgBetplay.getP28().setVisible(false);
			vMenBetplay.add(vMenBetplay.getP27());
			vMenBetplay.getP27().setVisible(true);
			vMenBetplay.repaint();
			vMenBetplay.setVisible(true);
		} else if (comando.equals("SALIR AGAPBETPLAY")) {
			vAgBetplay.setVisible(false);
			vAgBetplay.remove(vAgBetplay.getPnAgBetplay());
			vMenBetplay.add(vMenBetplay.getP27());
			vMenBetplay.getP27().setVisible(true);
			vMenBetplay.repaint();
			vMenBetplay.setVisible(true);
		} else if (comando.equals("ACTUALIZAR APBETPLAY")) {
			String buscar = JOptionPane.showInputDialog(null, "Ingrese el indice que ocupa la apuesta a modificar.",
					"indice-actualizar");
			if (noLetras(buscar) == false) {
				JOptionPane.showMessageDialog(null, "El indice no puede incluir letras.");
			} else if (balDao.buscarPorId(Integer.parseInt(buscar)) == false) {
				JOptionPane.showMessageDialog(null, "No existe ninguna apuesta con ese index.");
			} else {
				buscarIndex = buscar;
				BetplayDTO bet = betDao.search(Integer.parseInt(buscarIndex));
				if (bet == null) {
					JOptionPane.showMessageDialog(null, "No se encontró ninguna apuesta con ese índice.");
				} else {
					vActBetplay.getPnActBetplay().getTxtValorApuesta().setText(bet.getValorApuesta() + "");
					opc2 = 1;
					vMenBetplay.setVisible(false);
					vMenBetplay.remove(vMenBetplay.getP27());
					vMenBetplay.getP27().setVisible(false);
					vActBetplay.getPnActBetplay().addSedeChangeListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e4) {
							String sedeSeleccionada = e4.getActionCommand();
							List<Long> cedulas = obtenerCedulasPorSede(sedeSeleccionada);
							vActBetplay.getPnActBetplay().actualizarCedulas(cedulas);
						}
					});
					vActBetplay.add(vActBetplay.getPnActBetplay());
					vActBetplay.getPnActBetplay().setVisible(true);
					vActBetplay.repaint();
					vActBetplay.setVisible(true);
				}
			}
			buscarIndex = buscar;
         
		} else if (comando.equals("ACTUALAPBETPLAY")) {
			if (buscarIndex == null) {
				JOptionPane.showMessageDialog(null, "Index no encontrado");
			} else {
				if (opc2 == 1) {
					int index = Integer.parseInt(buscarIndex);
					if (betDao.searchById(index)) {
						vActBetplay.getPnActBetplay().setVisible(true);
						LocalDate dia = LocalDate.now();
						String sede = vActBetplay.getPnActBetplay().getSedeSeleccionada();
						Long cedulaApostador = (Long) vActBetplay.getPnActBetplay().getComboBoxCedula()
								.getSelectedItem();
						String partido = vActBetplay.getPnActBetplay().getComboBoxPartidos().getSelectedItem()
								.toString();
						String resultado = vActBetplay.getPnActBetplay().getComboBoxResultado().getSelectedItem()
								.toString();

						Double valorApuesta = 0.0; // Valor predeterminado

						// Validar y convertir el valor de la apuesta
						String valorApuestaStr = vActBetplay.getPnActBetplay().getTxtValorApuesta().getText().trim();
						if (!valorApuestaStr.isEmpty()) {
							try {
								valorApuesta = Double.parseDouble(valorApuestaStr);
							} catch (NumberFormatException e3) {
								// Mostrar un mensaje de error al usuario
								JOptionPane.showMessageDialog(null,
										"Error en el formato del valor de apuesta. Se establecerá a 0.0");
								valorApuesta = 0.0; // Restablecer el valor predeterminado después del error
							}
						}
						// Actualizar la sede por índice
						boolean actualizado = betDao.updateByIndex(index, dia.toString(), cedulaApostador.toString(),
								sede, partido, resultado, valorApuesta.toString());

						if (actualizado) {
							vActBetplay.getPnActBetplay().mostrarRecibo(dia, sede, cedulaApostador, partido, resultado,
									valorApuesta, index);
							JOptionPane.showMessageDialog(null, "Apuesta Betplay actualizada con éxito!");
							vActBetplay.getPnActBetplay().getTxtValorApuesta().setText("");

							// Cambiar la visibilidad de las vistas
							vActBetplay.setVisible(false);
							vActBetplay.remove(vActBetplay.getP29());
							vActBetplay.getP29().setVisible(false);
							vMenBetplay.add(vMenBetplay.getP27());
							vMenBetplay.getP27().setVisible(true);
							vMenBetplay.repaint();
							vMenBetplay.setVisible(true);

						} else {
							JOptionPane.showMessageDialog(null, "Error al actualizar la apuesta");
						}
					} else {
						JOptionPane.showMessageDialog(null, "No existe ninguna apuesta con ese índice.");
					}
				}
			}
		} else if (comando.equals("SALIR ACTAPBETPLAY")) {
			vActBetplay.setVisible(false);
			vActBetplay.remove(vActBetplay.getPnActBetplay());
			vMenBetplay.add(vMenBetplay.getP27());
			vMenBetplay.getP27().setVisible(true);
			vMenBetplay.repaint();
			vMenBetplay.setVisible(true);
		} else if (comando.equals("ELIMINAR APBETPLAY")) {
			String buscar = JOptionPane.showInputDialog(null,
					"Ingrese el indice que ocupa la apuesta que quiere eliminar de nuestra casa de apuesta.",
					"indice-eliminar");
			if (noLetras(buscar) == false) {
				JOptionPane.showMessageDialog(null, "El indice no puede incluir numeros.");
			} else {
				if (betDao.delete(Integer.parseInt(buscar))) {
					JOptionPane.showMessageDialog(null, "Se elimino la apuesta con exito.");
				} else {
					JOptionPane.showMessageDialog(null,
							"Recuerde que el indice debe existir y la apuesta no puede ser vacia");
				}
			}
		} else if (comando.equals("MOSTRAR APBETPLAY")) {
			ArrayList<BetplayDTO> apBetplay = betDao.getApBetplay();
			ArrayList<BetplayDTO> aux = new ArrayList<BetplayDTO>();
			for (int i = 0; i < apBetplay.size(); i++) {
				if (apBetplay.get(i).getClass().getSimpleName().toString().equals("BetplayDTO")) {
					aux.add(apBetplay.get(i));
				}
			}
			TablaApBetplay tablaBet = new TablaApBetplay(aux);
			JTable tablitaBet = tablaBet.agregarBetplay();
		} else if (comando.equals("SALIR APBETPLAY")) {
			vMenBetplay.remove(vMenBetplay.getP27());
			vMenBetplay.getP27().setVisible(false);
			vMenBetplay.setVisible(false);
			vMenuPrincipal.setVisible(true);
		} else if (comando.equals("CONSULTAS")) {
			vMenuPrincipal.remove(vMenuPrincipal.getP5());
			vMenuPrincipal.getP5().setVisible(false);
			vMenuPrincipal.setVisible(false);
			vMenuConsulta.add(vMenuConsulta.getP30());
			vMenuConsulta.getP30().setVisible(true);
			vMenuConsulta.repaint();
			vMenuConsulta.setVisible(true);
		} else if (comando.equals("CLIENTEXSEDE")) {
			vMenuConsulta.remove(vMenuConsulta.getP30());
			vMenuConsulta.getP30().setVisible(false);
			vMenuConsulta.setVisible(false);
			vListadoxSede.add(vListadoxSede.getPnListadoxSede());
			vListadoxSede.getPnListadoxSede().setVisible(true);
			vListadoxSede.repaint();
			vListadoxSede.setVisible(true);
		} else if (comando.equals("BUSCARCLIENTE")) {
			String search = vListadoxSede.getPnListadoxSede().getSede().getSelectedItem().toString();
			if (search.equals("Sede")) {
				String sedeFilter = JOptionPane.showInputDialog(null,
						"Ingresa la sede por la cual quieres filtrar la informacion", "sede");
				try {
					checkName(sedeFilter);
				} catch (NombreNotValidException e2) {
					JOptionPane.showMessageDialog(null, "No puede contener numeros.");
				}
				if (apDao.depurar(3, sedeFilter) != null) {
					JOptionPane.showMessageDialog(null, apDao.depurar(3, sedeFilter));
				} else {
					JOptionPane.showMessageDialog(null, "Informacion no encontrada.");

				}
				vListadoxSede.setVisible(false);
				vListadoxSede.remove(vListadoxSede.getP33());
				vListadoxSede.getP33().setVisible(false);
				vMenuConsulta.add(vMenuConsulta.getP30());
				vMenuConsulta.getP30().setVisible(true);
				vMenuConsulta.repaint();
				vMenuConsulta.setVisible(true);
			}
		} else if (comando.equals("TOTALAPUESTA")) {
			vMenuConsulta.remove(vMenuConsulta.getP30());
			vMenuConsulta.getP30().setVisible(false);
			vMenuConsulta.setVisible(false);
			vTotalApxCliente.add(vTotalApxCliente.getPnTotalApxApos());
			vTotalApxCliente.getPnTotalApxApos().setVisible(true);
			vTotalApxCliente.setVisible(true);
		} else if (comando.equals("BUSCARVALORTOTAL")) {
			String search = vTotalApxCliente.getPnTotalApxApos().getApostador().getSelectedItem().toString();

			if (search.equals("Apostador")) {
				String cedulaFilter = JOptionPane.showInputDialog(null,
						"Ingresa la cedula por la cual quieres filtrar la informacion", "cedula");
				long cedula = Long.parseLong(cedulaFilter);
				double totalApostadoPorCedula = apuDao.calcularValorTotalApostadoPorClienteEnTodosJuegos(cedula);
				JOptionPane.showMessageDialog(null,
						"Total apostado por cédula " + cedula + ": " + totalApostadoPorCedula);
				vTotalApxCliente.setVisible(false);
				vTotalApxCliente.remove(vTotalApxCliente.getP32());
				vTotalApxCliente.getP32().setVisible(false);
				vMenuConsulta.add(vMenuConsulta.getP30());
				vMenuConsulta.getP30().setVisible(true);
				vMenuConsulta.repaint();
				vMenuConsulta.setVisible(true);
			} else if (search.equals("Sede")) {
				String sedeFilter = JOptionPane.showInputDialog(null,
						"Ingresa la sede por la cual quieres filtrar la informacion", "sede");
				double totalApostadoPorSede = apuDao.calcularTotalApuestasPorSede(sedeFilter);
				JOptionPane.showMessageDialog(null,
						"Total apostado en la sede " + sedeFilter + ": " + totalApostadoPorSede);
				vTotalApxCliente.setVisible(false);
				vTotalApxCliente.remove(vTotalApxCliente.getP32());
				vTotalApxCliente.getP32().setVisible(false);
				vMenuConsulta.add(vMenuConsulta.getP30());
				vMenuConsulta.getP30().setVisible(true);
				vMenuConsulta.repaint();
				vMenuConsulta.setVisible(true);
			} else if (search.equals("Tipo Juego")) {
				String tipoJuegoFilter = JOptionPane.showInputDialog(null,
						"Ingresa el tipo de juego por el cual quieres filtrar la informacion", "tipo de juego");

				double totalApostadoPorTipoJuego = apuDao.calcularTotalApostadoPorTipoJuego(tipoJuegoFilter);
				JOptionPane.showMessageDialog(null,
						"Total apostado en el juego " + tipoJuegoFilter + ": " + totalApostadoPorTipoJuego);
				vTotalApxCliente.setVisible(false);
				vTotalApxCliente.remove(vTotalApxCliente.getP32());
				vTotalApxCliente.getP32().setVisible(false);
				vMenuConsulta.add(vMenuConsulta.getP30());
				vMenuConsulta.getP30().setVisible(true);
				vMenuConsulta.repaint();
				vMenuConsulta.setVisible(true);
			}

		} else if (comando.equals("DETALLEAPREALIZADA")) {
			vMenuConsulta.remove(vMenuConsulta.getP30());
			vMenuConsulta.getP30().setVisible(false);
			vMenuConsulta.setVisible(false);
			vMenApRealizada.add(vMenApRealizada.getPnApRealizada());
			vMenApRealizada.getPnApRealizada().setVisible(true);
			vMenApRealizada.setVisible(true);
		} else if (comando.equals("BUSCARDETALLE")) {
			String search = vMenApRealizada.getPnApRealizada().getApuesta().getSelectedItem().toString();

			if (search.equals("Apostador")) {

				String cedulaFilter = JOptionPane.showInputDialog(null,
						"Ingresa la cedula por la cual quieres filtrar la informacion", "cedula");
				long cedula = Long.parseLong(cedulaFilter);
				String detalleBaloto = balDao.obtenerDetalleApuestasPorCedula(cedula);
				String detalleLoteria = ltDao.obtenerDetalleApuestasPorCedula(cedula);
				String detalleBetplay = betDao.obtenerDetalleApuestasPorCedula(cedula);
				String detalletChance = chanDao.obtenerDetalleApuestasPorCedula(cedula);
				String detalleSuperAstro = sAstroDao.obtenerDetalleApuestasPorCedula(cedula);

				String detalleCompleto = "Detalle de apuestas para la cédula " + cedula + ":\n" + "Baloto:\n"
						+ detalleBaloto + "\n\n" + "Lotería:\n" + detalleLoteria + "\n" + "Betplay: " + detalleLoteria
						+ "Betplay: " + detalleBetplay + "Chance: " + detalletChance + "SuperAstro: "
						+ detalleSuperAstro;

				JOptionPane.showMessageDialog(null, detalleCompleto, "Detalle de Apuestas",
						JOptionPane.INFORMATION_MESSAGE);

				vMenApRealizada.setVisible(false);
				vMenApRealizada.remove(vMenApRealizada.getP31());
				vMenApRealizada.getP31().setVisible(false);
				vMenuConsulta.add(vMenuConsulta.getP30());
				vMenuConsulta.getP30().setVisible(true);
				vMenuConsulta.repaint();
				vMenuConsulta.setVisible(true);
			} else if (search.equals("Sede")) {

				String sedeFilter = JOptionPane.showInputDialog(null,
						"Ingresa la sede por la cual quieres filtrar la informacion", "sede");

				String detalleBaloto = balDao.obtenerDetalleApuestasPorSede(sedeFilter);
				String detalleLoteria = ltDao.obtenerDetalleApuestasPorSede(sedeFilter);
				String detalleBetplay = betDao.obtenerDetalleApuestasPorSede(sedeFilter);
				String detalleChance = chanDao.obtenerDetalleApuestasPorSede(sedeFilter);
				String detalleSuperAstro = sAstroDao.obtenerDetalleApuestasPorSede(sedeFilter);

				String detalleCompleto = "Detalle de apuestas para la sede " + sedeFilter + ":\n" + "Baloto:\n"
						+ detalleBaloto + "\n\n" + "Lotería:\n" + detalleLoteria + "\n" + "Betplay: " + detalleLoteria
						+ "Betplay: " + detalleBetplay + "Chance: " + detalleChance + "SuperAstro: "
						+ detalleSuperAstro;

				JOptionPane.showMessageDialog(null, detalleCompleto, "Detalle de Apuestas por Sede",
						JOptionPane.INFORMATION_MESSAGE);

				vMenApRealizada.setVisible(false);
				vMenApRealizada.remove(vMenApRealizada.getP31());
				vMenApRealizada.getP31().setVisible(false);
				vMenuConsulta.add(vMenuConsulta.getP30());
				vMenuConsulta.getP30().setVisible(true);
				vMenuConsulta.repaint();
				vMenuConsulta.setVisible(true);
			}
		} else if (comando.equals("SALIRCONSULTA")) {
			vMenuConsulta.remove(vMenuConsulta.getP30());
			vMenuConsulta.getP30().setVisible(false);
			vMenuConsulta.setVisible(false);
			vMenuPrincipal.add(vMenuPrincipal.getP5());
			vMenuPrincipal.getP5().setVisible(true);
			vMenuPrincipal.setVisible(true);
		}
	}

	private List<Long> obtenerCedulasPorSede(String sede) {
		List<ApostadorDTO> apostadoresEnSede = apDao.getApostadoresPorSede(sede);

		// Extraer las cédulas de los apostadores en la sede
		List<Long> cedulas = apostadoresEnSede.stream().map(ApostadorDTO::getCedula).collect(Collectors.toList());

		return cedulas;
	}

	private boolean usuarioNoEncontrado(String nombreUsuario, String Contrasena) throws UsuarioNoEncontradoException {
		for (UsuarioDTO usuario : usDao.getListaUsuarios()) {
			if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(Contrasena)) {
				return true;
			}
		}
		return false;
	}

	public void accesoSiguientePestaña(String nombreUsuario, String constrasena) throws UsuarioNoEncontradoException {
		if (!usuarioNoEncontrado(nombreUsuario, constrasena)) {
			throw new UsuarioNoEncontradoException("Usuario no encontrado, intente de nuevo.");
		} else {
			System.out.println("Usuario autenticado con exito: " + nombreUsuario + constrasena);
		}
	}

	/**
	 * Comprueba si una cadena de texto no contiene letras.
	 *
	 * @param aux La cadena de texto a verificar.
	 * @return true si la cadena de texto no contiene letras, false en caso
	 *         contrario.
	 */

	public boolean noLetras(String aux) {
		boolean salida = true;

		for (int i = 0; i < aux.length(); i++) {
			if (Character.isLetter(aux.charAt(i))) {
				salida = false;
			}
		}
		return salida;
	}

	/**
	 * Verifica si el nombre contiene caracteres válidos.
	 * 
	 * @param name El nombre que se verificará.
	 * @throws NameNotValidException Si el nombre contiene caracteres no válidos.
	 */

	public void checkName(String name) throws NombreNotValidException {
		for (char c : name.toCharArray()) {
			if (!Character.isAlphabetic(c) && !Character.isWhitespace(c)) {
				throw new NombreNotValidException("Los nombres no pueden contener numeros ni letras");
			}
		}
	}

	/**
	 * Verifica si el documento contiene caracteres válidos.
	 * 
	 * @param doc El documento que se verificará.
	 * @throws DocumentNotValidException Si el documento contiene caracteres no
	 *                                   válidos.
	 */

	public void checkLetterDoc(String cc) throws CedulaNotValidException {
		for (char c : cc.toCharArray()) {
			if (!Character.isDigit(c)) {
				throw new CedulaNotValidException("La cedula no puede contener letras");
			}
		}
	}

	private int[] obtenerNumerosDesdeComboBoxes() {
		int[] numeros = new int[6];
		for (int i = 0; i < 6; i++) {
			JComboBox<Integer>[] comboBox = pnAgBaloto.getComboBoxNumeros();
			numeros[i] = comboBox.length; // Obtener el ítem en la posición i

		}
		return numeros;
	}

	public void checkNumber(String number) throws NumeroNegativoException {
		if (Integer.parseInt(number) < 0) {
			throw new NumeroNegativoException(number);
		}
	}

}
