package projects.model;

import projects.interfaces.Manageable;
import java.util.Objects;

public abstract class Person implements Manageable {

    private int id;
    private String name;
    private String email;
    private int IQ;

    private static int idCount = 1;

    public Person(String name, String email, int IQ) {
        this.id = idCount++;
        this.name = name;
        this.email = email;
        this.IQ = IQ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIQ() {
        return IQ;
    }

    public void setIQ(int IQ) {
        this.IQ = IQ;
    }

    abstract void printInfo();

    @Override
    public void sendNotification(String message) {
        System.out.println(message);
    }

    @Override
    public String generateReport() {
        return "Person is person";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public String toString() {
        return "Person ->" +
                " | ID: " + id +
                " | Name: " + name +
                " | Email: " + email +
                " | IQ: " + IQ;
    }
}
