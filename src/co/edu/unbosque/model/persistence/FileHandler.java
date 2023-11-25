package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import co.edu.unbosque.model.ApostadorDTO;
import co.edu.unbosque.model.BalotoDTO;
import co.edu.unbosque.model.BetplayDTO;
import co.edu.unbosque.model.ChanceDTO;
import co.edu.unbosque.model.JuegoDTO;
import co.edu.unbosque.model.LoteriaDTO;
import co.edu.unbosque.model.SedeDTO;
import co.edu.unbosque.model.SuperAstroDTO;
import co.edu.unbosque.model.UsuarioDTO;

/**
 * @author AgudeloDaniel, GonzalezSergio, GuizaSophy, WakilGabriella
 * 
 *         La clase FileHandler proporciona métodos para leer y escribir
 *         archivos de texto y archivos serializados.
 */

public class FileHandler {

	// texto
	private static Scanner fileReader;
	private static File myFile;
	private static PrintWriter fileWriter;

	// serializados
	// lectura de serializados
	private static ObjectInputStream ois;

	// escritura de serializados;
	private static ObjectOutputStream oos;

	/**
	 * Constructor por defecto de la clase FileHandler.
	 */
	public FileHandler() {
	}

	/**
	 * Abre y lee un archivo de texto.
	 *
	 * @param url La URL o ruta del archivo de texto a leer.
	 * @return El contenido del archivo de texto como una cadena.
	 */

	public static String openAndReadFile(String url) {

		myFile = new File(url);

		try {
			fileReader = new Scanner(myFile);
		} catch (FileNotFoundException e) {
			try {
				myFile.createNewFile();
			} catch (IOException e1) {

				System.out.println("No tengo permisos de escritura");
			}
			System.out.println("El archivo no existia, ha sido creado");
		}
		String content = "";
		while (fileReader.hasNext()) {
			content += fileReader.nextLine() + "\n";
		}
		return content;
	}

	/**
	 * Abre y escribe en un archivo de texto.
	 *
	 * @param url     La URL o ruta del archivo de texto en el que se escribirá.
	 * @param content El contenido que se escribirá en el archivo de texto.
	 */

	public static void openAndWriteFile(String url, String content) {

		myFile = new File(url);

		try {
			if (!myFile.exists()) {

				myFile.createNewFile();
			}
			fileWriter = new PrintWriter(myFile);
			fileWriter.write(content);
			fileWriter.close();
			// System.out.println(myFile.length());
		} catch (FileNotFoundException e) {

			System.out.println("No encontre el archivo");
		} catch (IOException e) {

			System.out.println("No tengo permisos");
		}

	}

	/**
	 * Abre y lee un archivo serializado de objetos de tipo ApostadorDTO.
	 *
	 * @param url La URL o ruta del archivo serializado a leer.
	 * @return Una lista de objetos ApostadorDTO leídos desde el archivo.
	 */

