import java.io.FileWriter;

public class CreateFileWithThisText {

	public CreateFileWithThisText(String nombreFichero, String text) {
		// File f=new File(nombreFichero);
		FileWriter fichero = null;

		try {

			fichero = new FileWriter(nombreFichero);

			// Escribimos linea a linea en el fichero
			fichero.write(text);

			fichero.close();

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
	}

}
