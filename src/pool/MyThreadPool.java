package pool;

import java.util.ArrayList;

/**
 * Created by fpschina on 16/7/16.
 */
public class MyThreadPool {
    private int size = 3;
    private ArrayList<MyThreadObject> tList = new ArrayList<>();
    private int[] intList = {1,2,6,7,25,12,34,54,21,345};

    public MyThreadPool() {
        for (int i = 0; i < size; i++) {
            MyThreadObject o = new MyThreadObject("thread" + (i+1));
            o.start();
            tList.add(o);
        }
    }

    public void execute(){
        for (int i = 0; i < intList.length; i++) {
            MyThreadObject m=null;
            while (true){
                for (int j = 0; j < tList.size(); j++) {
                    if((m = tList.get(j)).isRunning()){
                        continue;
                    }else{
                        break;
                    }
                }
                if(m!= null && m.isRunning()){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    m.setRunning(true);
                    break;
                }
            }

            MyMission myMission = new MyMission(intList[i], m.getThreadName());
            m.setMyMission(myMission);
        }

    }

}
