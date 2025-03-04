package temperaturesensor;

import java.util.Random;

public class TemperatureSensor implements TemperatureService {
    private Random random = new Random();

    @Override
    public int getTemperature() {
        int temperature = 15 + random.nextInt(15);
        System.out.println("🌡️ Temperature Sensor: Current Temperature is " + temperature + "°C");
        return temperature;
    }
}