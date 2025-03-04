package lightsensor;

import java.util.Random;

public class LightSensor implements LightService {
    private Random random = new Random();

    @Override
    public int getLightIntensity() {
        int intensity = random.nextInt(100);
        System.out.println("💡 Light Sensor: Light Intensity is " + intensity + "%");
        return intensity;
    }
}