package co.edu.uptc.services;

import co.edu.uptc.models.Person;
import java.util.ArrayList;
import java.util.List;

public class FilterService {

    private List<Person> persons;

    public FilterService(List<Person> persons) {
        this.persons = persons;
    }

    public long promSalary() {
        long totalSalary = 0;
        for (Person person : persons) {
            totalSalary += person.getSalary();
        }
        return totalSalary / persons.size();
    }

    public List<Person> filterMinorSalary() {
        List<Person> minorSalary = new ArrayList<>();
        long promSalary = promSalary();

        for (Person person : persons) {
            if (person.getSalary() < promSalary) {
                minorSalary.add(person);
            }
        }
        return minorSalary;
    }

    public List<Person> filterGreatSalary() {
        List<Person> greatSalary = new ArrayList<>();
        long promSalary = promSalary();

        for (Person person : persons) {
            if (person.getSalary() >= promSalary) {
                greatSalary.add(person);
            }
        }
        return greatSalary;
    }
}
