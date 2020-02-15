
public class Roundup{

    public static void main(String[] args) {
        System.out.println("interval = "+new Roundup().getRounded(5));
        
    }

    public float getRounded(float number, float interval){
        return 0;
    }

    public float getRounded(float number){
        if(number % interval)
        return 0;
    }

    float interval = 0.05f;
}