package za.co.entelect.javaforum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Person {

    private static final Logger LOGGER = LoggerFactory.getLogger(Person.class);

    private String name;

    public Person(String name) {
        if (name == null) {
            throw new RuntimeException("name cannot be null");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Character, Integer> getCharacterCounts() {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : name.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                if (counts.containsKey(c)) {
                    counts.put(c, counts.get(c) + 1);
                } else {
                    counts.put(c, 1);
                }
            }
        }
        //Debugging message:
        LOGGER.debug("For '{}', counts are: {}", this, counts);
        return counts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        //Lets pretend this is a really slow tostring method:
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            LOGGER.error("Exception thown in sleep", ex);
        }
        return "Person{name='" + name + "'}";
    }
}
