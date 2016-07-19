package sdclone;

import java.io.IOException;

/**
 * Created by abel on 2016/7/19.
 */
public class MyRun {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DeepClone deepClone = new DeepClone();
        Professor professor = new Professor("小河马");
        Student student1 = new Student("szq", "male", professor);
        Student student2 = (Student)student1.clone();
        Student student3 = student1;
        student1.setName("zy");
        student1.setSex("female");
        student1.getProfessor().setName("小鳄鱼");
        System.out.println(student1.printFullInfo());
        System.out.println(student2.printFullInfo());
        System.out.println(student3.printFullInfo());
    }
}
