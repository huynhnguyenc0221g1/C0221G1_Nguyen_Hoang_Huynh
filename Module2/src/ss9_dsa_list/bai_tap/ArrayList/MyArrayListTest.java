package ss9_dsa_list.bai_tap.ArrayList;

public class MyArrayListTest {
    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", Age =" + age +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            Person person = (Person) obj;
            return this.name.equals(((Person) obj).name)
                    && this.age == ((Person) obj).age;
        }
    }

    public static void main(String[] args) {
        MyArrayList<Person> myArrayList = new MyArrayList<>();
        myArrayList.ensureCapacity(4);
        myArrayList.add(new Person("Nguyễn Hoàng Huynh", 25));
        myArrayList.add(new Person("Đông Phạt Tiền Ác", 19));
        myArrayList.add(new Person("Hoàng Giáo sư", 30));
        myArrayList.add(new Person("Trang Đi trễ", 23), 1);
        myArrayList.remove(2);
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.get(i).toString());
        }
        MyArrayList<Person> myArrayListCloned = myArrayList.clone();       //Cloning the OG List
        System.out.println("Cloning the original list..");
        for (int i = 0; i < myArrayListCloned.size(); i++) {
            System.out.println(myArrayListCloned.get(i).toString());
        }
        int indexTesting = myArrayListCloned.indexOf(new Person("Trang Đi trễ", 23));
        System.out.println("index = " + indexTesting);
        System.out.println(myArrayList.contains(new Person("Nguyễn Hoàng Huynh", 25))); //True
        System.out.println(myArrayList.contains(new Person("Anh Trung Jungler", 38)));  //False
        myArrayListCloned.clear();
        for (int i = 0; i < myArrayListCloned.size(); i++) {
            System.out.println(myArrayListCloned.get(i).toString());
        }
    }
}
