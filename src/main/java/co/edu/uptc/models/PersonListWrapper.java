package co.edu.uptc.models;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class PersonListWrapper {
    private List<Person> persons;

    public PersonListWrapper() {
    }

    public PersonListWrapper(List<Person> persons) {
        this.persons = persons;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
