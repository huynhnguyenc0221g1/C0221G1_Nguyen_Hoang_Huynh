package ss10_generics_stack_queue.bai_tap.to_chuc_du_lieu;

import java.util.*;

public class Demerging {
    public static void main(String[] args) {
        Person person1 = new Person("Pham Dong", "Male", "2002");
        Person person2 = new Person("Thuy Trang", "Female", "1997");
        Person person3 = new Person("Hoang Huynh", "Male", "1996");
        Person person4 = new Person("Van Hoang", "Male", "1996");
        Person person5 = new Person("Dieu Thuy", "Female", "1998");
        Person person6 = new Person("Thu Thao", "Female", "1994");
        Person[] persons = {person1, person2, person3, person4, person5, person6};
        List<Person> personTest = new ArrayList<>();
        personTest.add(person1);

        Arrays.sort(persons, new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.birthday.compareTo(o2.birthday);
                    }
                }
        );
        Queue<Person> queueFemale = new LinkedList<>();
        Queue<Person> queueMale = new LinkedList<>();
        Queue<Person> queueResult = new LinkedList<>();
        for (Person person : persons) {
            if (person.getGender().equals("Female")) {
                queueFemale.add(person);
            }
            if (person.getGender().equals("Male")) {
                queueMale.add(person);
            }
        }
        int sizeFemale = queueFemale.size();
        int sizeMale = queueMale.size();
        for (int i = 0; i < sizeFemale; i++) {
            queueResult.add(queueFemale.remove());
        }
        for (int i = 0; i < sizeMale; i++) {
            queueResult.add(queueMale.remove());
        }
        System.out.println(queueResult);
    }
}
