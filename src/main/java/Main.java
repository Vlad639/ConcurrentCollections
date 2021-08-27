import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class Main {
    public static long mapOperations = 0;
    public static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
    static long startTime;
    static double executionTimeSeconds;
    static long  speed;

    public static void main(String[] args) throws InterruptedException {
        MapRandPutter mapRandPutter1 = new MapRandPutter();
        MapRandPutter mapRandPutter2 = new MapRandPutter();

        MapRandDeleter mapRandDeleter1 = new MapRandDeleter();
        MapRandDeleter mapRandDeleter2 = new MapRandDeleter();


        startTime = System.currentTimeMillis();
        mapRandPutter1.start();
        mapRandPutter2.start();

        mapRandDeleter1.start();
        mapRandDeleter2.start();

        Thread.sleep(5000);

        mapRandPutter1.disable();
        mapRandPutter2.disable();

        mapRandDeleter1.disable();
        mapRandDeleter2.disable();

        executionTimeSeconds = (System.currentTimeMillis() - startTime) / 1000.0;
        speed = (long)(mapOperations / executionTimeSeconds);
        System.out.println(speed);
    }
}
