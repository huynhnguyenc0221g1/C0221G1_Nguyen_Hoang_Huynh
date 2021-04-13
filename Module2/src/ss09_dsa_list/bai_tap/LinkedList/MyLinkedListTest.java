package ss09_dsa_list.bai_tap.LinkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        class Student {
            private int id;
            private String name;

            public Student() {}

            public Student(int id, String name) {
                this.id = id;
                this.name = name;
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
        }
        MyLinkedList<Student> myLinkedList = new MyLinkedList<>();
        Student student1 = new Student(1,"Huynh");
        Student student2 = new Student(2,"Hoang");
        Student student3 = new Student(3,"Trang");
        Student student4 = new Student(4,"Dong");
        myLinkedList.addFirst(student1);
        myLinkedList.addFirst(student2);
        myLinkedList.addLast(student3);
        myLinkedList.add(student4,2);
        MyLinkedList<Student> myClonedLinkedList = myLinkedList.clone();
        for (int i = 0; i < myLinkedList.size(); i++) {
            Student student = (Student) myLinkedList.get(i);
            System.out.println(student.getName());
        }
        System.out.println();
        myLinkedList.remove(student4);
        for (int i = 0; i < myLinkedList.size(); i++) {
            Student student = (Student) myLinkedList.get(i);
            System.out.println(student.getName());
        }
//        System.out.println("*\t" + "Remove index 0\t" + "*");
//        myLinkedList.remove(0);
//        for (int i = 0; i < myLinkedList.size(); i++) {
//            Student student = (Student) myLinkedList.get(i);
//            System.out.println(student.getName());
//        }
//        System.out.println("*\t" + "Printing the cloned LinkedList\t" + "*");
//        for (int i = 0; i < myClonedLinkedList.size(); i++) {
//            Student studentCloned = (Student) myClonedLinkedList.get(i);
//            System.out.println(studentCloned.getName());
//        }
//        int indexCheck = myClonedLinkedList.indexOf(student3);
//        System.out.println("Index Checking: " + indexCheck);
//        myClonedLinkedList.printList();
    }
}
