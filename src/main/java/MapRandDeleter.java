
public class MapRandDeleter extends MapRandPutter{

    public void run() {
        try{
            while (enable) {
                Main.map.remove(randKey());
                Main.mapOperations++;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
