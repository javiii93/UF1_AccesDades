import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ModificarcioXml {

	public ModificarcioXml() {
		String filePath = "videojuegos.xml";
		File xmlFile = new File(filePath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();

			// add new element
			addElement(doc);
			// write the updated document to file or console
			doc.getDocumentElement().normalize();
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("videojuegos.xml"));
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);
			System.out.println("XML actualizado con exito");

		} catch (IOException | TransformerException | ParserConfigurationException | SAXException e1) {
			e1.printStackTrace();
		}
	}

	private static void addElement(Document doc) {
		NodeList lista = doc.getElementsByTagName("Juegos");
		Element emp1 = null;
		emp1 = (Element) lista.item(1);

		Element juego = doc.createElement("Juego");
		juego.appendChild(doc.createTextNode("The last of us 2"));
		emp1.appendChild(juego);

	}

}
