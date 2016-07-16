package pool;

/**
 * Created by fpschina on 16/7/16.
 */
public class MyThreadObject extends Thread{
    private boolean isRunning = false;
    private String threadName;
    private MyMission myMission;

    public MyThreadObject(String threadName) {
        this.threadName = threadName;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public MyMission getMyMission() {
        return myMission;
    }

    public void setMyMission(MyMission myMission) {
        this.myMission = myMission;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        while (true){
            if(isRunning && myMission != null){
                myMission.operation();
                isRunning = false;
                myMission = null;

            }else{
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
