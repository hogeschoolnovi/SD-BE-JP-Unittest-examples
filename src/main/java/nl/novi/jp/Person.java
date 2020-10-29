package nl.novi.jp;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String lastName;
    private int age;
    private List<Person> children = new ArrayList<Person>();
    private Person partner;

    public Person() {
        this.name = "John";
        this.lastName = "Doe";
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(isFirstLetterUpperCase(lastName)) {
            this.lastName = lastName;
        } else {
            this.lastName = lastName.substring(0, 1).toUpperCase()
                    + lastName.substring(1).toLowerCase();
        }
    }

    private boolean isFirstLetterUpperCase(String name) {
        return Character.isUpperCase(name.codePointAt(0));
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void age() {
        this.age++;
    }

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    public boolean hasPartner() {
        if(this.partner != null) {
            return true;
        }
        return false;
    }

    public void addChild(Person child) {
        if(hasUniqueName(child)) {
            children.add(child);
        }
    }

    private boolean hasUniqueName(Person child) {
        if(children.isEmpty()) {
            return true;
        }
        for (Person person : children) {
            if(person.getName().equalsIgnoreCase(child.getName())) {
                return false;
            }
        }
        return true;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }
}
