package pool;

/**
 * Created by fpschina on 16/7/16.
 */
public class MyMission {
    private int num;
    private String threadName;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public MyMission(int num, String threadName) {
        this.num = num;
        this.threadName = threadName;
    }

    public void operation(){
        System.out.println("The thread name is: "+ threadName + "  and the out number is: " + num);
    }

}
