package co.edu.uptc.services;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import co.edu.uptc.models.Person;

public class PersonaXMLConverter {

    public static void convertirA_XML(ArrayList<Person> personas) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("Personas");
            doc.appendChild(rootElement);

            for (Person persona : personas) {
                Element personaElement = doc.createElement("Persona");
                rootElement.appendChild(personaElement);

                Element nombreElement = doc.createElement("Nombre");
                nombreElement.appendChild(doc.createTextNode(persona.getName()));
                personaElement.appendChild(nombreElement);

                Element apellidoElement = doc.createElement("Apellido");
                apellidoElement.appendChild(doc.createTextNode(persona.getLastName()));
                personaElement.appendChild(apellidoElement);

                Element edadElement = doc.createElement("Edad");
                edadElement.appendChild(doc.createTextNode(String.valueOf(persona.getAge())));
                personaElement.appendChild(edadElement);

                Element salarioElement = doc.createElement("Salario");
                salarioElement.appendChild(doc.createTextNode(String.valueOf(persona.getSalary())));
                personaElement.appendChild(salarioElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            String fileName = System.getProperty("java.io.tmpdir") + File.separator + "personas.xml";
            StreamResult result = new StreamResult(new File(fileName));
            transformer.transform(source, result);

            System.out.println("Archivo XML creado exitosamente en: " + fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
