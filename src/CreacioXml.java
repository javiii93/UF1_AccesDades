import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreacioXml {
	File fichero = new File("examConfig.conf");
	Scanner s = null;
	ArrayList<String> lineas = new ArrayList<>();

	public CreacioXml() {

		try {
			// Leemos el contenido del fichero
			s = new Scanner(fichero);
			// Leemos linea a linea el fichero
			while (s.hasNextLine()) {
				String linea = s.nextLine(); // Guardamos la linea en un String
				lineas.add(linea);
			}

		} catch (Exception ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		} finally {
			// Cerramos el fichero tanto si la lectura ha sido correcta o no
			try {
				if (s != null)
					s.close();
			} catch (Exception ex2) {
				System.out.println("Mensaje 2: " + ex2.getMessage());
			}
		}
		escrituraXml(lineas);
	}

	public static void escrituraXml(ArrayList<String> lineas) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// Elemento raíz
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("Configurations");
			doc.appendChild(rootElement);
			for (int i = 0; i < lineas.size(); i++) {
				// Primer elemento

				String[] lineass = lineas.get(i).split(" = ");
				if (lineass.length == 2) {
					Element elemento = doc.createElement(lineass[0]);
					elemento.appendChild(doc.createTextNode(lineass[1]));
					rootElement.appendChild(elemento);
				}
			}

			// Se escribe el contenido del XML en un archivo
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("examConfig.xml"));
			transformer.transform(source, result);
			System.out.println("Se ha creado el xml correctamente");
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}
}
