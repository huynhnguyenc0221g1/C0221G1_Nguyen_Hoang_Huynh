package ss16_binary_file.thuc_hanh.readAndWriteListStudent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeToFile(String path, List<Student> student){
        try{
            FileOutputStream fos=new FileOutputStream(path);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(student);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Student> students=new ArrayList<>();
        students.add(new Student(1,"Vũ Kiều Anh","Hà Nội"));
        students.add(new Student(2,"Nguyễn Minh Quân","Hà Nội"));
        students.add(new Student(3,"Đặng Huy Hòa","Đà nẵng"));
        students.add(new Student(4,"Nguyễn Khánh Tùng","Hà Nội"));
        students.add(new Student(5,"Nguyễn Khắc Nhật","Hà Nội"));
        students.add(new Student(6,"Hoàng Phạm Đông","Dak Lak"));
        writeToFile("D:\\C0221G1-hoangphamdon1\\Module02\\src\\b17_binaryFile\\thuc_hanh\\readAndWriteListStudent\\student.txt",students);
        List<Student> studentDataFromFile =readDataFromFile("D:\\C0221G1-hoangphamdon1\\Module02\\src\\b17_binaryFile\\thuc_hanh\\readAndWriteListStudent\\student.txt");
        for(Student student:studentDataFromFile){
            System.out.println(student);
        }
    }public static List<Student>readDataFromFile(String path){
        List<Student> students=new ArrayList<>();
        try {
            FileInputStream fis=new FileInputStream(path);
            ObjectInputStream ois=new ObjectInputStream(fis);
            students=(List<Student>) ois.readObject();
            fis.close();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }return students;
    }
}
