package ss10_generics_stack_queue.bai_tap.to_chuc_du_lieu;

import java.util.Comparator;
import java.util.*;

public class Person implements Comparable<Person>{

    public String name;
    public String gender;
    public String birthday;

    public Person() {
    }

    public Person(String name, String gender, String birthday) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return '\n' + "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                '}' + '\n';
    }


    @Override
    public int compareTo(Person o) {
        return toString().compareTo(o.toString());
    }
}
