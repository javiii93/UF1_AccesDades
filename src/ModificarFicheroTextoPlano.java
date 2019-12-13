import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ModificarFicheroTextoPlano {

	public ModificarFicheroTextoPlano(String nombreFichero, String caracterAEliminar) {
		Scanner s = null;
		File fichero = new File(nombreFichero);
		if (fichero.exists()) {
			System.out.println("El archivo existe y su ruta es: " + fichero.getAbsolutePath());
			FileWriter ficheroSalida = null;
			try {
				ficheroSalida = new FileWriter(nombreFichero + "salida");
				// Leemos el contenido del fichero
				s = new Scanner(fichero);
				// Leemos linea a linea el fichero
				while (s.hasNextLine()) {
					String linea = s.nextLine(); // Guardamos la linea en un String
					System.out.println(linea);
					linea = linea.replaceAll(caracterAEliminar, "");
					ficheroSalida.write(linea);
				}

			} catch (Exception ex) {
				System.out.println("Mensaje: " + ex.getMessage());
			} finally {
				// Cerramos el fichero tanto si la lectura ha sido correcta o no
				try {
					if (s != null)
						s.close();
					ficheroSalida.close();
				} catch (Exception ex2) {
					System.out.println("Mensaje 2: " + ex2.getMessage());
				}
			}
			fichero.delete();
			File f = new File(nombreFichero + "salida");
			f.renameTo(new File(nombreFichero));
			System.out.println("El fichero se ha modificado con exito");
		} else {
			System.out.println("El fichero introducido no existe");
		}

	}

}
