package co.edu.uptc.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import co.edu.uptc.models.Person;
import co.edu.uptc.models.PersonListWrapper;
import co.edu.uptc.services.FilterService;
import co.edu.uptc.services.PropertiesService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class WriteFiles {

    private PropertiesService p = new PropertiesService();
    private FilterService fs;

    public WriteFiles(FilterService fs) {
        this.fs = fs;
    }

    public void writeMinorSalaryFile() {
        try {
            File outputFile = new File(p.getProperties("file_outputLowSalary"));
            List<Person> minorSalaries = fs.filterMinorSalary();
            writeToXML(minorSalaries, outputFile);
            System.out.println("Archivo de salarios bajos guardado en " + p.getProperties("file_outputLowSalary"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void writeGreatSalaryFile() {
        try {
            File outputFile = new File(p.getProperties("file_outputGreatSalary"));
            List<Person> greatSalaries = fs.filterGreatSalary();
            writeToXML(greatSalaries, outputFile);
            System.out.println("Archivo de salarios altos guardado en " + p.getProperties("file_outputGreatSalary"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private void writeToXML(List<Person> persons, File outputFile) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(PersonListWrapper.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        try {
            marshaller.marshal(new PersonListWrapper(persons), new FileOutputStream(outputFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
