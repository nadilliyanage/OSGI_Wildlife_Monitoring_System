package humiditysensor;

import java.util.Random;

public class HumiditySensor implements HumidityService {
    private Random random = new Random();

    @Override
    public int getHumidity() {
        int humidity = 30 + random.nextInt(70);
        System.out.println("💧 Humidity Sensor: Humidity is " + humidity + "%");
        return humidity;
    }
}