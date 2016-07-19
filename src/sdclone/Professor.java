package sdclone;

/**
 * Created by abel on 2016/7/19.
 */
public class Professor implements Cloneable{
    private String name;

    public Professor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object clone(){
        Object o = null;
        try {
            o = (Professor)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }


}
