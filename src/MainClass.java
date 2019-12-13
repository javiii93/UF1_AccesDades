import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nombreFichero;
		String text;
		// Ejercicio 1:
		/*System.out.println("Ejercicio 1: ");
		ConfigurationForExam cFE = new ConfigurationForExam();*/
		
		// Ejercicio 2:
		/*System.out.println("Ejercicio 2: ");
		System.out.println("escribe en primer lugar el nombre del archivo a crear");
		nombreFichero = sc.next();
		sc.nextLine();
		System.out.println("Ahora el contenido de este: ");
		text = sc.nextLine();
		CreateFileWithThisText cfwtt = new CreateFileWithThisText(nombreFichero, text);*/
		
		// Ejercicio 3:
		/*System.out.println("Ejercicio 3: ");
		sc.nextLine();
		System.out.println("Introduce la ruta del archivo a modificar: ");
		nombreFichero = sc.nextLine();
		sc.nextLine();
		System.out.println("Introduce el caracter a eliminar: ");
		text = sc.next();

		while (text.length() != 1) {
			System.out.println("Solo puede ser 1 caracter, vuelve a teclearlo");
			sc.nextLine();
			text = sc.next();
		}
		System.out.println(nombreFichero);
		System.out.println(text);
		ModificarFicheroTextoPlano mftp = new ModificarFicheroTextoPlano(nombreFichero, text);*/
		
		// Ejercicio 4
		/*System.out.println("Ejercicio 4: ");
		CreacioXml cx = new CreacioXml();*/
		
		// Ejercicio 5
		/*System.out.println("Ejercicio 5: ");
		ModificarcioXml mx = new ModificarcioXml();*/

		sc.close();
	}

}
