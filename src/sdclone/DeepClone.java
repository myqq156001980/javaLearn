package sdclone;

import java.io.*;

/**
 * Created by abel on 2016/7/19.
 */
public class DeepClone {

    public static Object dpClone(Object o) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(o);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return objectInputStream.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Teacher teacher = new Teacher("小河马", 2);
        Child c1 = new Child("szq", "male", teacher);
        Child c2 = (Child) dpClone(c1);
        c1.name = "zy";
        c1.sex = "female";
        c1.teacher.setName("小鳄鱼");
        System.out.println(c1);
        System.out.println(c2);

    }

}

class Teacher implements Serializable {
    String name;
    int age;

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Child implements Serializable {
    public String name;
    public String sex;
    public Teacher teacher;

    public Child(String name, String sex, Teacher teacher) {
        this.name = name;
        this.sex = sex;
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("name:");
        stringBuilder.append(name);
        stringBuilder.append("\n");
        stringBuilder.append("sex:");
        stringBuilder.append(sex);
        stringBuilder.append("\n");
        stringBuilder.append("teacher:");
        stringBuilder.append(teacher.getName());
        return stringBuilder.toString();
    }
}

