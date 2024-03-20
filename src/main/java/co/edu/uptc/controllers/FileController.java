package co.edu.uptc.controllers;

import co.edu.uptc.models.Person;
import co.edu.uptc.services.PropertiesService;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileController {
    private PropertiesService p = new PropertiesService();

    public List<Person> leer() {
        List<Person> persons = new ArrayList<>();
        try {
            File inputFile = new File(p.getProperties("file_people"));
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Persona");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String nombre = element.getElementsByTagName("Nombre").item(0).getTextContent();
                    String apellido = element.getElementsByTagName("Apellido").item(0).getTextContent();
                    int edad = Integer.parseInt(element.getElementsByTagName("Edad").item(0).getTextContent());
                    int salario = Integer.parseInt(element.getElementsByTagName("Salario").item(0).getTextContent());
                    persons.add(new Person(nombre, apellido, edad, salario));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return persons;
    }
}