	public static ArrayList<ApostadorDTO> openAndReadFileApostador(String url) {
		myFile = new File("./Dat/" + url);
		ArrayList<ApostadorDTO> contenido = new ArrayList<ApostadorDTO>();
		try {
			if (!myFile.exists()) {
				myFile.createNewFile();
			} else {
				if (myFile.length() != 0) {
					ois = new ObjectInputStream(new FileInputStream(myFile));
					contenido = (ArrayList<ApostadorDTO>) ois.readObject();
					ois.close();
				}
			}
		} catch (IOException e) {
			System.out.println("Problema al crear el archivo, revise problemas de acceso.");
			System.out.println("FileHandler - openAndReadFileApostador");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return contenido;
	}

	/**
	 * Abre y escribe en un archivo serializado de objetos de tipo ApostadorDTO.
	 *
	 * @param url            La URL o ruta del archivo serializado en el que se
	 *                       escribirán los objetos.
	 * @param contentToWrite La lista de objetos ApostadorDTO que se escribirán en
	 *                       el archivo.
	 */

	public static void openAndWriteFileApostador(String url, ArrayList<ApostadorDTO> contentToWrite) {
		myFile = new File("./Dat/" + url);
		myFile.delete();
		try {
			if (!myFile.exists()) {
				myFile.createNewFile();
			}
			oos = new ObjectOutputStream(new FileOutputStream(myFile));
			oos.writeObject(contentToWrite);
			oos.close();
		} catch (IOException e) {
			System.out.println("Problema al crear el archivo, revise problemas de acceso.");
			System.out.println("FileHandler - openAndWriteFileApostador");
			e.printStackTrace();
		}
	}

	/**
	 * Abre y lee un archivo serializado de objetos de tipo BalotoDTO.
	 *
	 * @param url La URL o ruta del archivo serializado a leer.
	 * @return Una lista de objetos BalotoDTO leídos desde el archivo.
	 */

	public static ArrayList<BalotoDTO> openAndReadFileBaloto(String url) {
		myFile = new File("./Dat/" + url);
		ArrayList<BalotoDTO> contenido = new ArrayList<BalotoDTO>();
		try {
			if (!myFile.exists()) {
				myFile.createNewFile();
			} else {
				if (myFile.length() != 0) {
					ois = new ObjectInputStream(new FileInputStream(myFile));
					contenido = (ArrayList<BalotoDTO>) ois.readObject();
					ois.close();
				}
			}
		} catch (IOException e) {
			System.out.println("Problema al crear el archivo, revise problemas de acceso.");
			System.out.println("FileHandler - openAndReadFileBaloto");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return contenido;
	}

	/**
	 * Abre y escribe en un archivo serializado de objetos de tipo BalotoDTO.
	 *
	 * @param url            La URL o ruta del archivo serializado en el que se
	 *                       escribirán los objetos.
	 * @param contentToWrite La lista de objetos BalotoDTO que se escribirán en el
	 *                       archivo.
	 */

	public static void openAndWriteFileBaloto(String url, ArrayList<BalotoDTO> contentToWrite) {
		myFile = new File("./Dat/" + url);
		myFile.delete();
		try {
			if (!myFile.exists()) {
				myFile.createNewFile();
			}
			oos = new ObjectOutputStream(new FileOutputStream(myFile));
			oos.writeObject(contentToWrite);
			oos.close();
		} catch (IOException e) {
			System.out.println("Problema al crear el archivo, revise problemas de acceso.");
			System.out.println("FileHandler - openAndWriteFileBaloto");
			e.printStackTrace();
		}
	}

	/**
	 * Abre y lee un archivo serializado de objetos de tipo BetplayDTO.
	 *
	 * @param url La URL o ruta del archivo serializado a leer.
	 * @return Una lista de objetos BetplayDTO leídos desde el archivo.
	 */

	public static ArrayList<BetplayDTO> openAndReadFileBetplay(String url) {
		myFile = new File("./Dat/" + url);
		ArrayList<BetplayDTO> contenido = new ArrayList<BetplayDTO>();
		try {
			if (!myFile.exists()) {
				myFile.createNewFile();
			} else {
				if (myFile.length() != 0) {
					ois = new ObjectInputStream(new FileInputStream(myFile));
					contenido = (ArrayList<BetplayDTO>) ois.readObject();
					ois.close();
				}
			}
		} catch (IOException e) {
			System.out.println("Problema al crear el archivo, revise problemas de acceso.");
			System.out.println("FileHandler - openAndReadFileBetPlay");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return contenido;
	}

	/**
	 * Abre y escribe en un archivo serializado de objetos de tipo BetplayDTO.
	 *
	 * @param url            La URL o ruta del archivo serializado en el que se
	 *                       escribirán los objetos.
	 * @param contentToWrite La lista de objetos BetplayDTO que se escribirán en el
	 *                       archivo.
	 */

	public static void openAndWriteFileBetplay(String url, ArrayList<BetplayDTO> contentToWrite) {
		myFile = new File("./Dat/" + url);
		myFile.delete();
		try {
			if (!myFile.exists()) {
				myFile.createNewFile();
			}
			oos = new ObjectOutputStream(new FileOutputStream(myFile));
			oos.writeObject(contentToWrite);
			oos.close();
		} catch (IOException e) {
			System.out.println("Problema al crear el archivo, revise problemas de acceso.");
			System.out.println("FileHandler - openAndWriteFileBetplay");
			e.printStackTrace();
		}
	}

	/**
	 * Abre y lee un archivo serializado de objetos de tipo ChanceDTO.
	 *
	 * @param url La URL o ruta del archivo serializado a leer.
	 * @return Una lista de objetos ChanceDTO leídos desde el archivo.
	 */

	public static ArrayList<ChanceDTO> openAndReadFileChance(String url) {
		myFile = new File("./Dat/" + url);
		ArrayList<ChanceDTO> contenido = new ArrayList<ChanceDTO>();
		try {
			if (!myFile.exists()) {
				myFile.createNewFile();
			} else {
				if (myFile.length() != 0) {
					ois = new ObjectInputStream(new FileInputStream(myFile));
					contenido = (ArrayList<ChanceDTO>) ois.readObject();
					ois.close();
				}
			}
		} catch (IOException e) {
			System.out.println("Problema al crear el archivo, revise problemas de acceso.");
			System.out.println("FileHandler - openAndReadFileChance");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return contenido;
	}

	/**
	 * Abre y escribe en un archivo serializado de objetos de tipo ChanceDTO.
	 *
	 * @param url            La URL o ruta del archivo serializado en el que se
	 *                       escribirán los objetos.
	 * @param contentToWrite La lista de objetos ChanceDTO que se escribirán en el
	 *                       archivo.
	 */

	public static void openAndWriteFileChance(String url, ArrayList<ChanceDTO> contentToWrite) {
		myFile = new File("./Dat/" + url);
		myFile.delete();
		try {
			if (!myFile.exists()) {
				myFile.createNewFile();
			}
			oos = new ObjectOutputStream(new FileOutputStream(myFile));
			oos.writeObject(contentToWrite);
			oos.close();
		} catch (IOException e) {
			System.out.println("Problema al crear el archivo, revise problemas de acceso.");
			System.out.println("FileHandler - openAndWriteFileChance");
			e.printStackTrace();
		}
	}

	/**
	 * Abre y lee un archivo serializado de objetos de tipo JuegoDTO.
	 *
	 * @param url La URL o ruta del archivo serializado a leer.
	 * @return Una lista de objetos JuegoDTO leídos desde el archivo.
	 */

	public static ArrayList<JuegoDTO> openAndReadFileJuego(String url) {
		myFile = new File("./Dat/" + url);
		ArrayList<JuegoDTO> contenido = new ArrayList<JuegoDTO>();
		try {
			if (!myFile.exists()) {
				myFile.createNewFile();
			} else {
				if (myFile.length() != 0) {
					ois = new ObjectInputStream(new FileInputStream(myFile));
					contenido = (ArrayList<JuegoDTO>) ois.readObject();
					ois.close();
				}
			}
		} catch (IOException e) {
			System.out.println("Problema al crear el archivo, revise problemas de acceso.");
			System.out.println("FileHandler - openAndReadFileJuego");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return contenido;
	}

	/**
	 * Abre y escribe en un archivo serializado de objetos de tipo JuegoDTO.
	 *
	 * @param url            La URL o ruta del archivo serializado en el que se
	 *                       escribirán los objetos.
	 * @param contentToWrite La lista de objetos JuegoDTO que se escribirán en el
	 *                       archivo.
	 */

	public static void openAndWriteFileJuego(String url, ArrayList<JuegoDTO> contentToWrite) {
		myFile = new File("./Dat/" + url);
		myFile.delete();
		try {
			if (!myFile.exists()) {
				myFile.createNewFile();
			}
			oos = new ObjectOutputStream(new FileOutputStream(myFile));
			oos.writeObject(contentToWrite);
			oos.close();
		} catch (IOException e) {
			System.out.println("Problema al crear el archivo, revise problemas de acceso.");
			System.out.println("FileHandler - openAndWriteFileJuego");
			e.printStackTrace();
		}
	}

	/**
	 * Abre y lee un archivo serializado de objetos de tipo LoteriaDTO.
	 *
	 * @param url La URL o ruta del archivo serializado a leer.
	 * @return Una lista de objetos LoteriaDTO leídos desde el archivo.
	 */

	public static ArrayList<LoteriaDTO> openAndReadFileLoteria(String url) {
		myFile = new File("./Dat/" + url);
		ArrayList<LoteriaDTO> contenido = new ArrayList<LoteriaDTO>();
		try {
			if (!myFile.exists()) {
				myFile.createNewFile();
			} else {
				if (myFile.length() != 0) {
					ois = new ObjectInputStream(new FileInputStream(myFile));
					contenido = (ArrayList<LoteriaDTO>) ois.readObject();
					ois.close();
				}
			}
		} catch (IOException e) {
			System.out.println("Problema al crear el archivo, revise problemas de acceso.");
			System.out.println("FileHandler - openAndReadFileLoteria");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return contenido;
	}

	/**
	 * Abre y escribe en un archivo serializado de objetos de tipo LoteriaDTO.
	 *
	 * @param url            La URL o ruta del archivo serializado en el que se
	 *                       escribirán los objetos.
	 * @param contentToWrite La lista de objetos LoteriaDTO que se escribirán en el
	 *                       archivo.
	 */

	public static void openAndWriteFileLoteria(String url, ArrayList<LoteriaDTO> contentToWrite) {
		myFile = new File("./Dat/" + url);
		myFile.delete();
		try {
			if (!myFile.exists()) {
				myFile.createNewFile();
			}
			oos = new ObjectOutputStream(new FileOutputStream(myFile));
			oos.writeObject(contentToWrite);
			oos.close();
		} catch (IOException e) {
			System.out.println("Problema al crear el archivo, revise problemas de acceso.");
			System.out.println("FileHandler - openAndWriteFileLoteria");
			e.printStackTrace();
		}
	}

	/**
	 * Abre y lee un archivo serializado de objetos de tipo SedeDTO.
	 *
	 * @param url La URL o ruta del archivo serializado a leer.
	 * @return Una lista de objetos SedeDTO leídos desde el archivo.
	 */

	public static ArrayList<SedeDTO> openAndReadFileSede(String url) {
		myFile = new File("./Dat/" + url);
		ArrayList<SedeDTO> contenido = new ArrayList<SedeDTO>();
		try {
			if (!myFile.exists()) {
				myFile.createNewFile();
			} else {
				if (myFile.length() != 0) {
					ois = new ObjectInputStream(new FileInputStream(myFile));
					contenido = (ArrayList<SedeDTO>) ois.readObject();
					ois.close();
				}
			}
		} catch (IOException e) {
			System.out.println("Problema al crear el archivo, revise problemas de acceso.");
			System.out.println("FileHandler - openAndReadFileSede");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return contenido;
	}

	/**
	 * Abre y escribe en un archivo serializado de objetos de tipo SedeDTO.
	 *
	 * @param url            La URL o ruta del archivo serializado en el que se
	 *                       escribirán los objetos.
	 * @param contentToWrite La lista de objetos SedeDTO que se escribirán en el
	 *                       archivo.
	 */

	public static void openAndWriteFileSede(String url, ArrayList<SedeDTO> contentToWrite) {
		myFile = new File("./Dat/" + url);
		myFile.delete();
		try {
			if (!myFile.exists()) {
				myFile.createNewFile();
			}
			oos = new ObjectOutputStream(new FileOutputStream(myFile));
			oos.writeObject(contentToWrite);
			oos.close();
		} catch (IOException e) {
			System.out.println("Problema al crear el archivo, revise problemas de acceso.");
			System.out.println("FileHandler - openAndWriteFileSede");
			e.printStackTrace();
		}
	}

	/**
	 * Abre y lee un archivo serializado de objetos de tipo SuperAstroDTO.
	 *
	 * @param url La URL o ruta del archivo serializado a leer.
	 * @return Una lista de objetos SuperAstroDTO leídos desde el archivo.
	 */

	public static ArrayList<SuperAstroDTO> openAndReadFileSuperAstro(String url) {
		myFile = new File("./Dat/" + url);
		ArrayList<SuperAstroDTO> contenido = new ArrayList<SuperAstroDTO>();
		try {
			if (!myFile.exists()) {
				myFile.createNewFile();
			} else {
				if (myFile.length() != 0) {
					ois = new ObjectInputStream(new FileInputStream(myFile));
					contenido = (ArrayList<SuperAstroDTO>) ois.readObject();
					ois.close();
				}
			}
		} catch (IOException e) {
			System.out.println("Problema al crear el archivo, revise problemas de acceso.");
			System.out.println("FileHandler - openAndReadFileSuperAstro");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return contenido;
	}

	/**
	 * Abre y escribe en un archivo serializado de objetos de tipo ApostadorDTO.
	 *
	 * @param url            La URL o ruta del archivo serializado en el que se
	 *                       escribirán los objetos.
	 * @param contentToWrite La lista de objetos SuperAstroDTO que se escribirán en
	 *                       el archivo.
	 */

	public static void openAndWriteFileSuperAstro(String url, ArrayList<SuperAstroDTO> contentToWrite) {
		myFile = new File("./Dat/" + url);
		myFile.delete();
		try {
			if (!myFile.exists()) {
				myFile.createNewFile();
			}
			oos = new ObjectOutputStream(new FileOutputStream(myFile));
			oos.writeObject(contentToWrite);
			oos.close();
		} catch (IOException e) {
			System.out.println("Problema al crear el archivo, revise problemas de acceso.");
			System.out.println("FileHandler - openAndWriteFileSuperAstro");
			e.printStackTrace();
		}
	}

	/**
	 * Abre y lee un archivo serializado de objetos de tipo UsuarioDTO.
	 *
	 * @param url La URL o ruta del archivo serializado a leer.
	 * @return Una lista de objetos UsuarioDTO leídos desde el archivo.
	 */

	public static ArrayList<UsuarioDTO> openAndReadFileUsuario(String url) {
		myFile = new File("./Dat/" + url);
		ArrayList<UsuarioDTO> contenido = new ArrayList<UsuarioDTO>();
		try {
			if (!myFile.exists()) {
				myFile.createNewFile();
			} else {
				if (myFile.length() != 0) {
					ois = new ObjectInputStream(new FileInputStream(myFile));
					contenido = (ArrayList<UsuarioDTO>) ois.readObject();
					ois.close();
				}
			}
		} catch (IOException e) {
			System.out.println("Problema al crear el archivo, revise problemas de acceso.");
			System.out.println("FileHandler - openAndReadFileUsuario");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return contenido;
	}

	/**
	 * Abre y escribe en un archivo serializado de objetos de tipo ApostadorDTO.
	 *
	 * @param url            La URL o ruta del archivo serializado en el que se
	 *                       escribirán los objetos.
	 * @param contentToWrite La lista de objetos UsuarioDTO que se escribirán en el
	 *                       archivo.
	 */

	public static void openAndWriteFileUsuario(String url, ArrayList<UsuarioDTO> contentToWrite) {
		myFile = new File("./Dat/" + url);
		myFile.delete();
		try {
			if (!myFile.exists()) {
				myFile.createNewFile();
			}
			oos = new ObjectOutputStream(new FileOutputStream(myFile));
			oos.writeObject(contentToWrite);
			oos.close();
		} catch (IOException e) {
			System.out.println("Problema al crear el archivo, revise problemas de acceso.");
			System.out.println("FileHandler - openAndWriteFileUsuario");
			e.printStackTrace();
		}
	}

}
