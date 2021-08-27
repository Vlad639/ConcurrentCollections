import java.util.HashMap;
import java.util.concurrent.ConcurrentMap;

public class MapRandPutter extends Thread{
     boolean enable = true;

     int randKey(){
        int min = 1;
        int max = 1000;
        return (int) (min + Math.random() * max);
    }

    public void disable(){
        this.enable = false;
    }

    public void run() {
        try{
            while (enable) {
                    Main.map.put(randKey(), 33);
                    Main.mapOperations++;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
