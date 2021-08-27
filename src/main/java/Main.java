import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static long mapOperations = 0;
    public static ConcurrentMap<Integer, Integer> map = new ConcurrentHashMap<>();
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
