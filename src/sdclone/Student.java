package sdclone;

/**
 * Created by abel on 2016/7/19.
 */
public class Student implements Cloneable{
    private String name;
    private String sex;
    private Professor professor;

    public Student(String name, String sex){
        this.name = name;
        this.sex = sex;
    }

    public Student(String name, String sex, Professor professor) {
        this.name = name;
        this.sex = sex;
        this.professor = professor;
    }

    public Object clone(){
        Object o = null;
        try {
            o = (Student)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        ((Student)o).setProfessor((Professor) professor.clone());
        return o;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "name: "+ name + " --||-- sex: " + sex;
    }

    public String printFullInfo(){
        return "name: "+ name + " --||-- sex: " + sex + " --Professor: " + professor.getName();
    }
}
